package it.polimi.ingsw.view;

import it.polimi.ingsw.network.observer.VMObserver;

public interface ViewClient extends VMObserver{
    void askNickname();
    void askNumberPlayer();

    void askCardsToTakeFromBoard();
    void askForDissconection();

}
