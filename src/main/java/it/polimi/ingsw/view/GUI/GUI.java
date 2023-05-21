package it.polimi.ingsw.view.GUI;

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
    }

    @Override
    public void onShowReq(String s) {
        Platform.runLater(() -> livingController.setTextArea(s));
    }

    @Override
    public void onNumbPlayerReq() {
        LoginSceneController login = new LoginSceneController();
        Platform.runLater(() -> login.NumbPlayer());
    }

    @Override
    public void onShowNewBoardReq(Board board) {
        Platform.runLater(() -> livingController.createBoard(board));
    }

    @Override
    public void onNotifyGameFullReq() {
        LoginSceneController login = new LoginSceneController();
        Platform.runLater(() -> login.GameFull());
    }

    @Override
    public void onNotifyPlayerDisconnectionReq(Player player) {
        Platform.runLater(() -> chatController.removePlayer(player.getNickname()));
        Platform.runLater(() -> livingController.setTextArea(player.getNickname() + "has left the game"));
    }

    @Override
    public void onNotifyPlayerReconnectionReq(Player player) {
        Platform.runLater(() -> livingController.setTextArea(player.getNickname() + "is back in the game"));
    }

    @Override
    public void onNotifyPlayerConnectionReq(String nickname) {
        Platform.runLater(() -> waitcontr.setPlayer(nickname));
    }

    @Override
    public void onNotifyReachedCommonGoalCardReq(String nickname, EffectiveCard completedEffectiveCard, int score) {
        if (this.nickname.equals(nickname)) {
            Platform.runLater(() -> livingController.setTokenCommon(score));
        } else {
            onShowReq(nickname + " has reached a common goal taking " + score + " score");
        }
    }

    @Override
    public void onNotifyChairAssignedReq(String nickname) {
        Platform.runLater(() -> livingController.setChair());
    }

    @Override
    public void onShowPossibleColumnReq(int[] x, ArrayList<Card> cards, Library library) {
        Platform.runLater(() -> livingController.ShowColumn(x));
    }

    @Override
    public void onNotifyCardsAreNotAdjacentReq() {
        Platform.runLater(() -> livingController.setTextArea("Cards are not adjacent. Take some valid"));
        askCardsToTakeFromBoard();
    }

    @Override
    public void onNotifyNumbPlayerReq(int playerNum) {

    }

    @Override
    public void onNotifyPlayerFinishedFirstReq(Player player) {
        Platform.runLater(() -> livingController.setFirstFinished());
    }

    @Override
    public void onNotifyMatchHasStartedReq(ArrayList<Player> players) {
        Platform.runLater(() -> SceneController.setRootPane(livingController, "living_room.fxml"));
    }

    @Override
    public void onShowFinalScoreBoardReq(HashMap<String, Integer> point) {
        //interfaccia fine gioco
    }

    @Override
    public void onShowNewMyLibraryReq(Library l, String name) {
        if (name.equals(nickname)) {
            Platform.runLater(() -> livingController.createLibrary(l));
        } else {
            LibrariesController contr = new LibrariesController();
            Platform.runLater(() -> contr.createLibrary(l));
        }
    }

    @Override
    public void onNotifyDisconnectionReqAcceptedAns() {
        Platform.runLater(() -> livingController.setTextArea("Disconnection accepted.Bye"));

    }

    @Override
    public void onNotifyNewNicknameReq() {

    }

    @Override
    public void onNotifyIsYourTurnReq(Board board, Library library) {
        boolean yourTurn = true;
        Platform.runLater(() -> livingController.setYourTurn(yourTurn));
        askCardsToTakeFromBoard();
    }

    @Override
    public void onNotifyYourTurnIsEndedReq(String current_player) {
        Platform.runLater(() -> livingController.setTextArea("Now is" + current_player + "turn"));
    }

    @Override
    public void onNotifyWhoIsPlayingNowReq(String current_player) {
        Platform.runLater(() -> livingController.setTextArea(current_player + "is playing"));
    }

    @Override
    public void onNotifyPersonalCardReq(PersonalGoalCard personalGoalCard) {
        Platform.runLater(() -> livingController.setPP(personalGoalCard.getNumn_png()));
    }

    @Override
    public void NotifyaskNicknameReq() throws InterruptedException {
        LoginSceneController login = new LoginSceneController();
        Platform.runLater(() -> login.Connect_before_first());
    }

    @Override
    public void onNotifyAllPlayerReq(ArrayList<String> players) {
        Platform.runLater(() -> chatController.setChats(players));
    }

    @Override
    public void onNotifyCommonCards(EffectiveCard[] cards) {
        common1 = new CGController();
        common2 = new CGController();
        Platform.runLater(() -> common1.setImageAndText(cards[0].getCommonCard().getNumberCard(), cards[0].getCommonCard().getDesc()));
        Platform.runLater(() -> common2.setImageAndText(cards[1].getCommonCard().getNumberCard(), cards[1].getCommonCard().getDesc()));
    }

    @Override
    public void onNotifyMexInChat(String getnickname, String mex, String dest) {
        Platform.runLater(() -> chatController.arrivedMex(getnickname, mex, dest));
    }

    @Override
    public void onPressedButtonChange(String scene) {
        switch (scene) {
            case "common1":
                Platform.runLater(() -> SceneController.setRootPane(common1, "CG.fxml"));
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

    @Override
    public void askNickname() {
        Platform.runLater(() -> SceneController.setRootPane(new LoginSceneController(),"login_scene.fxml"));
    }

    @Override
    public void askNumberPlayer() {

    }

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
    public void errorNickname(ArrayList<Player> players) {

    }
}
