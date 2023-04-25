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
    private Map<String, VirtualView> viewPlayer;

    private final MatchController matchController;

    public TurnController(Map<String,VirtualView> virtualview,MatchController matchController){

        match = new Match();
        nicknamePlayers = new ArrayList<>(match.getPlayersNickname());

        this.activePlayer = nicknamePlayers.get(0);
        this. viewPlayer = virtualview;
        this.matchController = matchController;
    }

    public String getActivePlayer(){
        return activePlayer;
    }

    public void setActivePlayer(String nickname){
        this.activePlayer= nickname;
    }
}
