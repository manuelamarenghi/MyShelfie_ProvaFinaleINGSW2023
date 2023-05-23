package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StairsGoalCardTest {
    CommonGoalCards stair=new StairsGoalCard();

    @Test
    void checkSxStair(){
        Library library = new Library();

        //first row
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(5, 1).setColour("blue");
        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(5, 3).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        //second row
        library.getCardinPos(4, 0).setColour("blue");
        library.getCardinPos(4, 1).setColour("blue");
        library.getCardinPos(4, 2).setColour("blue");
        library.getCardinPos(4, 3).setColour("blue");
        //third row
        library.getCardinPos(3, 0).setColour("blue");
        library.getCardinPos(3, 1).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        //fourth row
        library.getCardinPos(2, 0).setColour("blue");
        library.getCardinPos(2, 1).setColour("blue");
        //fifth row
        library.getCardinPos(1, 0).setColour("blue");

        assertTrue(stair.check(library));


    }
    @Test
    void checkShiftedSxStair(){
        Library library = new Library();
        //first row
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(5, 1).setColour("blue");
        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(5, 3).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        //second row
        library.getCardinPos(4, 0).setColour("blue");
        library.getCardinPos(4, 1).setColour("blue");
        library.getCardinPos(4, 2).setColour("blue");
        library.getCardinPos(4, 3).setColour("blue");
        library.getCardinPos(4, 4).setColour("blue");
        //third row
        library.getCardinPos(3, 0).setColour("blue");
        library.getCardinPos(3, 1).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");
        //fourth row
        library.getCardinPos(2, 0).setColour("blue");
        library.getCardinPos(2, 1).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");
        //fifth row
        library.getCardinPos(1, 0).setColour("blue");
        library.getCardinPos(1, 1).setColour("blue");
        //sixth row
        library.getCardinPos(0, 0).setColour("blue");

        assertTrue(stair.check(library));

    }
    @Test
    void checkDxStair(){
        Library library = new Library();

        //first row
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(5, 1).setColour("blue");
        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(5, 3).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        //second row
        library.getCardinPos(4, 4).setColour("blue");
        library.getCardinPos(4, 1).setColour("blue");
        library.getCardinPos(4, 2).setColour("blue");
        library.getCardinPos(4, 3).setColour("blue");
        //third row
        library.getCardinPos(3, 4).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        //fourth row
        library.getCardinPos(2, 4).setColour("blue");
        library.getCardinPos(2, 3).setColour("blue");
        //fifth row
        library.getCardinPos(1, 4).setColour("blue");

        assertTrue(stair.check(library));


    }
    @Test
    void checkShiftedDxStair(){
        Library library = new Library();

        //first row
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(5, 1).setColour("blue");
        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(5, 3).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        //second row
        library.getCardinPos(4, 4).setColour("blue");
        library.getCardinPos(4, 1).setColour("blue");
        library.getCardinPos(4, 2).setColour("blue");
        library.getCardinPos(4, 3).setColour("blue");
        library.getCardinPos(4, 0).setColour("blue");
        //third row
        library.getCardinPos(3, 4).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(3, 1).setColour("blue");

        //fourth row
        library.getCardinPos(2, 4).setColour("blue");
        library.getCardinPos(2, 3).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");

        //fifth row
        library.getCardinPos(1, 4).setColour("blue");
        library.getCardinPos(1, 3).setColour("blue");

        library.getCardinPos(0, 4).setColour("blue");

        assertTrue(stair.check(library));


    }
    @Test
    void checkWrongCase1(){
        Library library = new Library();

        //first row
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(5, 1).setColour("blue");
        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(5, 3).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        //second row
        library.getCardinPos(4, 4).setColour("blue");
        library.getCardinPos(4, 1).setColour("blue");
        library.getCardinPos(4, 2).setColour("blue");
        library.getCardinPos(4, 3).setColour("blue");
        library.getCardinPos(4, 0).setColour("blue");
        //third row
        library.getCardinPos(3, 4).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(3, 1).setColour("blue");
        library.getCardinPos(3, 0).setColour("blue");

        //fourth row
        library.getCardinPos(2, 4).setColour("blue");
        library.getCardinPos(2, 3).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");

        //fifth row
        library.getCardinPos(1, 4).setColour("blue");
        library.getCardinPos(1, 3).setColour("blue");

        library.getCardinPos(0, 4).setColour("blue");

        assertFalse(stair.check(library));


    }
    @Test
    void checkWrongCase2(){
        Library library = new Library();

        //first row
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(5, 1).setColour("blue");
        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(5, 3).setColour("blue");
        library.getCardinPos(5, 4).setColour("blue");
        //third row

        library.getCardinPos(3, 4).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(3, 1).setColour("blue");
        library.getCardinPos(3, 0).setColour("blue");

        //fourth row
        library.getCardinPos(2, 4).setColour("blue");
        library.getCardinPos(2, 3).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");

        //fifth row
        library.getCardinPos(1, 4).setColour("blue");
        library.getCardinPos(1, 3).setColour("blue");

        library.getCardinPos(0, 4).setColour("blue");

        assertFalse(stair.check(library));


    }
    @Test
    void checkIfExpired(){
        Library library = new Library();
        assertFalse(stair.expired(library));
    }
    @Test
    public void checkShow(){
        stair.showCommonCard();
        System.out.println(stair.getDesc());
    }
}
