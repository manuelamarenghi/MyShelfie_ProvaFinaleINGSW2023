package it.polimi.ingsw;

public class PersonalGoalCard {
    private final DIMENSION=6
    private Card personalObjective=new Card[DIMENSION];
    public PersonalGoalCard(Card[] personalObjective){
        for(int i;i<DIMENSION;i++){
            this.personalObjective[i]=new Card(personalObjective[i].getColour(),personalObjective[i].getCoordinates());
        }
    }

    public Card getPersonalObjective() {
        return personalObjective;
    }

    public void showPersonalGoalCard(){
        //da rivedere...
    }
}