package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.Card;
import it.polimi.ingsw.Library;
import it.polimi.ingsw.Player;

import java.util.ArrayList;

public class CornersCommG implements CommonGoalCards{

    public boolean check(Library library){
        Card carta00 = new Card(library.getCardinPos(0,0).getColour(),library.getCardinPos(0,0).getCoordinates());
        Card carta05 = new Card(library.getCardinPos(0,4).getColour(),library.getCardinPos(0,4).getCoordinates());
        Card carta60 = new Card(library.getCardinPos(5,0).getColour(),library.getCardinPos(5,0).getCoordinates());
        Card carta65 = new Card(library.getCardinPos(5,4).getColour(),library.getCardinPos(5,4).getCoordinates());



        if(carta00.getColour() != "" && carta05.getColour() != "" && carta60.getColour() != "" && carta65.getColour() != ""){
            if(carta00.getColour() == carta05.getColour() && carta05.getColour() == carta60.getColour()
                    && carta60.getColour() == carta65.getColour())
                return true;
            else return false;
        }
        else {
            expired(library);
            return false;
        }
    }

    public boolean expired(Library library){
        boolean expire = false;
        ArrayList<Card> carte = new ArrayList<Card>();
        if(library.getCardinPos(0,0).getColour()!="")
            carte.add(new Card(library.getCardinPos(0,0).getColour(),library.getCardinPos(0,0).getCoordinates()));
        if(library.getCardinPos(0,4).getColour()!="")
            carte.add(new Card(library.getCardinPos(0,4).getColour(),library.getCardinPos(0,4).getCoordinates()));
        if(library.getCardinPos(5,0).getColour()!="")
            carte.add(new Card(library.getCardinPos(5,0).getColour(),library.getCardinPos(5,0).getCoordinates()));
        if(library.getCardinPos(5,4).getColour()!="")
            carte.add(new Card(library.getCardinPos(5,4).getColour(),library.getCardinPos(5,4).getCoordinates()));

        String colore = carte.get(0).getColour();

        for ( Card c: carte){
            if(c.getColour().equals(colore) == false){
                expire = true;
            }
        }

        return expire;

    }

    @Override
    public void getImage() {

    }
}
