package it.polimi.ingsw.message;

/**
 * message from server to client to notify the chair is assigned
 */
public class ChairAssigned extends MessageContent{
    public ChairAssigned(){
        super("assigned_chair");
    }
}
