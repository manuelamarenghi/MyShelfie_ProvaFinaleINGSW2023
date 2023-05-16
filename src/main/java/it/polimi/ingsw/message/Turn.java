package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

public class Turn extends Message implements Serializable {

    private String turnPlayer;

    public Turn(String nickname){
        super("Server","player_turn");
        turnPlayer=nickname;


    }
    public String getTurnPlayer(){
        return turnPlayer;
    }
    public void visit(MessageHandler controller) {
        controller.handle(this);
    }
}
