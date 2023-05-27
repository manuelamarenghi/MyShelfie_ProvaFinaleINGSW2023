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
    private CG_oneController common1;
    private CG_twoController common2;
    private String nickname;
    private WaitingController waitcontr;
    private LibrariesController lcontr;

    public GUI(LivingRoomController livingController, ChatController chatController, WaitingController wait) {
        this.livingController = livingController;
        this.livingController.start();
        this.chatController = chatController;
        this.waitcontr = wait;
        lcontr = new LibrariesController();
        common1 = new CG_oneController();
        common2 = new CG_twoController();
    }

    /**
     * A method that shows the living room when the game starts
     * @param s
     */
    @Override
    public void onShowReq(String s) {
        System.out.println(s);
        if (s.equals("Server message: Start Game")) {
            lcontr.addAllObservers(observers);
            livingController.addAllObservers(observers);
            waitcontr.addAllObservers(observers);
            onPressedButtonChange("living");
        } else {
            Platform.runLater(() -> livingController.setTextArea(s));
        }
    }

    /**
     * A method for the number of players request
     */
    @Override
    public void onNumbPlayerReq() {
        LoginSceneController login = (LoginSceneController) SceneController.getActiveController();
        Platform.runLater(() -> login.NumbPlayer());

    }

    /**
     * A method that shows the new board
     * @param board
     */
    @Override
    public void onShowNewBoardReq(Board board) {
        livingController.getData().setBoard(board);
        Platform.runLater(() -> livingController.createBoard(board));
    }

    /**
     * A method to use when the number of players is already full
     */
    @Override
    public void onNotifyGameFullReq() {
        LoginSceneController login = new LoginSceneController();
        Platform.runLater(() -> login.GameFull());
    }

    /**
     * A method to notify when a player has left the game
     * @param player
     */
    @Override
    public void onNotifyPlayerDisconnectionReq(Player player) {
        Platform.runLater(() -> chatController.removePlayer(player.getNickname()));
        Platform.runLater(() -> livingController.setTextArea(player.getNickname() + "has left the game\n"));
    }

    /**
     * A method to notify when the player is back in the game after the dissconnection
     * @param player
     */
    @Override
    public void onNotifyPlayerReconnectionReq(Player player) {
        Platform.runLater(() -> livingController.setTextArea(player.getNickname() + "is back in the game\n"));
    }

    /**
     * A notify method when a player is connected to the game
     * @param nickname
     * @param you
     */
    @Override
    public void onNotifyPlayerConnectionReq(String nickname, boolean you) {
        if (you) {
            notifyObserver(obs -> obs.setNickname(nickname));
            onPressedButtonChange("wait");
        } else {
            Platform.runLater(() -> waitcontr.setPlayer(nickname));
        }
    }

    /**
     * A mathod to notify when the common goal has been completed
     * @param nickname
     * @param completedEffectiveCard
     * @param score
     */
    @Override
    public void onNotifyReachedCommonGoalCardReq(String nickname, EffectiveCard completedEffectiveCard, int score) {
        if (this.nickname.equals(nickname)) {
            if (!livingController.isToken1set()) {
                livingController.getData().setScore0(score);
            } else {
                livingController.getData().setScore1(score);
            }
            Platform.runLater(() -> livingController.setTokenCommon(score));
        } else {
            onShowReq(nickname + " has reached a common goal taking " + score + " score\n");
        }
    }

    /**
     * A notify method to notify the name of the player to who the chair has been assigned
     * @param nickname
     */
    @Override
    public void onNotifyChairAssignedReq(String nickname) {
        livingController.getData().setChair(true);
        Platform.runLater(() -> livingController.setChair());
    }

    /**
     * A notify method to show the possible coloumns where the cards can be put
     * @param x
     * @param cards
     * @param library
     */
    @Override
    public void onShowPossibleColumnReq(int[] x, ArrayList<Card> cards, Library library) {
        Platform.runLater(() -> livingController.ShowColumn(x));
    }

    /**
     * A method to notify the player that the cards are not adjacent
     */
    @Override
    public void onNotifyCardsAreNotAdjacentReq() {
        Platform.runLater(() -> livingController.setTextArea("Cards are not adjacent. Take some valid\n"));
        askCardsToTakeFromBoard();
    }
    @Override
    public void onNotifyNumbPlayerReq(int playerNum) {
        // vuoto
    }

    /**
     * A method to notify the player who has finished the game first
     * @param player
     */
    @Override
    public void onNotifyPlayerFinishedFirstReq(Player player) {
        livingController.getData().setFirstFinish(true);
        Platform.runLater(() -> livingController.setFirstFinished());
    }

    /**
     * A method to notify when the match has started
     * @param players
     */
    @Override
    public void onNotifyMatchHasStartedReq(ArrayList<Player> players) {
        Platform.runLater(() -> SceneController.setRootPane(livingController, "living_room.fxml"));
    }

    /**
     * A method to notify the final score board of the game
     * @param point
     */
    @Override
    public void onShowFinalScoreBoardReq(HashMap<String, Integer> point) {
        FinalController finalcontr = new FinalController();
        finalcontr.addAllObservers(observers);
        Platform.runLater(() -> SceneController.setRootPane(finalcontr, "FinalScene.fxml"));
        Platform.runLater(() -> finalcontr.SetClassification(point));
    }

    /**
     * A method to create and show a new library for the player
     * @param l
     * @param name
     */
    @Override
    public void onShowNewMyLibraryReq(Library l, String name) {
        if (name.equals(nickname)) {
            livingController.getData().setLibrary(l);
            Platform.runLater(() -> livingController.createLibrary(l));
        } else {
            Platform.runLater(() -> lcontr.createLibrary(l));
        }
    }

    /**
     * A method to notify when a player decides to dissconnect
     */
    @Override
    public void onNotifyDisconnectionReqAcceptedAns() {
        Platform.runLater(() -> livingController.setTextArea("Disconnection accepted.Bye"));

    }

    /**
     * A method to notify the player that it has to select an another nickname
     */
    @Override
    public void onNotifyNewNicknameReq() {
        LoginSceneController login = (LoginSceneController) SceneController.getActiveController();
        Platform.runLater(() -> login.TryAgainNick());
    }

    /**
     * A method to notify the player that it's their turn
     * @param board
     * @param library
     */
    @Override
    public void onNotifyIsYourTurnReq(Board board, Library library) {
        boolean yourTurn = true;
        livingController.getData().setLibrary(library);
        Platform.runLater(() -> livingController.createLibrary(library));
        Platform.runLater(() -> livingController.setYourTurn(yourTurn));
        Platform.runLater(() -> livingController.setTextArea("Insert the number of items you want to take"));
        askCardsToTakeFromBoard();
    }

    /**
     * A method to notify the player that their turn has ended
     * @param current_player
     */
    @Override
    public void onNotifyYourTurnIsEndedReq(String current_player) {
        boolean yourTurn = false;
        Platform.runLater(() -> livingController.setYourTurn(yourTurn));
        Platform.runLater(() -> livingController.setTextArea("Your turn is over"));
    }

    /**
     * A method to notify the player which player is playing right now
     * @param current_player
     */
    @Override
    public void onNotifyWhoIsPlayingNowReq(String current_player) {
        Platform.runLater(() -> livingController.setTextArea(current_player + " is playing"));
    }

    /**
     * A method to notify the player about their personal goal card
     * @param personalGoalCard
     */
    @Override
    public void onNotifyPersonalCardReq(PersonalGoalCard personalGoalCard) {
        Platform.runLater(() -> livingController.setPP(personalGoalCard.getNumn_png()));
    }

    /**
     * A method to Ask the player their nickname
     * @throws InterruptedException
     */
    @Override
    public void NotifyaskNicknameReq() throws InterruptedException {
        LoginSceneController login = new LoginSceneController();
        Platform.runLater(() -> login.Connect_before_first());
    }
    /**
     * The method prints the players of the match
     *
     * @param players
     */
    @Override
    public void onNotifyAllPlayerReq(ArrayList<String> players) {
        chatController.addAllObservers(observers);
        players.remove(nickname);
        Platform.runLater(() -> chatController.initialize());
        Platform.runLater(() -> chatController.setChats(players));
    }
    /**
     * A notify method to see and get the description of the common goal cards
     * @param cards
     */
    @Override
    public void onNotifyCommonCards(EffectiveCard[] cards) {
        common2.addAllObservers(observers);
        common1.addAllObservers(observers);
        Platform.runLater(() -> common1.setImageAndText(cards[0].getCommonCard().getNumberCard(), cards[0].getCommonCard().getDesc()));
        Platform.runLater(() -> common2.setImageAndText(cards[1].getCommonCard().getNumberCard(), cards[1].getCommonCard().getDesc()));
    }

    /**
     * A method to send the message recived int he chat to destination
     * @param getnickname
     * @param mex
     * @param dest
     */
    @Override
    public void onNotifyMexInChat(String getnickname, String mex, String dest) {
        Platform.runLater(() -> chatController.arrivedMex(getnickname, mex, dest));
    }

    /**
     * A methos to set the scene for the GUI
     * @param scene
     */
    @Override
    public void onPressedButtonChange(String scene) {
        switch (scene) {
            case "common1":
                Platform.runLater(() -> SceneController.setRootPane(common1, "CG.fxml"));
                break;
            case "common2":
                Platform.runLater(() -> SceneController.setRootPane(common2, "CG_two.fxml"));
                break;
            case "living":
                Platform.runLater(() -> SceneController.setRootPane(livingController, "living_room.fxml"));
                break;
            case "chat":
                Platform.runLater(() -> SceneController.setRootPane(chatController, "chat.fxml"));
                break;
            case "wait":
                Platform.runLater(() -> SceneController.setRootPane(waitcontr, "WaitController.fxml"));
                break;
            case "library":
                Platform.runLater(() -> SceneController.setRootPane(lcontr, "libraries.fxml"));
                break;
        }
    }

    /**
     * A method to set the player's nickname
     * @param nickname
     */
    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
        chatController.setYourNickname(nickname);
    }

    /**
     * A method to ask the player thier nickname
     */
    @Override
    public void askNickname() {
        Platform.runLater(() -> SceneController.setRootPane(observers, "login_scene.fxml"));
    }

    @Override
    public void askNumberPlayer() {

    }

    /**
     * A metho to ask the player to take card from the board
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
    public void readMessageChat(ArrayList<Receiving_Mex> message, ArrayList<String> players) {

    }
}
