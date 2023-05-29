
package it.polimi.ingsw.modello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void checkZeroZeroHasCoordinatesNullTest(){
        Board board = new Board(4);
        assertEquals(null , board.getBoard()[0][0].getCoordinates());
    }
    @Test
    public void checkOneTwoHasCoordinatesNullTest(){
        Board board = new Board(4);
        assertEquals(null ,board.getBoard()[1][2].getCoordinates());
    }
    @Test
    public void checkSixOneHasCoordinatesNullTest(){
        Board board = new Board(4);
        assertEquals(null ,board.getBoard()[6][1].getCoordinates());
    }
    @Test
    public void checkOneCardAllowTest(){
        Board board = new Board(4);
        ArrayList<Card> testCards = new ArrayList<Card>();
        Card test1 = new Card("Green" , new Position(3,7));
        testCards.add(test1);
        assertEquals(true , board.allow(testCards));
    }
    @Test
    public void allowWithMoreThanThreeCardsReturnFalseTest(){
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
    public void AllowReturnFalseWithSameCardTest(){
        Board board = new Board(4);
        ArrayList<Card> testCards = new ArrayList<Card>();
        Card test1 = new Card("Green" , new Position(3,7));
        Card test2 = new Card("Green" , new Position(3,7));
        testCards.add(test1);
        testCards.add(test2);
        assertEquals(false , board.allow(testCards));
    }
    @Test
    public void AllowReturnFalseWithNotAdjacentCardsTest(){
        Board board = new Board(4);
        ArrayList<Card> testCards = new ArrayList<Card>();
        Card test1 = new Card("Green" , new Position(3,7));
        Card test2 = new Card("Green" , new Position(6,7));
        testCards.add(test1);
        testCards.add(test2);
        assertEquals(false , board.allow(testCards));
    }
    @Test
    public void checkNumberOfCardsFilledTest(){
        Board board = new Board(2);
        assertEquals(29 , board.getFreeposition());
    }
    @Test
    public void checkIfCardIsNullTest(){
        Board board = new Board(2);
        board.fill(2);
        assertEquals("" , board.getBoard()[3][0].getColour());

    }
    @Test
    public void checkIfCardIsNotNullTest(){
        Board board = new Board(2);
        board.fill(0);
        assertNotEquals("" , board.getBoard()[3][3].getColour());

    }
    @Test
    public void checkIfCardIsNotNull2Test(){
        Board board = new Board(3);
        board.fill(2);
        assertEquals("" , board.getBoard()[3][8].getColour());

    }
    @Test
    public void checkIfCardIsNotNull3Test(){
        Board board = new Board(4);
        board.fill(3);
        assertNotEquals("" , board.getBoard()[3][1].getColour());

    }
    /*
     * showBoard() we test the board in 4 players version
     */
    @Test
    public void showBoardTest(){
        Board b=new Board(4);
        b.fill(0);
        b.showBoard();
    }
    @Test
    public void showBoardtest2Test(){
        Board b = new Board(2);
        b.fill(0);
        System.out.println(b.getBoard()[4][7].getColour());
        b.showBoard();
    }
    @Test
    public void groupTest(){
        Board board= new Board(2);
        board.setCard("V",new Position(1,3));
        board.setCard("R",new Position(2,4));

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        Assertions.assertEquals(expected,board.Group());
    }

    @Test
    public void groupTest2(){
        Board board= new Board(2);
        board.setCard("V",new Position(1,3));
        board.setCard("R",new Position(2,3));
        board.setCard("R",new Position(2,4));

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        Assertions.assertEquals(expected,board.Group());
    }

    @Test
    public void groupTest3(){
        Board board= new Board(2);
        board.setCard("V",new Position(1,3));
        board.setCard("R",new Position(2,3));
        board.setCard("R",new Position(2,4));

        board.setCard("T",new Position(5,2));
        board.setCard("F",new Position(5,3));

        board.setCard("G",new Position(7,4));

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(2);
        expected.add(1);
        Assertions.assertEquals(expected,board.Group());
    }

    @Test
    public void takeCardTest() {

        Board board = new Board(2);
        board.fill(0);

        board.takeCard(new Position(3, 3));
        System.out.println(board.getCard(3, 3).getColour());
    }

    @Test
    public void chechAllowReturnTrue() {
        Board board = new Board(4);
        board.fill(0);
        Card card1, card2, card3;
        ArrayList<Card> cards = new ArrayList<Card>();
        card1 = board.getCard(7, 3);
        card2 = board.getCard(7, 4);
        card3 = board.getCard(7, 5);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        assertFalse(board.allow(cards));
    }

    @Test
    public void checkTakeCard() {
        Board b = new Board(2);
        Position p = new Position(1, 3);
        b.fill(0);
        b.takeCard(p);
        assertEquals(b.getCard(1, 3).getColour(), "");
    }

    @Test
    public void checkAllow() {
        Board b = new Board(4);
        ArrayList<Card> testCards = new ArrayList<Card>();
        Card test1 = new Card("Green", new Position(0, 3));
        Card test2 = new Card("Green", new Position(0, 4));
        testCards.add(test1);
        testCards.add(test2);
        assertTrue(b.allow(testCards));
    }

    @Test
    public void checkAllow2() {
        Board board = new Board(4);
        board.fill(0);
        Card card1, card2, card3;
        ArrayList<Card> cards = new ArrayList<Card>();
        card1 = board.getCard(5, 1);
        card2 = board.getCard(4, 2);
        cards.add(card1);
        cards.add(card2);
        assertFalse(board.allow(cards));
    }

    @Test
    public void checkAllow3() {
        Board b = new Board(4);
        ArrayList<Card> testCards = new ArrayList<Card>();
        Card test1 = new Card("Green", new Position(4, 2));
        Card test2 = new Card("Green", new Position(5, 1));
        testCards.add(test1);
        testCards.add(test2);
        assertFalse(b.allow(testCards));
    }

    @Test
    public void checkAllow4() {
        Board board = new Board(4);
        board.fill(0);
        Card card1, card2, card3;
        ArrayList<Card> cards = new ArrayList<Card>();
        card1 = board.getCard(4, 6);
        card2 = board.getCard(4, 7);
        card3 = board.getCard(3, 8);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        assertFalse(board.allow(cards));
    }

    @Test
    public void checkAllow5() {
        Board board = new Board(2);
        board.fill(0);
        Card card1, card2, card3, card4, card5;
        ArrayList<Card> cards = new ArrayList<Card>();
        card1 = board.getCard(5, 2);
        card2 = board.getCard(6, 3);
        card3 = board.getCard(6, 4);
        //card4 = board.getCard(7,4);
        //card5 = board.getCard(7,5);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        board.takeCard(new Position(7, 4));
        board.takeCard(new Position(7, 5));
        assertFalse(board.allow(cards));
    }

    @Test
    public void checkAllow6() {
        Board board = new Board(2);
        board.fill(0);
        Card card1, card2, card3, card4, card5;
        ArrayList<Card> cards = new ArrayList<Card>();
        card1 = board.getCard(6, 3);
        card2 = board.getCard(6, 4);
        card3 = board.getCard(6, 5);
        //card4 = board.getCard(7,4);
        //card5 = board.getCard(7,5);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        board.takeCard(new Position(7, 4));
        board.takeCard(new Position(7, 5));
        assertTrue(board.allow(cards));
    }


}