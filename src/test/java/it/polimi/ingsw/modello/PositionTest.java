package it.polimi.ingsw.modello;

import it.polimi.ingsw.modello.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    public void xCoordinateReturnValue(){
        Position testCoordinate = new Position (2,4);
        assertEquals(2 , testCoordinate.getX());
    }
    @Test
    public void yCoordinateReturnValue(){
        Position testCoordinate = new Position (2,4);
        assertEquals(4 , testCoordinate.getY());
    }

}