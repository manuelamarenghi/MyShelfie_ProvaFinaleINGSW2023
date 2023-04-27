package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.PlayerManager;

public class CalculatePointsMessage extends Message{

    private PlayerManager playerManager;

    public CalculatePointsMessage(PlayerManager playerManager){
        super(null , "Calculate_Points");
        this.playerManager = playerManager;
    }

    public Match getPlayerManager(){
        return playerManager;
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
