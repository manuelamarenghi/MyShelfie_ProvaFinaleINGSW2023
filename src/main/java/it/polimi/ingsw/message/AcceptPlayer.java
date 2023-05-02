package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;

/**
 * message from server to client after a player entered the game
 */
public class AcceptPlayer extends Message{
    public AcceptPlayer(String name){
        super(name,"accepted_in_the_match");
    }
}
