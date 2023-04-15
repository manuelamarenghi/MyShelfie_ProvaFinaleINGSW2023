package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Match;

public class ShowCommonGoalMessage extends Message{
    private Match match;

    public ShowCommonGoalMessage(Match match){
        super(MessageType.SHOW_COMMON_GOAL);
        this.match=match;
    }

    public Match getMatch() {
        return match;
    }

    @Override
    void setPayload(String s) {
    }

    @Override
    void redirectAnswer() {

    }
}
