package it.polimi.ingsw.message;

/**
 * message from server to client after a player entered the game
 */
public class AcceptPlayer extends MessageContent{
    public AcceptPlayer(){
        super("accepted_in_the_match");
    }
}
