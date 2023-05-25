package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class Square2G implements CommonGoalCards, Serializable {
    int numberCard = 1;

    public int getNumberCard() {
        return numberCard;
    }

    /**
     * the method checks if the the target is completed or not
     */

    @Override
    public boolean check(Library library) {
        int r, c, i, indexToSkip1 = -1, indexToSkip2 = -1 , totalSquares=0;
        int[] numOfSquares = {0, 0, 0, 0, 0, 0};
        for (r = 0; r < 5; r++) {
            for (c = 0; c < 4; c++) {
                if(c==indexToSkip1){
                    indexToSkip1=-1;
                    continue;
                }
                else if (c==indexToSkip2){
                    indexToSkip2=-1;
                    continue;
                }
                if(library.getCardinPos(r, c).getColour().equals(library.getCardinPos(r, c + 1).getColour()) &&
                        library.getCardinPos(r, c).getColour().equals(library.getCardinPos(r + 1, c).getColour()) &&
                        library.getCardinPos(r, c).getColour().equals(library.getCardinPos(r + 1, c + 1).getColour())){
                    if (library.getCardinPos(r, c).getColour().equals("green")) {
                        numOfSquares[0]++;
                    } else if (library.getCardinPos(r, c).getColour().equals("white")) {
                        numOfSquares[1]++;
                    } else if (library.getCardinPos(r, c).getColour().equals("yellow")) {
                        numOfSquares[2]++;
                    } else if (library.getCardinPos(r, c).getColour().equals("blue")) {
                        numOfSquares[3]++;
                    } else if (library.getCardinPos(r, c).getColour().equals("lightBlue")) {
                        numOfSquares[4]++;
                    } else if (library.getCardinPos(r, c).getColour().equals("pink")) {
                        numOfSquares[5]++;
                    }
                    indexToSkip1=c;
                    indexToSkip2=c+1;
                    c++;
                }

            }
        }
        for(i=0 ; i<6 ; i++){
            totalSquares = totalSquares + numOfSquares[i];
        }
        if(totalSquares>1){
            return true;
        }
        return false;
    }
    /**
     * expired() let you know if the player can still reach the goal or not
     */

    @Override
    public boolean expired(Library library) {
        return false;
    }
    /**
     *the method returns the description of the card
     */
    @Override
    public String getDesc() {
        return "Two groups each containing 4 tiles of the same type in a 2x2 square. \n" +
                "The tiles of one square can be different from those of the other square.\n";
    }

    /**
     * The method shows an example of the target
     */

    @Override
    public void showCommonCard() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(0, 1).setColour("green");
        l.getCardinPos(1, 0).setColour("green");
        l.getCardinPos(1, 1).setColour("green");

        l.getCardinPos(2, 0).setColour("green");
        l.getCardinPos(2, 1).setColour("green");
        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(3, 1).setColour("green");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();
    }
}
