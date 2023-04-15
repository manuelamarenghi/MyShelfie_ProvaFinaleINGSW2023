package it.polimi.ingsw.Controller.observer;

import it.polimi.ingsw.Controller.Subject;
import it.polimi.ingsw.message.*;
import it.polimi.ingsw.modello.*;

public class CreateBoardObserverClient implements ObserverClient{

    @Override
    public void update(Subject subject, Message message) {
        if(message.getCode() == MessageType.TWO_PLAYERS){
            TwoPlayersMessage twoPlayersMessage  = (TwoPlayersMessage) message ;
            Match match = twoPlayersMessage.getMatch();
            Matchmanager matchmanager= twoPlayersMessage.getMatchmanager();
            if (matchmanager instanceof TwoPlayers) {
                ((TwoPlayers) matchmanager).createBoard(match);
            }
        }
        else if (message.getCode() == MessageType.THREE_PLAYERS) {
            ThreePlayersMessage threePlayersMessage = (ThreePlayersMessage) message;
            Match match = threePlayersMessage.getMatch();
            Matchmanager matchmanager = threePlayersMessage.getMatchmanager();
            if (matchmanager instanceof ThreePlayers) {
                ((ThreePlayers) matchmanager).createBoard(match);
            }
        } else if (message.getCode() == MessageType.FOUR_PLAYERS) {
            FourPlayersMessage fourPlayersMessage = (FourPlayersMessage) message;
            Match match = fourPlayersMessage.getMatch();
            Matchmanager matchmanager = fourPlayersMessage.getMatchmanager();
            if (matchmanager instanceof FourPlayers) {
                ((FourPlayers) matchmanager).createBoard(match);
            }
        }
    }
}
