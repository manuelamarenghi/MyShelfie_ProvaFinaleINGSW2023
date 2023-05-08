package it.polimi.ingsw.network;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.message.Disconnection_Answer;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.view.VirtualView;

import java.util.*;

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
        if (!clientdisconnected.contains(nickname)){
            synchronized(this){
               if(matchController.loginHandler(nickname, new VirtualView(clientHandler)) ){
                clientsconnected.add(nickname);
                clientHandlerMap.put(nickname, clientHandler);
            }}
        }
        else{
            matchController.PlayerBack(nickname);
            clientsconnected.add(nickname);
            clientdisconnected.remove(nickname);
            clientHandlerMap.put(nickname, clientHandler);
            disconnettedclientMap.remove(nickname);
        }
    }
    /**
     * removeClient() when a client leave the game
     */
    public void removeClient(String nickname){
        disconnettedclientMap.put(nickname,clientHandlerMap.get(nickname));
        clientHandlerMap.remove(nickname);
        matchController.removeClient(nickname);
        disconnettedclientMap.get(nickname).sendMessage(new Disconnection_Answer(nickname));
    }
    /**
     * HandleDisconnection() when the connection ends
     */
    public void HandleDisconnection(){
        String nickname = null;
        Set set=clientHandlerMap.keySet();
        for(Object o: set){
            if(!clientHandlerMap.get(o).isConnected()){
                nickname=(String)o;
                break;
            }
        }
        clientdisconnected.add(nickname);
        clientsconnected.remove(nickname);
        disconnettedclientMap.put(nickname,clientHandlerMap.get(nickname));
        clientHandlerMap.remove(nickname);
        matchController.removeClient(nickname);
    }
    /**
     * onMessageReceived() send the message to the controller
     * @param message
     */
    public void onMessageReceived(Message message){
        matchController.messageHandler(message);
    }
    /**
     * broadcastMessage() shares message in chat to other clientHandler
     * @param clientHandler
     * @param message
     */
    public void broadcastMessage(ClientHandler clientHandler,Message message) {
         for(String o: clientsconnected){
             if(!o.equals(message.getnickname())){
                message.MextoClientHandler(clientHandlerMap.get(o));
             }
         }
    }
}
