package it.polimi.ingsw.modello;

import it.polimi.ingsw.modello.Card;

import java.util.Arrays;
/**
 * this class initialize PersonalGoalCard using json file as source
 */
public class PersonalGoalCard {
    private static final int DIMENSION = 6;
    private Card[] personalObjective=new Card[DIMENSION];
    /**
     * the constructor takes an array of cards with their position and colour based on goals in json's file
     */
    public PersonalGoalCard(Card[] personalObjective){
        for(int i=0;i<DIMENSION;i++){
            this.personalObjective[i]=new Card(personalObjective[i].getColour(),personalObjective[i].getCoordinates());
        }
    }
    /**
     * getPersonalObjective() returns an array with personalObjective's cards
     */
    public Card[] getPersonalObjective() {
        return Arrays.copyOf(personalObjective,personalObjective.length);
    }
    /**
     * showPersonalGoalCard() lets see a player's PersonalGoalCard
     */
    public void showPersonalGoalCard(){
        boolean printed;
        for(int i=0;i<6;i++){
            for (int j=0;j<5;j++){
                printed=false;
                for(Card card:this.personalObjective){
                    if(card.getCoordinates().getX()==i&&card.getCoordinates().getY()==j){
                        System.out.print("["+card.getColour()+"] ");
                        printed=true;
                    }

                }
                if(!printed) System.out.print("[ ]");

            }
            System.out.println();
        }
    }
}