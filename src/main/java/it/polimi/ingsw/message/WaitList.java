package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.MatchController;

/**
 * message from server to client when the game has enough players
 */
public class WaitList extends Message{
    public WaitList(String name){
        super(name,"Game_full");
    }
    @Override
    public void visit(MatchController c) {
        // metodo che gestisce messaggio specifico
    }
}
