package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.Matchmanager;

public class TwoPlayersMessage extends Message{
    private Match match ;
    private Matchmanager matchmanger;

    public TwoPlayersMessage(Match match , Matchmanager matchmanager){
        super(MessageType.TWO_PLAYERS);
        this.match=match;
        this.matchmanger=matchmanager;
    }

    public Match getMatch(){
        return match;
    }

    public Matchmanager getMatchmanager(){
        return matchmanger;
    }

    @Override
    void setPayload(String s) {
    }

    @Override
    void redirectAnswer() {
    }

    public void visit(ClientController clientController){
        clientController.handleTwoPlayersBoard(this);
    }
}
