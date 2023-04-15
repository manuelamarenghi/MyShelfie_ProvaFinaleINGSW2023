package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Player;

import java.util.ArrayList;

public class PickCardFromBoardMessage extends Message{
    private Board board ;
    private Player player;
    private ArrayList<Card> selectedCardsTemp ;

    public PickCardFromBoardMessage(Board board , Player player , ArrayList<Card> selectedCardsTemp){
        super(MessageType.PICK_CARD_FROM_BOARD);
        this.board=board;
        this.player=player;
        this.selectedCardsTemp=selectedCardsTemp;
    }
    public Board getBoard(){
        return board;
    }

    public Player getPlayer(){
        return player;
    }

    public ArrayList<Card> getSelectedCardsTemp(){
        return selectedCardsTemp;
    }
    @Override
    void setPayload(String s) {

    }

    @Override
    void redirectAnswer() {

    }
}
