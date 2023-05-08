package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

public class AskNumbPlayer extends Message{
    public AskNumbPlayer(String name){
        super(name,"Insert_numb_player");
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }

}
