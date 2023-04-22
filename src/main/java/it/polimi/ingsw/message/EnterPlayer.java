package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.Client;

/**
 * message from client to server to add a player to the match
 */

public class EnterPlayer extends Message{
    private String nick;

    public EnterPlayer(String nick){
        super(nick,"enter_player");
        this.nick=nick;
    }
    public String getNick() {
        return nick;
    }
    @Override
    public void visit(MatchController c) {
        // metodo che gestisce messaggio specifico
    }

}
