package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCard.CommonGoalCard.XGoalCard;
import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XGoalCardTest {
    private CommonGoalCards xcard=new XGoalCard();
    @Test
        void checkIfItShouldWork(){
        for(int i=0;i<3;i++){
            for(int j=5;j>1;j--){
                Library library=new Library();
                library.getCardinPos(j,i).setColour("blue");
                library.getCardinPos(j-1,i+1).setColour("blue");
                library.getCardinPos(j-2,i+2).setColour("blue");
                library.getCardinPos(j,i+2).setColour("blue");
                library.getCardinPos(j-2,i).setColour("blue");
                if(!xcard.check(library)) fail();
            }
        }
        assertTrue(true);
        }
    @Test
    void checkIfItShouldNtWork(){

        for(int i=0;i<3;i++){
            for(int j=5;j>1;j--){
                Library library=new Library();
                library.getCardinPos(j,i).setColour("blue");
                library.getCardinPos(j-1,i+1).setColour("red");
                library.getCardinPos(j-2,i+2).setColour("pink");
                library.getCardinPos(j,i+2).setColour("white");
                library.getCardinPos(j-2,i).setColour("yellow");
                if(xcard.check(library)) fail();
            }
        }
        assertTrue(true);
    }
    @Test
    void checkIfExpired(){
        Library library = new Library();
        assertFalse(xcard.expired(library));
    }
    }

