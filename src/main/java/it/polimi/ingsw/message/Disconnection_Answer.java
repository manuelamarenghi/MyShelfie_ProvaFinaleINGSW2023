package it.polimi.ingsw.message;

/**
 * message from server to client when the disconnection is ended
 */
public class Disconnection_Answer extends MessageContent{
    public Disconnection_Answer(){
        super("you_are_disconnected");
    }
}
