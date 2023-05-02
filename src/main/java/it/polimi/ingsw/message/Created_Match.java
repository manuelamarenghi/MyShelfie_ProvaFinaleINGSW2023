package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Match;

public class Created_Match extends Message{
    Match match;
    public Created_Match(Match match) {
        super("Server", "New_Match");
        this.match=match;
    }
    public Match getMatch() {
        return match;
    }
}
