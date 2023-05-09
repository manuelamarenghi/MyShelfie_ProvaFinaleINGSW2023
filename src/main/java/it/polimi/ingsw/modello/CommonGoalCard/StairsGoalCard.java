package it.polimi.ingsw.modello.CommonGoalCard;
import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class StairsGoalCard implements CommonGoalCards, Serializable {
    @Override
    public boolean check(Library library) {
    return sxStair(library)||dxStair(library)||sxShiftedStair(library)||dxShiftedStair(library);
    }

    @Override
    public boolean expired(Library library) {
        return false;
    }

    @Override
    public void getImage() {

    }
    private static boolean sxStair(Library library){
        for(int i=0;i<5;i++){
            if(!(library.getFilledColumnNumber(i)==5-i&& library.getFilledRowNumber(5-i)==5-i))return false;
        }
        return true;
    }
    private static boolean dxStair(Library library){
        for(int i=5;i>0;i--){
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
