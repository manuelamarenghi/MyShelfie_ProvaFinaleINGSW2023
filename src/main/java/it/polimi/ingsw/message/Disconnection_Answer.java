package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.ClientHandler;

/**
 * message from server to client when the disconnection is ended
 */
public class Disconnection_Answer extends Message{
    public Disconnection_Answer(String name){
        super(name,"you_are_disconnected");
    }

}
