package it.polimi.ingsw.network.observer;

import it.polimi.ingsw.modello.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An interface to be implemented by Cli and GUI
 */
public interface VMObserver {
    void onShowReq(String s);

    void onNumbPlayerReq();

    void onShowNewBoardReq(Board board);

    void onNotifyGameFullReq();

    void onNotifyPlayerDisconnectionReq(Player player);

    void onNotifyPlayerReconnectionReq(Player player);

    void onNotifyPlayerConnectionReq(String nickname);

    void onNotifyReachedCommonGoalCardReq(String nickname, EffectiveCard completedEffectiveCard, int score);

    void onNotifyChairAssignedReq(String nickname);

    void onShowPossibleColumnReq(int[] x, ArrayList<Card> cards, Library library);

    void onNotifyCardsAreNotAdjacentReq();

    void onNotifyNumbPlayerReq(int playerNum);

    void onNotifyPlayerFinishedFirstReq(Player player);

    void onNotifyMatchHasStartedReq(ArrayList<Player> players);

    void onShowFinalScoreBoardReq(HashMap<String, Integer> point);

    void onShowNewMyLibraryReq(Library l, String name);

    void onNotifyDisconnectionReqAcceptedAns();

    void onNotifyNewNicknameReq();

    void onNotifyIsYourTurnReq(Board board, Library library);

    void onNotifyYourTurnIsEndedReq(String current_player);

    void onNotifyWhoIsPlayingNowReq(String current_player);

    void onNotifyPersonalCardReq(PersonalGoalCard personalGoalCard);

    void NotifyaskNicknameReq() throws InterruptedException;

    void onNotifyAllPlayerReq(ArrayList<String> players);

    void onNotifyCommonCards(EffectiveCard[] cards);

    void onNotifyMexInChat(String getnickname, String mex, String dest);

    void onPressedButtonChange(String scene);
}
