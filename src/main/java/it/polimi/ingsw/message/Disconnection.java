package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.ClientHandler;

/**
 * message from client when the player wants to leave
 */
public class Disconnection extends Message{
    public Disconnection(String name){
        super(name,"Client_has_disconnected");
    }
    @Override
    public void MextoClientHandler(ClientHandler c) {
        // metodo che gestisce messaggio specifico
    }
    @Override
    public void visit(MatchController c) {
        super.visit(c);
    }
}
