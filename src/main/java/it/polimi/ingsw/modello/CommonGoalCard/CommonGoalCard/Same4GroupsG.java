package it.polimi.ingsw.modello.CommonGoalCard.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.util.ArrayList;

/**
 * Same4GroupsG Four groups each containing at least 4 tiles of the same type.The tiles of one group can be different from those of another group.
 */
public class Same4GroupsG implements CommonGoalCards {
    /**
     * check() returns true if the library match the goal,otherwise false
     */
    @Override
    public boolean check(Library library) {
        ArrayList<Integer> adjacent = library.getgroup();
        int count=0;

        for(Integer i : adjacent){
            if(i>=4)
                count ++;
        }
        if(count >=4)
            return true;
        else return false;
    }
    /**
     * getImage() let you see this goal
     */
    @Override
    public void getImage() {
        Library l=new Library();
        l.getCardinPos(4,1).setColour("R");
        l.getCardinPos(3,1).setColour("R");
        l.getCardinPos(3,2).setColour("R");
        l.getCardinPos(5,1).setColour("R");
        l.getCardinPos(4,2).setColour("G");
        l.getCardinPos(5,2).setColour("G");
        l.getCardinPos(4,3).setColour("G");
        l.getCardinPos(5,3).setColour("G");
        l.getCardinPos(2,0).setColour("W");
        l.getCardinPos(3,0).setColour("W");
        l.getCardinPos(4,0).setColour("W");
        l.getCardinPos(5,0).setColour("W");
        l.getCardinPos(2,4).setColour("B");
        l.getCardinPos(3,4).setColour("B");
        l.getCardinPos(4,4).setColour("B");
        l.getCardinPos(5,4).setColour("B");
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
}
