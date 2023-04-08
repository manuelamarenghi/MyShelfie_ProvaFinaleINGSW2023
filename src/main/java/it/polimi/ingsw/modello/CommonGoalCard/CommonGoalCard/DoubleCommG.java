package it.polimi.ingsw.modello.CommonGoalCard.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.util.ArrayList;

public class DoubleCommG implements CommonGoalCards {

    @Override
    public boolean check(Library library) {

        ArrayList<Integer> adjacent = library.getgroup();
        int count=0;

        for(Integer i : adjacent){
            if(i>=2)
                count ++;
        }
        if(count >=6)
            return true;
        else return false;
    }

    @Override
    public boolean expired(Library library) {
        return false;
    }

    @Override
    public void getImage() {

    }
}
