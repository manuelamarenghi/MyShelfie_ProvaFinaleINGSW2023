package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class EightEqualsCards implements CommonGoalCards, Serializable {
    private final int DIMENSION=8;
    @Override
    public boolean check(Library library) {
        int indexGreen = 0;
        int indexBlue = 0;
         int indexWhite=0;
         int indexYellow=0;
         int indexPink=0;
         int indexLightBLue=0;
        for(Card card:library){
            if (card.getColour().equals("blue")) indexBlue++;
            if (card.getColour().equals("green")) indexGreen++;
            if (card.getColour().equals("yellow")) indexYellow++;
            if(card.getColour().equals("lightBlue"))indexLightBLue++;
            if(card.getColour().equals("white"))indexWhite++;
            if(card.getColour().equals("pink"))indexPink++;
        }
        return indexPink >= DIMENSION ||
                indexBlue >= DIMENSION ||
                indexYellow >= DIMENSION ||
                indexLightBLue >= DIMENSION ||
                indexGreen >= DIMENSION ||
                indexWhite >= DIMENSION;
    }

    @Override
    public boolean expired(Library library) {
        //in this particular CommonGoalCard, using the expired method bring more difficulties than not using it
        //to prove the impossibility of completing the task I would have to control tons of cases and to verify all one at a time
        return false;
    }

    @Override
    public String getDesc() {
        return "Eight tiles of the same type. \n" +
                "There’s no restriction about the position of these tiles.\n";
    }

    @Override
    public void showCommonCard() {

        Library library = new Library();
        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(4, 2).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");
        library.getCardinPos(1, 2).setColour("blue");
        library.getCardinPos(5, 1).setColour("blue");
        library.getCardinPos(3, 0).setColour("blue");
        library.getCardinPos(4, 0).setColour("blue");
        System.out.println("This is an example of a library that respects this goal");
        library.showLibrary();
    }
}
