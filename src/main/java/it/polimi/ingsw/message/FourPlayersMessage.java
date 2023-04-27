package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.FourPlayers;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.Matchmanager;

public class FourPlayersMessage extends Message{
    private Match match ;
    private Matchmanager matchmanger;

    public FourPlayersMessage(Match match , Matchmanager matchmanager){
        super(null , "Four_players_create_board");
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
    @Override
    /*public void visit(ClientController clientController) {
        clientController.handle(this);
    }*/
}
