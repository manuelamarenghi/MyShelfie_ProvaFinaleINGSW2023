package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

public class AskNewNickname extends Message{
    public AskNewNickname() {
        super("server","changing_nickname");
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
