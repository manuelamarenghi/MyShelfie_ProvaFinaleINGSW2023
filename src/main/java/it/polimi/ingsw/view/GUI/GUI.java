package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.view.GUI.Scenes.ChatController;
import it.polimi.ingsw.view.GUI.Scenes.LibrariesController;
import it.polimi.ingsw.view.GUI.Scenes.LivingRoomController;
import it.polimi.ingsw.view.ObservableViewClient;
import it.polimi.ingsw.view.ViewClient;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.HashMap;

public class GUI extends ObservableViewClient implements ViewClient {
    private ClientController clientController;
    private LivingRoomController livingController;
    private ChatController chatController;
    private String nickname;

    public GUI(LivingRoomController livingController, ChatController chatController) {
        this.livingController = livingController;
        this.chatController = chatController;
    }

    @Override
    public void onShowReq(String s) {
        Platform.runLater(() -> livingController.setTextArea(s));
    }

    @Override
    public void onNumbPlayerReq() {

    }

    @Override
    public void onShowNewBoardReq(Board board) {
        Platform.runLater(() -> livingController.createBoard(board));
    }

    @Override
    public void onNotifyGameFullReq() {
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

    }

    @Override
    public void onShowFinalScoreBoardReq(HashMap<String, Integer> point) {
        //interfaccia fine gioco
    }

    @Override
    public void onShowNewMyLibraryReq(Library l) {
        LibrariesController contr = new LibrariesController();
        Platform.runLater(() -> contr.createLibrary(l));
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

    }

    @Override
    public void onNotifyPersonalCardReq(PersonalGoalCard personalGoalCard) {
        Platform.runLater(() -> livingController.setPP(personalGoalCard.getNumn_png()));
    }

    @Override
    public void NotifyaskNicknameReq() throws InterruptedException {

    }

    @Override
    public void onNotifyAllPlayerReq(ArrayList<String> players) {
        Platform.runLater(() -> chatController.setChats(players));
    }

    @Override
    public void onNotifyCommonCards(EffectiveCard[] cards) {

    }

    @Override
    public void onNotifyMexInChat(String getnickname, String mex, String dest) {
        Platform.runLater(() -> chatController.arrivedMex(getnickname, mex, dest));
    }

    @Override
    public void askNickname() {

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
}
