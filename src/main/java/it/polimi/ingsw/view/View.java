package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.network.observer.Observer;

import java.io.Serializable;

/**
 *  this class create an observer for each view from server or client
 */
public interface View extends Observer, Serializable {
    void askNickname();
    void askNumbPlayer();
    void updateboard(Board b);
    void updatelibrary(Library l,String nickname);
    void assignedChair(String name);
    void CreateMatch(Match m);

}
