
package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    public void checkZeroZeroHasCoordinatesNull(){
        Board board = new Board(4);
        assertEquals(null , board.getBoard()[0][0].getCoordinates());
    }
    @Test
    public void checkOneTwoHasCoordinatesNull(){
        Board board = new Board(4);
        assertEquals(null ,board.getBoard()[1][2].getCoordinates());
    }
    @Test
    public void checkSixOneHasCoordinatesNull(){
        Board board = new Board(4);
        assertEquals(null ,board.getBoard()[6][1].getCoordinates());
    }
    @Test
    public void checkOneCardAllow(){
        Board board = new Board(4);
        ArrayList<Card> testCards = new ArrayList<Card>();
        Card test1 = new Card("Green" , new Position(3,7));
        testCards.add(test1);
        assertEquals(true , board.allow(testCards));
    }
    @Test
    public void allowWithMoreThanThreeCardsReturnFalse(){
        Board board = new Board(4);
        ArrayList<Card> testCards = new ArrayList<Card>();
        Card test1 = new Card("Green" , new Position(3,7));
        Card test2 = new Card("Green" , new Position(3,6));
        Card test3 = new Card("Green" , new Position(3,4));
        Card test4 = new Card("Green" , new Position(3,8));
        testCards.add(test1);
        testCards.add(test2);
        testCards.add(test3);
        testCards.add(test4);
        assertEquals(false , board.allow(testCards));
    }

    @Test
    public void AllowReturnFalseWithSameCard(){
        Board board = new Board(4);
        ArrayList<Card> testCards = new ArrayList<Card>();
        Card test1 = new Card("Green" , new Position(3,7));
        Card test2 = new Card("Green" , new Position(3,7));
        testCards.add(test1);
        testCards.add(test2);
        assertEquals(false , board.allow(testCards));
    }
    @Test
    public void AllowReturnFalseWithNotAdjacentCards(){
        Board board = new Board(4);
        ArrayList<Card> testCards = new ArrayList<Card>();
        Card test1 = new Card("Green" , new Position(3,7));
        Card test2 = new Card("Green" , new Position(6,7));
        testCards.add(test1);
        testCards.add(test2);
        assertEquals(false , board.allow(testCards));
    }
    @Test
    public void checkNumberOfCardsFilled(){
        Board board = new Board(2);
        assertEquals(29 , board.getFreeposition());
    }
    @Test
    public void checkIfCardIsNull(){
        Board board = new Board(2);
        board.fill();
        assertEquals("" , board.getBoard()[3][0].getColour());

    }
    @Test
    public void checkIfCardIsNull2(){
        Board board = new Board(2);
        board.fill();
        assertEquals("" , board.getBoard()[3][8].getColour());

    }
    @Test
    public void checkIfCardIsNotNull(){
        Board board = new Board(2);
        board.fill();
        assertNotEquals("" , board.getBoard()[3][3].getColour());

    }
    @Test
    public void checkIfCardIsNotNull2(){
        Board board = new Board(3);
        board.fill();
        assertNotEquals("" , board.getBoard()[3][8].getColour());

    }
    @Test
    public void checkIfCardIsNotNull3(){
        Board board = new Board(4);
        board.fill();
        assertNotEquals("" , board.getBoard()[3][1].getColour());

    }
}