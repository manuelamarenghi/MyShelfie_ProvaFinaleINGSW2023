package it.polimi.ingsw.message;

public class Turn extends Message{

    private String turnPlayer;

    public Turn(String name,String nickname){
        super(name,"player_turn");
        turnPlayer=nickname;

    }
}
