package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Controller.observer.ObserverClient;
import it.polimi.ingsw.message.Message;
public interface Subject {
    public void addObserver(ObserverClient observer);
    public void removeObserver(ObserverClient observer);
    public void notifyObservers(Message message);
}
