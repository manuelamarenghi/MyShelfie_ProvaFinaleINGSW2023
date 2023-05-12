package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Col2GTest {
    private static Col2G card = new Col2G();
    /**
     * check1() tests when the library is empty
     */
    @Test
    void check1() {
        Library library = new Library();
        Assertions.assertFalse(card.check(library));
    }
    /**
     * check2() tests when the library has only one column filled with the same type
     */
    @Test
    void check2(){
        Library library = new Library();
        library.getCardinPos(0, 4).setColour("V");
        library.getCardinPos(1, 4).setColour("V");
        library.getCardinPos(2, 4).setColour("V");
        library.getCardinPos(3, 4).setColour("V");
        library.getCardinPos(4, 4).setColour("V");
        library.getCardinPos(5, 4).setColour("V");
        Assertions.assertFalse(card.check(library));
    }
    /**
     * check3() tests when the library has only one column filled with all different type
     */
    @Test
    void check3(){
        Library library = new Library();
        library.getCardinPos(0, 4).setColour("V");
        library.getCardinPos(1, 4).setColour("R");
        library.getCardinPos(2, 4).setColour("T");
        library.getCardinPos(3, 4).setColour("Y");
        library.getCardinPos(4, 4).setColour("H");
        library.getCardinPos(5, 4).setColour("D");
        library.showLibrary();
        Assertions.assertFalse(card.check(library));
    }
    /**
     * check4() tests when the library has only two columns filled with all different type
     */
    @Test
    void check4(){
        Library library = new Library();
        library.getCardinPos(0, 4).setColour("V");
        library.getCardinPos(1, 4).setColour("R");
        library.getCardinPos(2, 4).setColour("T");
        library.getCardinPos(3, 4).setColour("Y");
        library.getCardinPos(4, 4).setColour("H");
        library.getCardinPos(5, 4).setColour("D");
        library.getCardinPos(0, 3).setColour("V");
        library.getCardinPos(1, 3).setColour("R");
        library.getCardinPos(2, 3).setColour("T");
        library.getCardinPos(3, 3).setColour("Y");
        library.getCardinPos(4, 3).setColour("H");
        library.getCardinPos(5, 3).setColour("D");
        Assertions.assertTrue(card.check(library));
    }
    /**
     * check5() tests when the library has some columns with two of them filled with all different type
     */
    @Test
    void check5(){
        Library library = new Library();
        library.getCardinPos(0, 4).setColour("V");
        library.getCardinPos(1, 4).setColour("R");
        library.getCardinPos(2, 4).setColour("T");
        library.getCardinPos(3, 4).setColour("Y");
        library.getCardinPos(4, 4).setColour("H");
        library.getCardinPos(5, 4).setColour("D");
        library.getCardinPos(0, 3).setColour("V");
        library.getCardinPos(1, 3).setColour("V");
        library.getCardinPos(2, 3).setColour("T");
        library.getCardinPos(3, 3).setColour("Y");
        library.getCardinPos(4, 3).setColour("H");
        library.getCardinPos(5, 3).setColour("D");
        library.getCardinPos(0, 2).setColour("V");
        library.getCardinPos(1, 2).setColour("V");
        library.getCardinPos(2, 2).setColour("T");
        library.getCardinPos(3, 2).setColour("Y");
        library.getCardinPos(4, 2).setColour("H");
        library.getCardinPos(5, 2).setColour("D");
        library.getCardinPos(0, 0).setColour("V");
        library.getCardinPos(1, 0).setColour("R");
        library.getCardinPos(2, 0).setColour("T");
        library.getCardinPos(3, 0).setColour("Y");
        library.getCardinPos(4, 0).setColour("H");
        library.getCardinPos(5, 0).setColour("D");
        library.showLibrary();
        Assertions.assertTrue(card.check(library));
    }
    /**
     * check6() tests when the library is full of no valid columns
     */
    @Test
    void check6(){
        Library library = new Library();
        library.getCardinPos(0, 4).setColour("V");
        library.getCardinPos(1, 4).setColour("R");
        library.getCardinPos(2, 4).setColour("T");
        library.getCardinPos(3, 4).setColour("N");
        library.getCardinPos(4, 4).setColour("H");
        library.getCardinPos(5, 4).setColour("D");
        library.getCardinPos(0, 3).setColour("V");
        library.getCardinPos(1, 3).setColour("V");
        library.getCardinPos(2, 3).setColour("T");
        library.getCardinPos(3, 3).setColour("H");
        library.getCardinPos(4, 3).setColour("H");
        library.getCardinPos(5, 3).setColour("D");
        library.getCardinPos(0, 2).setColour("V");
        library.getCardinPos(1, 2).setColour("V");
        library.getCardinPos(2, 2).setColour("T");
        library.getCardinPos(3, 2).setColour("Y");
        library.getCardinPos(4, 2).setColour("D");
        library.getCardinPos(5, 2).setColour("D");
        library.getCardinPos(0, 0).setColour("V");
        library.getCardinPos(1, 0).setColour("R");
        library.getCardinPos(2, 0).setColour("T");
        library.getCardinPos(3, 0).setColour("Y");
        library.getCardinPos(4, 0).setColour("Y");
        library.getCardinPos(5, 0).setColour("D");
        library.getCardinPos(0, 1).setColour("V");
        library.getCardinPos(1, 1).setColour("R");
        library.getCardinPos(2, 1).setColour("T");
        library.getCardinPos(3, 1).setColour("Y");
        library.getCardinPos(4, 1).setColour("Y");
        library.getCardinPos(5, 1).setColour("D");
        library.showLibrary();
        Assertions.assertFalse(card.check(library));
    }
    /**
     * getImage() to see the output of the method in the card
     */
    @Test
    void getImage() {
        card.showCommonCard();
    }
    /**
     * expired1() to see when the library is empty
     */
    @Test
    void expired1() {
        Library library = new Library();
        Assertions.assertFalse(card.expired(library));
    }
    /**
     * expired2() to see when the library has 3 columns not full but can still reach the goal
     */
    @Test
    void expired2() {
        Library library = new Library();
        library.getCardinPos(5, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("V");
        library.getCardinPos(4, 1).setColour("V");
        library.getCardinPos(4, 0).setColour("R");
        library.getCardinPos(3, 0).setColour("Y");
        library.getCardinPos(4, 1).setColour("V");
        library.getCardinPos(5, 2).setColour("R");
        library.getCardinPos(4, 2).setColour("R");
        library.getCardinPos(4, 1).setColour("V");
        Assertions.assertFalse(card.expired(library));
    }
    /**
     * expired3() to see when the library has 4 columns not full and cannot reach the goal
     */
    @Test
    void expired3(){
        Library library = new Library();
        library.getCardinPos(5, 0).setColour("R");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(3, 0).setColour("P");
        library.getCardinPos(2, 0).setColour("Y");
        library.getCardinPos(1, 0).setColour("W");
        library.getCardinPos(0, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("R");
        library.getCardinPos(4, 1).setColour("W");
        library.getCardinPos(3, 1).setColour("P");
        library.getCardinPos(2, 1).setColour("I");
        library.getCardinPos(1, 1).setColour("Y");
        library.getCardinPos(0, 1).setColour("R");
        library.getCardinPos(5, 2).setColour("R");
        library.getCardinPos(4, 2).setColour("V");
        library.getCardinPos(3, 2).setColour("W");
        library.getCardinPos(5, 3).setColour("V");
        library.getCardinPos(4, 3).setColour("Y");
        library.getCardinPos(3, 3).setColour("E");
        library.getCardinPos(2, 3).setColour("B");
        library.getCardinPos(1, 3).setColour("V");
        library.getCardinPos(0, 3).setColour("V");
        library.getCardinPos(5, 4).setColour("V");
        library.getCardinPos(4, 4).setColour("Y");
        library.getCardinPos(3, 4).setColour("E");
        library.getCardinPos(2, 4).setColour("B");
        library.getCardinPos(1, 4).setColour("V");
        library.getCardinPos(0, 4).setColour("V");
        assertTrue(card.expired(library));
    }
    /**
     * expired4() similar to test 3 but can still reach the goal
     */
    @Test
    void expired4(){
        Library library = new Library();
        library.getCardinPos(5, 0).setColour("R");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(3, 0).setColour("P");
        library.getCardinPos(2, 0).setColour("Y");
        library.getCardinPos(1, 0).setColour("W");
        library.getCardinPos(0, 0).setColour("V");
        library.getCardinPos(5, 1).setColour("Z");
        library.getCardinPos(4, 1).setColour("W");
        library.getCardinPos(3, 1).setColour("P");
        library.getCardinPos(2, 1).setColour("I");
        library.getCardinPos(1, 1).setColour("Y");
        library.getCardinPos(0, 1).setColour("R");
        library.getCardinPos(5, 2).setColour("R");
        library.getCardinPos(4, 2).setColour("P");
        library.getCardinPos(3, 2).setColour("W");
        library.getCardinPos(5, 3).setColour("V");
        library.getCardinPos(4, 3).setColour("Y");
        library.getCardinPos(3, 3).setColour("E");
        library.getCardinPos(2, 3).setColour("B");
        library.getCardinPos(1, 3).setColour("V");
        library.getCardinPos(0, 3).setColour("V");
        library.getCardinPos(5, 4).setColour("V");
        library.getCardinPos(4, 4).setColour("Y");
        library.getCardinPos(3, 4).setColour("E");
        library.getCardinPos(2, 4).setColour("B");
        library.getCardinPos(1, 4).setColour("V");
        library.getCardinPos(0, 4).setColour("V");
        assertFalse(card.expired(library));
    }
    /**
     * expired5() with no column full but can't reach the goal
     */
    @Test
    void expired5(){
        Library library = new Library();
        library.getCardinPos(5, 0).setColour("R");
        library.getCardinPos(4, 0).setColour("R");
        library.getCardinPos(5, 1).setColour("R");
        library.getCardinPos(4, 1).setColour("w");
        library.getCardinPos(3, 1).setColour("R");
        library.getCardinPos(4, 2).setColour("R");
        library.getCardinPos(5, 2).setColour("R");
        library.getCardinPos(5, 3).setColour("T");
        library.getCardinPos(4, 3).setColour("Y");
        library.getCardinPos(3, 3).setColour("W");
        library.getCardinPos(2, 3).setColour("R");
        library.getCardinPos(5, 4).setColour("R");
        library.getCardinPos(4, 4).setColour("R");
        assertTrue(card.expired(library));
    }
}