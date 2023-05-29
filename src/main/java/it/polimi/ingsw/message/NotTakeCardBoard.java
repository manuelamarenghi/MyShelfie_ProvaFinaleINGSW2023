package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * Class to send a message when it is not possible to take the card selected
 */
public class NotTakeCardBoard extends Message implements Serializable {

    public NotTakeCardBoard(String c) {
        super(c, "Not_Takable_Mex");
    }

    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
