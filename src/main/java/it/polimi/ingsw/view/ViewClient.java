package it.polimi.ingsw.view;

import it.polimi.ingsw.message.Receiving_Mex;
import it.polimi.ingsw.network.observer.VMObserver;

import java.util.ArrayList;

/**
 * all methods implemented by cli and gui
 */
public interface ViewClient extends VMObserver {
    void askNickname();
    void askNumberPlayer();

    void askCardsToTakeFromBoard();
    void askForDissconection();

    void actionByPlayer();

    void errorNickname(ArrayList<String> players);

    void readMessageChat(ArrayList<Receiving_Mex> message, ArrayList<String> players);
}
