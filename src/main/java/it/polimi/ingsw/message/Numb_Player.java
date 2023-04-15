package it.polimi.ingsw.message;
import it.polimi.ingsw.network.Client;

/**
 * message from client to server to start the match with the number of players
 */

public class Numb_Player extends MessageContent {
    private int numb;
    public Numb_Player(int x){
        super("numb_player");
        this.numb=x;
    }

    public int getNumb() {
        return numb;
    }

}
