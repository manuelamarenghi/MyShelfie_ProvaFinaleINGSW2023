package it.polimi.ingsw.modello;

import java.util.ArrayList;

/**
 *  this class is used to initialize the match in Main Class
 */
public class Match {
    public static final int MAX_PLAYERS = 4;
    public static final int MIN_PLAYERS = 2;
    private ArrayList<Player> players;

    private int playerNumber;
private Board board;
private Player firstFinish;
private Player chair;
private EffectiveCard[] CommonCards=new EffectiveCard[2];
private Matchmanager matchmanager;
    /**
     *  the constructor initialize the manager based on number of players
     *  MatchManager is an abstract class and has 3 classes that extends it
     */
    public Match(){
        players = new ArrayList<>();
    }
    public void setMatch(int number) {

        playerNumber =number;
        if (number == 4) {
            matchmanager = new FourPlayers();
        }
        if (number == 3) {
            matchmanager = new ThreePlayers();
        }
        if (number == 2) {
            matchmanager = new TwoPlayers();
        }
    }

    public Board getBoard() {
        return board;
    }

    public EffectiveCard[] getCommonCards() {
        return CommonCards;
    }

    public int getPlayerNumber(){
        return playerNumber;
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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<String> getPlayersNickname(){
        ArrayList<String> nickname = new ArrayList<>();
        for(Player p:players){
            nickname.add(p.getNickname());
        }
        return  nickname;
    }

    public Player getPlayerByNickname(String nickname){
        for(Player p: players){
            if(p.getNickname().equals(nickname))
                return p;
        }
        return null;
    }
    public void setPlayers(Player p){
        players.add(p);
    }


}
