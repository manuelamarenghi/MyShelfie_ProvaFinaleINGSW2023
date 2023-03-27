package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.Library;

import java.util.ArrayList;

/*
 * Line4G goal needs 4 lines formed by 5 tiles of maximum 3 different types. Different lines can have different combination of types
 */
public class Line4G implements CommonGoalCards{
    /*
     * check() returns true if the library match the goal,otherwise false
     */
    @Override
    public boolean check(Library library) {
        ArrayList<String> n = new ArrayList<String>();
        int x = 0;
        int temp = 0;
        int j = 0;
        for (int i = 0; i < 6; i++) {
            while (j < 5 && temp< 3) {
                if (!library.getCardinPos(i, j).getColour().isEmpty()) {
                    if (!n.contains(library.getCardinPos(i, j).getColour())) {
                        n.add(temp, library.getCardinPos(i, j).getColour());
                        temp++;
                    }
                    j++;
                    if (j == 5 && temp<4) {
                        x++;
                    }
                }
                else{ j=5;}
            }
            j = 0;
            n.clear();
            temp=0;
        }
            if (x >= 4) {
                return true;
            }
            return false;
        }
    /*
     * getImage() let you see this goal
     */
    @Override
    public void getImage() {
      Library l=new Library();
      l.getCardinPos(5,0).setColour("G");
      l.getCardinPos(5,1).setColour("R");
      l.getCardinPos(5,2).setColour("G");
      l.getCardinPos(5,3).setColour("G");
      l.getCardinPos(5,4).setColour("G");
      l.getCardinPos(4,0).setColour("G");
      l.getCardinPos(4,1).setColour("R");
      l.getCardinPos(4,2).setColour("G");
      l.getCardinPos(4,3).setColour("B");
      l.getCardinPos(4,4).setColour("B");
      l.getCardinPos(3,0).setColour("G");
      l.getCardinPos(3,1).setColour("R");
      l.getCardinPos(3,2).setColour("G");
      l.getCardinPos(3,3).setColour("B");
      l.getCardinPos(3,4).setColour("G");
      l.getCardinPos(2,0).setColour("B");
      l.getCardinPos(2,1).setColour("B");
      l.getCardinPos(2,2).setColour("B");
      l.getCardinPos(2,3).setColour("B");
      l.getCardinPos(2,4).setColour("B");
      System.out.println("This is an example of a library that respects this goal");
      l.showLibrary();

    }
}