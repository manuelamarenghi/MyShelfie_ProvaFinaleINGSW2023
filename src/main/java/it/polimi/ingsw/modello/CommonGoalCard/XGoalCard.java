package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class XGoalCard implements CommonGoalCards, Serializable {

    @Override
    public boolean check(Library library) {
        for (int i = 0; i < 3; i++) {
            for (int j = 5; j > 1; j--) {
                String colour = library.getCardinPos(j, i).getColour();
                if (!colour.equals("") && colour.equals(library.getCardinPos(j - 1, i + 1).getColour()) &&
                        colour.equals(library.getCardinPos(j - 2, i + 2).getColour()) &&
                        colour.equals(library.getCardinPos(j, i + 2).getColour()) &&
                        colour.equals(library.getCardinPos(j - 2, i).getColour())) return true;
            }
        }
        return false;
    }

    @Override
    public boolean expired(Library library) {
        return false;
    }

    @Override
    public String getDesc() {
        return "Five tiles of the same type forming an X.\n";
    }

    @Override
    public void showCommonCard() {

        Library library = new Library();
        library.getCardinPos(5, 0).setColour("blue");
        library.getCardinPos(4, 1).setColour("blue");
        library.getCardinPos(3, 2).setColour("blue");
        library.getCardinPos(5, 2).setColour("blue");
        library.getCardinPos(3, 0).setColour("blue");
        System.out.println("This is an example of a library that respects this goal");
        library.showLibrary();

    }

}
