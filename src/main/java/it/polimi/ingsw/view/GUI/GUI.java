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

    @Override
    public void onNumbPlayerReq() {
        LoginSceneController login = (LoginSceneController) SceneController.getActiveController();
        Platform.runLater(() -> login.NumbPlayer());

    }

    @Override
    public void onShowNewBoardReq(Board board) {
        livingController.getData().setBoard(board);
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
        Platform.runLater(() -> livingController.appendText(player.getNickname() + "has left the game\n"));
    }

    @Override
    public void onNotifyPlayerReconnectionReq(Player player) {
        Platform.runLater(() -> chatController.addPlayer(player.getNickname()));
        Platform.runLater(() -> livingController.appendText(player.getNickname() + "is back in the game\n"));
    }

    @Override
    public void onNotifyPlayerConnectionReq(String nickname, boolean you) {
        if (you) {
            notifyObserver(obs -> obs.setNickname(nickname));
            onPressedButtonChange("wait");
        } else {
            Platform.runLater(() -> waitcontr.setPlayer(nickname));
        }
    }

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
            Platform.runLater(() -> livingController.appendText(nickname + " has reached a common goal taking " + score + " score\n"));
        }
    }

    @Override
    public void onNotifyChairAssignedReq(String nickname) {
        livingController.getData().setChair(true);
        Platform.runLater(() -> livingController.setChair());
    }

    @Override
    public void onShowPossibleColumnReq(int[] x, ArrayList<Card> cards, Library library) {
        Platform.runLater(() -> livingController.ShowColumn(x));
    }

    @Override
    public void onNotifyCardsAreNotAdjacentReq() {
        Platform.runLater(() -> livingController.setTextArea("Cards are not adjacent. Take some valid\n"));
        Platform.runLater(() -> livingController.removeHighlights());
        askCardsToTakeFromBoard();
    }

    @Override
    public void onNotifyNumbPlayerReq(int playerNum) {
        // vuoto
    }

    @Override
    public void onNotifyPlayerFinishedFirstReq(Player player) {
        livingController.getData().setFirstFinish(true);
        Platform.runLater(() -> livingController.setFirstFinished());
    }

    @Override
    public void onNotifyMatchHasStartedReq(ArrayList<Player> players) {
        Platform.runLater(() -> SceneController.setRootPane(livingController, "living_room.fxml"));
    }

    @Override
    public void onShowFinalScoreBoardReq(HashMap<String, Integer> point) {
        FinalController finalcontr = new FinalController();
        finalcontr.addAllObservers(observers);
        Platform.runLater(() -> SceneController.setRootPane(finalcontr, "FinalScene.fxml"));
        Platform.runLater(() -> finalcontr.SetClassification(point));
    }

    @Override
    public void onShowNewMyLibraryReq(Library l, String name) {
        if (name.equals(nickname)) {
            livingController.getData().setLibrary(l);
            Platform.runLater(() -> livingController.createLibrary(l));
        } else {
            Platform.runLater(() -> lcontr.createLibrary(l));
        }
    }

    @Override
    public void onNotifyDisconnectionReqAcceptedAns() {
        Platform.runLater(() -> livingController.setTextArea("Disconnection accepted.Bye"));

    }

    @Override
    public void onNotifyNewNicknameReq() {
        LoginSceneController login = (LoginSceneController) SceneController.getActiveController();
        Platform.runLater(() -> login.TryAgainNick());
    }

    @Override
    public void onNotifyIsYourTurnReq(Board board, Library library) {
        boolean yourTurn = true;
        livingController.getData().setLibrary(library);
        Platform.runLater(() -> livingController.createLibrary(library));
        Platform.runLater(() -> livingController.setYourTurn(yourTurn));
        Platform.runLater(() -> livingController.setTextArea("Insert the number of items you want to take"));
        askCardsToTakeFromBoard();
    }

    @Override
    public void onNotifyYourTurnIsEndedReq(String current_player) {
        boolean yourTurn = false;
        Platform.runLater(() -> livingController.setYourTurn(yourTurn));
        Platform.runLater(() -> livingController.setTextArea("Your turn is over"));
    }

    @Override
    public void onNotifyWhoIsPlayingNowReq(String current_player) {
        Platform.runLater(() -> livingController.setTextArea(current_player + " is playing"));
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
        chatController.addAllObservers(observers);
        players.remove(nickname);
        Platform.runLater(() -> chatController.initialize());
        Platform.runLater(() -> chatController.setChats(players));
    }

    @Override
    public void onNotifyCommonCards(EffectiveCard[] cards) {
        common2.addAllObservers(observers);
        common1.addAllObservers(observers);
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

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
        chatController.setYourNickname(nickname);
    }

    @Override
    public void askNickname() {
        Platform.runLater(() -> SceneController.setRootPane(observers, "login_scene.fxml"));
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
    public void errorNickname(ArrayList<String> players) {

    }

    @Override
    public void readMessageChat(ArrayList<Receiving_Mex> message, ArrayList<String> players) {

    }
}
