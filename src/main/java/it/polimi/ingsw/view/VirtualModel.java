package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.network.observer.VMObservable;

import java.util.ArrayList;

public class  VirtualModel extends VMObservable {
    private ArrayList<Player> players;
    private Player me;
    private boolean isMyTurn;
    private int playerNumber;
    private Board board;
    private Player firstFinish;
    private Player chair;
    private EffectiveCard[] CommonCards;

    private ArrayList<Card> cardSelect;


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
        this.cardSelect = new ArrayList<>();
    }

    public synchronized void setCardSelect(ArrayList<Card> cards) {
        this.cardSelect = cards;
    }

    public synchronized ArrayList<Card> getCardSelect() {
        return cardSelect;
    }

    public synchronized void setCommonCards(EffectiveCard[] commonCards) {
        CommonCards = commonCards;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public synchronized Player getFirstFinish() {
        return firstFinish;
    }

    public synchronized void setMe(String me) {
        this.me = new Player(me);
    }

    public synchronized void setFirstFinish(String firstFinish) {
        for (Player player : this.players) {
            if (player.getNickname().equals(firstFinish)) this.firstFinish = player;
        }
    }

    public synchronized void setPlayers(ArrayList<String> players) {
        for (String p : players) {
            this.players.add(new Player(p));
        }
    }

    public synchronized void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public synchronized ArrayList<Player> getPlayers() {
        return players;
    }

    public synchronized void addPlayer(Player player) {
        this.players.add(player);
    }

    public  synchronized void removePlayer(String nickname) {
        this.players.removeIf(player -> player.getNickname().equals(nickname));
    }

    public synchronized void updateBoard(Board board) {
        this.board = board;
    }

    public synchronized void updateChair(String nickname) {
        for (Player player : this.players) {
            if (player.getNickname().equals(nickname)) this.chair = player;
        }
    }

    public synchronized Player getChair() {
        return chair;
    }

    public synchronized void updatePlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public synchronized PersonalGoalCard getPersonalGoalCard() {
        return this.me.getPersonalCard();
    }

    public synchronized EffectiveCard[] getCommonGoalCards() {
        return this.CommonCards;
    }

    public synchronized void updateIsMyTurn() {
        this.isMyTurn = !this.isMyTurn;
    }

    public synchronized boolean isMyTurn() {
        return this.isMyTurn;
    }

    public synchronized Player getMe() {
        return this.me;
    }

    public synchronized void updateCommonScore(String nickname, int score) {
        for (Player player : this.players) {
            if (player.getNickname().equals(nickname)) player.setCommonGoalScore(score);
        }
    }

    public synchronized Player getPlayer(String nickname) {
        for (Player player : this.players) {
            if (player.getNickname().equals(nickname)) return player;
        }
        return new Player(null);
    }

    public synchronized Board getBoard() {
        return board;
    }
}
