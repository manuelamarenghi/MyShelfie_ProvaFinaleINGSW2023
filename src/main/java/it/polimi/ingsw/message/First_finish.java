package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

public class First_finish extends Message implements Serializable {

    public First_finish(String c) {
        super(c, "first_player_finished");
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
