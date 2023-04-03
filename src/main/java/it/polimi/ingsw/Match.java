package it.polimi.ingsw;

import java.util.Scanner;

public class Match {
    /*
     *  this class is used to initialize the match in Main Class
     */
    private Player[] players;
private Board board;
private Player firstFinish;
private Player chair;
private EffectiveCard[] CommonCards=new EffectiveCard[2];
private Matchmanager matchmanager;
    /*
     *  the constructor initialize the manager based on number of players
     *  MatchManager is an abstract class and has 3 classes that extends it
     */
    public Match(int n) {
        players=new Player[n];
        Scanner in=new Scanner(System.in);
        for(Player p: players){
            System.out.println("Inserire nickname giocatore");
            String nickname= in.nextLine();
            p.setNickname(nickname);
        }
        this.setChair(players[0]);
        if(n==4){  matchmanager=new FourPlayers();}
        if(n==3){matchmanager=new ThreePlayers();}
        if(n==2){matchmanager=new TwoPlayers();}
    }

    public Board getBoard() {
        return board;
    }

    public EffectiveCard[] getCommonCards() {
        return CommonCards;
    }

    public Player getChair() {
        return chair;
    }

    public Player getFirstFinish() {
        return firstFinish;
    }

    public Matchmanager getMatchmanager() {
        return matchmanager;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setChair(Player chair) {
        this.chair = chair;
    }

    public void setCommonCards(EffectiveCard[] commoncards) {
        CommonCards = commoncards;
    }

    public void setFirstFinish(Player firstFinish) {
        this.firstFinish = firstFinish;
    }

    public void setMatchmanager(Matchmanager matchmanager) {
        this.matchmanager = matchmanager;
    }

}
