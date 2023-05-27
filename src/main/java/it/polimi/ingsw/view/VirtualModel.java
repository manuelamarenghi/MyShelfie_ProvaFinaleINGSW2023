package it.polimi.ingsw.view;

import it.polimi.ingsw.message.Receiving_Mex;
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

    private ArrayList<Card> cardSelect;
    private ArrayList<Receiving_Mex> chatMessage;

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
        this.chatMessage = new ArrayList<>();
    }

    public ArrayList<Card> getCardSelect() {
        return cardSelect;
    }

    public void setCardSelect(ArrayList<Card> cards) {
        this.cardSelect = cards;
    }

    public void setCommonCards(EffectiveCard[] commonCards) {
        CommonCards = commonCards;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Player getFirstFinish() {
        return firstFinish;
    }

    public ArrayList<Receiving_Mex> getChatMessage() {
        return chatMessage;
    }

    public void addChatMessage(Receiving_Mex message) {
        chatMessage.add(message);
    }

    public void resetChatMessage() {
        chatMessage = new ArrayList<>();
    }

    public void setFirstFinish(String firstFinish) {
        for (Player player : this.players) {
            if (player.getNickname().equals(firstFinish)) this.firstFinish = player;
        }
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<String> getPlayersNickname() {
        ArrayList<String> nicknames = new ArrayList<>();
        for (Player p : players) {
            nicknames.add(p.getNickname());
        }
        return nicknames;
    }

    public void setPlayers(ArrayList<String> players) {
        for (String p : players) {
            this.players.add(new Player(p));
        }
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String nickname) {
        this.players.removeIf(player -> player.getNickname().equals(nickname));
    }

    /**
     * A method to update the board
     *
     * @param board
     */
    public void updateBoard(Board board) {
        this.board = board;
    }

    /**
     * A method to update the chair
     *
     * @param nickname
     */
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

    public void updateIsMyTurn() {
        this.isMyTurn = !this.isMyTurn;
    }

    public boolean isMyTurn() {
        return this.isMyTurn;
    }

    public Player getMe() {
        return this.me;
    }

    public void setMe(String me) {
        this.me = new Player(me);
    }

    /**
     * A method to update all plyers' common goal score
     */
    public void updateCommonScore(String nickname, int score) {
        for (Player player : this.players) {
            if (player.getNickname().equals(nickname)) player.setCommonGoalScore(score);
        }
    }

    public Player getPlayer(String nickname) {
        for (Player player : this.players) {
            if (player.getNickname().equals(nickname)) return player;
        }
        return new Player(null);
    }

    public Board getBoard() {
        return board;
    }
}
