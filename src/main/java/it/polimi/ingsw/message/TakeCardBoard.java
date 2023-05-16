package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.modello.Card;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * message from client to server when the player is taking cards from board
 */

public class TakeCardBoard extends Message implements Serializable {
    private ArrayList<Card> cards = new ArrayList<>();
    public TakeCardBoard(Card[] cards, String name){
        super(name,"takes_cards_board");
        for(Card c:cards){
            this.cards.add(c);
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    @Override
    public void visitServer(MatchController c) {
        c.handler(this);
    }
}
