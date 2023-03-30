package it.polimi.ingsw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class LibraryTest {
    private static Library library = new Library();
    /*
     * showColumn1() tests where you can put 2 cards with some column permitted
     */
    @Test
    void showColumn1() {
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
     * showColumn2() tests where you can put 3 cards when not permitted
     */
    @Test
    void showColumn2() {
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
        library.getCardinPos(2, 0).setColour("V");
        library.getCardinPos(2, 1).setColour("V");
        library.getCardinPos(2, 3).setColour("V");
        library.getCardinPos(2, 4).setColour("V");
        library.getCardinPos(3, 1).setColour("V");
        library.getCardinPos(3, 4).setColour("V");
        library.showLibrary();
        actual = library.showColumn(3);
        Assertions.assertTrue(actual.length==0);
    }
    /*
     * showColumn3() tests where you can put 3 cards when library's empty
     */
    @Test
    void showColumn3(){
        int[] expected = new int[5];
        expected[0] = 1;
        expected[1] = 2;
        expected[2] = 3;
        expected[3] = 4;
        expected[4] = 5;
        int[] actual;
        actual = library.showColumn(2);
        Assertions.assertArrayEquals(expected, actual);
    }
    /*
     * setColumn1() testing to put 1 card in an empty column
     */
    @Test
    void setColumn1() {
        Card[] cards = new Card[1];
        cards[0]=new Card();
        cards[0].setColour("V");
        Library l = new Library();
        l.getCardinPos(5,2).setColour("V");
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
     * setColumn2() testing to put 2 cards in a library given
     */
    @Test
    void setColumn2() {
        Card[] cards = new Card[2];
        cards[0]=new Card();
        cards[0].setColour("V");
        cards[1]=new Card();
        cards[1].setColour("V");
        Library l = new Library();
        l.getCardinPos(5,2).setColour("V");
        l.getCardinPos(4,2).setColour("R");
        l.getCardinPos(5,1).setColour("R");
        l.getCardinPos(4,1).setColour("R");
        l.getCardinPos(3,1).setColour("V");
        l.getCardinPos(2,1).setColour("V");
        l.getCardinPos(5,0).setColour("B");
        l.getCardinPos(4,0).setColour("V");
        l.getCardinPos(3,0).setColour("V");
        library.getCardinPos(5,2).setColour("V");
        library.getCardinPos(4,2).setColour("R");
        library.getCardinPos(5,1).setColour("R");
        library.getCardinPos(4,1).setColour("R");
        library.getCardinPos(3,1).setColour("V");
        library.getCardinPos(2,1).setColour("V");
        library.getCardinPos(5,0).setColour("B");
        library.setColumn(cards, 0);
        for (int i = 0; i < 6; i++) {
            String expected= new String();
            String actual= new String();
            expected=l.getCardinPos(i,0).getColour();
            actual=library.getCardinPos(i,0).getColour();
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
    /*
     * getGroup1() tests if it works
     */
    @Test
    void getGroup1(){
        library.getCardinPos(5,0).setColour("V");
        library.getCardinPos(4,0).setColour("G");
        library.getCardinPos(3,0).setColour("G");
        library.getCardinPos(5,1).setColour("V");
        library.getCardinPos(4,1).setColour("B");
        library.getCardinPos(3,1).setColour("V");
        library.getCardinPos(5,2).setColour("V");
        library.getCardinPos(4,2).setColour("V");
        library.getCardinPos(5,3).setColour("G");
        library.getCardinPos(4,3).setColour("V");
        library.getCardinPos(3,3).setColour("V");
        library.getCardinPos(3,2).setColour("V");
        library.getCardinPos(1,2).setColour("R");
        library.getCardinPos(5,4).setColour("G");
        library.showLibrary();

        library.getgroup();
    }
}