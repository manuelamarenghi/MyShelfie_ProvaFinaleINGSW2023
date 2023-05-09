package it.polimi.ingsw.network.observer;

import it.polimi.ingsw.modello.*;

import java.util.ArrayList;
import java.util.HashMap;

public interface VMObserver {
    void onShowReq(String s);
     void onNumbPlayerReq();
     void onShowNewBoardReq(Board board);
     void onNotifyNewLibraryReq(String nickname, Library library);
     void onNotifyGameFullReq();
     void onNotifyPlayerDisconnectionReq(Player player);
     void onNotifyPlayerReconnectionReq(Player player);
     void onNotifyPlayerConnectionReq(String nickname);
     void onNotifyReachedCommonGoalCardReq(EffectiveCard completedEffectiveCard, int score);
     void onNotifyChairAssignedReq(String nickname);
     void onShowPossibleColumnReq(int[] x, Library library);
     void onNotifyCardsAreNotAdjacentReq();

    void onNotifyNumbPlayerReq(int playerNum);

     void onNotifyPlayerFinishedFirstReq(Player player);

     void onNotifyMatchHasStartedReq(ArrayList<Player> players);

     void onShowFinalScoreBoardReq(HashMap<String, Integer> point);

     void onShowNewMyLibraryReq(Library l);

    void onNotifyDisconnectionReqAcceptedAns();

    void onNotifyNewNicknameReq();

    void onNotifyIsYourTurnReq(Board board, Library library);

    void onNotifyYourTurnIsEndedReq(String current_player);

    void onNotifyWhoIsPlayingNowReq(String current_player);

    void onNotifyPersonalCardReq(PersonalGoalCard personalGoalCard);
}
