package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.*;

public class EightEqualsCards implements CommonGoalCards {

    @Override
    public boolean check(Library library) {
        return false;
    }

    @Override
    public boolean expired(Player player) {
        return false;
    }

    @Override
    public void getImage() {

    }
}
