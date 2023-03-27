package it.polimi.ingsw;

import it.polimi.ingsw.CommonGoalCard.StairsGoalCard;
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


        library.getCardinPos(3, 0).setColour("blue");
        library.getCardinPos(3, 1).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");

        library.getCardinPos(2, 0).setColour("blue");
        library.getCardinPos(2, 1).setColour("blue");

        library.getCardinPos(1, 0).setColour("blue");
        library.showLibrary();

        assertTrue(stair.check(library));


    }
    @Test
    void checkShiftedSxStair(){
        Library library = new Library();
        //first column
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(4, 0).setColour("blue");
        library.getCardinPos(3, 0).setColour("blue");
        library.getCardinPos(2, 0).setColour("blue");
        library.getCardinPos(1, 0).setColour("blue");
        library.getCardinPos(0, 0).setColour("blue");
        //second column
        library.getCardinPos(5, 1).setColour("blue");
        library.getCardinPos(4, 1).setColour("blue");
        library.getCardinPos(3, 1).setColour("blue");
        library.getCardinPos(2, 1).setColour("blue");
        library.getCardinPos(1, 1).setColour("blue");


        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(4, 2).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");

        library.getCardinPos(5, 3).setColour("blue");
        library.getCardinPos(4, 3).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");

        library.getCardinPos(5, 4).setColour("blue");
        library.getCardinPos(4, 4).setColour("blue");

        assertTrue(stair.check(library));

    }

}