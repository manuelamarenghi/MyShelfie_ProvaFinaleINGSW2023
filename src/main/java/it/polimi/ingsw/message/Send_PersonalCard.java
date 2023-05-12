package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.PersonalGoalCard;
import it.polimi.ingsw.network.MessageHandler;

/**
 * Message from server to client send the personal card of the match
 */
public class Send_PersonalCard extends Message {
    private PersonalGoalCard personalGoalCard;

    public Send_PersonalCard(PersonalGoalCard personalGoalCard) {
        super("Server", "Personal Goal Card");
        this.personalGoalCard = personalGoalCard;
    }

    public PersonalGoalCard getPersonalGoalCard() {
        return personalGoalCard;
    }

    public void visit(MessageHandler controller) {
        controller.handle(this);
    }
}
