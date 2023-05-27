package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

import java.util.ArrayList;

/**
 * A message containing all the players of the game
 */
public class AllPlayer extends Message {
    private ArrayList<String> players;

    public AllPlayer(ArrayList<String> players) {
        super("Server", "All_Players");
        this.players = players;
    }

    public ArrayList<String> getPlayers() {
        return this.players;
    }

    public void visit(MessageHandler controller) {
        controller.handle(this);
    }
}
