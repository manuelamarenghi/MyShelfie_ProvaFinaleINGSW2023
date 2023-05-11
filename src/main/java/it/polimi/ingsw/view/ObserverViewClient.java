package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.Position;

import java.util.ArrayList;

public interface ObserverViewClient {
     void handleEnterPlayer (String nickname);
     void handleCreateBoard(int numeberOfPlayers , String name );
     void handleCreateMatch(Match match);
     void handleTakeCard(Position[] positions , String name );
     void handlePutInLibrary (int x , String name , ArrayList<Card> cards);
     void handleColoumnRequest(int numberOfCards , String name);
     void handleFinalPoint(String name);
     void handleDisconection(String name);

    void setNickname(String nickname);
}
