package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

public class Created_Match extends Message implements Serializable {
    Match match;
    public Created_Match(Match match) {
        super("Server", "New_Match");
        this.match=match;
    }
    public Match getMatch() {
        return match;
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
