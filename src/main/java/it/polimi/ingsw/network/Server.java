package it.polimi.ingsw.network;

import it.polimi.ingsw.Controller.GameController;

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

}
