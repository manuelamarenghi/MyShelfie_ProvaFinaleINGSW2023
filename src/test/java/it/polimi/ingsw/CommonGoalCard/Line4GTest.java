package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Line4GTest {
    private static Library library = new Library();
    private static Line4G card = new Line4G();
    /*
     * check1() tests when the library is empty
     */
    @Test
    void check1() {
        Assertions.assertFalse(card.check(library));
    }
    /*
     * check2() tests when the library has only one line filled
     */
    @Test
    void check2() {
        library.getCardinPos(5, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("V");
        library.getCardinPos(5, 2).setColour("V");
        library.getCardinPos(5, 3).setColour("V");
        library.getCardinPos(5, 4).setColour("V");
        library.showLibrary();
        Assertions.assertFalse(card.check(library));
    }
    /*
     * check3() tests when the library has 4 lines filled but with more than 3 types
     */
    @Test
    void check3() {
        library.getCardinPos(5, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("V");
        library.getCardinPos(5, 2).setColour("V");
        library.getCardinPos(5, 3).setColour("V");
        library.getCardinPos(5, 4).setColour("V");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(4, 1).setColour("R");
        library.getCardinPos(4, 2).setColour("W");
        library.getCardinPos(4, 3).setColour("B");
        library.getCardinPos(4, 4).setColour("V");
        library.getCardinPos(3, 0).setColour("V");
        library.getCardinPos(3, 1).setColour("R");
        library.getCardinPos(3, 2).setColour("W");
        library.getCardinPos(3, 3).setColour("B");
        library.getCardinPos(3, 4).setColour("V");
        library.getCardinPos(2, 0).setColour("V");
        library.getCardinPos(2, 1).setColour("V");
        library.getCardinPos(2, 2).setColour("V");
        library.getCardinPos(2, 3).setColour("V");
        library.getCardinPos(2, 4).setColour("V");
        library.showLibrary();
        Assertions.assertFalse(card.check(library));
    }
    /*
     * check4() tests when the library has 3 lines with less or equal than 3 types
     */
    @Test
    void check4() {
        library.getCardinPos(5, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("V");
        library.getCardinPos(5, 2).setColour("V");
        library.getCardinPos(5, 3).setColour("V");
        library.getCardinPos(5, 4).setColour("V");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(4, 1).setColour("V");
        library.getCardinPos(4, 2).setColour("V");
        library.getCardinPos(4, 3).setColour("B");
        library.getCardinPos(4, 4).setColour("V");
        library.getCardinPos(3, 0).setColour("V");
        library.getCardinPos(3, 1).setColour("R");
        library.getCardinPos(3, 2).setColour("V");
        library.getCardinPos(3, 3).setColour("V");
        library.getCardinPos(3, 4).setColour("V");
        Assertions.assertFalse(card.check(library));
    }
    /*
     * check5() tests when the library has 4 lines filled with less or equal than 3 types
     */
    @Test
    void check5() {
        library.getCardinPos(5, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("V");
        library.getCardinPos(5, 2).setColour("V");
        library.getCardinPos(5, 3).setColour("V");
        library.getCardinPos(5, 4).setColour("V");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(4, 1).setColour("R");
        library.getCardinPos(4, 2).setColour("R");
        library.getCardinPos(4, 3).setColour("R");
        library.getCardinPos(4, 4).setColour("V");
        library.getCardinPos(3, 0).setColour("V");
        library.getCardinPos(3, 1).setColour("V");
        library.getCardinPos(3, 2).setColour("V");
        library.getCardinPos(3, 3).setColour("B");
        library.getCardinPos(3, 4).setColour("V");
        library.getCardinPos(2, 0).setColour("V");
        library.getCardinPos(2, 1).setColour("V");
        library.getCardinPos(2, 2).setColour("V");
        library.getCardinPos(2, 3).setColour("V");
        library.getCardinPos(2, 4).setColour("V");
        Assertions.assertTrue(card.check(library));
    }
    /*
     * check6() tests when the library is full and has more than 4 lines with less or equal than 3 types
     */
    @Test
    void check6() {
        library.getCardinPos(5, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("V");
        library.getCardinPos(5, 2).setColour("V");
        library.getCardinPos(5, 3).setColour("V");
        library.getCardinPos(5, 4).setColour("V");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(4, 1).setColour("R");
        library.getCardinPos(4, 2).setColour("R");
        library.getCardinPos(4, 3).setColour("R");
        library.getCardinPos(4, 4).setColour("V");
        library.getCardinPos(3, 0).setColour("V");
        library.getCardinPos(3, 1).setColour("V");
        library.getCardinPos(3, 2).setColour("V");
        library.getCardinPos(3, 3).setColour("V");
        library.getCardinPos(3, 4).setColour("V");
        library.getCardinPos(2, 0).setColour("V");
        library.getCardinPos(2, 1).setColour("V");
        library.getCardinPos(2, 2).setColour("V");
        library.getCardinPos(2, 3).setColour("V");
        library.getCardinPos(2, 4).setColour("V");
        library.getCardinPos(1, 0).setColour("V");
        library.getCardinPos(1, 1).setColour("V");
        library.getCardinPos(1, 2).setColour("V");
        library.getCardinPos(1, 3).setColour("V");
        library.getCardinPos(1, 4).setColour("V");
        library.getCardinPos(0, 0).setColour("V");
        library.getCardinPos(0, 1).setColour("V");
        library.getCardinPos(0, 2).setColour("V");
        library.getCardinPos(0, 3).setColour("V");
        library.getCardinPos(0, 4).setColour("V");
        library.showLibrary();
        Assertions.assertTrue(card.check(library));
    }
    /*
     * check7() tests when the library is full and hasn't 4 lines with less or equal than 3 types
     */
    @Test
    void check7() {
        library.getCardinPos(5, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("B");
        library.getCardinPos(5, 2).setColour("V");
        library.getCardinPos(5, 3).setColour("C");
        library.getCardinPos(5, 4).setColour("V");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(4, 1).setColour("R");
        library.getCardinPos(4, 2).setColour("B");
        library.getCardinPos(4, 3).setColour("R");
        library.getCardinPos(4, 4).setColour("V");
        library.getCardinPos(3, 0).setColour("V");
        library.getCardinPos(3, 1).setColour("B");
        library.getCardinPos(3, 2).setColour("C");
        library.getCardinPos(3, 3).setColour("X");
        library.getCardinPos(3, 4).setColour("V");
        library.getCardinPos(2, 0).setColour("V");
        library.getCardinPos(2, 1).setColour("D");
        library.getCardinPos(2, 2).setColour("V");
        library.getCardinPos(2, 3).setColour("V");
        library.getCardinPos(2, 4).setColour("V");
        library.getCardinPos(1, 0).setColour("V");
        library.getCardinPos(1, 1).setColour("D");
        library.getCardinPos(1, 2).setColour("W");
        library.getCardinPos(1, 3).setColour("C");
        library.getCardinPos(1, 4).setColour("V");
        library.getCardinPos(0, 0).setColour("R");
        library.getCardinPos(0, 1).setColour("W");
        library.getCardinPos(0, 2).setColour("B");
        library.getCardinPos(0, 3).setColour("C");
        library.getCardinPos(0, 4).setColour("V");
        library.showLibrary();
        Assertions.assertFalse(card.check(library));
    }
    /*
     * getImage() to see the output of the method in the card
     */
    @Test
    void getImage() {
        card.getImage();
    }
}