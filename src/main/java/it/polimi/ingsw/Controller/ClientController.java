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
    //localhost
    //16847

    public ClientController(ViewClient view, SocketClient socketClient) {
        this.view = view;
        this.virtualModel = new VirtualModel();
        this.socketClient = socketClient;
        socketClient.enablePinger(true);
        this.messageHandler = new MessageHandler(this.virtualModel);
        this.socketClient.addObserver(this.messageHandler);
        this.virtualModel.addObserver(this.view);

    }

    public ClientController(ViewClient view) {
        this.view = view;
        this.virtualModel = new VirtualModel();


    }

    /**
     * Method to set information for the server
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
     * Method to send a message to handle a new player in the game
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
     * A method to send a message to create a match
     * @param match
     */

    public void handleCreateMatch(Match match) {
        Created_Match message = new Created_Match(match);
        socketClient.sendMessage(message);
    }

    /**
     * the sends a message to socket client in case it decides to pick a card from board
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
        PlayerAction message = new PlayerAction(virtualModel.getMe().getNickname(), virtualModel.getCardSelect(), x);
        socketClient.sendMessage(message);
    }

    /**
     * A method to ask the server for the coloumns where it can put the cards
     * @param numberOfCards
     * @param name
     */
    public void handleColoumnRequest(int numberOfCards, String name) {
        ColumnRequest message = new ColumnRequest(numberOfCards, name);
        socketClient.sendMessage(message);
    }

    /**
     * A method to ask the virtualModel to see the bpard
     */
    @Override
    public void handleSeeBoard() {
        view.onShowNewBoardReq(virtualModel.getBoard());
    }

    /**
     * A method to ask the virtual model to show the personal goal card
     */
    @Override
    public void handleSeePersonalCard() {
        view.onNotifyPersonalCardReq(virtualModel.getMe().getPersonalCard());
    }

    /**
     * A method to ask the virtual model to see the common goal card
     */

    @Override
    public void handleSeeCommonCard() {
        view.onNotifyCommonCards(virtualModel.getCommonGoalCards());
    }

    /**
     * the method sends a message to socket client to calculate points for the player
     */
    public void handleFinalPoint(String name) {
        FinalPointRequest message = new FinalPointRequest(name);
        socketClient.sendMessage(message);
    }

    /**
     * The method tells the server to dissconect
     *
     * @param name
     */
    public void handleDisconection(String name) {
        Disconnection message = new Disconnection(name);
        socketClient.sendMessage(message);
    }

    /**
     * A method to send a message for the chat
     * @param dest
     * @param mex
     */
    @Override
    public void handleMexChat(ArrayList<String> dest, String mex) {
        MexInChat message = new MexInChat(mex, virtualModel.getMe().getNickname(), dest);
        socketClient.sendMessage(message);
    }

    /**
     * A method to set the nickname of the player
     * @param nickname
     */

    @Override
    public void setNickname(String nickname) {
        virtualModel.setMe(nickname);
    }

    /*public void addViewObserver(ViewClient view) {
        this.virtualModel.addObserver(view);

    }*/

    /**
     * A method to ask virtual model to see someones else's library
     * @param nickname
     */
    public void SeeSomeoneLibrary(String nickname) {
        if (!virtualModel.getPlayersNickname().contains(nickname))
            view.errorNickname(virtualModel.getPlayersNickname());
        else
            view.onShowNewMyLibraryReq(virtualModel.getPlayer(nickname).getLibrary(), nickname);
    }

    /**
     * A method to change a scene in GUI
     * @param scene
     */
    public void ChangeRoot(String scene) {
        view.onPressedButtonChange(scene);
    }

    /**
     * A method to read a message in chat
     */

    @Override
    public void ReadMessageChat(){
        ArrayList<Receiving_Mex> message = virtualModel.getChatMessage();
        view.readMessageChat(message,virtualModel.getPlayersNickname());
        virtualModel.resetChatMessage();
    }
}
