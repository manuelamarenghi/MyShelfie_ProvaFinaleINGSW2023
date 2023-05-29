package it.polimi.ingsw.modello;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerManager implements Serializable {
    /**
     * the method notifies the observer about the state of the player
     */

    public void notifyAllObservers(Player player){
        ArrayList<ObserverCC> observers = new ArrayList<>(player.getObservers());

        for (ObserverCC observer : observers) {
            if (observer.update(player))
                player.removeObserver(observer);
        }

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
        score+=this.showPersonalPoint(player);
        ArrayList<Integer> groups=player.getLibrary().getgroup();
        for(Integer i: groups){
            if(i==3){
                score+=2;}
            if(i==4){
                score+=3;}
            if(i==5){
                score+=5;}
            if(i>=6){
                score+=8;}
        }
        return score;
    }


}
