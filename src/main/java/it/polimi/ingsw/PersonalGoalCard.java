package it.polimi.ingsw;

import java.util.Arrays;

public class PersonalGoalCard {
    private static final int DIMENSION = 6;
    private Card[] personalObjective=new Card[DIMENSION];
    public PersonalGoalCard(Card[] personalObjective){
        for(int i=0;i<DIMENSION;i++){
            this.personalObjective[i]=new Card(personalObjective[i].getColour(),personalObjective[i].getCoordinates());
        }
    }

    public Card[] getPersonalObjective() {
        return Arrays.copyOf(personalObjective,personalObjective.length);
    }

    public void showPersonalGoalCard(){
        //da rivedere...
    }
}