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
    private boolean lastRound = false;

    public TurnController(ArrayList<String> nicknames,String activePlayer,Match match){
        this.match = match;
        this.nicknamePlayers = nicknames;

        this.activePlayer = activePlayer;

    }

    public String getActivePlayer(){
        return activePlayer;
    }

    public void setActivePlayer(String nickname){
        this.activePlayer= nickname;
    }

    public boolean getLastRound(){return lastRound;}
    public void setLastRound(boolean b){
        lastRound=b;
    }




    /**
     * next player
     */
    public boolean nextPlayer(){
        int currentActive = nicknamePlayers.indexOf(activePlayer);
        if(currentActive+1<match.getPlayerNumber())
            currentActive +=1;
        else if(lastRound==false )
            currentActive=0;
        else
            return false;

        activePlayer = nicknamePlayers.get(currentActive);
        return true;

    }

}
