package it.polimi.ingsw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LibraryTest {
    private static Library library = new Library();
    /*
     * showColumn() tests if the column returned from the method in Library are right
     */
    @Test
    void showColumn() {
        int[] expected = new int[4];
        expected[0] = 1;
        expected[1] = 2;
        expected[2] = 4;
        expected[3] = 5;
        int[] actual;
        library.getCardinPos(5, 2).setColour("V");
        library.getCardinPos(4, 2).setColour("V");
        library.getCardinPos(3, 2).setColour("R");
        library.getCardinPos(2, 2).setColour("V");
        library.getCardinPos(1, 2).setColour("R");
        library.getCardinPos(5, 1).setColour("V");
        library.getCardinPos(3, 0).setColour("V");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(5, 0).setColour("V");
        actual = library.showColumn(2);
        Assertions.assertArrayEquals(expected, actual);
    }
    /*
     * setColumn() tests if the function in class Library puts cards in right places
     */
    @Test
    void setColumn() {
        Card[] cards = new Card[2];
        cards[0]=new Card();
        cards[0].setColour("Verde");
        cards[1]=new Card();
        cards[1].setColour("Verde");
        Library l = new Library();
        l.getCardinPos(5, 2).setColour("Verde");
        l.getCardinPos(4, 2).setColour("Verde");
        l.getCardinPos(3, 2).setColour("Verde");
        l.getCardinPos(2, 2).setColour("Verde");
        l.getCardinPos(1, 2).setColour("Verde");
        l.getCardinPos(0, 2).setColour("Verde");
        library.getCardinPos(5, 2).setColour("Verde");
        library.getCardinPos(4, 2).setColour("Verde");
        library.getCardinPos(3, 2).setColour("Verde");
        library.getCardinPos(2, 2).setColour("Verde");
        library.setColumn(cards, 2);
        for (int i = 0; i < 6; i++) {
          String expected= new String();
          String actual= new String();
          expected=l.getCardinPos(i,2).getColour();
          actual=library.getCardinPos(i,2).getColour();
          Assertions.assertTrue(expected.equals(actual));
        }
    }
    /*
     * takeAction() tests if the function makes the right move ( direct by the player)
     */
    @Test
    void takeAction() {
        Card[] cards = new Card[2];
        cards[0]=new Card();
        cards[0].setColour("R");
        cards[1]=new Card();
        cards[1].setColour("B");
        Library l = new Library();
        l.getCardinPos(5, 2).setColour("V");
        l.getCardinPos(4, 2).setColour("V");
        l.getCardinPos(3, 2).setColour("R");
        l.getCardinPos(1, 2).setColour("R");
        l.getCardinPos(5, 0).setColour("V");
        l.getCardinPos(4, 0).setColour("V");
        l.getCardinPos(3, 0).setColour("V");
        l.getCardinPos(2, 2).setColour("V");
        l.getCardinPos(5,1).setColour("V");
        l.getCardinPos(4,1).setColour("R");
        l.getCardinPos(3,1).setColour("B");
        library.getCardinPos(5, 2).setColour("V");
        library.getCardinPos(4, 2).setColour("V");
        library.getCardinPos(3, 2).setColour("R");
        library.getCardinPos(2, 2).setColour("V");
        library.getCardinPos(1, 2).setColour("R");
        library.getCardinPos(5, 1).setColour("V");
        library.getCardinPos(3, 0).setColour("V");
        library.getCardinPos(4, 0).setColour("V");
        library.getCardinPos(5, 0).setColour("V");
        library.takeAction(cards);
        for (int i = 0; i < 6; i++) {
            String expected= new String();
            String actual= new String();
            expected=l.getCardinPos(i,1).getColour();
            actual=library.getCardinPos(i,1).getColour();
            Assertions.assertTrue(expected.equals(actual));
        }
    }

}