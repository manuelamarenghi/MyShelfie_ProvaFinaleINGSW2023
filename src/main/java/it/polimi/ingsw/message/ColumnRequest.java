package it.polimi.ingsw.message;

public class ColumnRequest extends Message{

    private int numberOfCards ;

    public ColumnRequest(int numberOfCards , String name){
        super(name , "Coloumn_Request");
        this.numberOfCards=numberOfCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }
}
