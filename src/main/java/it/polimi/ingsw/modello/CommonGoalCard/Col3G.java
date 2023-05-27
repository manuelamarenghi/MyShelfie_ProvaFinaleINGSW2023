package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class Col3G implements CommonGoalCards, Serializable {
    int numberCard = 5;

    public int getNumberCard() {
        return numberCard;
    }

    /**
     * the method checks if the target has been completed or not
     */

    @Override
    public boolean check(Library library) {
        int r, c, i;
        int[] differentColours = {0, 0, 0, 0, 0, 0};
        int differentCols = 0, totalTypes, numberOfCards = 0;
        for (c = 0; c < 5; c++) {
            numberOfCards=0;
            totalTypes=0;
            for(i=0 ; i<6 ; i++){
                differentColours[i]=0;
            }
            for(r=0 ;r<6 ; r++){
                if (library.getCardinPos(r, c).getColour() == "green") {
                    differentColours[0]++;
                    numberOfCards++;
                } else if (library.getCardinPos(r, c).getColour() == "white") {
                    differentColours[1]++;
                    numberOfCards++;
                } else if (library.getCardinPos(r, c).getColour() == "yellow") {
                    differentColours[2]++;
                    numberOfCards++;
                } else if (library.getCardinPos(r, c).getColour() == "blue") {
                    differentColours[3]++;
                    numberOfCards++;
                } else if (library.getCardinPos(r, c).getColour() == "lightBlue") {
                    differentColours[4]++;
                    numberOfCards++;
                } else if (library.getCardinPos(r, c).getColour() == "pink") {
                    differentColours[5]++;
                    numberOfCards++;
                }

            }
            for(i=0 ; i<6 ; i++){
                if(differentColours[i]!=0){
                    totalTypes++;
                }
            }
            if(totalTypes<=3 && numberOfCards==6){
                differentCols++;
            }


        }
        if(differentCols>=3){
            return true;
        }
        return false;
    }

    /**
     * The method checks if the target can still be completed or not
     */

    @Override
    public boolean expired(Library library) {
        int r , c , i ;
        int [] differentTypes= {0,0,0,0,0,0};
        int differentCols=5 , totalTypes;
        for(c=0 ; c<5 ; c++){
            totalTypes=0;
            for(i=0 ; i<6 ; i++){
                differentTypes[i]=0;
            }
            for(r=0 ;r<6 ; r++){
                if (library.getCardinPos(r, c).getColour() == "green") {
                    differentTypes[0]++;
                } else if (library.getCardinPos(r, c).getColour() == "white") {
                    differentTypes[1]++;
                } else if (library.getCardinPos(r, c).getColour() == "yellow") {
                    differentTypes[2]++;
                } else if (library.getCardinPos(r, c).getColour() == "blue") {
                    differentTypes[3]++;
                } else if (library.getCardinPos(r, c).getColour() == "lightBlue") {
                    differentTypes[4]++;
                } else if (library.getCardinPos(r, c).getColour() == "pink") {
                    differentTypes[5]++;
                }
            }
            for(i=0 ; i<6 ; i++){
                if(differentTypes[i]!=0){
                    totalTypes++;
                }
            }
            if(totalTypes<=3){
                differentCols--;
            }
        }
        if(differentCols>=3){
            return true;
        }

        return false;
    }

    /**
     * The method lets you see an example of the target
     */


    @Override
    public void showCommonCard() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");

        l.getCardinPos(1, 0).setColour("yellow");
        l.getCardinPos(2, 0).setColour("blue");
        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(4, 0).setColour("blue");
        l.getCardinPos(5, 0).setColour("green");

        l.getCardinPos(0, 2).setColour("green");
        l.getCardinPos(1, 2).setColour("white");
        l.getCardinPos(2, 2).setColour("white");
        l.getCardinPos(3, 2).setColour("white");
        l.getCardinPos(4, 2).setColour("green");
        l.getCardinPos(5, 2).setColour("green");

        l.getCardinPos(0, 4).setColour("green");
        l.getCardinPos(1, 4).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");
        l.getCardinPos(3, 4).setColour("lightBlue");
        l.getCardinPos(4, 4).setColour("lightBlue");
        l.getCardinPos(5, 4).setColour("green");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();
    }
    /**
     *Returns the description of the card
     * @return
     */
    @Override
    public String getDesc() {
        return "Three columns each formed by 6 tiles of maximum three different types.\n" +
                "One column can show the same or a different combination of another column.\n";
    }
}
