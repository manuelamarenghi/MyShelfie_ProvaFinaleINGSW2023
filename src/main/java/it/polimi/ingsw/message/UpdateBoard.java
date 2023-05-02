package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Board;

public class UpdateBoard extends Message{
    Board b;
    public UpdateBoard(Board b){
        super("Server","Board_changed");
        this.b=b;
    }
    public Board getB() {
        return b;
    }
}
