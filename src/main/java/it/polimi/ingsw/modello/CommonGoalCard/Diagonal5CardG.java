package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class Diagonal5CardG implements CommonGoalCards, Serializable {
    int numberCard = 11;

    public int getNumberCard() {
        return numberCard;
    }
    /**
     * Checks if the library of the player has completed the goal or not
     * @param library
     * @return
     */
    @Override
    public boolean check(Library library) {

        return sxDiagonal(library) || sxDiagonalShift(library) || dxDiagonal(library) || dxDiagonalShift(library);
    }
    /**
     * The method checks if the goal is still achieveable
     * @param library
     * @return
     */
    @Override
    public boolean expired(Library library) {
        return false;
    }
    /**
     *the method shows the goal
     */
    @Override
    public void showCommonCard() {
        Library library = new Library();
        library.getCardinPos(0, 0).setColour("blue");
        library.getCardinPos(1, 1).setColour("blue");
        library.getCardinPos(2, 2).setColour("blue");
        library.getCardinPos(3, 3).setColour("blue");
        library.getCardinPos(4, 4).setColour("blue");
        System.out.println("This is an example of a library that respects this goal");
        library.showLibrary();
    }
    /**
     * the method returns the description of the card
     * @return
     */
    @Override
    public String getDesc() {
        return "Five tiles of the same type forming a diagonal.\n ";
    }

    /**
     * the method gets called in the check method and checks if the diagonal to respect the the goal starts from left
     * @param library
     * @return
     */

    private boolean sxDiagonal(Library library) {
        String color;

        if (!library.getCardinPos(0, 0).getColour().equals(""))
            color = library.getCardinPos(0, 0).getColour();
        else
            return false;

        for(int i=1;i<5;i++)
        {
            if(!library.getCardinPos(i,i).getColour().equals(color))
                return false;
        }
        return true;
    }
    /**
     * the method gets called in the check method and checks if the diagonal to respect the the goal starts from right
     * @param library
     * @return
     */
    private boolean dxDiagonal(Library library){
        String color;
        if(!library.getCardinPos(0,4).getColour().equals(""))
            color=library.getCardinPos(0,4).getColour();
        else
            return false;
        int j=3;
        for(int i=1;i<5;i++)
        {
            if(!library.getCardinPos(i,j).getColour().equals(color))
                return false;
            j--;
        }
        return true;
    }
    /**
     * the method gets called in the check method and checks if the diagonal to respect the the goal starts from left
     * but from the first line
     * @param library
     * @return
     */

    private boolean sxDiagonalShift(Library library)
    {
        String color;

        if(!library.getCardinPos(1,0).getColour().equals(""))
            color=library.getCardinPos(1,0).getColour();
        else
            return false;

        for(int i=2;i<6;i++)
        {
            if(!library.getCardinPos(i,i-1).getColour().equals(color))
                return false;
        }
        return true;
    }
    /**
     * the method gets called in the check method and checks if the diagonal to respect the the goal starts from right
     * but from the first line
     * @param library
     * @return
     */

    private boolean dxDiagonalShift(Library library)
    {
        String color;
        if(!library.getCardinPos(1,4).getColour().equals(""))
            color=library.getCardinPos(1,4).getColour();
        else
            return false;
        int j=3;
        for(int i=2;i<6;i++)
        {
            if(!library.getCardinPos(i,j).getColour().equals(color))
                return false;
            j--;
        }
        return true;
    }
}

