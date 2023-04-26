package it.polimi.ingsw.view;

/**
 *  this class create an observer for each view from server or client
 */
public interface View {
    void askNickname();
    void acceptmatch();
    void askNumbPlayer();
    void updateboard();
    void updatelibrary();
    void updateplayerconnect();
    void sendCommonCard();
    void sendPersonalCard();
}
