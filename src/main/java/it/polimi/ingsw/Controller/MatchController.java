package it.polimi.ingsw.Controller;


import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.Numb_Player;
import it.polimi.ingsw.message.PutInLib;
import it.polimi.ingsw.message.TakeCardBoard;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Player;
import it.polimi.ingsw.view.VirtualView;
import it.polimi.ingsw.modello.Match;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MatchController {
    private Match match;
    private int numberOfPlayers;
    private ArrayList<String> players;
    private TurnController turnController;
    private Map<Player, VirtualView> disconnectClients;
    private Map<String, VirtualView> connectClients;


    private boolean isStarted = false;



    public MatchController(){
        this.match = new Match();
        this.connectClients = Collections.synchronizedMap(new HashMap<>());
        this.disconnectClients=Collections.synchronizedMap(new HashMap<>());
        players = new ArrayList<>();
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


    private void addPlayers(String nickname){
        players.add(nickname);
    }
    /**
     * connect new player and his virtualview
     * the first player, he needs choose how many player play
     *  other player, add virtualview and wait the game start
     */
    public synchronized void loginHandler(String nickname, VirtualView virtualView) {
        if (connectClients.keySet().contains(nickname)) {
               virtualView.askNickname();
        } else {
            if (connectClients.isEmpty()) {
                addVirtualView(nickname, virtualView);
                addPlayers(nickname);
                match.setPlayers(new Player(nickname));
                match.getPlayerByNickname(nickname).setView(virtualView);
                connectClients.get(nickname).askNumbPlayer();
            } else if (connectClients.size() < match.getPlayerNumber()) {
                addVirtualView(nickname, virtualView);
                addPlayers(nickname);
                match.setPlayers(new Player(nickname));
                match.getPlayerByNickname(nickname).setView(virtualView);
                for (VirtualView v : connectClients.values()) {
                    if(!connectClients.equals(connectClients.get(nickname)))
                             {v.AcceptNewPlayer(nickname);}
                }
                if(connectClients.size() == match.getPlayerNumber()){ startGame();}
            } else {
                connectClients.get(nickname).Gamefull();
            }
        }
    }
    /**
     * Start game
     */
    public void startGame(){

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
    }

    /**
     * next player
     * call endgame when don't have a next player
     */
    private void nextPlayer(){
        if(turnController.nextPlayer() == true)
            connectClients.get(turnController.getActivePlayer()).YourTurn(turnController.getActivePlayer());
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
        for(VirtualView v: connectClients.values()){
         v.EndGame(results);
        }
    }
    private void firstFinish(Player p){
        turnController.setLastRound(true);
        match.setFirstFinish(p);
        for(VirtualView v: connectClients.values()){
            v.FirstFinished(match.getFirstFinish().getNickname());
        }
    }
    /**
     * removeClient() when a client wants to live or has problem with the connection
     * @param nickname
     */
    public void removeClient(String nickname){
        Player p=match.getPlayerByNickname(nickname);
        disconnectClients.put(p,connectClients.get(nickname));
        connectClients.remove(nickname);
        match.getPlayers().remove(p);
        for(VirtualView v: connectClients.values()){
            v.updateanotherplayerconnect(nickname,false,null);
        }
    }
    /**
     * PlayerBack() when a player before disconnected returns back
     * @param name
     */
    public void PlayerBack(String name){
        Player player=null;
        for(Player p: disconnectClients.keySet())
        {
            if(p.getNickname().equals(name)){  player=p;}
        }
        connectClients.put(name,disconnectClients.get(player));
        disconnectClients.remove(player);
        match.getPlayers().add(player);
        for(VirtualView v: connectClients.values()) {
            if (v.equals(connectClients.get(player.getNickname()))) {
                v.CreateMatch(match);
            } else {
                v.updateanotherplayerconnect(name, true, player);
            }
        }
    }
    //------------------------On message received-------------------------------------------

    /**
     * received generic message
     * @param m message
     */
    public void messageHandler (Message m){
        if(isStarted == true) {
            if (turnController.getActivePlayer().equals(m.getnickname())) {
                m.visitServer(this);
            } else {
                connectClients.get(m.getnickname()).GenericMessage(null,"WrongAction");
            }
        }
        else
            m.visitServer(this);
    }

    /**
     * this message received, the first player decide how many players play the game
     * @param numberPlayer number of player who play the game
     */
    public void handler(Numb_Player numberPlayer){
        match.setMatch(numberPlayer.getNumb());
        numberOfPlayers = numberPlayer.getNumb();
        for(VirtualView v: connectClients.values()){
            v.sendNumbPlayer(numberOfPlayers);
        }
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
            for(VirtualView v: connectClients.values()){
                v.updateboard(match.getBoard());
            }
            Player player = match.getPlayerByNickname(m.getnickname());

            int[] coloum = match.getPlayerByNickname(m.getnickname()).getLibrary().showColumn(cardSelect.size());
            connectClients.get(player.getNickname()).showPossibleColumn(player.getNickname(),coloum);
        }
        else{
            connectClients.get(m.getnickname()).NotallowedCard(m.getnickname());
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
        for(VirtualView v: connectClients.values()){
            v.updatelibrary(match.getPlayerByNickname(m.getnickname()).getLibrary(),m.getnickname());
        }
        if(match.getPlayerByNickname(player).getLibrary().isFull())
            firstFinish(match.getPlayerByNickname(player));
        match.getPlayerByNickname(player).getPlayerManager().notifyAllObservers(match.getPlayerByNickname(player));


        nextPlayer();

    }

    //----------------------VIRTUALVIEW METHODS----------------
    public void addVirtualView(String nickname,VirtualView virtualView){
        connectClients.put(nickname,virtualView);
    }
}
