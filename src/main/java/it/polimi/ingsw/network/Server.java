package it.polimi.ingsw.network;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.MessageContent;
import it.polimi.ingsw.message.MexInChat;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Server {
    private final GameController gameController;

    private final Map<String, ClientHandler> clientHandlerMap;
    public Server(GameController gameController){
        this.gameController = gameController;
        this.clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
    }
    /**
     * addClient() when a new client connected to the game
     */
    public void addClient(String nickname,ClientHandler clientHandler){
        // controllo nickname da input controller
        clientHandlerMap.put(nickname,clientHandler);
        // gamecontroller che aggiunge giocatore
    }
    /**
     * removeClient() when a client leave the game
     */
    public void removeClient(String nickname){
        clientHandlerMap.remove(nickname);
        //game controller che toglie giocatore
    }
    /**
     * HandleDisconnection() when the connection ends
     */
    public void HandleDisconnection(){
           //gestione disconnessione in base a fase del gioco
    }
    /**
     * onMessageReceived() send the message to the controller
     * @param message
     */
    public void onMessageReceived(Message message){
        // gestione game controller
    }

    public void startGame() {
        // game controller
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
                 MessageContent mex=new MexInChat((String)message.getMessage().getObject());
                 Message m= new Message("Server",mex);
                 clientHandlerMap.get(o).sendMessage(message);
             }
         }
    }
}
