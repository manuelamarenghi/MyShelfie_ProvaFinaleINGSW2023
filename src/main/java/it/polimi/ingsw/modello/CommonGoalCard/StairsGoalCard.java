package it.polimi.ingsw.modello.CommonGoalCard;
import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class StairsGoalCard implements CommonGoalCards, Serializable {
    @Override
    public boolean check(Library library) {
        return sxStair(library) || dxStair(library) || sxShiftedStair(library) || dxShiftedStair(library);
    }

    @Override
    public boolean expired(Library library) {
        return false;
    }

    @Override
    public String getDesc() {
        return "Five columns of increasing or decreasing height.\n" +
                "Starting from the first column on the left or on the right,\n" +
                "each next column must be made of exactly one more tile. \n" +
                "Tiles can be of any type.\n";
    }

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

    private static boolean sxStair(Library library) {
        for (int i = 0; i < 5; i++) {
            if (!(library.getFilledColumnNumber(i) == 5 - i && library.getFilledRowNumber(5 - i) == 5 - i))
                return false;
        }
        return true;
    }

    private static boolean dxStair(Library library) {
        for (int i = 5; i > 0; i--) {
            if(!(library.getFilledColumnNumber(i-1)==i&& library.getFilledRowNumber(i)==i))return false;
        }
        return true;
    }
    private static boolean sxShiftedStair(Library library){
        for(int i=0;i<5;i++){
            if(!(library.getFilledColumnNumber(i)==6-i&& library.getFilledRowNumber(5-i-1)==5-i))return false;
        }
        return true;
    }
    private static boolean dxShiftedStair(Library library){
        for(int i=5;i>0;i--){
            if(!(library.getFilledColumnNumber(i-1)==i+1&& library.getFilledRowNumber(i-1)==i))return false;
        }
        return true;
    }
}
