package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.Match;

public interface ObserverViewClient {
     void askNickname();

     void askNumberPlayer();

     void askCardsToTakeFromBoard();

     void askForDissconection();

     void createMatch(Match match);

}
