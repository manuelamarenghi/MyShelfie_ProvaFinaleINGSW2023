package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Diagonal5Test {

    private Diagonal5CardG diagonal=new Diagonal5CardG();

    @Test
    public void sxDiagonalOK(){
        Library library = new Library();
        library.getCardinPos(0, 0).setColour("blue");
        library.getCardinPos(1, 1).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");
        library.getCardinPos(4, 4).setColour("blue");
        library.showLibrary();
        assertTrue(diagonal.check(library));
    }
    @Test
    public void sxDiagonalNoOK(){
        Library library = new Library();
        library.getCardinPos(0, 0).setColour("blue");
        library.getCardinPos(1, 1).setColour("red");
        library.getCardinPos(2, 2).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");
        library.getCardinPos(4, 4).setColour("blue");
        assertFalse(diagonal.check(library));
    }

    @Test
    public void dxDiagonalOK(){
        Library library = new Library();
        library.getCardinPos(0, 4).setColour("blue");
        library.getCardinPos(1, 3).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");
        library.getCardinPos(3, 1).setColour("blue");
        library.getCardinPos(4, 0).setColour("blue");
        assertTrue(diagonal.check(library));
    }
    @Test
    public void dxDiagonalNoOK(){
        Library library = new Library();
        library.getCardinPos(0, 4).setColour("blue");
        library.getCardinPos(1, 3).setColour("blue");
        library.getCardinPos(2, 2).setColour("red");
        library.getCardinPos(3, 1).setColour("blue");
        library.getCardinPos(4, 0).setColour("blue");
        assertFalse(diagonal.check(library));
    }

    @Test
    public void sxDiagonalShiftOK(){
        Library library = new Library();
        library.getCardinPos(1, 0).setColour("blue");
        library.getCardinPos(2, 1).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(4, 3).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        assertTrue(diagonal.check(library));
    }
    @Test
    public void sxDiagonalShiftNoOK(){
        Library library = new Library();
        library.getCardinPos(1, 0).setColour("blue");
        library.getCardinPos(2, 1).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(4, 3).setColour("blue");
        library.getCardinPos(5, 4).setColour("white");
        assertFalse(diagonal.check(library));
    }
    @Test
    public void dxDiagonalShiftOK(){
        Library library = new Library();
        library.getCardinPos(1, 4).setColour("blue");
        library.getCardinPos(2, 3).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(4, 1).setColour("blue");
        library.getCardinPos(5, 0).setColour("blue");
        assertTrue(diagonal.check(library));
    }
    @Test
    public void dxDiagonalShiftNoOK(){
        Library library = new Library();
        library.getCardinPos(0, 4).setColour("blue");
        library.getCardinPos(1, 3).setColour("blue");
        library.getCardinPos(2, 2).setColour("red");
        library.getCardinPos(3, 1).setColour("blue");
        library.getCardinPos(4, 0).setColour("blue");
        assertFalse(diagonal.check(library));
    }
    @Test
    public void sxDiagonalNoCompleta(){
        Library library = new Library();
        library.getCardinPos(0, 0).setColour("blue");
        library.getCardinPos(1, 1).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");
        library.getCardinPos(4, 4).setColour("blue");
        assertFalse(diagonal.check(library));
    }
}

