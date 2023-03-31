package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Same4GroupsGTest {
    private static Same4GroupsG card = new Same4GroupsG();
    /*
     * getImage() to see the output of the method in the card
     */
    @Test
    void getImage() {
        card.getImage();
    }
    /*
     * check1() to see if it works when the library doesn't reach the goal
     */
    @Test
    void check1() {
        Library library=new Library();
        library.getCardinPos(5, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("B");
        library.getCardinPos(5, 2).setColour("B");
        library.getCardinPos(5, 3).setColour("C");
        library.getCardinPos(5, 4).setColour("C");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(4, 1).setColour("V");
        library.getCardinPos(4, 2).setColour("B");
        library.getCardinPos(4, 3).setColour("C");
        library.getCardinPos(4, 4).setColour("C");
        library.getCardinPos(3, 0).setColour("V");
        library.getCardinPos(3, 2).setColour("V");
        library.getCardinPos(3, 3).setColour("C");
        library.getCardinPos(3, 4).setColour("C");
        library.getCardinPos(2, 2).setColour("V");
        Assertions.assertFalse(card.check(library));
    }
    /*
     * check2() to see when the library has reached the goal
     */
    @Test
    void check2() {
        Library library=new Library();
        library.getCardinPos(5, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("B");
        library.getCardinPos(5, 2).setColour("B");
        library.getCardinPos(5, 3).setColour("C");
        library.getCardinPos(5, 4).setColour("C");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(4, 1).setColour("V");
        library.getCardinPos(4, 2).setColour("B");
        library.getCardinPos(4, 3).setColour("C");
        library.getCardinPos(4, 4).setColour("C");
        library.getCardinPos(3, 0).setColour("V");
        library.getCardinPos(3, 1).setColour("D");
        library.getCardinPos(3, 2).setColour("V");
        library.getCardinPos(3, 3).setColour("B");
        library.getCardinPos(3, 4).setColour("B");
        library.getCardinPos(2, 0).setColour("D");
        library.getCardinPos(2, 1).setColour("D");
        library.getCardinPos(2, 2).setColour("V");
        library.getCardinPos(2, 3).setColour("B");
        library.getCardinPos(1, 1).setColour("D");
        library.getCardinPos(1, 2).setColour("D");
        library.getCardinPos(1, 3).setColour("B");
        library.showLibrary();
        Assertions.assertTrue(card.check(library));
    }
    /*
     * check3() to see when the library is empty
     */
    @Test
    void check3() {
        Library library=new Library();
        library.showLibrary();
        Assertions.assertFalse(card.check(library));
    }

}