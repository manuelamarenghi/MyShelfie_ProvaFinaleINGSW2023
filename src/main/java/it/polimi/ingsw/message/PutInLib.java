package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;

import java.io.Serializable;


/**
 * message from client to server to put cards in library
 */

public class PutInLib extends Message implements Serializable {
    private int column;
    public PutInLib(int x, String name) {
        super(name, "puts_in_library");
        this.column = x;

    }

    public int getColumn() {
        return column;
    }
    @Override
    public void visitServer(MatchController c) {
        c.handler(this);
    }

}
