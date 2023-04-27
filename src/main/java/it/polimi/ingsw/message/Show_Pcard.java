package it.polimi.ingsw.message;

/**
 * message from client to server to let the player see its PersonalGoal Card
 */
import it.polimi.ingsw.network.Client;

public class Show_Pcard extends Message{
    public Show_Pcard(){
        super("show_personal_card",null);
    }

}
