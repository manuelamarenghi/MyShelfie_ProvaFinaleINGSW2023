package it.polimi.ingsw.Controller;

import it.polimi.ingsw.enumeration.TurnPhase;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.view.VirtualView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TurnController {

    private final Match match;
    private final List<String> nicknamePlayers;
    private String activePlayer;

    private TurnPhase turnPhase;

    private final MatchController matchController;

    public TurnController(MatchController matchController,ArrayList<String> nicknames,String activePlayer,Match match){

        this.match = match;
        this.nicknamePlayers = nicknames;

        this.activePlayer = activePlayer;
        this.matchController = matchController;
    }

    public String getActivePlayer(){
        return activePlayer;
    }

    public void setActivePlayer(String nickname){
        this.activePlayer= nickname;
    }

    /**
     * checks if the turn is completed
     */
    public void nextTurn(){

    }

    /**
     * check if the player have completed a round and next player
     */
    public void nextPlayer(){

    }
}
