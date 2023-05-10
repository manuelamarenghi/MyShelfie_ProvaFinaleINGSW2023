package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.EffectiveCard;

public class Send_EffectiveCard extends Message {
    EffectiveCard[] cards = new EffectiveCard[2];

    public Send_EffectiveCard(EffectiveCard[] cards) {
        super("Server", "commongoal_cards");
        this.cards = cards;
    }
}
