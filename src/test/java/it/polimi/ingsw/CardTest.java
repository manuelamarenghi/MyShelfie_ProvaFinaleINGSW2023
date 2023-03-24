package it.polimi.ingsw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest{
    @Test
    public void getColorReturnsGreen(){
        Card testcard = new Card("Green");
        testcard.setCoordinates(new Position(2,4));
        assertEquals("Green" , testcard.getColour());
    }
    @Test
    public void getPositionReturnsCoordinates(){
        Card testcard = new Card("Green");
        testcard.setCoordinates(new Position(2,4));
        assertEquals(2 , testcard.getCoordinates().getX());
        assertEquals(4, testcard.getCoordinates().getY());
    }



}