package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.EffectiveCard;
import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.modello.PersonalGoalCard;

/**
 *  this class create an observer for each view from server or client
 */
public interface View {
    void askNickname();
    void acceptmatch();
    void askNumbPlayer();
    void updateboard(Board b);
    void updatelibrary(Library l,String nickname);
    void updateplayerconnect(String name);
    void sendCommonCard(EffectiveCard[] card);
    void sendPersonalCard(PersonalGoalCard p);
    void assignedCC(EffectiveCard e,int x,String name);
    void assignedChair(String name);
}
