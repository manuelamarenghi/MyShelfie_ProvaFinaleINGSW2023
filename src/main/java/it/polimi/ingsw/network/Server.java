package it.polimi.ingsw.network;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.message.Disconnection_Answer;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.view.VirtualView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private final MatchController matchController;
    private Map<String,ClientHandler>    disconnettedclientMap;
    private final Map<String, ClientHandler> clientHandlerMap;
    private ArrayList<String> clientsconnected;
    private  ArrayList<String> clientdisconnected;
    public Server(MatchController matchController){
        this.matchController = matchController;
        this.clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
        this.disconnettedclientMap = Collections.synchronizedMap(new HashMap<>());
        clientsconnected=new ArrayList<>();
        clientdisconnected=new ArrayList<>();
    }
    /**
     * addClient() when a new client connected to the game
     */
    public void addClient(String nickname,ClientHandler clientHandler) {
        if (!clientdisconnected.contains(nickname)) {
            synchronized (this) {
                if (matchController.loginHandler(nickname, new VirtualView(clientHandler))) {
                    clientsconnected.add(nickname);
                    clientHandlerMap.put(nickname, clientHandler);
                    System.out.println("il giocatore " + nickname + " si è connesso");
                }
            }
            System.out.println(clientsconnected);
        } else {
            matchController.PlayerBack(nickname, new VirtualView(clientHandler));
            clientsconnected.add(nickname);
            clientdisconnected.remove(nickname);
            clientHandlerMap.put(nickname, clientHandler);
            disconnettedclientMap.remove(nickname);
        }
    }
    /**
     * removeClient() when a client leave the game
     */
    public void removeClient(String nickname) {
        clientHandlerMap.get(nickname).sendMessage(new Disconnection_Answer(nickname));
        if (matchController.getIsStarted() == true) {
            disconnettedclientMap.put(nickname, clientHandlerMap.get(nickname));
            clientdisconnected.add(nickname);
        }
        clientHandlerMap.remove(nickname);
        matchController.removeClient(nickname);
    }
    /**
     * HandleDisconnection() when the connection ends
     */
    public void HandleDisconnection() {
        String nickname = null;
        for (String s : clientsconnected) {
            if (!clientHandlerMap.get(s).isConnected()) {
                nickname = s;
                break;
            }
        }
        System.out.println("starting disconnection");
        if (matchController.getIsStarted() == true) {
            clientdisconnected.add(nickname);
            disconnettedclientMap.put(nickname, clientHandlerMap.get(nickname));
        }
        clientsconnected.remove(nickname);
        clientHandlerMap.remove(nickname);
        matchController.removeClient(nickname);
        System.out.println(clientsconnected);
    }
    /**
     * onMessageReceived() send the message to the controller
     * @param message
     */
    public void onMessageReceived(Message message) {
        matchController.messageHandler(message);
    }

    /**
     * broadcastMessage() shares message in chat to other clientHandler
     *
     * @param clientHandler
     * @param message
     */
    public void broadcastMessage(ClientHandler clientHandler, Message message) {
        for (String o : clientsconnected) {
            if (!o.equals(message.getnickname())) {
                message.MextoClientHandler(clientHandlerMap.get(o), o);
            }
        }
    }
}
