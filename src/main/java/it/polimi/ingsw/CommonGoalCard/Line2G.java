package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.CommonGoalCards;
import it.polimi.ingsw.Library;

import java.util.ArrayList;
import java.util.Objects;

public class Line2G implements CommonGoalCards {

    @Override
    public boolean check(Library library) {
        int r , c , i;
        //ArrayList<Integer> differentCard = new ArrayList<Integer>(6);
        int [] differentCards = {0,0,0,0,0,0};
        int differentLines=0 , total;
        for(r=0 ; r<6 ; r++){
            total=0;
            for(i=0 ; i<6 ; i++){
                differentCards[i]=0;
            }
            for(c=0 ; c<5 ; c++){
                if(library.getCardinPos(r,c).getColour()=="Green"){
                    differentCards[0]++;
                }
                else if(library.getCardinPos(r,c).getColour()=="White"){
                    differentCards[1]++;
                }
                else if(library.getCardinPos(r,c).getColour()=="Yellow"){
                    differentCards[2]++;
                }
                else if(library.getCardinPos(r,c).getColour()=="Navy"){
                    differentCards[3]++;
                }
                else if(library.getCardinPos(r,c).getColour()=="Blue"){
                    differentCards[4]++;
                }
                else if(library.getCardinPos(r,c).getColour()=="Pink"){
                    differentCards[5]++;
                }
            }
            for(i=0 ; i<6 ; i++){
                if(differentCards[i]==1){
                    total++;
                }
            }
            if(total==5){
                differentLines++;
            }
        }
        if(differentLines>=2){
            return true;
        }
        return false;
    }

    @Override
    public boolean expired(Library library) {
        int r , c , i;
        int differentLines=6 ;
        int [] differentTypes = {0,0,0,0,0,0};
        for(r=0 ; r<6 ;r++){
            for(i=0 ;i<6; i++){
                differentTypes[i]=0;
            }
            for(c=0 ; c<5 ; c++){
                if(library.getCardinPos(r, c).getColour()==("Green")){
                    differentTypes[0]++;
                }
                else if(library.getCardinPos(r,c).getColour()=="White"){
                    differentTypes[1]++;
                }
                else if(library.getCardinPos(r,c).getColour()=="Yellow"){
                    differentTypes[2]++;
                }
                else if(library.getCardinPos(r,c).getColour()=="Navy"){
                    differentTypes[3]++;
                }
                else if(library.getCardinPos(r, c).getColour().equals("Blue")){
                    differentTypes[4]++;
                }
                else if(library.getCardinPos(r,c).getColour()=="Pink"){
                    differentTypes[5]++;
                }
            }
            for(i=0 ; i<6 ; i++){
                if(differentTypes[i]>1){
                    differentLines--;
                }
            }
        }
        if(differentLines<2){
            return true;
        }
        return false;

    }

    @Override
    public void getImage() {
        Library l = new Library();
        l.getCardinPos(0,0).setColour("Green");
        l.getCardinPos(1,0).setColour("Yellow");
        l.getCardinPos(2,0).setColour("White");
        l.getCardinPos(3,0).setColour("Navy");
        l.getCardinPos(4,0).setColour("Blue");

        l.getCardinPos(0,2).setColour("Green");
        l.getCardinPos(1,2).setColour("Yellow");
        l.getCardinPos(2,2).setColour("White");
        l.getCardinPos(3,2).setColour("Navy");
        l.getCardinPos(4,2).setColour("Blue");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();
    }
}
