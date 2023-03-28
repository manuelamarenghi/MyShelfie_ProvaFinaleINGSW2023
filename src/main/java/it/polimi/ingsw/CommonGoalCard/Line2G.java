package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.Card;
import it.polimi.ingsw.CommonGoalCards;
import it.polimi.ingsw.Library;
import it.polimi.ingsw.Player;

import java.util.ArrayList;

public class Line2G implements CommonGoalCards {

    @Override
    public boolean check(Library library) {
        int r , c , i;
        ArrayList<Integer> differentCard = new ArrayList<Integer>(6);
        int differentLines=0 , total;
        for(r=0 ; r<6 ; r++){
            total=0;
            for(i=0 ; i<6 ; i++){
                differentCard.set(i,0);
            }
            for(c=0 ; c<5 ; c++){
                if(library.getCardinPos(r,c).getColour()=="Green"){
                    differentCard.set(0 , differentCard.get(0)+1);
                }
                else if(library.getCardinPos(r,c).getColour()=="White"){
                    differentCard.set(1 , differentCard.get(1)+1);
                }
                else if(library.getCardinPos(r,c).getColour()=="Yellow"){
                    differentCard.set(2 , differentCard.get(2)+1);
                }
                else if(library.getCardinPos(r,c).getColour()=="Navy"){
                    differentCard.set(3 , differentCard.get(3)+1);
                }
                else if(library.getCardinPos(r,c).getColour()=="Blue"){
                    differentCard.set(4 , differentCard.get(4)+1);
                }
                else if(library.getCardinPos(r,c).getColour()=="Pink"){
                    differentCard.set(5 , differentCard.get(5)+1);
                }
            }
            for(i=0 ; i<6 ; i++){
                if(differentCard.get(i)==1){
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
    public boolean expired(Player player) {
        int r , c , i;
        ArrayList<Integer> differentTypes = new ArrayList<Integer>(6);
        int differentLines=6 , totalTypes;
        for(r=0 ; r<6 ;r++){
            totalTypes=0;
            for(i=0 ;i<6; i++){
                differentTypes.set(i , 0);
            }
            for(c=0 ; c<5 ; c++){
                if(player.getLibrary().getCardinPos(r,c).getColour()=="Green"){
                    differentTypes.set(0,differentTypes.get(0)+1);
                }
                else if(player.getLibrary().getCardinPos(r,c).getColour()=="White"){
                    differentTypes.set(1,differentTypes.get(1)+1);
                }
                else if(player.getLibrary().getCardinPos(r,c).getColour()=="Yellow"){
                    differentTypes.set(2,differentTypes.get(2)+1);
                }
                else if(player.getLibrary().getCardinPos(r,c).getColour()=="Navy"){
                    differentTypes.set(3,differentTypes.get(3)+1);
                }
                else if(player.getLibrary().getCardinPos(r,c).getColour()=="Blue"){
                    differentTypes.set(4,differentTypes.get(4)+1);
                }
                else if(player.getLibrary().getCardinPos(r,c).getColour()=="Pink"){
                    differentTypes.set(5,differentTypes.get(5)+1);
                }
            }
            for(i=0 ; i<6 ; i++){
                if(differentTypes.get(i)!=0){
                    totalTypes++;
                }
            }
            if(totalTypes!=5){
                differentLines--;
            }
        }
        if(differentLines>=2){
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
