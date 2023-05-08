package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.MessageHandler;

/**
 * message from server to client to notify the chair is assigned
 */
public class ChairAssigned extends Message{
    public ChairAssigned(String name){
        super(name,"assigned_chair");
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }

}
