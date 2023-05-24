package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.message.Receiving_Mex;
import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.view.GUI.Scenes.*;
import it.polimi.ingsw.view.ObservableViewClient;
import it.polimi.ingsw.view.ViewClient;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.HashMap;

public class GUI extends ObservableViewClient implements ViewClient {
    private LivingRoomController livingController;
    private ChatController chatController;
    private CGController common1;
    private CGController common2;
    private String nickname;
    private WaitingController waitcontr;

    public GUI(LivingRoomController livingController, ChatController chatController, WaitingController wait) {
        this.livingController = livingController;
        this.chatController = chatController;
        this.waitcontr = wait;
        livingController.addAllObservers(observers);
        chatController.addAllObservers(observers);
        waitcontr.addAllObservers(observers);
    }

    @Override
    public void onShowReq(String s) {
        Platform.runLater(() -> livingController.setTextArea(s));
    }

    /**
     * The method calls the login interface scene to ask the number of players
     */
    @Override
    public void onNumbPlayerReq() {
        LoginSceneController login = (LoginSceneController) SceneController.getActiveController();
        Platform.runLater(() -> login.NumbPlayer());

    }

    /**
     * The method is needed to create a new board in th GUI interface
     * @param board
     */
    @Override
    public void onShowNewBoardReq(Board board) {
        Platform.runLater(() -> livingController.createBoard(board));
    }

    /**
     * The method calls the interface that shows that the game is over
     */
    @Override
    public void onNotifyGameFullReq() {
        LoginSceneController login = new LoginSceneController();
        Platform.runLater(() -> login.GameFull());
    }

    /**
     * The method shows the interface where a plyer has been disconnected with it's name
     * @param player
     */
    @Override
    public void onNotifyPlayerDisconnectionReq(Player player) {
        Platform.runLater(() -> chatController.removePlayer(player.getNickname()));
        Platform.runLater(() -> livingController.setTextArea(player.getNickname() + "has left the game"));
    }

    /**
     * The method shows the name of the player that has reconnected
     * @param player
     */
    @Override
    public void onNotifyPlayerReconnectionReq(Player player) {
        Platform.runLater(() -> livingController.setTextArea(player.getNickname() + "is back in the game"));
    }

    /**
     * The method is needed to connect the player to the game
     * @param nickname
     */
    @Override
    public void onNotifyPlayerConnectionReq(String nickname) {
        Platform.runLater(() -> waitcontr.setPlayer(nickname));
    }

    /**
     * The method shows the scene when the common goal card has been completed
     * @param nickname
     * @param completedEffectiveCard
     * @param score
     */
    @Override
    public void onNotifyReachedCommonGoalCardReq(String nickname, EffectiveCard completedEffectiveCard, int score) {
        if (this.nickname.equals(nickname)) {
            Platform.runLater(() -> livingController.setTokenCommon(score));
        } else {
            onShowReq(nickname + " has reached a common goal taking " + score + " score");
        }
    }

    /**
     * The method shows to the who has beeen given the chair to
     * @param nickname
     */
    @Override
    public void onNotifyChairAssignedReq(String nickname) {
        Platform.runLater(() -> livingController.setChair());
    }

    /**
     * The method shows the coloumns to put the selected cards
     * @param x
     * @param cards
     * @param library
     */
    @Override
    public void onShowPossibleColumnReq(int[] x, ArrayList<Card> cards, Library library) {
        Platform.runLater(() -> livingController.ShowColumn(x));
    }

    /**
     * The tells the player that the selected cards are not adjacent and can not be taken
     */
    @Override
    public void onNotifyCardsAreNotAdjacentReq() {
        Platform.runLater(() -> livingController.setTextArea("Cards are not adjacent. Take some valid"));
        askCardsToTakeFromBoard();
    }


    @Override
    public void onNotifyNumbPlayerReq(int playerNum) {

    }

    /**
     * The method shows the the player who finished the game first
     * @param player
     */
    @Override
    public void onNotifyPlayerFinishedFirstReq(Player player) {
        Platform.runLater(() -> livingController.setFirstFinished());
    }

    /**
     * The method shows the living room when the match starts
     * @param players
     */
    @Override
    public void onNotifyMatchHasStartedReq(ArrayList<Player> players) {
        Platform.runLater(() -> SceneController.setRootPane(livingController, "living_room.fxml"));
    }

    @Override
    public void onShowFinalScoreBoardReq(HashMap<String, Integer> point) {
        //interfaccia fine gioco
    }

    /**
     * The method shows to the player it's library
     * @param l
     * @param name
     */
    @Override
    public void onShowNewMyLibraryReq(Library l, String name) {
        if (name.equals(nickname)) {
            Platform.runLater(() -> livingController.createLibrary(l));
        } else {
            LibrariesController contr = new LibrariesController();
            Platform.runLater(() -> contr.createLibrary(l));
        }
    }

    /**
     * The method shows to the player a message when it has been disconnected
     */
    @Override
    public void onNotifyDisconnectionReqAcceptedAns() {
        Platform.runLater(() -> livingController.setTextArea("Disconnection accepted.Bye"));

    }

    @Override
    public void onNotifyNewNicknameReq() {

    }

    /**
     * The method tells the player that it's their turn now and shows the board and the library
     * @param board
     * @param library
     */
    @Override
    public void onNotifyIsYourTurnReq(Board board, Library library) {
        boolean yourTurn = true;
        Platform.runLater(() -> livingController.setYourTurn(yourTurn));
        askCardsToTakeFromBoard();
    }

    /**
     * The method shows to all the player the active player's turn
     * @param current_player
     */
    @Override
    public void onNotifyYourTurnIsEndedReq(String current_player) {
        Platform.runLater(() -> livingController.setTextArea("Now is" + current_player + "turn"));
    }

    /**
     * The method shows the name of the player who is playing right now
     * @param current_player
     */
    @Override
    public void onNotifyWhoIsPlayingNowReq(String current_player) {
        Platform.runLater(() -> livingController.setTextArea(current_player + "is playing"));
    }

    /**
     * The method shows the personal goal card of the player
     * @param personalGoalCard
     */
    @Override
    public void onNotifyPersonalCardReq(PersonalGoalCard personalGoalCard) {
        Platform.runLater(() -> livingController.setPP(personalGoalCard.getNumn_png()));
    }

    /**
     * The method asks the player it's nickname
     * @throws InterruptedException
     */
    @Override
    public void NotifyaskNicknameReq() throws InterruptedException {
        LoginSceneController login = new LoginSceneController();
        Platform.runLater(() -> login.Connect_before_first());
    }

    /**
     *The method sets the chat for all the players in the game
     * @param players
     */

    @Override
    public void onNotifyAllPlayerReq(ArrayList<String> players) {
        Platform.runLater(() -> chatController.setChats(players));
    }

    /**
     *The method sets the common goal cards for the match
     * @param cards
     */
    @Override
    public void onNotifyCommonCards(EffectiveCard[] cards) {
        common1 = new CGController();
        common2 = new CGController();
        Platform.runLater(() -> common1.setImageAndText(cards[0].getCommonCard().getNumberCard(), cards[0].getCommonCard().getDesc()));
        Platform.runLater(() -> common2.setImageAndText(cards[1].getCommonCard().getNumberCard(), cards[1].getCommonCard().getDesc()));
    }

    /**
     * The method notifies the chat when a message is recieved
     * @param getnickname
     * @param mex
     * @param dest
     */
    @Override
    public void onNotifyMexInChat(String getnickname, String mex, String dest) {
        Platform.runLater(() -> chatController.arrivedMex(getnickname, mex, dest));
    }

    /**
     * The method changes the scenes in the game
     * @param scene
     */
    @Override
    public void onPressedButtonChange(String scene) {
        switch (scene) {
            case "common1":
                Platform.runLater(() ->{
                    SceneController.setRootPane(common1, "CG.fxml");
                });
            case "common2":
                Platform.runLater(() -> SceneController.setRootPane(common2, "CG.fxml"));
            case "living":
                Platform.runLater(() -> SceneController.setRootPane(livingController, "living_room.fxml"));
            case "chat":
                Platform.runLater(() -> SceneController.setRootPane(chatController, "chat.fxml"));
            case "wait":
                Platform.runLater(() -> SceneController.setRootPane(waitcontr, "WaitController.fxml"));
        }
    }

    /**
     * The method asks the nickname to the player
     */
    @Override
    public void askNickname() {
        Platform.runLater(() -> SceneController.setRootPane(observers,"login_scene.fxml"));
    }

    @Override
    public void askNumberPlayer() {

    }

    /**
     * The method calls the method in living controller tot take the cards from the board
     */
    @Override
    public void askCardsToTakeFromBoard() {
        Platform.runLater(() -> livingController.TakeCards());
    }

    @Override
    public void askForDissconection() {

    }

    @Override
    public void actionByPlayer() {

    }

    @Override
    public void errorNickname(ArrayList<String> players) {

    }

    @Override
    public void readMessageChat(ArrayList<Receiving_Mex> message,ArrayList<String> players) {

    }
}
