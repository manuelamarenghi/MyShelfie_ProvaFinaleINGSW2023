package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.Matchmanager;

public class ThreePlayersMessage extends Message{
    private Match match ;
    private Matchmanager matchmanger;

    public ThreePlayersMessage(Match match , Matchmanager matchmanager){
        super(MessageType.THREE_PLAYERS);
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
}
