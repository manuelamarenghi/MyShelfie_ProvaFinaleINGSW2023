package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.Match;

public class FillBoardMessage extends Message {
    private Board board;

    public FillBoardMessage(Board board){
        super(null , "Fill_Board_Message");
        this.board=board;
    }

    public Match getBoard() {
        return board;
    }

    @Override
    void setPayload(String s) {

    }

    @Override
    void redirectAnswer() {

    }

    /*@Override
    public void visit (ClientController clientController){
        clientController.handle(this);
    }*/
}
