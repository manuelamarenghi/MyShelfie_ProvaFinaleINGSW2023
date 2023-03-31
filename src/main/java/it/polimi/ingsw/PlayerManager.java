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
        int numberOfCards , i , x , y , coloumn , founded;
        int [] coloumnsForCards ;
        Scanner value = new Scanner(System.in);
        Card tempCard = new Card();
        String answer;
        ArrayList<Card> selectedCards  = new ArrayList<Card>(3);
        ArrayList<Card> selectedCardsTemp  = new ArrayList<Card>(3);
        Card [] selsectedCardsArray = {};
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
                selectedCards=selectedCardsTemp;
            }
            else{
                break;
            }
        }
        //Per le carte scelte bisogna inizializzarle a null nelle posizioni da cui sono state scelte
        numberOfCards=i+1;
        coloumnsForCards=player.getLibrary().showColumn(numberOfCards);
        while(true){//While loop to find coloumns to put cards
            founded=0;
            System.out.println("Select among the following coloumns to put cards");
            for(i=0 ; i< coloumnsForCards.length ; i++){
                System.out.println(coloumnsForCards[i]);
            }
            coloumn= value.nextInt();
            for(i=0 ; i<coloumnsForCards.length ; i++){
                if(coloumnsForCards[i]==coloumn){
                    founded=1;
                }
            }
            if(founded==1){
                break;
            }
            else{
                System.out.println("Please select another coloumn");
            }
        }
        for(i=0 ; i<numberOfCards ; i++){
            selsectedCardsArray[i]=selectedCards.get(i);
        }
        //Method to put cards in the selected coloumns
        player.getLibrary().setColumn(selsectedCardsArray, numberOfCards);
        //Penso che non ci sia bisogno di ritornare nulla , bisogna trasformare il metodo al void
    }
    public void showPersonalGoal (){

    }
    public void showPersonalPoint(){

    }
    public void showProgressScore(){

    }


}
