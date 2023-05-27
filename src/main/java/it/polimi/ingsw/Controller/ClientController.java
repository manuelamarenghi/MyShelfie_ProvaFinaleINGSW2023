package it.polimi.ingsw.Controller;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.Position;
import it.polimi.ingsw.network.MessageHandler;
import it.polimi.ingsw.network.SocketClient;
import it.polimi.ingsw.view.ObserverViewClient;
import it.polimi.ingsw.view.ViewClient;
import it.polimi.ingsw.view.VirtualModel;

import java.io.IOException;
import java.util.ArrayList;

public class ClientController implements ObserverViewClient {
    private ViewClient view;
    private SocketClient socketClient;
    private VirtualModel virtualModel;
    private MessageHandler messageHandler;

    /**
     * Constructor of the controller class
     * @param view
     */
    public ClientController(ViewClient view) {
        this.view = view;
        this.virtualModel = new VirtualModel();


    }

    /**
     * Method to set the information for the server
     * @param ipAddress
     */
    @Override
    public void setServerInfo(String ipAddress) {
        try {
            this.socketClient = new SocketClient(ipAddress, 16847);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        socketClient.readMessage();
        socketClient.enablePinger(true);
        this.messageHandler = new MessageHandler(this.virtualModel);
        this.virtualModel.addObserver(this.view);
        this.socketClient.addObserver(this.messageHandler);
        this.view.askNickname();

    }

    /**
     * A method to handle a message for a new player that has entered in the game
     * @param nickname
     */
    public void handleEnterPlayer(String nickname) {
        EnterPlayer message = new EnterPlayer(nickname);
        socketClient.sendMessage(message);
    }

    /**
     * The method creates board depending on number of players
     */

    public void handleCreateBoard(int numeberOfPlayers) {
        Numb_Player message = new Numb_Player(numeberOfPlayers, virtualModel.getMe().getNickname());
        socketClient.sendMessage(message);
    }

    /**
     * A handle method to send a message to the socket client when a math is being created
     * @param match
     */
    public void handleCreateMatch(Match match) {
        Created_Match message = new Created_Match(match);
        socketClient.sendMessage(message);
    }

    /**
     * the method sends a message to socket client in case it decides to pick a card from board
     */
    public void handleTakeCard(Position[] positions) {
        int i;
        ArrayList<Card> cards = new ArrayList<>();
        for (i = 0; i < positions.length; i++) {
            if (virtualModel.getBoard().getCard(positions[i].getX(), positions[i].getY()).getCoordinates() == null) {
                view.onNotifyCardsAreNotAdjacentReq();
                return;
            } else {
                cards.add(virtualModel.getBoard().getCard(positions[i].getX(), positions[i].getY()));
            }
        }
        if (virtualModel.getBoard().allow(cards)) {
            for (Card card : cards) {
                virtualModel.getBoard().takeCard(card.getCoordinates());
            }
            view.onShowNewBoardReq(virtualModel.getBoard());
            virtualModel.setCardSelect(cards);
            int[] coloum = virtualModel.getMe().getLibrary().showColumn(cards.size());
            if (coloum.length == 0)
                view.onNotifyCardsAreNotAdjacentReq();
            else
                view.onShowPossibleColumnReq(coloum, cards, virtualModel.getMe().getLibrary());
        } else
            view.onNotifyCardsAreNotAdjacentReq();
    }
    /**
     * The method sends a message to socket client to put a card in the library
     */
    public void handlePutInLibrary(int x) {
        System.out.println("mando colonna scelta");
        PlayerAction message = new PlayerAction(virtualModel.getMe().getNickname(), virtualModel.getCardSelect(), x);
        socketClient.sendMessage(message);
    }

    /**
     * A handle method for the message to see the board
     */
    @Override
    public void handleSeeBoard() {
        view.onShowNewBoardReq(virtualModel.getBoard());
    }

    /**
     * A handle method for the message to see the personal goal card
     */
    @Override
    public void handleSeePersonalCard() {
        view.onNotifyPersonalCardReq(virtualModel.getMe().getPersonalCard());
    }

    /**
     * A handle method for the message to see the common goal card
     */
    @Override
    public void handleSeeCommonCard() {
        view.onNotifyCommonCards(virtualModel.getCommonGoalCards());
    }

    /**
     * The method tells the server to dissconect
     * @param name
     */
    public void handleDisconection(String name) {
        Disconnection message = new Disconnection(name);
        socketClient.sendMessage(message);
    }

    /**
     * A handle method for the message to handle a new message recived in the chat
     * @param dest
     * @param mex
     */
    @Override
    public void handleMexChat(ArrayList<String> dest, String mex) {
        MexInChat message = new MexInChat(mex, virtualModel.getMe().getNickname(), dest);
        socketClient.sendMessage(message);
    }

    /**
     * A handle method for the message to set the player's nickname
     * @param nickname
     */
    @Override
    public void setNickname(String nickname) {
        virtualModel.setMe(nickname);
        view.setNickname(nickname);
    }

    /*public void addViewObserver(ViewClient view) {
        this.virtualModel.addObserver(view);

    }*/

    /**
     * A method to see some other player's library through the virtual model
     * @param nickname
     */
    public void SeeSomeoneLibrary(String nickname) {
        if (!virtualModel.getPlayersNickname().contains(nickname))
            view.errorNickname(virtualModel.getPlayersNickname());
        else
            view.onShowNewMyLibraryReq(virtualModel.getPlayer(nickname).getLibrary(), nickname);
    }

    /**
     * A method to change the scene
     * @param scene
     */
    public void ChangeRoot(String scene) {
        view.onPressedButtonChange(scene);
    }

    /**
     * A method to read a message from the chat
     */
    @Override
    public void ReadMessageChat() {
        ArrayList<Receiving_Mex> message = virtualModel.getChatMessage();
        view.readMessageChat(message, virtualModel.getPlayersNickname());
        virtualModel.resetChatMessage();
    }
}
