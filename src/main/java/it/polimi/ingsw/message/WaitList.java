package it.polimi.ingsw.message;

/**
 * message from server to client when the game has enough players
 */
public class WaitList extends MessageContent{
    public WaitList(){
        super("Game_full");
    }
}
