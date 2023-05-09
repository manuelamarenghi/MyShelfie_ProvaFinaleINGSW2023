package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.PersonalGoalCard;

public class Send_PersonalCard extends Message{
    private PersonalGoalCard personalGoalCard ;

    public Send_PersonalCard(PersonalGoalCard personalGoalCard){
        super("Server","Personal Goal Card");
        this.personalGoalCard = personalGoalCard;
    }

    public PersonalGoalCard getPersonalGoalCard(){
        return personalGoalCard;
    }

}
