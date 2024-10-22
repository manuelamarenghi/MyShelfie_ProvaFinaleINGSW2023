package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;
import java.util.ArrayList;

public class DoubleCommG implements CommonGoalCards, Serializable {
    int numberCard = 4;

    public int getNumberCard() {
        return numberCard;
    }

    /**
     * Checks if the library of the player has completed the goal or not
     *
     * @param library
     * @return
     */
    @Override
    public boolean check(Library library) {

        ArrayList<Integer> adjacent = library.getgroup();
        int count = 0;
        for (Integer i : adjacent) {
            if (i == 2) {
                count++;
            }
            if (i > 2) {
                count = count + (i / 2);
            }
        }
        if (count >= 6)
            return true;
        else return false;
    }

    /**
     * The method checks if the goal is still achieveable
     *
     * @param library
     * @return
     */
    @Override
    public boolean expired(Library library) {
        return false;
    }

    /**
     * the method shows the goal
     */
    @Override
    public void showCommonCard() {

        Library library = new Library();
        library.getCardinPos(0, 0).setColour("green");
        library.getCardinPos(1, 0).setColour("green");
        library.getCardinPos(2, 0).setColour("yellow");
        library.getCardinPos(3, 0).setColour("yellow");
        library.getCardinPos(4, 0).setColour("blue");
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(0, 4).setColour("green");
        library.getCardinPos(1, 4).setColour("green");
        library.getCardinPos(2, 4).setColour("yellow");
        library.getCardinPos(3, 4).setColour("yellow");
        library.getCardinPos(4, 4).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        System.out.println("This is an example of a library that respects this goal");
        library.showLibrary();
    }

    /**
     * the method returns the description of the card
     * @return
     */
    @Override
    public String getDesc() {
        return "Six groups each containing at least 2 tiles of the same type (not necessarily in the depicted shape). \n" +
                "The tiles of one group can be different from those of another group.\n";
    }
}
