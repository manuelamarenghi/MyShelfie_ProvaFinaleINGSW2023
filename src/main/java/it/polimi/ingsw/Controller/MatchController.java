package it.polimi.ingsw.Controller;

import it.polimi.ingsw.enumeration.GameState;
import it.polimi.ingsw.enumeration.TurnPhase;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.Numb_Player;
import it.polimi.ingsw.message.PutInLib;
import it.polimi.ingsw.message.TakeCardBoard;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Player;
import it.polimi.ingsw.view.VirtualView;
import it.polimi.ingsw.modello.Match;

import org.apache.maven.properties.internal.EnvironmentUtils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MatchController {
    private Match match;
    private int numberOfPlayers;
    private ArrayList<String> players;
    private TurnController turnController;
    private ArrayList<String> disconnectClients;
    private Map<String, VirtualView> connectClients;


    private boolean isStarted = false;


    private GameState gameState;
    private TurnPhase turnPhase;

    public MatchController(){
        this.match = new Match();
        this.connectClients = Collections.synchronizedMap(new HashMap<>());
    }


    public VirtualView getVirtualView(String nickname){
            return connectClients.get(nickname);
    }
    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }
    public boolean getIsStarted(){
        return isStarted;
    }

    public Match getMatch(){return match;}


    /**
     * Set the State of the Game.
     *
     * @param gameState State of the current Game.
     */
    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private void addPlayers(String nickname){
        players.add(nickname);
    }


    /**
     * connect new player and his virtualview
     * the first player, he needs choose how many player play
     *  other player, add virtualview and wait the game start
     */
    public void loginHandler(String nickname,VirtualView virtualView){
        if(connectClients.isEmpty()){
            addVirtualView(nickname,virtualView);
            addPlayers(nickname);

            //chiamata virtualview

        }
        else if(connectClients.size() < match.getPlayerNumber()){
            addVirtualView(nickname,virtualView);
            addPlayers(nickname);
        }
        else{
            startGame();
            //avviso virtualview che ci sono già abbastanza giocatori

        }
    }

    /**
     * Start game
     */
    public void startGame(){
        for(String name : players){
            this.match.setPlayers(new Player(name));
        }


        match.getMatchmanager().startGame(match);

        String firstPlayer = match.getChair().getNickname();
        int indexFirst = players.indexOf(firstPlayer);
        ArrayList<String> playerInOrder = new ArrayList<>();

        //Order player according with the chair
        if(indexFirst !=0) {
            for (int i = indexFirst; i < numberOfPlayers; i++) {
                playerInOrder.add(players.get(i));
            }
            for(int i = 0;i<indexFirst;i++){
                playerInOrder.add(players.get(i));
            }
        }
        else {
            for(int i = 0;i<numberOfPlayers;i++){
                playerInOrder.add(players.get(i));
            }
        }

        this.turnController = new TurnController(playerInOrder,match.getChair().getNickname(),match);
        //virtualview per far vedere le personal card e manda un messagio al primo giocatore e farlo iniziare.
    }

    /**
     * next player
     * call endgame when don't have a next player
     */
    private void nextPlayer(){
        if(turnController.nextPlayer() == true);
        //TODO avviso il player che deve giocare
        else{
            endGame();

        }
    }

    /**
     * END GAME
     * Send the score to the player
     */
    public void endGame(){
        HashMap<String,Integer> results = match.getMatchmanager().results(match);
        //TODO avviso i giocatori che il gioco è finito e visualizza il punteggio.

    }
    private void firstFinish(Player p){
        turnController.setLastRound(true);
        match.setFirstFinish(p);
    }

    //------------------------On message received-------------------------------------------

    /**
     * received generic message
     * @param m message
     */
    public void messageHandler (Message m){
        if(isStarted == true) {
            if (turnController.getActivePlayer().equals(m.getnickname())) {
                m.visit(this);
            } else {
                // TODO virtualview avvisa al cliente che non è il suo turno.
            }
        }
        else
            m.visit(this);
    }

    /**
     * this message received, the first player decide how many players play the game
     * @param numberPlayer number of player who play the game
     */
    public void handler(Numb_Player numberPlayer){
        match.setMatch(numberPlayer.getNumb());
        numberOfPlayers = numberPlayer.getNumb();


        // TODO virtualview che dice che attende gli altri giocatori
    }
    /**
     * this message the server received the card chosen by the player
     * @param m ArrayList of Card choose by the player
     */
    public void handler(TakeCardBoard m){
        ArrayList<Card> cardSelect = m.getCards();
        if(match.getBoard().allow(cardSelect)){
            for(Card card : cardSelect){
                match.getBoard().takeCard(card.getCoordinates());
            }
            match.getMatchmanager().IsEmptyBoard(match);

            Player player = match.getPlayerByNickname(m.getnickname());

            int[] coloum = match.getPlayerByNickname(m.getnickname()).getLibrary().showColumn(cardSelect.size());
            //TODO messaggio virtualview per dire al giocatore le colonne possibili

        }
        else{
            //messagio virtualview non può prenderli
        }

    }

    /**
     * Put the card in the library and notify the common cards
     * call next player
     * @param m
     */
    public void handler(PutInLib m){
        int coloum = m.getColumn();
        String player = m.getnickname();
        ArrayList<Card> cards = m.getCardsInOrder();

        match.getPlayerByNickname(player).getLibrary().setColumn(cards,coloum);
        if(match.getPlayerByNickname(player).getLibrary().isFull())
            firstFinish(match.getPlayerByNickname(player));
        match.getPlayerByNickname(player).getPlayerManager().notifyAllObservers(match.getPlayerByNickname(player));


        nextPlayer();

    }

    //----------------------VIRTUALVIEW METHODS----------------
    public void addVirtualView(String nickname,VirtualView virtualView){
        connectClients.put(nickname,virtualView);
        //TODO se si vuole aggiungere l'observer della virtualview
    }
}
