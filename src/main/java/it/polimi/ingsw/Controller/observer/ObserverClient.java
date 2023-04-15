package it.polimi.ingsw.Controller.observer;

import it.polimi.ingsw.Controller.Subject;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.modello.NotUsableException;

public interface ObserverClient {
    public void update(Subject subject, Message message) throws NotUsableException;
}
