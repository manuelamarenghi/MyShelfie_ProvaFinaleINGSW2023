package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Same4GroupsG Four groups each containing at least 4 tiles of the same type.The tiles of one group can be different from those of another group.
 */
public class Same4GroupsG implements CommonGoalCards, Serializable {
    int numberCard = 3;

    public int getNumberCard() {
        return numberCard;
    }

    /**
     * check() returns true if the library match the goal,otherwise false
     */
    @Override
    public boolean check(Library library) {
        ArrayList<Integer> adjacent = library.getgroup();
        int count = 0;

        for (Integer i : adjacent) {
            if (i >= 4)
                count++;
        }
        if (count >= 4)
            return true;
        else return false;
    }

    /**
     * getImage() let you see this goal
     */
    @Override
    public void showCommonCard() {
        Library l = new Library();
        l.getCardinPos(4, 1).setColour("pink");
        l.getCardinPos(3, 1).setColour("pink");
        l.getCardinPos(3, 2).setColour("pink");
        l.getCardinPos(5, 1).setColour("pink");
        l.getCardinPos(4, 2).setColour("green");
        l.getCardinPos(5, 2).setColour("green");
        l.getCardinPos(4, 3).setColour("green");
        l.getCardinPos(5, 3).setColour("green");
        l.getCardinPos(2, 0).setColour("white");
        l.getCardinPos(3, 0).setColour("white");
        l.getCardinPos(4, 0).setColour("white");
        l.getCardinPos(5, 0).setColour("white");
        l.getCardinPos(2, 4).setColour("blue");
        l.getCardinPos(3, 4).setColour("blue");
        l.getCardinPos(4, 4).setColour("blue");
        l.getCardinPos(5, 4).setColour("blue");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();
    }

    /**
     * expired() returns false and doesn't control if the goal couldn't be reached
     */
    @Override
    public boolean expired(Library library) {
        return false;
    }

    /**
     * the method returns the description of the card
     */
    @Override
    public String getDesc() {
        return "Four groups each containing at least 4 tiles of the same type (not necessarily in the depicted shape). \n" +
                "The tiles of one group can be different from those of another group.\n";
    }
}
