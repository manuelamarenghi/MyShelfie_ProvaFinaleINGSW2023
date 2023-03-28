package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.CommonGoalCards;
import it.polimi.ingsw.Library;
import it.polimi.ingsw.Player;

import java.util.ArrayList;
/*
 * Col2G goal needs two columns each formed by 6 different types of tiles
 */
public class Col2G implements CommonGoalCards {
    /*
     * check() returns true if the library match the goal,otherwise false
     */
    @Override
    public boolean check(Library library) {
        ArrayList<String> n = new ArrayList<String>();
        int temp=0;
        int x=0;
        int j=0;
        for(int i=0;i<5;i++){
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
        if(x>=2){
        return true;}
        return false;
    }
    /*
     * getImage() let you see this goal
     */
    @Override
    public void getImage() {
        Library l=new Library();
        l.getCardinPos(0,1).setColour("G");
        l.getCardinPos(1,1).setColour("R");
        l.getCardinPos(2,1).setColour("G");
        l.getCardinPos(3,1).setColour("G");
        l.getCardinPos(4,1).setColour("G");
        l.getCardinPos(5,1).setColour("G");
        l.getCardinPos(0,0).setColour("G");
        l.getCardinPos(1,0).setColour("R");
        l.getCardinPos(2,0).setColour("W");
        l.getCardinPos(3,0).setColour("P");
        l.getCardinPos(4,0).setColour("B");
        l.getCardinPos(5,0).setColour("Y");
        l.getCardinPos(0,4).setColour("R");
        l.getCardinPos(1,4).setColour("G");
        l.getCardinPos(2,4).setColour("B");
        l.getCardinPos(3,4).setColour("W");
        l.getCardinPos(4,4).setColour("P");
        l.getCardinPos(5,4).setColour("Y");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();
    }

    @Override
    public boolean expired(Player player) {
        return false;
    }
}
