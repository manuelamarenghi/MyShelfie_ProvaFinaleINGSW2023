package it.polimi.ingsw.message;

import java.io.Serializable;

/**
 * Class to send a message to ask the server the coloumns to put the cards
 */
public class ColumnRequest extends Message implements Serializable {

    private int numberOfCards ;

    public ColumnRequest(int numberOfCards , String name){
        super(name , "Coloumn_Request");
        this.numberOfCards=numberOfCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }
}
