package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Match;

public class ShowCommonGoalMessage extends Message{
    private Match match;

    public ShowCommonGoalMessage(Match match){
        super(null , "Show_commom_goal_card");
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
    /*@Override
    public void visit(ClientController clientController){
        clientController.handle(this);
    }*/
}
