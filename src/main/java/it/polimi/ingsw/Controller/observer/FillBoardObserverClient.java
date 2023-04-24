package it.polimi.ingsw.Controller.observer;

import it.polimi.ingsw.Controller.Subject;
import it.polimi.ingsw.message.FillBoardMessage;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.MessageType;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.NotUsableException;

public class FillBoardObserverClient implements ObserverClient{


    @Override
    public void update(Subject subject, Message message) throws NotUsableException {
        if(message.getCode()== MessageType.FILL_BOARD){
            Match match ;
            FillBoardMessage fillBoardMessage = (FillBoardMessage) message;
            match = fillBoardMessage.getMatch();
            match.getMatchmanager().IsEmpyBoard(match);
        }
    }
}
