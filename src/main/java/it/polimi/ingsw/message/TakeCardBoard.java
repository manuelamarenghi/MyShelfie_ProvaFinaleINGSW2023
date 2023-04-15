package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.network.Client;

/**
 * message from client to server when the player is taking cards from board
 */
public class TakeCardBoard extends MessageContent{
    private Card[] cards;
    public TakeCardBoard(Card[] c){
        super("takes_cards_board");
        this.cards=c;
    }

    public Card[] getCards() {
        return cards;
    }


}
