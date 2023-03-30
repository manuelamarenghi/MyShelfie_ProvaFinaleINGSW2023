package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.*;

public class EightEqualsCards implements CommonGoalCards {
    private final int DIMENSION=8;
    @Override
    public boolean check(Library library) {
        int indexRed=0;
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
        return false;
    }

    @Override
    public void getImage() {

    }
}
