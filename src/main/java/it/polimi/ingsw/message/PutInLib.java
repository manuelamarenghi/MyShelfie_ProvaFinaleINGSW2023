package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.Client;

/**
 * message from client to server to put cards in library
 */
public class PutInLib extends Message{
    private int column;
    public PutInLib(int x,String name){
        super(name,"puts_in_library");
        this.column=x;
    }
    public int getColumn() {
        return column;
    }
    @Override
    public void visit(MatchController c) {
        // metodo che gestisce messaggio specifico
    }
}
