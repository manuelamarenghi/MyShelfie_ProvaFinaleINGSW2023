package it.polimi.ingsw;

import java.util.Iterator;

public class LibraryIterator implements Iterator<Card> {
    private int column=0;
    private int row=0;
    private Card[][] current;
    protected LibraryIterator(Card[][] library){
    current=library;
    }
    @Override
    public boolean hasNext() {
        if(row==current.length-1 &&column==current[0].length-1)return false;
        return true;
    }

    @Override
    public Card next() {
        if(column<current[row].length-1){
            column++;
            return current[row][column];
        }else{
            column=0;
            row++;
        }
      return current[row][column];
    }
}
