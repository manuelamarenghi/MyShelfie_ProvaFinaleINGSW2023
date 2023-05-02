package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.*;

/**
 *  this class create an observer for each view from server or client
 */
public interface View {
    void askNickname();
    void askNumbPlayer();
    void updateboard(Board b);
    void updatelibrary(Library l,String nickname);
    void assignedCC(EffectiveCard e,int x,String name);
    void assignedChair(String name);
    void CreateMatch(Match m);
}
