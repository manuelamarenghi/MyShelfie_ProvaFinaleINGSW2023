package it.polimi.ingsw.network;

import it.polimi.ingsw.message.Message;

import it.polimi.ingsw.network.observer.Observable;

public abstract class Client extends Observable {
    //private final int IDClient;
    /*public Client(int idClient) {
        IDClient = idClient;
    }*/

    /**
     * An override method to send a message from client to server
     * @param message
     */
    public abstract void sendMessage(Message message);

    /**
     * An override method to read a message from server
     */
    public abstract void readMessage();

    /**
     * An override method for the disconnection
     */
    public abstract void disconnect();
}
