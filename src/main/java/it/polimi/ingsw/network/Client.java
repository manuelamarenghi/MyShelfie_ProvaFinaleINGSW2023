package it.polimi.ingsw.network;

import it.polimi.ingsw.message.Message;

import it.polimi.ingsw.network.observer.Observable;

public abstract class Client extends Observable {
    //private final int IDClient;
    /*public Client(int idClient) {
        IDClient = idClient;
    }*/
    public abstract void sendMessage(Message message);

    public abstract void readMessage();

    public abstract void disconnect();
}
