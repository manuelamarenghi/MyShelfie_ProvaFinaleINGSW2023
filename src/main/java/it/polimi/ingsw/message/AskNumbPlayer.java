package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * Class to sned a message to ask number of players
 */
public class AskNumbPlayer extends Message implements Serializable {
    public AskNumbPlayer(String name){
        super(name,"Insert_numb_player");
    }

    public void visit(MessageHandler controller){
        controller.handle(this);
    }

}
