package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;

import it.polimi.ingsw.network.Client;

/**
 * message from client to server to add a player to the match
 */


public class EnterPlayer extends Message{

    public EnterPlayer(String nick){
        super(nick,"enter_player");
    }

}
