package it.polimi.ingsw.message;

import it.polimi.ingsw.network.Client;

/**
 * message from client to server to put cards in library
 */
public class PutInLib extends MessageContent{
    private int column;
    public PutInLib(int x){
        super("puts_in_library",x);
        this.column=x;
    }

    public int getColumn() {
        return column;
    }
}
