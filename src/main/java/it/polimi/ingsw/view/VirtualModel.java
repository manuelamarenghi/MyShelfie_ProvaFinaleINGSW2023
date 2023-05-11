package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.network.observer.VMObservable;

import java.util.ArrayList;

public class VirtualModel extends VMObservable {
    private ArrayList<Player> players;
    private Player me;
    private boolean isMyTurn;
    private int playerNumber;
    private Board board;
    private Player firstFinish;
    private Player chair;
    private EffectiveCard[] CommonCards = new EffectiveCard[2];

    public VirtualModel(Match match) {
        this.playerNumber = match.getPlayerNumber();
        this.board = match.getBoard();
        this.chair = match.getChair();
        this.firstFinish = match.getFirstFinish();
        this.CommonCards = match.getCommonCards();
        this.players = null;
    }

    public VirtualModel() {
        this.players = null;
        this.me = new Player("missing_nickname");
        this.chair = null;
        this.firstFinish = null;
        this.isMyTurn = false;
        this.playerNumber = -1;
        this.CommonCards = null;
        this.board = null;
        this.me.setLibrary(new Library());
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Player getFirstFinish() {
        return firstFinish;
    }

    public void setMe(String me) {
        this.me = new Player(me);
    }

    public void setFirstFinish(String firstFinish) {
        for (Player player : this.players) {
            if (player.getNickname().equals(firstFinish)) this.firstFinish = player;
        }
    }

    public void setPlayers(ArrayList<String> players) {
        for(String p:players)
        {
            this.players.add(new Player(p));
        }
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
    public void removePlayer(String nickname){
        this.players.removeIf(player -> player.getNickname().equals(nickname));
    }

    public void updateBoard(Board board) {
        this.board = board;
    }

    public void updateChair(String nickname) {
        for (Player player : this.players) {
            if (player.getNickname().equals(nickname)) this.chair = player;
        }
    }

    public Player getChair() {
        return chair;
    }

    public void updatePlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public PersonalGoalCard getPersonalGoalCard() {
        return this.me.getPersonalCard();
    }

    public EffectiveCard[] getCommonGoalCards() {
        return this.CommonCards;
    }
    public void updateIsMyTurn(){
        this.isMyTurn=!this.isMyTurn;
    }
    public boolean isMyTurn(){
        return this.isMyTurn;
    }
    public Player getMe(){
        return this.me;
    }
    public void updateCommonScore(String nickname,int score){
        for(Player player:this.players){
            if(player.getNickname().equals(nickname))player.setCommonGoalScore(score);
        }
    }
    public Player getPlayer(String nickname) {
        for(Player player:this.players){
            if(player.getNickname().equals(nickname))return player;
        }
        return new Player(null);
    }

    public Board getBoard(){
        return board;
    }
}
