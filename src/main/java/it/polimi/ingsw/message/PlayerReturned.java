package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Player;
import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

public class PlayerReturned extends Message implements Serializable {
    Player p;
    public PlayerReturned(Player p) {
        super(p.getNickname(), "Player_returned");
        this.p=p;
    }
    public Player getP() {
        return p;
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
