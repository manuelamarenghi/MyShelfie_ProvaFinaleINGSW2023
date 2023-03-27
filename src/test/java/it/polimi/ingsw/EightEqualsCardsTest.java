package it.polimi.ingsw;

import it.polimi.ingsw.CommonGoalCard.EightEqualsCards;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EightEqualsCardsTest {
    private CommonGoalCards eightEC=new EightEqualsCards();
    @Test
    void checkIfClassWorksProperly(){
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
}