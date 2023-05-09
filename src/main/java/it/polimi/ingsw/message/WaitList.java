package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * message from server to client when the game has enough players
 */
public class WaitList extends Message implements Serializable {
    public WaitList(String name){
        super(name,"Game_full");
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }

}
