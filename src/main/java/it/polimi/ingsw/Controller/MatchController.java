package it.polimi.ingsw.Controller;


import it.polimi.ingsw.message.*;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.EffectiveCard;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.Player;
import it.polimi.ingsw.view.VirtualView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MatchController {
    private Match match;
    private Integer numberOfPlayers;
    private ArrayList<String> players;
    private TurnController turnController;
    private ArrayList<Player> disconnectClients;
    private Map<String, VirtualView> connectClients;
    private boolean isStarted = false;
    ArrayList<Card> cardSelect;


    public MatchController() {
        this.match = new Match();
        this.connectClients = Collections.synchronizedMap(new HashMap<>());
        this.disconnectClients = new ArrayList<>();
        players = new ArrayList<>();
    }

    public VirtualView getVirtualView(String nickname) {
        return connectClients.get(nickname);
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public boolean getIsStarted() {
        return isStarted;
    }

    public Match getMatch() {
        return match;
    }


    private void addPlayers(String nickname) {
        players.add(nickname);
    }

    /**
     * connect new player and his virtualview
     * the first player, he needs choose how many player play
     * other player, add virtualview and wait the game start
     */
    public boolean loginHandler(String nickname, VirtualView virtualView) {
        if (players.contains(nickname) && !players.isEmpty()) {
            virtualView.askNickname();
            return false;
        } else {
            if (connectClients.isEmpty()) {
                addVirtualView(nickname, virtualView);
                addPlayers(nickname);
                virtualView.AcceptNewPlayer(nickname, false);
                match.setPlayers(new Player(nickname));
                connectClients.get(nickname).askNumbPlayer();
            } else if (numberOfPlayers != null) {
                if (connectClients.size() < numberOfPlayers) {
                    addVirtualView(nickname, virtualView);
                    addPlayers(nickname);
                    match.setPlayers(new Player(nickname));
                    for (VirtualView v : connectClients.values()) {
                        if (!v.equals(connectClients.get(nickname))) {
                            v.AcceptNewPlayer(nickname, false);
                        } else {
                            v.AcceptNewPlayer(nickname, true);
                        }
                    }
                    if (connectClients.size() == match.getPlayerNumber()) {
                        startGame();
                    }
                } else {
                    virtualView.Gamefull();
                    return false;
                }
            } else {
                virtualView.update(new Connected_Before_FirstPlayer("Server"));
                return false;
            }
        }
        return true;
    }

    /**
     * Start game
     */
    public void startGame() {

        for (VirtualView vv : connectClients.values()) {
            vv.GenericMessage("Server", "Start Game");
            vv.sendAllPlayers(players);
        }


        match.getMatchmanager().startGame(match);

        for (Player player : match.getPlayers()) {
            connectClients.get(player.getNickname()).sendPersonalCard(player.getPersonalCard());
            connectClients.get(player.getNickname()).sendCommonCard(match.getCommonCards());
        }


        //Order player accord with the chair

        String firstPlayer = match.getChair().getNickname();
        connectClients.get(firstPlayer).assignedChair(firstPlayer);
        int indexFirst = players.indexOf(firstPlayer);
        ArrayList<String> playerInOrder = new ArrayList<>();


        if (indexFirst != 0) {
            for (int i = indexFirst; i < numberOfPlayers; i++) {
                playerInOrder.add(players.get(i));
            }
            for (int i = 0; i < indexFirst; i++) {
                playerInOrder.add(players.get(i));
            }
        } else {
            for (int i = 0; i < numberOfPlayers; i++) {
                playerInOrder.add(players.get(i));
            }
        }
        for (EffectiveCard e : match.getCommonCards()) {
            for (VirtualView v : connectClients.values()) {
                e.addObserver(v);
            }
        }
        isStarted = true;
        this.turnController = new TurnController(playerInOrder, match.getChair().getNickname(), match);
        for (VirtualView vv : connectClients.values()) {
            vv.YourTurn(turnController.getActivePlayer());
        }

    }

    /**
     * next player
     * call endgame when don't have a next player
     */
    private void nextPlayer() {
        if (turnController.nextPlayer() == true) {
            for (Player player : disconnectClients) {
                if (player.getNickname().equals(turnController.getActivePlayer())) {
                    nextPlayer();
                    return;
                }
            }
            for (VirtualView vv : connectClients.values()) {
                vv.YourTurn(turnController.getActivePlayer());
            }
        } else {
            endGame();
        }
    }

    /**
     * END GAME
     * Send the score to the player
     */
    public void endGame() {
        HashMap<String, Integer> results = match.getMatchmanager().results(match);
        for (VirtualView v : connectClients.values()) {
            v.EndGame(results);
        }
    }

    /**
     * one player finish library, notify all player last round
     *
     * @param p player finish
     */
    private void firstFinish(Player p) {
        turnController.setLastRound(true);
        match.setFirstFinish(p);
        for (VirtualView v : connectClients.values()) {
            v.FirstFinished(match.getFirstFinish().getNickname());
        }
    }

    /**
     * removeClient() when a client wants to live or has problem with the connection
     *
     * @param nickname
     */
    public void removeClient(String nickname) {
        Player p = match.getPlayerByNickname(nickname);
        if (isStarted) {
            disconnectClients.add(p);
            for (EffectiveCard e : match.getCommonCards()) {
                e.removeObserver(connectClients.get(nickname));
            }
            if (turnController.getActivePlayer().equals(nickname))
                nextPlayer();
        }
        match.getPlayers().remove(p);
        connectClients.remove(nickname);
        players.remove(nickname);
        for (VirtualView v : connectClients.values()) {
            v.updateanotherplayerconnect(nickname, false, null);
        }
    }

    /**
     * PlayerBack() when a player that have been disconnected returns
     *
     * @param name
     */
    public void PlayerBack(String name, VirtualView virtualView) {
        Player player = null;
        for (Player p : disconnectClients) {
            if (p.getNickname().equals(name)) {
                player = p;
            }
        }
        connectClients.put(name, virtualView);
        virtualView.AcceptNewPlayer(name, true);

        match.getPlayers().add(player);
        disconnectClients.remove(player);
        if (isStarted) {
            for (VirtualView v : connectClients.values()) {
                if (v.equals(connectClients.get(player.getNickname()))) {
                    for (EffectiveCard e : match.getCommonCards()) {
                        e.addObserver(connectClients.get(name));
                    }
                    v.sendAllPlayers(players);
                    connectClients.get(name).updateboard(match.getBoard());
                    connectClients.get(name).sendCommonCard(match.getCommonCards());
                    v.sendPersonalCard(player.getPersonalCard());
                    for (Player p : match.getPlayers()) {
                        v.updatelibrary(p.getLibrary(), p.getNickname());
                    }

                } else {
                    v.updateanotherplayerconnect(name, true, player);
                }
            }
        }
    }

//------------------------On message received-------------------------------------------

    /**
     * received generic message
     *
     * @param m message
     */
    public void messageHandler(Message m) {
        if (isStarted == true) {
            if (!m.getType().equals("Ping!")) {
                if (turnController.getActivePlayer().equals(m.getnickname())) {
                    m.visitServer(this);
                } else {
                    connectClients.get(m.getnickname()).GenericMessage(null, "WrongAction");
                }
            }
        } else
            m.visitServer(this);
    }

    /**
     * this message received, the first player decide how many players play the game
     *
     * @param numberPlayer number of player who play the game
     */
    public void handler(Numb_Player numberPlayer) {

        match.setMatch(numberPlayer.getNumb());

        numberOfPlayers = numberPlayer.getNumb();

        System.out.println("The number of players is " + numberPlayer.getNumb());
        for (VirtualView v : connectClients.values()) {
            v.sendNumbPlayer(numberOfPlayers);
        }

    }

    public void handler(PlayerAction m) {
        cardSelect = m.getCards();
        int column = m.getColumn();
        String nickname = m.getnickname();

        if (match.getBoard().allow(cardSelect)) {
            for (Card card : cardSelect) {
                match.getBoard().takeCard(card.getCoordinates());
            }
            match.getMatchmanager().IsEmptyBoard(match);
            for (VirtualView v : connectClients.values()) {
                v.updateboard(match.getBoard());
            }
            System.out.println("update board");
            match.getPlayerByNickname(nickname).getLibrary().setColumn(cardSelect, column);

            for (VirtualView v : connectClients.values()) {
                v.updatelibrary(match.getPlayerByNickname(m.getnickname()).getLibrary(), m.getnickname());
            }
            System.out.println("update library");
            if (match.getPlayerByNickname(nickname).getLibrary().isFull())
                firstFinish(match.getPlayerByNickname(nickname));

            System.out.println("Finish control library full");
            match.getPlayerByNickname(nickname).getPlayerManager().notifyAllObservers(match.getPlayerByNickname(nickname));
            System.out.println("call next player");
            nextPlayer();

            System.out.println("next player");

        } else {
            connectClients.get(m.getnickname()).NotallowedCard(m.getnickname());
        }

    }

    //----------------------VIRTUALVIEW METHODS----------------
    public void addVirtualView(String nickname, VirtualView virtualView) {
        connectClients.put(nickname, virtualView);
        match.addObserver(virtualView);
    }
}
