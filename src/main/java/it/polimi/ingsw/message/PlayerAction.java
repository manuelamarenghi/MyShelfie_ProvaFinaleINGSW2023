package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.modello.Card;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerAction extends Message implements Serializable {
    private ArrayList<Card> cards = new ArrayList<>();
    private int column;

    public PlayerAction(String name, ArrayList<Card> cards, int column) {
        super(name, "Player_Action");
        this.cards = cards;
        this.column = column;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public void visitServer(MatchController c) {
        c.handler(this);
    }
}
