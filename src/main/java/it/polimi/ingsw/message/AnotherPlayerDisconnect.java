package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

public class AnotherPlayerDisconnect extends Message{
    public AnotherPlayerDisconnect(String name){
        super(name,"player_disconnected");
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
