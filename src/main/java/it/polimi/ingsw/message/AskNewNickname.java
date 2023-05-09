package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

public class AskNewNickname extends Message implements Serializable {
    public AskNewNickname() {
        super("server","changing_nickname");
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
