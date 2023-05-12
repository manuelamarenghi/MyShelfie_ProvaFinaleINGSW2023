package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.view.ObservableViewClient;
import it.polimi.ingsw.view.ViewClient;

import java.util.ArrayList;
import java.util.HashMap;

public class GUI extends ObservableViewClient implements ViewClient {
    ClientController clientController;
    @Override
    public void onShowReq(String s) {

    }

    @Override
    public void onNumbPlayerReq() {

    }

    @Override
    public void onShowNewBoardReq(Board board) {

    }

    @Override
    public void onNotifyNewLibraryReq(String nickname, Library library) {

    }

    @Override
    public void onNotifyGameFullReq() {

    }

    @Override
    public void onNotifyPlayerDisconnectionReq(Player player) {

    }

    @Override
    public void onNotifyPlayerReconnectionReq(Player player) {

    }

    @Override
    public void onNotifyPlayerConnectionReq(String nickname) {

    }

    @Override
    public void onNotifyReachedCommonGoalCardReq(EffectiveCard completedEffectiveCard, int score) {

    }

    @Override
    public void onNotifyChairAssignedReq(String nickname) {

    }

    @Override
    public void onShowPossibleColumnReq(int[] x, Library library) {

    }

    @Override
    public void onNotifyCardsAreNotAdjacentReq() {

    }

    @Override
    public void onNotifyNumbPlayerReq(int playerNum) {

    }

    @Override
    public void onNotifyPlayerFinishedFirstReq(Player player) {

    }

    @Override
    public void onNotifyMatchHasStartedReq(ArrayList<Player> players) {

    }

    @Override
    public void onShowFinalScoreBoardReq(HashMap<String, Integer> point) {

    }

    @Override
    public void onShowNewMyLibraryReq(Library l) {

    }

    @Override
    public void onNotifyDisconnectionReqAcceptedAns() {

    }

    @Override
    public void onNotifyNewNicknameReq() {

    }

    @Override
    public void onNotifyIsYourTurnReq(Board board, Library library) {

    }

    @Override
    public void onNotifyYourTurnIsEndedReq(String current_player) {

    }

    @Override
    public void onNotifyWhoIsPlayingNowReq(String current_player) {

    }

    @Override
    public void onNotifyPersonalCardReq(PersonalGoalCard personalGoalCard) {

    }

    @Override
    public void NotifyaskNicknameReq() throws InterruptedException {

    }

    @Override
    public void onNotifyAllPlayerReq(ArrayList<Player> players) {

    }

    @Override
    public void askNickname() {

    }

    @Override
    public void askNumberPlayer() {

    }

    @Override
    public void askCardsToTakeFromBoard() {

    }

    @Override
    public void askForDissconection() {

    }

    @Override
    public void createMatch(Match match) {

    }
}
