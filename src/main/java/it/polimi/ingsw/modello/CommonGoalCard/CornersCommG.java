package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;
import java.util.ArrayList;

public class CornersCommG implements CommonGoalCards, Serializable {

    public boolean check(Library library){

        Card card00 = new Card(library.getCardinPos(0,0).getColour(),library.getCardinPos(0,0).getCoordinates());
        Card card04 = new Card(library.getCardinPos(0,4).getColour(),library.getCardinPos(0,4).getCoordinates());
        Card card50 = new Card(library.getCardinPos(5,0).getColour(),library.getCardinPos(5,0).getCoordinates());
        Card card54 = new Card(library.getCardinPos(5,4).getColour(),library.getCardinPos(5,4).getCoordinates());


        if(card00.getColour() != "" && card04.getColour() != "" && card50.getColour() != "" && card54.getColour() != ""){
            if(card00.getColour() == card04.getColour() && card04.getColour() == card50.getColour()
                    && card50.getColour() == card54.getColour())
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
        ArrayList<Card> cards = new ArrayList<Card>();
        if(library.getCardinPos(0,0).getColour()!="")
            cards.add(new Card(library.getCardinPos(0,0).getColour(),library.getCardinPos(0,0).getCoordinates()));
        if(library.getCardinPos(0,4).getColour()!="")
            cards.add(new Card(library.getCardinPos(0,4).getColour(),library.getCardinPos(0,4).getCoordinates()));
        if(library.getCardinPos(5,0).getColour()!="")
            cards.add(new Card(library.getCardinPos(5,0).getColour(),library.getCardinPos(5,0).getCoordinates()));
        if(library.getCardinPos(5,4).getColour()!="")
            cards.add(new Card(library.getCardinPos(5,4).getColour(),library.getCardinPos(5,4).getCoordinates()));

        String colore = cards.get(0).getColour();

        for ( Card c: cards){
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
