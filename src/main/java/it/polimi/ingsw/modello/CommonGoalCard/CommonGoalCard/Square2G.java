package it.polimi.ingsw.modello.CommonGoalCard.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

public class Square2G implements CommonGoalCards {
    /**
     * the method checks if the the target is completed or not
     */

    @Override
    public boolean check(Library library) {
        int r , c , i , indexToSkip1=-1 , indexToSkip2=-1;
        int [] numOfSquares = {0,0,0,0,0,0};
        for(r=0 ; r<5 ; r++){
            for(c=0 ; c<4 ;c++){
                if(c==indexToSkip1){
                    indexToSkip1=-1;
                    continue;
                }
                else if (c==indexToSkip2){
                    indexToSkip2=-1;
                    continue;
                }
                if(library.getCardinPos(r, c).getColour().equals(library.getCardinPos(r, c + 1).getColour()) &&
                        library.getCardinPos(r, c).getColour().equals(library.getCardinPos(r + 1, c).getColour()) &&
                        library.getCardinPos(r, c).getColour().equals(library.getCardinPos(r + 1, c + 1).getColour())){
                    if(library.getCardinPos(r, c).getColour().equals("Green")){
                        numOfSquares[0]++;
                    }
                    else if(library.getCardinPos(r, c).getColour().equals("White")){
                        numOfSquares[1]++;
                    }
                    else if(library.getCardinPos(r, c).getColour().equals("Yellow")){
                        numOfSquares[2]++;
                    }
                    else if(library.getCardinPos(r, c).getColour().equals("Navy")){
                        numOfSquares[3]++;
                    }
                    else if(library.getCardinPos(r, c).getColour().equals("Blue")){
                        numOfSquares[4]++;
                    }
                    else if(library.getCardinPos(r, c).getColour().equals("Pink")){
                        numOfSquares[5]++;
                    }
                    indexToSkip1=c;
                    indexToSkip2=c+1;
                    c++;
                }

            }
        }
        for(i=0 ; i<6 ; i++){
            if(numOfSquares[i]>=2){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean expired(Library library) {
        return false;
    }

    /**
     * The method shows an example of the target
     */

    @Override
    public void getImage() {
        Library l  =new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(0,1).setColour("Green");
        l.getCardinPos(1,0).setColour("Green");
        l.getCardinPos(1,1).setColour("Green");

        l.getCardinPos(2,0).setColour("Green");
        l.getCardinPos(2,1).setColour("Green");
        l.getCardinPos(3,0).setColour("Green");
        l.getCardinPos(3,1).setColour("Green");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();
    }
}
