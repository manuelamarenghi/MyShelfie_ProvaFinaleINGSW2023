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
    private EffectiveCard[] CommonCards;


    public VirtualModel() {
        this.players = new ArrayList<>();
        this.me = new Player("missing_nickname");
        this.chair = null;
        this.firstFinish = null;
        this.isMyTurn = false;
        this.playerNumber = -1;
        this.CommonCards = new EffectiveCard[2];
        this.board = null;
        this.me.setLibrary(new Library());
    }

    synchronized public void setCommonCards(EffectiveCard[] commonCards) {
        CommonCards = commonCards;
    }

    synchronized public int getPlayerNumber() {
        return playerNumber;
    }

    synchronized public Player getFirstFinish() {
        return firstFinish;
    }

    synchronized public void setMe(String me) {
        this.me = new Player(me);
    }

    synchronized public void setFirstFinish(String firstFinish) {
        for (Player player : this.players) {
            if (player.getNickname().equals(firstFinish)) this.firstFinish = player;
        }
    }

    synchronized public void setPlayers(ArrayList<String> players) {
        for (String p : players) {
            this.players.add(new Player(p));
        }
    }

    synchronized public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    synchronized public ArrayList<Player> getPlayers() {
        return players;
    }

    synchronized public void addPlayer(Player player) {
        this.players.add(player);
    }
    public void removePlayer(String nickname){
        this.players.removeIf(player -> player.getNickname().equals(nickname));
    }

    synchronized public void updateBoard(Board board) {
        this.board = board;
    }

    synchronized public void updateChair(String nickname) {
        for (Player player : this.players) {
            if (player.getNickname().equals(nickname)) this.chair = player;
        }
    }

    synchronized public Player getChair() {
        return chair;
    }

    synchronized public void updatePlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    synchronized public PersonalGoalCard getPersonalGoalCard() {
        return this.me.getPersonalCard();
    }

    synchronized public EffectiveCard[] getCommonGoalCards() {
        return this.CommonCards;
    }
    synchronized public void updateIsMyTurn(){
        this.isMyTurn=!this.isMyTurn;
    }
    synchronized public boolean isMyTurn(){
        return this.isMyTurn;
    }
    synchronized public Player getMe(){
        return this.me;
    }
    synchronized public void updateCommonScore(String nickname,int score){
        for(Player player:this.players){
            if(player.getNickname().equals(nickname))player.setCommonGoalScore(score);
        }
    }
    synchronized public Player getPlayer(String nickname) {
        for(Player player:this.players){
            if(player.getNickname().equals(nickname))return player;
        }
        return new Player(null);
    }

    synchronized public Board getBoard(){
        return board;
    }
}
