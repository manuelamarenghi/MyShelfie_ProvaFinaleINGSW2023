package it.polimi.ingsw.network;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.message.Message;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

    }
    /**
     * removeClient() when a client leave the game
     */
    public void removeClient(String nickname){

    }
    /**
     * HandleDisconnection() when the connection ends
     */
    public void HandleDisconnection(){

    }
    /**
     * onMessageReceived() send the message to the controller
     * @param message
     */
    public void onMessageReceived(Message message){
        // gestione game controller
    }

    public void startGame() {

    }
}
