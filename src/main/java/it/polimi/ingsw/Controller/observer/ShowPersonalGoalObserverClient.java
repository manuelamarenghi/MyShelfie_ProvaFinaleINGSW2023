package it.polimi.ingsw.Controller.observer;

import it.polimi.ingsw.Controller.Subject;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.MessageType;
import it.polimi.ingsw.message.ShowPersonalGoalMessage;
import it.polimi.ingsw.modello.NotUsableException;
import it.polimi.ingsw.modello.Player;

public class ShowPersonalGoalObserverClient implements ObserverClient{


    @Override
    public void update(Subject subject, Message message) throws NotUsableException {
        if(message.getCode() == MessageType.SHOW_PERSONAL_GOAL){
            Player player;
            ShowPersonalGoalMessage showPersonalGoalMessage = (ShowPersonalGoalMessage) message;
            player= showPersonalGoalMessage.getPlayer();
            player.getPlayerManager().showPersonalGoal(Player);
        }
    }
}
