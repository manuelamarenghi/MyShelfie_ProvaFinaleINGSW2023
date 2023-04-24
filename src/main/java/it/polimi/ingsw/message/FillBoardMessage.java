package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.Match;

public class FillBoardMessage extends Message {
    private Match match;

    public FillBoardMessage(Match match){
        super(MessageType.FILL_BOARD);
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
