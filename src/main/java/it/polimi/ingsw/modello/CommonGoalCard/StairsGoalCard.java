package it.polimi.ingsw.modello.CommonGoalCard;
import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class StairsGoalCard implements CommonGoalCards, Serializable {
    int numberCard = 12;

    public int getNumberCard() {
        return numberCard;
    }

    /**
     * the method checks if the stair is from left
     *
     * @param library
     * @return
     */
    private static boolean sxStair(Library library) {
        for (int i = 0; i < 5; i++) {
            if (!(library.getFilledColumnNumber(i) == 5 - i && library.getFilledRowNumber(5 - i) == 5 - i))
                return false;
        }
        return true;
    }

    /**
     * the method checks if the stair is from right
     *
     * @param library
     * @return
     */

    private static boolean dxStair(Library library) {
        for (int i = 5; i > 0; i--) {
            if (!(library.getFilledColumnNumber(i - 1) == i && library.getFilledRowNumber(i) == i)) return false;
        }
        return true;
    }

    /**
     * the method checks if the stair is from left but shifted of one line
     *
     * @param library
     * @return
     */
    private static boolean sxShiftedStair(Library library) {
        for (int i = 0; i < 5; i++) {
            if (!(library.getFilledColumnNumber(i) == 6 - i && library.getFilledRowNumber(5 - i - 1) == 5 - i))
                return false;
        }
        return true;
    }

    /**
     * the method checks if the stair is from right but shifted of one line
     *
     * @param library
     * @return
     */
    private static boolean dxShiftedStair(Library library) {
        for (int i = 5; i > 0; i--) {
            if (!(library.getFilledColumnNumber(i - 1) == i + 1 && library.getFilledRowNumber(i - 1) == i))
                return false;
        }
        return true;
    }

    /**
     * the method checks if the the target is completed or not
     */
    @Override
    public boolean check(Library library) {
        return sxStair(library) || dxStair(library) || sxShiftedStair(library) || dxShiftedStair(library);
    }

    /**
     * expired() let you know if the player can still reach the goal or not
     */
    @Override
    public boolean expired(Library library) {
        return false;
    }

    /**
     * the method returns the description of the card
     */
    @Override
    public String getDesc() {
        return "Five columns of increasing or decreasing height.\n" +
                "Starting from the first column on the left or on the right,\n" +
                "each next column must be made of exactly one more tile. \n" +
                "Tiles can be of any type.\n";
    }

    /**
     * The method shows an example of the target
     */

    @Override
    public void showCommonCard() {
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
        System.out.println("This is an example of a library that respects this goal");
        library.showLibrary();

    }
}
