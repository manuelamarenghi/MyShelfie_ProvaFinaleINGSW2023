package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerManager {
    //the method notifies the observer about the state of the player
    public void notifyAllObservers(Player player){

        for(Observer observer: player.getObservers())
        {
            if(observer.update(player))
                player.removeObserver(observer);
        }

    }
    //the method lets you select the cards from the board ant put them in the library
    public void selectCard(Player player , Board board){
        int i , x , y , l;
        Scanner value = new Scanner(System.in);
        Position tempPosition;
        Card tempCard = new Card();
        String answer;
        Card [] selectedCards  = {};
        ArrayList<Card> selectedCardsTemp  = new ArrayList<Card>(3);
        while(true){//A while loop to select cards from board and to see if they can be taken or not
            for(i=0 ; i<3 ; i++){
                System.out.println("Select a card from the board");
                System.out.println("Type card's x value");
                x=value.nextInt();
                System.out.println("Type card's y value");
                y=value.nextInt();
                tempCard=board.getCard(x,y);
                selectedCardsTemp.add(tempCard);
                System.out.println("Do you want to select other cards?");
                answer = value.nextLine();
                if(answer.equals("No") || answer.equals("NO") || answer.equals("no")){
                    break;
                }
            }
            if(!board.allow(selectedCardsTemp)){
                System.out.println("The cards selected can not be taken");
                System.out.println("Please select other cards");
            }
            else{
                for(l=0 ; l<selectedCardsTemp.size() ; l++){
                    selectedCards[i]=selectedCardsTemp.get(i);
                    tempPosition=new Position(selectedCardsTemp.get(i).getCoordinates().getX() , selectedCardsTemp.get(i).getCoordinates().getY());
                    board.takeCard(tempPosition);
                }
                break;
            }
        }
        player.getLibrary().takeAction(selectedCards);
    }
    //the method lets you see the personal goal card
    public void showPersonalGoal (Player player){
        player.getPersonalCard().showPersonalGoalCard();
    }
    //the method calculates points of the personal objective and returns it's value
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
    //The following method returns the points of the player
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
