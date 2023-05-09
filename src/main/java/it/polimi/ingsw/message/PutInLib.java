package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.modello.Card;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * message from client to server to put cards in library
 */

public class PutInLib extends Message implements Serializable {
    private int column;
    private ArrayList<Card> cardsInOrder;
    public PutInLib(int x,String name,ArrayList<Card> cards){
        super(name,"puts_in_library");
        this.column=x;
        this.cardsInOrder = cards;
    }
    public int getColumn() {
        return column;
    }
    public ArrayList<Card> getCardsInOrder(){return  cardsInOrder;}
    @Override
    public void visitServer(MatchController c) {
        c.handler(this);
    }

}
