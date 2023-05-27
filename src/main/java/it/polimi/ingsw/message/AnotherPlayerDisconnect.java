package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * Class to send a message for the dissconnection of another player
 */
public class AnotherPlayerDisconnect extends Message implements Serializable {
    public AnotherPlayerDisconnect(String name){
        super(name,"player_disconnected");
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
