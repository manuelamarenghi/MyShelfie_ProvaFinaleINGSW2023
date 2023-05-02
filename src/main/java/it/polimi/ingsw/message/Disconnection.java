package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;

/**
 * message from client when the player wants to leave
 */
public class Disconnection extends Message{
    public Disconnection(String name){
        super(name,"Client_has_disconnected");
    }

}
