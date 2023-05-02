package it.polimi.ingsw.modello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PlayerManager {
    /**
     * the method notifies the observer about the state of the player
     */

    public void notifyAllObservers(Player player){

        for(Observer observer: player.getObservers())
        {
            if(observer.update(player))
                player.removeObserver(observer);
        }

    }

    /**
     * the method lets you select the cards from the board ant put them in the library
     */
    /*
    public Card[] selectCard(Player player , Board board , ArrayList<Card> selectedCardsTemp ){
        int l;
        Position tempPosition;
        Card [] selectedCards  = {};
        if(!board.allow(selectedCardsTemp)){
            return null;
        }
        else{
            for(l=0 ; l<selectedCardsTemp.size() ; l++){
                selectedCards[l]=selectedCardsTemp.get(l);
                tempPosition=new Position(selectedCardsTemp.get(l).getCoordinates().getX() , selectedCardsTemp.get(l).getCoordinates().getY());
                board.takeCard(tempPosition);
            }
        }
        return selectedCards;
        //Da sistemare i test qunado il metodo take action in library e quando il metodo turn in library saranno aggiornati
    }
    /*
     */
    /**
     *Puts the card in the library
     */
    public void putCard ( Card[] selectedCards , Player player , int coloumn){
        int counter = 0 ;
        int i ;
        int [] freeColoumns ={};
        ArrayList<Card> listOfCards = new ArrayList<Card>(Arrays.asList(selectedCards));
        freeColoumns=player.getLibrary().showColumn(selectedCards.length);
        for(i=0 ; i< freeColoumns.length ; i++){
            if(coloumn==freeColoumns[i]){
                counter++;
            }
        }
        if(counter!=1){
            return ;
        }
        player.getLibrary().setColumn( listOfCards , selectedCards.length);
    }

    /**
     * the method lets you see the personal goal card
     */

    public void showPersonalGoal (Player player){
        player.getPersonalCard().showPersonalGoalCard();
    }

    /**
     * the method calculates points of the personal objective and returns it's value
     */

    public int showPersonalPoint(Player player){
        int sameCards=0 , x , y, i , points=0;
        String colour;
        Card [] personalCards = {};
        personalCards=player.getPersonalCard().getPersonalObjective();
        for(i=0 ; i<6 ; i++){
            colour=personalCards[i].getColour();
            x=personalCards[i].getCoordinates().getX();
            y=personalCards[i].getCoordinates().getY();
            if(colour.equals(player.getLibrary().getCardinPos(x,y).getColour())){
                sameCards++;
            }
        }
        if(sameCards==1){
            points=1;
        }
        else if(sameCards==2){
            points=2;
        }
        else if(sameCards==3){
            points=4;
        }
        else if(sameCards==4){
            points=6;
        }
        else if(sameCards==5){
            points=9;
        }
        else if(sameCards==6){
            points=12;
        }
        return points;
    }

    /**
     * The following method returns the points of the player
     */

    public int showProgressScore(Player player){
        int score=player.getCommonGoalScore();
        System.out.println("Your score starts from your CommonCards' score:"+score);
        // calculate personalgoalcard's achievment and its score
        System.out.println("You achieve from your PersonalGoalCard:"+this.showPersonalPoint(player));
        score+=this.showPersonalPoint(player);
        // calculate scores about adjacent items
        System.out.println("You achieve from your adjacent items:");
        ArrayList<Integer> groups=player.getLibrary().getgroup();
        for(Integer i: groups){
            if(i==3){
                System.out.println("items"+i+" score: 2");
                score+=2;}
            if(i==4){
                System.out.println("items"+i+" score: 3");
                score+=3;}
            if(i==5){
                System.out.println("items"+i+" score: 5");
                score+=5;}
            if(i>6){
                System.out.println("items"+i+" score: 6");
                score+=8;}
        }
        return score;
    }


}
