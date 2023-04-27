package it.polimi.ingsw.message;

/**
 * message from client to server to let the player see its PersonalGoal Card
 */
import it.polimi.ingsw.modello.PersonalGoalCard;
import it.polimi.ingsw.network.Client;

public class Show_Pcard extends Message{
    PersonalGoalCard p;
    public Show_Pcard(PersonalGoalCard p){
        super("Server","Send_PCard");
        this.p=p;
    }
    public PersonalGoalCard getP() {
        return p;
    }
}
