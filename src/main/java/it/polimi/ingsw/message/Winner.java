package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;

/**
 * message from server to client that is the winner
 */
public class Winner extends Message{
    public Winner(String name){
        super(name,"You_are_the_winner");
    }
    @Override
    public void visit(MatchController c) {
        // metodo che gestisce messaggio specifico
    }
}
