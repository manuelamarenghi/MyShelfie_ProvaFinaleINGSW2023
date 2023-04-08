package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.modello.CommonGoalCard.CommonGoalCard.Line2G;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Line2GTest {

    private CommonGoalCards line2G = new Line2G();
    @Test
    public void checkIfCheckReturnsTrue(){
        Library l = new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(0,1).setColour("Yellow");
        l.getCardinPos(0,2).setColour("White");
        l.getCardinPos(0,3).setColour("Navy");
        l.getCardinPos(0,4).setColour("Blue");

        l.getCardinPos(2,0).setColour("Green");
        l.getCardinPos(2,1).setColour("Yellow");
        l.getCardinPos(2,2).setColour("White");
        l.getCardinPos(2,3).setColour("Navy");
        l.getCardinPos(2,4).setColour("Blue");
        assertTrue(line2G.check(l));

    }
    @Test
    public void checkIfCheckReturnsFalse(){
        Library l = new Library();

        assertFalse(line2G.check(l));

    }
    @Test
    public void checkIfCheckReturnsFalse2(){
        Library l = new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(0,1).setColour("Yellow");
        l.getCardinPos(0,2).setColour("White");
        l.getCardinPos(0,3).setColour("Navy");
        l.getCardinPos(0,4).setColour("Navy");

        l.getCardinPos(2,0).setColour("Green");
        l.getCardinPos(2,1).setColour("Yellow");
        l.getCardinPos(2,2).setColour("White");
        l.getCardinPos(2,3).setColour("Navy");
        l.getCardinPos(2,4).setColour("Blue");
        assertFalse(line2G.check(l));

    }

    @Test
    public void checkIfExpiredReturnsTrue(){
        Library l = new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(0,1).setColour("Yellow");
        l.getCardinPos(0,2).setColour("White");
        l.getCardinPos(0,3).setColour("Navy");
        l.getCardinPos(0,4).setColour("Navy");

        l.getCardinPos(2,0).setColour("Green");
        l.getCardinPos(2,1).setColour("Yellow");
        l.getCardinPos(2,2).setColour("Blue");
        l.getCardinPos(2,3).setColour("Navy");
        l.getCardinPos(2,4).setColour("Blue");

        l.getCardinPos(3,0).setColour("Green");
        l.getCardinPos(3,1).setColour("Yellow");
        l.getCardinPos(3,2).setColour("Yellow");
        l.getCardinPos(3,3).setColour("Navy");
        l.getCardinPos(3,4).setColour("Blue");

        l.getCardinPos(4,0).setColour("Green");
        l.getCardinPos(4,1).setColour("Yellow");
        l.getCardinPos(4,2).setColour("White");
        l.getCardinPos(4,3).setColour("Blue");
        l.getCardinPos(4,4).setColour("Blue");

        l.getCardinPos(5,0).setColour("Green");
        l.getCardinPos(5,1).setColour("Yellow");
        l.getCardinPos(5,2).setColour("Green");
        l.getCardinPos(5,3).setColour("Navy");
        l.getCardinPos(5,4).setColour("Blue");
        assertTrue(line2G.expired(l));

    }
    @Test
    public void checkIfExpiredReturnsFalse(){
        Library l = new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(0,1).setColour("Yellow");
        l.getCardinPos(0,2).setColour("White");
        l.getCardinPos(0,3).setColour("Navy");
        l.getCardinPos(0,4).setColour("Navy");

        l.getCardinPos(2,0).setColour("Green");
        l.getCardinPos(2,1).setColour("Yellow");
        l.getCardinPos(2,2).setColour("Blue");
        l.getCardinPos(2,3).setColour("Navy");
        l.getCardinPos(2,4).setColour("Blue");

        l.getCardinPos(3,0).setColour("Green");
        l.getCardinPos(3,1).setColour("Yellow");
        l.getCardinPos(3,2).setColour("Yellow");
        l.getCardinPos(3,3).setColour("Navy");
        l.getCardinPos(3,4).setColour("Blue");

        l.getCardinPos(4,0).setColour("Green");
        l.getCardinPos(4,1).setColour("Yellow");
        l.getCardinPos(4,2).setColour("White");
        l.getCardinPos(4,3).setColour("Blue");
        l.getCardinPos(4,4).setColour("Navy");
        assertFalse(line2G.expired(l));

    }
}