package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Line2GTest {

    private CommonGoalCards line2G = new Line2G();
    @Test
    public void checkIfCheckReturnsTrue() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(0, 1).setColour("yellow");
        l.getCardinPos(0, 2).setColour("white");
        l.getCardinPos(0, 3).setColour("blue");
        l.getCardinPos(0, 4).setColour("lightBlue");

        l.getCardinPos(2, 0).setColour("green");
        l.getCardinPos(2, 1).setColour("yellow");
        l.getCardinPos(2, 2).setColour("white");
        l.getCardinPos(2, 3).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");
        assertTrue(line2G.check(l));

    }
    @Test
    public void checkIfCheckReturnsFalse(){
        Library l = new Library();

        assertFalse(line2G.check(l));

    }
    @Test
    public void checkIfCheckReturnsFalse2() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(0, 1).setColour("yellow");
        l.getCardinPos(0, 2).setColour("white");
        l.getCardinPos(0, 3).setColour("blue");
        l.getCardinPos(0, 4).setColour("blue");

        l.getCardinPos(2, 0).setColour("green");
        l.getCardinPos(2, 1).setColour("yellow");
        l.getCardinPos(2, 2).setColour("white");
        l.getCardinPos(2, 3).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");
        assertFalse(line2G.check(l));

    }

    @Test
    public void checkIfExpiredReturnsTrue() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(0, 1).setColour("yellow");
        l.getCardinPos(0, 2).setColour("white");
        l.getCardinPos(0, 3).setColour("blue");
        l.getCardinPos(0, 4).setColour("blue");

        l.getCardinPos(2, 0).setColour("green");
        l.getCardinPos(2, 1).setColour("yellow");
        l.getCardinPos(2, 2).setColour("lightBlue");
        l.getCardinPos(2, 3).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");

        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(3, 1).setColour("yellow");
        l.getCardinPos(3, 2).setColour("yellow");
        l.getCardinPos(3, 3).setColour("blue");
        l.getCardinPos(3, 4).setColour("lightBlue");

        l.getCardinPos(4, 0).setColour("green");
        l.getCardinPos(4, 1).setColour("yellow");
        l.getCardinPos(4, 2).setColour("white");
        l.getCardinPos(4, 3).setColour("lightBlue");
        l.getCardinPos(4, 4).setColour("lightBlue");

        l.getCardinPos(5, 0).setColour("green");
        l.getCardinPos(5, 1).setColour("yellow");
        l.getCardinPos(5, 2).setColour("green");
        l.getCardinPos(5, 3).setColour("blue");
        l.getCardinPos(5, 4).setColour("lightBlue");
        assertTrue(line2G.expired(l));

    }
    @Test
    public void checkIfExpiredReturnsFalse() {
        Library l = new Library();
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(0, 1).setColour("yellow");
        l.getCardinPos(0, 2).setColour("white");
        l.getCardinPos(0, 3).setColour("blue");
        l.getCardinPos(0, 4).setColour("blue");

        l.getCardinPos(2, 0).setColour("green");
        l.getCardinPos(2, 1).setColour("yellow");
        l.getCardinPos(2, 2).setColour("lightBlue");
        l.getCardinPos(2, 3).setColour("blue");
        l.getCardinPos(2, 4).setColour("lightBlue");

        l.getCardinPos(3, 0).setColour("green");
        l.getCardinPos(3, 1).setColour("yellow");
        l.getCardinPos(3, 2).setColour("yellow");
        l.getCardinPos(3, 3).setColour("blue");
        l.getCardinPos(3, 4).setColour("lightBlue");

        l.getCardinPos(4, 0).setColour("green");
        l.getCardinPos(4, 1).setColour("yellow");
        l.getCardinPos(4, 2).setColour("white");
        l.getCardinPos(4, 3).setColour("lightBlue");
        l.getCardinPos(4, 4).setColour("blue");
        assertFalse(line2G.expired(l));

    }
    @Test
    public void checkShow(){
        line2G.showCommonCard();
        System.out.println(line2G.getDesc());
    }
}