package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Player;
import it.polimi.ingsw.network.MessageHandler;

import java.util.ArrayList;

public class AllPlayer extends Message{
    private ArrayList<Player> players;
    public AllPlayer(ArrayList<Player> players) {
        super("Server", "All_Players");
        this.players=players;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
