package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Player;

public class PutCardInLibraryMessage extends Message{
    private Card[] selectedCards;
    private Player player;

    public PutCardInLibraryMessage(Card[] selectedCards , Player player){
        super(null , "Put_cards_in_library");
        this.player=player;
        this.selectedCards=selectedCards;
    }

    public Card[] getSelectedCards() {
        return selectedCards;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    void setPayload(String s) {

    }

    @Override
    void redirectAnswer() {

    }
    @Override
    public void visit (ClientController clientController){
        clientController.handle(this);
    }
}
