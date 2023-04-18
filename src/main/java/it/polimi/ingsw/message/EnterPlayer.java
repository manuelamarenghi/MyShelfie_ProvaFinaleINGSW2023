package it.polimi.ingsw.message;

import it.polimi.ingsw.network.Client;

/**
 * message from client to server to add a player to the match
 */

public class EnterPlayer extends MessageContent{
    private String nick;

    public EnterPlayer(String nick){
        super("enter_player",nick);
        this.nick=nick;
    }

    public String getNick() {
        return nick;
    }

}
