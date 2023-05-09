package it.polimi.ingsw.message;
import it.polimi.ingsw.Controller.MatchController;

import java.io.Serializable;

/**
 * message from client to server to start the match with the number of players
 */

public class Numb_Player extends Message implements Serializable {
    private int numb;
    public Numb_Player(int x,String name){
        super(name,"numb_player");
        this.numb=x;
    }
    public int getNumb() {
        return numb;
    }
    @Override
    public void visitServer(MatchController c) {
        c.handler(this);
    }

}
