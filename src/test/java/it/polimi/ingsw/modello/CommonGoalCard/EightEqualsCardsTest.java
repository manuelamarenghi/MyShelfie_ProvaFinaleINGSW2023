package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertTrue(eightEC.check(library));
    }
    @Test
    void checkIfClassWorksProperlyRed(){
        Library library = new Library();
        library.getCardinPos(5, 2).setColour("green");
        library.getCardinPos(4, 2).setColour("green");
        library.getCardinPos(3, 2).setColour("green");
        library.getCardinPos(2, 2).setColour("green");
        library.getCardinPos(1, 2).setColour("green");
        library.getCardinPos(5, 1).setColour("green");
        library.getCardinPos(3, 0).setColour("green");
        library.getCardinPos(4, 0).setColour("green");
        Assertions.assertTrue(eightEC.check(library));
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
        Assertions.assertTrue(eightEC.check(library));
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
        Assertions.assertTrue(eightEC.check(library));
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
        Assertions.assertTrue(eightEC.check(library));
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
        Assertions.assertTrue(eightEC.check(library));
    }

    @Test
    void checkIfClassWorksProperlyEmpty() {
        Library library = new Library();
        Assertions.assertFalse(eightEC.check(library));
    }

    @Test
    public void checkShow() {
        eightEC.showCommonCard();
        System.out.println(eightEC.getDesc());
    }
}