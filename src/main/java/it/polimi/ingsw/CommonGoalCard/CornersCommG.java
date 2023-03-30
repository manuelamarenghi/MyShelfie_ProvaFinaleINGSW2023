package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.*;

import java.util.ArrayList;
import java.util.Objects;

public class CornersCommG implements CommonGoalCards{

    public boolean check(Library library){
        Card carta00 = new Card(library.getCardinPos(0,0).getColour(),library.getCardinPos(0,0).getCoordinates());
        Card carta05 = new Card(library.getCardinPos(0,4).getColour(),library.getCardinPos(0,4).getCoordinates());
        Card carta60 = new Card(library.getCardinPos(5,0).getColour(),library.getCardinPos(5,0).getCoordinates());
        Card carta65 = new Card(library.getCardinPos(5,4).getColour(),library.getCardinPos(5,4).getCoordinates());



        if(!carta00.getColour().equals("") && !carta05.getColour().equals("") && !carta60.getColour().equals("") && !carta65.getColour().equals("")){
            return carta00.getColour().equals(carta05.getColour()) && carta05.getColour().equals(carta60.getColour())
                    && carta60.getColour().equals(carta65.getColour());
        }
        else {
            expired(library);
            return false;
        }
    }

    public boolean expired(Library library){
        boolean expire = false;
        ArrayList<Card> carte = new ArrayList<>();
        if(!Objects.equals(library.getCardinPos(0, 0).getColour(), ""))
            carte.add(new Card(library.getCardinPos(0,0).getColour(),library.getCardinPos(0,0).getCoordinates()));
        if(!Objects.equals(library.getCardinPos(0, 4).getColour(), ""))
            carte.add(new Card(library.getCardinPos(0,4).getColour(),library.getCardinPos(0,4).getCoordinates()));
        if(!Objects.equals(library.getCardinPos(5, 0).getColour(), ""))
            carte.add(new Card(library.getCardinPos(5,0).getColour(),library.getCardinPos(5,0).getCoordinates()));
        if(!Objects.equals(library.getCardinPos(5, 4).getColour(), ""))
            carte.add(new Card(library.getCardinPos(5,4).getColour(),library.getCardinPos(5,4).getCoordinates()));

        String colore = carte.get(0).getColour();

        for ( Card c: carte){
            if (!colore.equals(c.getColour())) {
                expire = true;
                break;
            }
        }

        return expire;

    }

    @Override
    public void getImage() {
    }
}
