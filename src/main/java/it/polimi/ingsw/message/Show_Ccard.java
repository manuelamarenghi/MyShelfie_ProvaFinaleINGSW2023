package it.polimi.ingsw.message;
/**
 * message from client to server to let the player see CommonGoal Cards
 */
public class Show_Ccard extends MessageContent{
    public Show_Ccard(){
        super("Show_CommonGoal_Card");
    }
}
