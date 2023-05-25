package it.polimi.ingsw.message;


import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * message from server to client after a player entered the game
 */
public class AcceptPlayer extends Message implements Serializable {
    boolean you;

    public AcceptPlayer(String name, Boolean you) {
        super(name, "accepted_in_the_match");
        this.you = you;
    }

    public boolean isYou() {
        return you;
    }

    public void visit(MessageHandler controller) {
        controller.handle(this);
    }
}
