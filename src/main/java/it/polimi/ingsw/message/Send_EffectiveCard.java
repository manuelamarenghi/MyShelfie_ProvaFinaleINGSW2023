package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.EffectiveCard;
import it.polimi.ingsw.network.MessageHandler;

/**
 * Message from server to client send the common goal card of the match
 */
public class Send_EffectiveCard extends Message {
    private EffectiveCard[] cards = new EffectiveCard[2];

    public Send_EffectiveCard(EffectiveCard[] cards) {
        super("Server", "commongoal_cards");
        this.cards = cards;
    }

    public EffectiveCard[] getCards() {
        return this.cards;
    }

    public void visit(MessageHandler controller) {
        controller.handle(this);
    }
}
