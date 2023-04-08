package it.polimi.ingsw.modello;
import java.lang.Math;
import java.sql.Array;
import java.util.ArrayList;

public class Bag {
    private int dim=132 , i , numberOfCards , l;
    private static int cardsFor2Players=29 , cardsFor3Players=37 , cardsFor4Player=45;
    ArrayList<Integer> remainingCards = new ArrayList<Integer>(dim);

    public Bag(){
        for(i=0 ; i<6 ; i++){
            remainingCards.add(22);
        }
    }

    /**
     * Extracts cards depending on number of players and cards already present on table
     */

    public ArrayList<String> extract(int numberOfPlayers , int cardsOnTable){
        if(numberOfPlayers==2){
            numberOfCards=cardsFor2Players-cardsOnTable;
        }
        else if(numberOfPlayers==3){
            numberOfCards=cardsFor3Players-cardsOnTable;
        }
        else{
            numberOfCards=cardsFor4Player-cardsOnTable;
        }
        i=0;
        int index;
        ArrayList<String> arrayOfCards  = new ArrayList<String>(numberOfCards);
        while(i!=numberOfCards){
            index=(int)(Math.random()*6)+0;
            if(remainingCards.get(index)==0){
                continue;
            }
            else{
                if(index==0){
                    arrayOfCards.add("Green");
                    remainingCards.set(0,remainingCards.get(0)-1);
                }
                else if(index==1){
                    arrayOfCards.add("White");
                    remainingCards.set(1,remainingCards.get(1)-1);
                }
                else if(index==2){
                    arrayOfCards.add("Yellow");
                    remainingCards.set(2,remainingCards.get(2)-1);
                }
                else if(index==3){
                    arrayOfCards.add("Navy");
                    remainingCards.set(3,remainingCards.get(3)-1);
                }
                else if(index==4){
                    arrayOfCards.add("Blue");
                    remainingCards.set(4,remainingCards.get(4)-1);
                }
                else if(index==5){
                    arrayOfCards.add("Pink");
                    remainingCards.set(5,remainingCards.get(5)-1);
                }
                i++;

            }

        }
        return arrayOfCards;
    }
    /**
    *The method return remaning Cards in bag
     */
     public ArrayList<Integer> getRemainingCards(){
        return remainingCards;
    }

}
