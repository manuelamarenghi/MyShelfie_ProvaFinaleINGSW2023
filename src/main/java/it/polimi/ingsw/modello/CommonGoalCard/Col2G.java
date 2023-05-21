package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Col2G goal needs two columns each formed by 6 different types of tiles
 */
public class Col2G implements CommonGoalCards, Serializable {
    int numberCard = 2;

    public int getNumberCard() {
        return numberCard;
    }

    /**
     * check() returns true if the library match the goal,otherwise false
     */
    @Override
    public boolean check(Library library) {
        ArrayList<String> n = new ArrayList<String>();
        int temp = 0;
        int x = 0;
        int j = 0;
        for (int i = 0; i < 5; i++) {
            while(j<6){
                if(!library.getCardinPos(j, i).getColour().isEmpty()){
                    if(!n.contains(library.getCardinPos(j, i).getColour())) {
                        n.add(temp, library.getCardinPos(j, i).getColour());
                        temp++;
                    }
                    else{j=6;}
                }
                else{j=6;}
                j++;
            }
            if(temp==6){ x++;}
            j=0;
            temp=0;
            n.clear();
        }
        if (x >= 2) {
            return true;
        }
        return false;
    }

    /**
     * getImage() let you see this goal
     */
    @Override
    public void showCommonCard() {
        Library l = new Library();
        l.getCardinPos(0, 1).setColour("green");
        l.getCardinPos(1, 1).setColour("pink");
        l.getCardinPos(2, 1).setColour("green");
        l.getCardinPos(3, 1).setColour("green");
        l.getCardinPos(4, 1).setColour("green");
        l.getCardinPos(5, 1).setColour("green");
        l.getCardinPos(0, 0).setColour("green");
        l.getCardinPos(1, 0).setColour("pink");
        l.getCardinPos(2, 0).setColour("white");
        l.getCardinPos(3, 0).setColour("pink");
        l.getCardinPos(4, 0).setColour("blue");
        l.getCardinPos(5, 0).setColour("yellow");
        l.getCardinPos(0, 4).setColour("pink");
        l.getCardinPos(1, 4).setColour("green");
        l.getCardinPos(2, 4).setColour("blue");
        l.getCardinPos(3, 4).setColour("white");
        l.getCardinPos(4, 4).setColour("pink");
        l.getCardinPos(5, 4).setColour("yellow");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();
    }

    @Override
    public String getDesc() {
        return "Two columns each formed by 6 different types of tiles. \n";
    }

    /**
     * expired() let you know if the player can still reach the goal or not
     */
    @Override
    public boolean expired(Library library) {
        ArrayList<String> n = new ArrayList<String>();
        int temp = 0;
        int j = 6;
        /* x is the number of invalid columns*/
        int x=0;
        for(int i=0;i<5;i++){
            while(j>0){
                if(!library.getCardinPos(j-1,i).getColour().isEmpty() && !n.contains(library.getCardinPos(j-1, i).getColour())){
                    n.add(temp,library.getCardinPos(j-1, i).getColour());
                    temp++;
                }
                else{ if(!library.getCardinPos(j-1,i).getColour().isEmpty()){x++;}j=0;}
                j--;
            }
            j=6;
            n.clear();
            temp=0;
        }
        if(x>3){
            return true;
        }
        return false;
    }
}
