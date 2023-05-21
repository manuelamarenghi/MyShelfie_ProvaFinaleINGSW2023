package it.polimi.ingsw.view;

import it.polimi.ingsw.network.observer.VMObserver;

import java.util.ArrayList;

public interface ViewClient extends VMObserver{
    void askNickname();
    void askNumberPlayer();

    void askCardsToTakeFromBoard();
    void askForDissconection();
    void errorNickname(ArrayList<String> players);

}
