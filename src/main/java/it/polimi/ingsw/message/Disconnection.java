package it.polimi.ingsw.message;
/**
 * message from client when the player wants to leave
 */
public class Disconnection extends MessageContent{
    public Disconnection(){
        super("Client_has_disconnected",null);
    }
}
