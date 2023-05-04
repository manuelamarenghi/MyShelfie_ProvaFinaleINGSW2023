package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.*;

import java.util.ArrayList;

public class VirtualModel {
    private ArrayList<Player> players;

    private int playerNumber;
    private Board board;
    private Player firstFinish;
    private Player chair;
    private EffectiveCard[] CommonCards=new EffectiveCard[2];

    public VirtualModel(Match match){
        this.playerNumber=match.getPlayerNumber();
        this.board=match.getBoard();
        this.chair=match.getChair();
        this.firstFinish=match.getFirstFinish();
        this.CommonCards=match.getCommonCards();
    }
    public void updatePlayerLibrary(String nickname, Library library){
       for(Player p: this.players){
           if(p.getNickname().equals(nickname))p.setLibrary(library);
       }
    }
    public void updateBoard(Board board){
        this.board=board;
    }
    public void updateChair(Player chair){
        this.chair=chair;
    }
    public void updatePlayerNumber(int playerNumber){
        this.playerNumber=playerNumber;
    }
    public void showPersonalGoalCard(){

    }
}
