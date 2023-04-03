package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerManager {

    public void notifyAllObservers(Player player){

        for(Observer observer: player.getObservers())
        {
            if(observer.update(player))
                player.removeObserver(observer);
        }

    }
    public void showCommGoal(){
        //Chiedere come si fa ad accedere alle 2 carte
    }
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
                for(l=0 ; l<selectedCardsTemp.size() ; l++){
                    selectedCards[i]=selectedCardsTemp.get(i);
                    tempPosition=new Position(selectedCardsTemp.get(i).getCoordinates().getX() , selectedCardsTemp.get(i).getCoordinates().getY());
                    board.takeCard(tempPosition);
                }
            }
            else{
                break;
            }
        }
        player.getLibrary().takeAction(selectedCards);
    }
    public void showPersonalGoal (){

    }
    public void showPersonalPoint(){

    }
    public int showProgressScore(Player player){
        int score=player.getCommonGoalScore();
        System.out.println("Your score starts from your CommonCards' score:"+score);
        // calculate personalgoalcard's achievment and its score
        System.out.println("You achieve from your PersonalGoalCard:");
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
