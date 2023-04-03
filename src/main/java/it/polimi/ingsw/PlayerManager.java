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
    public void showCommGoal(Player player){
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
    public void showPersonalGoal (Player player){
        player.getPersonalCard().showPersonalGoalCard();
    }
    public int showPersonalPoint(Player player){
        int sameCards=0 , x , y, i , points=0;
        String colour;
        Card [] personalCards = {};
        personalCards=player.getPersonalCard().getPersonalObjective();
        for(i=0 ; i<6 ; i++){
            colour=personalCards[i].getColour();
            x=personalCards[i].getCoordinates().getX();
            y=personalCards[i].getCoordinates().getY();
            //Forse x e y sono da scambiare per la confusione con righe e colonne
            /*if(colour == player.getLibrary()[x][y].getColour()){
                //da rivedere come mettere la condizione dell'If perche nonva bene
                sameCards++;
            }*/
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
    public void showProgressScore(Player player){
        System.out.println(player.getCommonGoalScore());
    }


}