package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.Match;

public class FillBoardMessage extends Message {
    private Match match;

    public FillBoardMessage(Match match){
        super(null , "Fill_Board_Message");
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

    @Override
    public void visit (ClientController clientController){
        clientController.handle(this);
    }
}
