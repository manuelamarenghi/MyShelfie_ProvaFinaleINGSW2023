package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Square2GTest {


    private CommonGoalCards square2G = new Square2G();
    @Test
    public void checkIfcheckReturnsTrue(){
        Library l  =new Library();
        l.getCardinPos(0,0).setColour("green");
        l.getCardinPos(0,1).setColour("green");
        l.getCardinPos(1,0).setColour("green");
        l.getCardinPos(1,1).setColour("green");

        l.getCardinPos(2,0).setColour("green");
        l.getCardinPos(2,1).setColour("green");
        l.getCardinPos(3,0).setColour("green");
        l.getCardinPos(3,1).setColour("green");
        l.showLibrary();
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
        l.getCardinPos(0,0).setColour("green");
        l.getCardinPos(0,1).setColour("green");
        l.getCardinPos(1,0).setColour("green");
        l.getCardinPos(1,1).setColour("green");
        assertFalse(square2G.check(l));
    }
    @Test
    public void checkIfcheckReturnsFalse3(){
        Library l  =new Library();
        l.getCardinPos(0,0).setColour("green");
        l.getCardinPos(0,1).setColour("green");
        l.getCardinPos(1,0).setColour("green");
        l.getCardinPos(1,1).setColour("green");

        l.getCardinPos(0,3).setColour("green");
        l.getCardinPos(0,4).setColour("green");
        l.getCardinPos(1,3).setColour("green");
        l.getCardinPos(1,4).setColour("blue");
        assertFalse(square2G.check(l));
    }
}