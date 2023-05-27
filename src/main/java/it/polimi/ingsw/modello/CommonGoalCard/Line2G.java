package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class Line2G implements CommonGoalCards, Serializable {
    int numberCard = 6;

    public int getNumberCard() {
        return numberCard;
    }

    /**
     * The method checks if the target has been completed or not
     */

    @Override
    public boolean check(Library library) {
        int r, c, i;
        int[] differentCard = {0, 0, 0, 0, 0, 0};
        int differentLines = 0, total;
        for (r = 0; r < 6; r++) {
            total=0;
            for(i=0 ; i<6 ; i++){
                differentCard[i]=0;
            }
            for(c=0 ; c<5 ; c++){
                if (library.getCardinPos(r, c).getColour() == "green") {
                    differentCard[0]++;
                } else if (library.getCardinPos(r, c).getColour() == "white") {
                    differentCard[1]++;
                } else if (library.getCardinPos(r, c).getColour() == "yellow") {
                    differentCard[2]++;
                } else if (library.getCardinPos(r, c).getColour() == "blue") {
                    differentCard[3]++;
                } else if (library.getCardinPos(r, c).getColour() == "lightBlue") {
                    differentCard[4]++;
                } else if (library.getCardinPos(r, c).getColour() == "pink") {
                    differentCard[5]++;
                }
            }
            for(i=0 ; i<6 ; i++){
                if(differentCard[i]==1){
                    total++;
                }
            }
            if(total==5){
                differentLines++;
            }
        }
        if(differentLines>=2){
            return true;
        }
        return false;
    }

    /**
     *  The method lets you know if the target is still possible to complete or not , it return true if it is not
     *     possible to complete the tatget anymore
     */

    @Override
    public boolean expired(Library library) {
        int r , c , i;
        int [] differentTypes = {0,0,0,0,0,0};
        int differentLines=6 , totalTypes , numberOfCards=0;
        for(r=0 ; r<6 ;r++){
            totalTypes=0;
            numberOfCards=0;
            for(i=0 ;i<6; i++){
                differentTypes[i]=0;
            }
            for(c=0 ; c<5 ; c++){
                if (library.getCardinPos(r, c).getColour() == "green") {
                    differentTypes[0]++;
                } else if (library.getCardinPos(r, c).getColour() == "white") {
                    differentTypes[1]++;
                } else if (library.getCardinPos(r, c).getColour() == "yellow") {
                    differentTypes[2]++;
                } else if (library.getCardinPos(r, c).getColour() == "blue") {
                    differentTypes[3]++;
                } else if (library.getCardinPos(r, c).getColour().equals("lightBlue")) {
                    differentTypes[4]++;
                } else if (library.getCardinPos(r, c).getColour() == "pink") {
                    differentTypes[5]++;
                }
                numberOfCards++;
            }
            for(i=0 ; i<6 ; i++){
                if(differentTypes[i]>1){
                    differentLines--;
                }
            }
        }
        if (differentLines < 2) {
            return true;
        }
        return false;
    }
    /**
     *the method returns the description of the card
     */

    @Override
    public String getDesc() {
        return "Two lines each formed by 5 different types of tiles.  \n" +
                "One line can show the same or a different combination of the other line.\n";
    }

    /**
     * The method shows you ana example of the target
     */

    @Override
    public void showCommonCard() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(1, 0).setColour("yellow");
        l.getCardinPos(2, 0).setColour("white");
        l.getCardinPos(3, 0).setColour("lightBlue");
        l.getCardinPos(4, 0).setColour("blue");

        l.getCardinPos(0, 2).setColour("green");
        l.getCardinPos(1, 2).setColour("yellow");
        l.getCardinPos(2, 2).setColour("white");
        l.getCardinPos(3, 2).setColour("lightBlue");
        l.getCardinPos(4, 2).setColour("blue");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();
    }
}
