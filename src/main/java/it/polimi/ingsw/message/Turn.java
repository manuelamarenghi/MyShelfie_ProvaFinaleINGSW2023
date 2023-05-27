package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * Class to send a message to notify the player that it is it's turn now
 */

public class Turn extends Message implements Serializable {

    private String turnPlayer;

    public Turn(String nickname) {
        super("Server", "player_turn");
        turnPlayer = nickname;


    }

    public String getTurnPlayer() {
        return turnPlayer;
    }

    public void visit(MessageHandler controller) {
        controller.handle(this);
    }
}
