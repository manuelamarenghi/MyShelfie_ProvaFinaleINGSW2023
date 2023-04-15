package it.polimi.ingsw.message;

/**
 * message from server to client that is the winner
 */
public class Winner extends MessageContent{
    public Winner(){
        super("You_are_the_winner");
    }
}
