package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Position;


/**
 * message from client to server when the player is taking cards from board
 */

public class TakeCardBoard extends Message{
    private Position[] cards;
    public TakeCardBoard(Position[] c, String name){
        super(name,"takes_cards_board");
        this.cards=c;
    }

    public Position[] getCards() {
        return cards;
    }
    @Override
    public void visit(MatchController c) {
        // metodo che gestisce messaggio specifico
    }
}
