package it.polimi.ingsw.network;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.view.VirtualView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Server {
    private final MatchController matchController;
    private Map<String,ClientHandler>    disconnettedclientMap;
    private final Map<String, ClientHandler> clientHandlerMap;
    public Server(MatchController matchController){
        this.matchController = matchController;
        this.clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
        this.disconnettedclientMap = Collections.synchronizedMap(new HashMap<>());
    }
    /**
     * addClient() when a new client connected to the game
     */
    public void addClient(String nickname,ClientHandler clientHandler){
        // controllo nickname da input controller
        clientHandlerMap.put(nickname,clientHandler);
        matchController.loginHandler(nickname,new VirtualView(clientHandler));
    }
    /**
     * removeClient() when a client leave the game
     */
    public void removeClient(String nickname){
        disconnettedclientMap.put(nickname,clientHandlerMap.get(nickname));
        clientHandlerMap.remove(nickname);
        //game controller che toglie giocatore
    }
    /**
     * HandleDisconnection() when the connection ends
     */
    public void HandleDisconnection(){
        String nickname = null;
        Set set=clientHandlerMap.keySet();
        for(Object o: set){
            if(clientHandlerMap.get(o).isConnected()==false){
                nickname=(String)o;
                break;
            }
        }
        disconnettedclientMap.put(nickname,clientHandlerMap.get(nickname));
        clientHandlerMap.remove(nickname);
           //gestione disconnessione in base a fase del gioco
    }
    /**
     * onMessageReceived() send the message to the controller
     * @param message
     */
    public void onMessageReceived(Message message){
        matchController.messageHandler(message);
    }

    public void startGame() {
        matchController.startGame();
    }
    /**
     * broadcastMessage() shares message in chat to other clientHandler
     * @param clientHandler
     * @param message
     */
    public void broadcastMessage(ClientHandler clientHandler,Message message) {
         Set set=clientHandlerMap.keySet();
         for(Object o: set){
             if(!o.equals(message.getnickname())){
                message.MextoClientHandler(clientHandlerMap.get(o));

             }
         }
    }
}
