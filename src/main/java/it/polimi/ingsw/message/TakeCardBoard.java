package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Position;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * message from client to server when the player is taking cards from board
 */

public class TakeCardBoard extends Message{
    private ArrayList<Card> cards;
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
    public void visit(MatchController c) {
        c.handler(this);
    }
}
