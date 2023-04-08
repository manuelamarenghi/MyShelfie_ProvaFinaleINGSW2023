package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Col3GTest {
    private Col3G col3G=new Col3G();
    @Test
    public void checkIfCheckReturnTrue(){
        Library l=new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(1,0).setColour("Yellow");
        l.getCardinPos(2,0).setColour("Navy");
        l.getCardinPos(3,0).setColour("Green");
        l.getCardinPos(4,0).setColour("Navy");
        l.getCardinPos(5,0).setColour("Green");

        l.getCardinPos(0,2).setColour("Green");
        l.getCardinPos(1,2).setColour("White");
        l.getCardinPos(2,2).setColour("White");
        l.getCardinPos(3,2).setColour("White");
        l.getCardinPos(4,2).setColour("Green");
        l.getCardinPos(5,2).setColour("Green");

        l.getCardinPos(0,4).setColour("Green");
        l.getCardinPos(1,4).setColour("Navy");
        l.getCardinPos(2,4).setColour("Blue");
        l.getCardinPos(3,4).setColour("Blue");
        l.getCardinPos(4,4).setColour("Blue");
        l.getCardinPos(5,4).setColour("Green");
        assertTrue(col3G.check(l));
    }
    @Test
    public void checkIfCheckReturnFalse(){
        Library l=new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(1,0).setColour("Yellow");
        l.getCardinPos(2,0).setColour("Navy");
        l.getCardinPos(3,0).setColour("White");
        l.getCardinPos(4,0).setColour("Navy");
        l.getCardinPos(5,0).setColour("Green");

        l.getCardinPos(0,2).setColour("Green");
        l.getCardinPos(1,2).setColour("White");
        l.getCardinPos(2,2).setColour("White");
        l.getCardinPos(3,2).setColour("White");
        l.getCardinPos(4,2).setColour("Green");
        l.getCardinPos(5,2).setColour("Green");

        l.getCardinPos(0,4).setColour("Green");
        l.getCardinPos(1,4).setColour("Navy");
        l.getCardinPos(2,4).setColour("Blue");
        l.getCardinPos(3,4).setColour("Blue");
        l.getCardinPos(4,4).setColour("Blue");
        l.getCardinPos(5,4).setColour("Green");

        assertFalse(col3G.check(l));
    }

    @Test
    public void checkIfCheckReturnFalse2(){
        Library l=new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(1,0).setColour("Yellow");
        l.getCardinPos(2,0).setColour("Navy");
        l.getCardinPos(3,0).setColour("Green");
        l.getCardinPos(4,0).setColour("Navy");
        l.getCardinPos(5,0).setColour("White");

        l.getCardinPos(0,2).setColour("Green");
        l.getCardinPos(1,2).setColour("White");
        l.getCardinPos(2,2).setColour("White");
        l.getCardinPos(3,2).setColour("White");
        l.getCardinPos(4,2).setColour("Green");
        l.getCardinPos(5,2).setColour("Green");

        l.getCardinPos(0,4).setColour("Green");
        l.getCardinPos(1,4).setColour("Navy");
        l.getCardinPos(2,4).setColour("Blue");
        l.getCardinPos(3,4).setColour("Blue");
        l.getCardinPos(4,4).setColour("Blue");
        l.getCardinPos(5,4).setColour("Blue");

        assertFalse(col3G.check(l));
    }
    @Test
    public void checkIfExpiredReturnsTrue(){
        Library l=new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(1,0).setColour("Yellow");
        l.getCardinPos(2,0).setColour("Navy");
        l.getCardinPos(3,0).setColour("Green");
        l.getCardinPos(4,0).setColour("Navy");
        l.getCardinPos(5,0).setColour("Blue");

        l.getCardinPos(0,2).setColour("Green");
        l.getCardinPos(1,2).setColour("White");
        l.getCardinPos(2,2).setColour("White");
        l.getCardinPos(3,2).setColour("Navy");
        l.getCardinPos(4,2).setColour("Pink");
        l.getCardinPos(5,2).setColour("Green");

        l.getCardinPos(0,4).setColour("Green");
        l.getCardinPos(1,4).setColour("Navy");
        l.getCardinPos(2,4).setColour("Blue");
        l.getCardinPos(3,4).setColour("Pink");
        l.getCardinPos(4,4).setColour("Blue");
        l.getCardinPos(5,4).setColour("Blue");

        assertTrue(col3G.expired(l));
    }

    @Test
    public void checkIfExpiredReturnsTrue2(){
        Library l=new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(1,0).setColour("Yellow");
        l.getCardinPos(2,0).setColour("Navy");
        l.getCardinPos(3,0).setColour("Green");
        l.getCardinPos(4,0).setColour("Navy");
        l.getCardinPos(5,0).setColour("Blue");

        l.getCardinPos(0,2).setColour("Green");
        l.getCardinPos(1,2).setColour("White");
        l.getCardinPos(2,2).setColour("Yellow");
        l.getCardinPos(3,2).setColour("Pink");

        l.getCardinPos(0,4).setColour("Green");
        l.getCardinPos(1,4).setColour("Navy");
        l.getCardinPos(2,4).setColour("Blue");
        l.getCardinPos(3,4).setColour("Pink");
        l.getCardinPos(4,4).setColour("Blue");
        l.getCardinPos(5,4).setColour("Blue");

        assertTrue(col3G.expired(l));
    }
    @Test
    public void checkIfExpiredReturnsFalse(){
        Library l=new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(1,0).setColour("Yellow");
        l.getCardinPos(2,0).setColour("Navy");
        l.getCardinPos(3,0).setColour("Green");
        l.getCardinPos(4,0).setColour("Navy");
        l.getCardinPos(5,0).setColour("Blue");


        assertFalse(col3G.expired(l));
    }
}