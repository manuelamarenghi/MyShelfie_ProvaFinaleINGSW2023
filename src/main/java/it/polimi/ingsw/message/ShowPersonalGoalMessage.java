package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Player;

public class ShowPersonalGoalMessage extends Message{
    private Player player;

    public ShowPersonalGoalMessage(Player player){
        super(MessageType.SHOW_PERSONAL_GOAL);
        this.player=player;
    }

    public Player getPlayer() {
        return player;
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
