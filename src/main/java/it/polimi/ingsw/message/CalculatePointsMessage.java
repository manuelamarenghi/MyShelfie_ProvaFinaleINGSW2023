package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Match;

public class CalculatePointsMessage extends Message{

    private Match match;

    public CalculatePointsMessage(Match match){
        super(null , "Calculate_Points");
        this.match=match;
    }

    public Match getMatch(){
        return match;
    }

    @Override
    void setPayload(String s) {

    }

    @Override
    void redirectAnswer() {

    }
    @Override
    public void visit(ClientController clientController){
        clientController.handle(this);
    }
}
