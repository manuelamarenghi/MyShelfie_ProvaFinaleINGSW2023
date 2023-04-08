package it.polimi.ingsw.modello.CommonGoalCard;


import it.polimi.ingsw.modello.CommonGoalCard.CommonGoalCard.CornersCommG;
import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CornersCommTest {

    private CornersCommG corners=new CornersCommG();

    @Test
    public void checkBingo(){
        Library library = new Library();
        library.getCardinPos(0, 0).setColour("blue");
        library.getCardinPos(0, 4).setColour("blue");
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        assertTrue(corners.check(library));
    }

    @Test
    public void checkNoBingo(){
        Library library = new Library();
        library.getCardinPos(0, 0).setColour("red");
        library.getCardinPos(0, 4).setColour("blue");
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        assertFalse(corners.check(library));
    }

    @Test
    public void checkNoFourCard(){
        Library library = new Library();
        library.getCardinPos(0, 0).setColour("red");
        library.getCardinPos(0, 4).setColour("blue");
        library.getCardinPos(5, 0).setColour("blue");
        assertFalse(corners.check(library));
    }

    @Test
    public void expiredTrue(){
        Library library = new Library();
        library.getCardinPos(0, 0).setColour("red");
        library.getCardinPos(0, 4).setColour("blue");
        assertTrue(corners.expired(library));
    }

    @Test
    public void expiredFalse(){
        Library library = new Library();
        library.getCardinPos(5, 0).setColour("red");
        library.getCardinPos(5, 4).setColour("red");
        assertFalse(corners.expired(library));
    }
}
