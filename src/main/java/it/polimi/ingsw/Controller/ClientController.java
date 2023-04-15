package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Controller.observer.ObserverClient;
import it.polimi.ingsw.message.Message;

import java.util.ArrayList;
import java.util.List;

public class ClientController implements Subject{
    private List<ObserverClient> observers;
    private Message message;

    public ClientController() {
        observers = new ArrayList<>();
    }

    public void sendMessage(Message message) {
        // send message to server
        this.message = message;
        notifyObservers(message);
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public void addObserver(ObserverClient observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverClient observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (ObserverClient observer : observers) {
            observer.update(this, message);
        }
    }
}
