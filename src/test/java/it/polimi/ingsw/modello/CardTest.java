package it.polimi.ingsw.modello;

import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest{
    @Test
    public void getColorReturnsGreen(){
        Card testcard = new Card("Green" , new Position(2,4));
        assertEquals("Green" , testcard.getColour());
    }
    @Test
    public void getPositionReturnsCoordinates(){
        Card testcard = new Card("Green" , new Position(2,4));
        assertEquals(2 , testcard.getCoordinates().getX());
        assertEquals(4, testcard.getCoordinates().getY());
    }



}