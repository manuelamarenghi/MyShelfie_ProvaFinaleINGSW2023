package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.network.observer.VMObservable;
import it.polimi.ingsw.network.observer.VMObserver;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Cli extends VMObservable implements VMObserver,ViewClient {
    private final PrintStream out;
    private static final String INVALID_INPUT = "INVALID INPUT";

    /**
     * Default constructor.
     */
    public Cli() {
        out = System.out;
    }
    /**
     * init_game() entering interface CLI version
     */
    public void init_game(){

    }
    @Override
    public void onShowReq(String s) {

    }

    /**
     * onNicknameReq() first method call when user connects to set valid nickname
     */
    @Override
    public void onNicknameReq() {

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
    public void onNotifyPlayerConnectionReq(Player player) {

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
    /**
     *  onNotifyConnectionAcceptedReq() notify user that its access went right
     */
    @Override
    public void onNotifyConnectionAcceptedReq() {
        out.println("You are connected to the game. Enjoy it !");

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
}
