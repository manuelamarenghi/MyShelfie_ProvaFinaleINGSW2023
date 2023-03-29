package it.polimi.ingsw;
import java.lang.Math;
import java.sql.Array;
import java.util.ArrayList;

public class Bag {
    private int dim=132 , i;
    ArrayList<Integer> remainingCards = new ArrayList<Integer>(dim);

    public Bag(){
        for(i=0 ; i<6 ; i++){
            remainingCards.set(i,22);
        }
    }
    public ArrayList<String> extract(int numberOfCards){
        //Va bene ritornare un arrayList di String in cui ogni elemento rappresenta il colore di una carta
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
        //Dichiare la variabile state in Card per vedere dove sta la carta sulla plancia , in libreria , in sacchetto
    }

    public ArrayList<Integer> getRemainingCards(){
        return remainingCards;
    }

}
