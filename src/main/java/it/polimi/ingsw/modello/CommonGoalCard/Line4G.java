package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Line4G goal needs 4 lines formed by 5 tiles of maximum 3 different types. Different lines can have different combination of types
 */
public class Line4G implements CommonGoalCards, Serializable {
    int numberCard = 7;

    public int getNumberCard() {
        return numberCard;
    }

    /**
     * check() returns true if the library match the goal,otherwise false
     */
    @Override
    public boolean check(Library library) {
        ArrayList<String> n = new ArrayList<String>();
        int x = 0;
        int temp = 0;
        int j = 0;
        for (int i = 0; i < 6; i++) {
            while (j < 5 && temp< 4) {
                if (!library.getCardinPos(i, j).getColour().isEmpty()) {
                    if (!n.contains(library.getCardinPos(i, j).getColour())) {
                        n.add(temp, library.getCardinPos(i, j).getColour());
                        temp++;
                    }
                    j++;
                    if (j == 5 && temp<4) {
                        x++;
                    }
                }
                else{ j=5;}
            }
            j = 0;
            n.clear();
            temp=0;
        }
        if (x >= 4) {
            return true;
        }
        return false;
    }

    /**
     * showCommonCard let you see this goal
     */
    @Override
    public void showCommonCard() {
        Library l = new Library();
        l.getCardinPos(5, 0).setColour("green");
        l.getCardinPos(5, 1).setColour("pink");
        l.getCardinPos(5, 2).setColour("green");
        l.getCardinPos(5, 3).setColour("green");
        l.getCardinPos(5, 4).setColour("green");
        l.getCardinPos(4, 0).setColour("green");
        l.getCardinPos(4, 1).setColour("pink");
        l.getCardinPos(4, 2).setColour("green");
        l.getCardinPos(4, 3).setColour("blue");
        l.getCardinPos(4, 4).setColour("blue");
        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(3, 1).setColour("pink");
        l.getCardinPos(3, 2).setColour("green");
        l.getCardinPos(3, 3).setColour("blue");
        l.getCardinPos(3, 4).setColour("green");
        l.getCardinPos(2, 0).setColour("blue");
        l.getCardinPos(2, 1).setColour("blue");
        l.getCardinPos(2, 2).setColour("blue");
        l.getCardinPos(2, 3).setColour("blue");
        l.getCardinPos(2, 4).setColour("blue");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();

    }
    /**
     * expired() let you know if the player can still reach the goal or not
     */
    @Override
    public boolean expired(Library library) {
        int j=0;
        ArrayList<String> colors = new ArrayList<String>();
        int n=0;
        int x=0;
        for(int i=0;i<6;i++){
            while(j<5 && x<4){
                if(!library.getCardinPos(i, j).getColour().isEmpty()){
                    if(!colors.contains(library.getCardinPos(i, j).getColour())){
                        colors.add(x,library.getCardinPos(i,j).getColour());
                        x++;
                    }
                    if(x>3){
                        n++;
                    }
                    j++;
                }
                else{
                    n++;
                    j++;
                }
            }
            j = 0;
            colors.clear();
            x = 0;
        }
        if (n > 3) {
            return true;
        }
        return false;
    }

    /**
     * the method returns the description of the card
     */

    @Override
    public String getDesc() {
        return "Four lines each formed by 5 tiles of maximum three different types.\n" +
                "One line can show the same or a different combination of another line.\n";
    }
}
