package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.EffectiveCard;

/**
 * message from client to server to let the player see CommonGoal Cards
 */
public class Show_Ccard extends Message{
    EffectiveCard[] c;
    public Show_Ccard(EffectiveCard[] c){
        super("Server","Show_CommonGoal_Card");
        this.c=c;
    }
    public EffectiveCard[] getC() {
        return c;
    }
}
