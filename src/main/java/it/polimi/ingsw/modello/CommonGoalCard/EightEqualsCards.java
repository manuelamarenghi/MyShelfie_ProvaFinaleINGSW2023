package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class EightEqualsCards implements CommonGoalCards, Serializable {
    private final int DIMENSION=8;
    @Override
    public boolean check(Library library) {
        int indexRed = 0;
         int indexBlue=0;
         int indexWhite=0;
         int indexYellow=0;
         int indexPink=0;
         int indexLightBLue=0;
        for(Card card:library){
            if(card.getColour().equals("blue"))indexBlue++;
            if(card.getColour().equals("red"))indexRed++;
            if(card.getColour().equals("yellow"))indexYellow++;
            if(card.getColour().equals("lightBlue"))indexLightBLue++;
            if(card.getColour().equals("white"))indexWhite++;
            if(card.getColour().equals("pink"))indexPink++;
        }
        return indexPink >= DIMENSION ||
                indexBlue >= DIMENSION ||
                indexYellow >= DIMENSION ||
                indexLightBLue >= DIMENSION ||
                indexRed >= DIMENSION ||
                indexWhite >= DIMENSION;
    }

    @Override
    public boolean expired(Library library) {
        //in this particular CommonGoalCard, using the expired method bring more difficulties than not using it
        //to prove the impossibility of completing the task I would have to control tons of cases and to verify all one at a time
        return false;
    }

    @Override
    public void getImage() {
    //it's better to insert here the path of the image we're going to display on the GUI
    }
}
