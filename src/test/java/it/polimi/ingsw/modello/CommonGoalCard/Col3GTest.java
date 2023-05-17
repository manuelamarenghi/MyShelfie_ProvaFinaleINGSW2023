package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Col3GTest {
    private Col3G col3G=new Col3G();
    @Test
    public void checkIfCheckReturnTrue() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(1, 0).setColour("yellow");
        l.getCardinPos(2, 0).setColour("blue");
        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(4, 0).setColour("blue");
        l.getCardinPos(5, 0).setColour("green");

        l.getCardinPos(0, 2).setColour("green");
        l.getCardinPos(1, 2).setColour("white");
        l.getCardinPos(2, 2).setColour("white");
        l.getCardinPos(3, 2).setColour("white");
        l.getCardinPos(4, 2).setColour("green");
        l.getCardinPos(5, 2).setColour("green");

        l.getCardinPos(0, 4).setColour("green");
        l.getCardinPos(1, 4).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");
        l.getCardinPos(3, 4).setColour("lightBlue");
        l.getCardinPos(4, 4).setColour("lightBlue");
        l.getCardinPos(5, 4).setColour("green");
        assertTrue(col3G.check(l));
    }
    @Test
    public void checkIfCheckReturnFalse() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(1, 0).setColour("yellow");
        l.getCardinPos(2, 0).setColour("blue");
        l.getCardinPos(3, 0).setColour("white");
        l.getCardinPos(4, 0).setColour("blue");
        l.getCardinPos(5, 0).setColour("green");

        l.getCardinPos(0, 2).setColour("green");
        l.getCardinPos(1, 2).setColour("white");
        l.getCardinPos(2, 2).setColour("white");
        l.getCardinPos(3, 2).setColour("white");
        l.getCardinPos(4, 2).setColour("green");
        l.getCardinPos(5, 2).setColour("green");

        l.getCardinPos(0, 4).setColour("green");
        l.getCardinPos(1, 4).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");
        l.getCardinPos(3, 4).setColour("lightBlue");
        l.getCardinPos(4, 4).setColour("lightBlue");
        l.getCardinPos(5, 4).setColour("green");

        assertFalse(col3G.check(l));
    }

    @Test
    public void checkIfCheckReturnFalse2() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(1, 0).setColour("yellow");
        l.getCardinPos(2, 0).setColour("blue");
        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(4, 0).setColour("blue");
        l.getCardinPos(5, 0).setColour("white");

        l.getCardinPos(0, 2).setColour("green");
        l.getCardinPos(1, 2).setColour("white");
        l.getCardinPos(2, 2).setColour("white");
        l.getCardinPos(3, 2).setColour("white");
        l.getCardinPos(4, 2).setColour("green");
        l.getCardinPos(5, 2).setColour("green");

        l.getCardinPos(0, 4).setColour("green");
        l.getCardinPos(1, 4).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");
        l.getCardinPos(3, 4).setColour("lightBlue");
        l.getCardinPos(4, 4).setColour("lightBlue");
        l.getCardinPos(5, 4).setColour("lightBlue");

        assertFalse(col3G.check(l));
    }
    @Test
    public void checkIfExpiredReturnsTrue() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(1, 0).setColour("yellow");
        l.getCardinPos(2, 0).setColour("blue");
        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(4, 0).setColour("blue");
        l.getCardinPos(5, 0).setColour("lightBlue");

        l.getCardinPos(0, 2).setColour("green");
        l.getCardinPos(1, 2).setColour("white");
        l.getCardinPos(2, 2).setColour("white");
        l.getCardinPos(3, 2).setColour("blue");
        l.getCardinPos(4, 2).setColour("pink");
        l.getCardinPos(5, 2).setColour("green");

        l.getCardinPos(0, 4).setColour("green");
        l.getCardinPos(1, 4).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");
        l.getCardinPos(3, 4).setColour("pink");
        l.getCardinPos(4, 4).setColour("lightBlue");
        l.getCardinPos(5, 4).setColour("lightBlue");

        assertTrue(col3G.expired(l));
    }

    @Test
    public void checkIfExpiredReturnsTrue2() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(1, 0).setColour("yellow");
        l.getCardinPos(2, 0).setColour("blue");
        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(4, 0).setColour("blue");
        l.getCardinPos(5, 0).setColour("lightBlue");

        l.getCardinPos(0, 2).setColour("green");
        l.getCardinPos(1, 2).setColour("white");
        l.getCardinPos(2, 2).setColour("yellow");
        l.getCardinPos(3, 2).setColour("pink");

        l.getCardinPos(0, 4).setColour("green");
        l.getCardinPos(1, 4).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");
        l.getCardinPos(3, 4).setColour("pink");
        l.getCardinPos(4, 4).setColour("lightBlue");
        l.getCardinPos(5, 4).setColour("lightBlue");

        assertTrue(col3G.expired(l));
    }
    @Test
    public void checkIfExpiredReturnsFalse() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(1, 0).setColour("yellow");
        l.getCardinPos(2, 0).setColour("blue");
        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(4, 0).setColour("blue");
        l.getCardinPos(5, 0).setColour("lightBlue");


        assertFalse(col3G.expired(l));
    }
}