package it.polimi.ingsw.message;
import it.polimi.ingsw.network.Client;

/**
 * message from client to server to start the match
 */
public class StartMatch extends MessageContent{

    public StartMatch() {
        super("start_game",null);
    }

}
