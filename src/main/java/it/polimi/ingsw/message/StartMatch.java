package it.polimi.ingsw.message;
import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.Client;

/**
 * message from client to server to start the match
 */
public class StartMatch extends Message{

    public StartMatch(String name) {
        super(name,"start_game");
    }
    @Override
    public void visit(MatchController c) {
        // metodo che gestisce messaggio specifico
    }

}
