package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * response to a modify on the board and request for column in library selectable
 */
public class ShowColumn extends Message implements Serializable {
    int[] x;
    ArrayList<Card> cards = new ArrayList<>();

    public ShowColumn(String name, int[] x, ArrayList<Card> cards) {
        super(name, "selectable_column");
        this.x = x;
        this.cards = cards;
    }

    public int[] getX() {
        return x;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void visit(MessageHandler controller) {
        controller.handle(this);
    }
}
