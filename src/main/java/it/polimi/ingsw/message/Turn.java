package it.polimi.ingsw.message;

import java.io.Serializable;

public class Turn extends Message implements Serializable {

    private String turnPlayer;

    public Turn(String name,String nickname){
        super(name,"player_turn");
        turnPlayer=nickname;

    }
}
