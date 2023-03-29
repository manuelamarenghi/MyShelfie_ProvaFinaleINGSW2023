package it.polimi.ingsw;

import it.polimi.ingsw.CommonGoalCard.EightEqualsCards;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EightEqualsCardsTest {
    private CommonGoalCards eightEC=new EightEqualsCards();
    @Test
    void checkIfClassWorksProperlyBlue(){
        Library library = new Library();
        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(4, 2).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");
        library.getCardinPos(1, 2).setColour("blue");
        library.getCardinPos(5, 1).setColour("blue");
        library.getCardinPos(3, 0).setColour("blue");
        library.getCardinPos(4, 0).setColour("blue");
        assertTrue(eightEC.check(library));
    }
    @Test
    void checkIfClassWorksProperlyRed(){
        Library library = new Library();
        library.getCardinPos(5, 2).setColour("red");
        library.getCardinPos(4, 2).setColour("red");
        library.getCardinPos(3, 2).setColour("red");
        library.getCardinPos(2, 2).setColour("red");
        library.getCardinPos(1, 2).setColour("red");
        library.getCardinPos(5, 1).setColour("red");
        library.getCardinPos(3, 0).setColour("red");
        library.getCardinPos(4, 0).setColour("red");
        assertTrue(eightEC.check(library));
    }
    @Test
    void checkIfClassWorksProperlyLightBlue(){
        Library library = new Library();
        library.getCardinPos(5, 2).setColour("lightBlue");
        library.getCardinPos(4, 2).setColour("lightBlue");
        library.getCardinPos(3, 2).setColour("lightBlue");
        library.getCardinPos(2, 2).setColour("lightBlue");
        library.getCardinPos(1, 2).setColour("lightBlue");
        library.getCardinPos(5, 1).setColour("lightBlue");
        library.getCardinPos(3, 0).setColour("lightBlue");
        library.getCardinPos(4, 0).setColour("lightBlue");
        assertTrue(eightEC.check(library));
    }
    @Test
    void checkIfClassWorksProperlyYellow(){
        Library library = new Library();
        library.getCardinPos(5, 2).setColour("yellow");
        library.getCardinPos(4, 2).setColour("yellow");
        library.getCardinPos(3, 2).setColour("yellow");
        library.getCardinPos(2, 2).setColour("yellow");
        library.getCardinPos(1, 2).setColour("yellow");
        library.getCardinPos(5, 1).setColour("yellow");
        library.getCardinPos(3, 0).setColour("yellow");
        library.getCardinPos(4, 0).setColour("yellow");
        assertTrue(eightEC.check(library));
    }
    @Test
    void checkIfClassWorksProperlyPink(){
        Library library = new Library();
        library.getCardinPos(5, 2).setColour("pink");
        library.getCardinPos(4, 2).setColour("pink");
        library.getCardinPos(3, 2).setColour("pink");
        library.getCardinPos(2, 2).setColour("pink");
        library.getCardinPos(1, 2).setColour("pink");
        library.getCardinPos(5, 1).setColour("pink");
        library.getCardinPos(3, 0).setColour("pink");
        library.getCardinPos(4, 0).setColour("pink");
        assertTrue(eightEC.check(library));
    }
    @Test
    void checkIfClassWorksProperlyWhite(){
        Library library = new Library();
        library.getCardinPos(5, 2).setColour("white");
        library.getCardinPos(4, 2).setColour("white");
        library.getCardinPos(3, 2).setColour("white");
        library.getCardinPos(2, 2).setColour("white");
        library.getCardinPos(1, 2).setColour("white");
        library.getCardinPos(5, 1).setColour("white");
        library.getCardinPos(3, 0).setColour("white");
        library.getCardinPos(4, 0).setColour("white");
        assertTrue(eightEC.check(library));
    }
    @Test
    void checkIfClassWorksProperlyEmpty(){
        Library library = new Library();
        assertFalse(eightEC.check(library));
    }
    @Test
    void checkIfExpired(){
        Player player=new Player();
        assertFalse(eightEC.expired(player));
    }
}