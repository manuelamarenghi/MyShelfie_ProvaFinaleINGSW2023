package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * message from server to client after a player entered the game
 */
public class AcceptPlayer extends Message implements Serializable {
    public AcceptPlayer(String name){
        super(name,"accepted_in_the_match");
    }

    public void visit(MessageHandler controller){
    controller.handle(this);
}
}
