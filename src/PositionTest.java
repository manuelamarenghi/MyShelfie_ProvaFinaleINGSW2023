package src;

import org.junit.Test;
import src.Position;

import static org.junit.Assert.assertEquals;

class PositionTest {
    @Test
    public void xCoordinateReturnValue(){
        Position testCoordinate = new Position (2,4);
        assertEquals(2 , testCoordinate.getX());
    }

    public void yCoordinateReturnValue(){
        Position testCoordinate = new Position (2,4);
        assertEquals(4 , testCoordinate.getY());
    }
}