package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoubleTest {

    private static DoubleCommG doubleCard = new DoubleCommG();

    @Test
    public void DoublieCardNoOK(){
        Library library = new Library();
        library.getCardinPos(5,0).setColour("V");
        library.getCardinPos(4,0).setColour("G");
        library.getCardinPos(3,0).setColour("G");
        library.getCardinPos(5,1).setColour("V");
        library.getCardinPos(4,1).setColour("B");
        library.getCardinPos(3,1).setColour("V");
        library.getCardinPos(5,2).setColour("V");
        library.getCardinPos(4,2).setColour("V");
        library.getCardinPos(5,3).setColour("G");
        library.getCardinPos(4,3).setColour("V");
        library.getCardinPos(3,3).setColour("V");
        library.getCardinPos(3,2).setColour("V");
        library.getCardinPos(1,2).setColour("R");
        library.getCardinPos(5,4).setColour("G");
        assertFalse(doubleCard.check(library));
    }

    @Test
    public void DoublieCardOK(){
        Library library = new Library();
        library.getCardinPos(0,0).setColour("V");
        library.getCardinPos(1,0).setColour("V");
        library.getCardinPos(2,0).setColour("G");
        library.getCardinPos(3,0).setColour("G");
        library.getCardinPos(4,0).setColour("B");
        library.getCardinPos(5,0).setColour("B");
        library.getCardinPos(0,4).setColour("V");
        library.getCardinPos(1,4).setColour("V");
        library.getCardinPos(2,4).setColour("G");
        library.getCardinPos(3,4).setColour("G");
        library.getCardinPos(4,4).setColour("B");
        library.getCardinPos(5,4).setColour("B");
        assertTrue(doubleCard.check(library));
    }

}
