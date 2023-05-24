package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

/**
 * Class to send a message If the player is connected before the first player
 */
public class Connected_Before_FirstPlayer extends Message {

    public Connected_Before_FirstPlayer(String nickname) {
        super(nickname, "First player is creating the match.Try later");
    }

    public void visit(MessageHandler controller) {
        controller.handle(this);
    }
}
