package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.CommonGoalCards;
import it.polimi.ingsw.Library;
import it.polimi.ingsw.Player;

import java.util.ArrayList;

public class Square2G implements CommonGoalCards {

    @Override
    public boolean check(Library library) {
        int r , c , i , indexToSkip1=-1 , indexToSkip2=-1;
        ArrayList<Integer> numOfSquares = new ArrayList<Integer>(6);
        for(i=0 ; i<6 ; i++){
            numOfSquares.set(i,0);
        }
        for(r=0 ; r<6 ; r++){
            for(c=0 ; c<5 ;c++){
                if(c==indexToSkip1){
                    continue;
                }
                else if (c==indexToSkip2){
                    continue;
                }
                if(library.getCardinPos(r,c).getColour()==library.getCardinPos(r,c+1).getColour() &&
                    library.getCardinPos(r,c).getColour()==library.getCardinPos(r+1,c).getColour() &&
                    library.getCardinPos(r,c).getColour()==library.getCardinPos(r+1,c+1).getColour()){
                    if(library.getCardinPos(r,c).getColour()=="Green"){
                        numOfSquares.set(0 , numOfSquares.get(0)+1);
                    }
                    else if(library.getCardinPos(r,c).getColour()=="White"){
                        numOfSquares.set(1 , numOfSquares.get(1)+1);
                    }
                    else if(library.getCardinPos(r,c).getColour()=="Yellow"){
                        numOfSquares.set(2 , numOfSquares.get(2)+1);
                    }
                    else if(library.getCardinPos(r,c).getColour()=="Navy"){
                        numOfSquares.set(3 , numOfSquares.get(3)+1);
                    }
                    else if(library.getCardinPos(r,c).getColour()=="Blue"){
                        numOfSquares.set(4 , numOfSquares.get(4)+1);
                    }
                    else if(library.getCardinPos(r,c).getColour()=="Pink"){
                        numOfSquares.set(5 , numOfSquares.get(5)+1);
                    }
                    indexToSkip1=c;
                    indexToSkip2=c+1;
                    c++;
                }

            }
        }

        return false;
    }

    @Override
    public boolean expired(Library library) {
        return false;
    }

    @Override
    public void getImage() {

    }
}
