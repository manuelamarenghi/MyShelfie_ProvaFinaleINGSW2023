package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.CommonGoalCards;
import it.polimi.ingsw.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Square2GTest {


    private CommonGoalCards square2G = new Square2G();
    @Test
    public void checkIfcheckReturnsTrue(){
        Library l  =new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(0,1).setColour("Green");
        l.getCardinPos(1,0).setColour("Green");
        l.getCardinPos(1,1).setColour("Green");

        l.getCardinPos(2,0).setColour("Green");
        l.getCardinPos(2,1).setColour("Green");
        l.getCardinPos(3,0).setColour("Green");
        l.getCardinPos(3,1).setColour("Green");
        assertTrue(square2G.check(l));

    }
    @Test
    public void checkIfcheckReturnsFalse(){
        Library l  =new Library();
        assertFalse(square2G.check(l));

    }
    @Test
    public void checkIfcheckReturnsFalse2(){
        Library l  =new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(0,1).setColour("Green");
        l.getCardinPos(1,0).setColour("Green");
        l.getCardinPos(1,1).setColour("Green");
        assertFalse(square2G.check(l));
    }
    @Test
    public void checkIfcheckReturnsFalse3(){
        Library l  =new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(0,1).setColour("Green");
        l.getCardinPos(1,0).setColour("Green");
        l.getCardinPos(1,1).setColour("Green");

        l.getCardinPos(0,3).setColour("Green");
        l.getCardinPos(0,4).setColour("Green");
        l.getCardinPos(1,3).setColour("Green");
        l.getCardinPos(1,4).setColour("Blue");
        assertFalse(square2G.check(l));
    }
}