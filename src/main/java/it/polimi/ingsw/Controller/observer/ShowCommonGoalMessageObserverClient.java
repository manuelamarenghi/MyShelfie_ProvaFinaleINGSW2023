package it.polimi.ingsw.Controller.observer;

import it.polimi.ingsw.Controller.Subject;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.MessageType;
import it.polimi.ingsw.message.ShowCommonGoalMessage;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.NotUsableException;

public class ShowCommonGoalMessageObserverClient implements ObserverClient{


    @Override
    public void update(Subject subject, Message message) throws NotUsableException {
        if(message.getCode() == MessageType.SHOW_COMMON_GOAL){
            Match match ;
            ShowCommonGoalMessage showCommonGoalMessage = (ShowCommonGoalMessage) message;
            match = showCommonGoalMessage.getMatch();
            match.getMatchmanager().showCommGoal(match);
        }
    }
}
