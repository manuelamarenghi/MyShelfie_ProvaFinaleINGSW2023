package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * Class to send a message to ask the player a new nickname
 */
public class AskNewNickname extends Message implements Serializable {
    public AskNewNickname() {
        super("server","changing_nickname");
    }

    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
