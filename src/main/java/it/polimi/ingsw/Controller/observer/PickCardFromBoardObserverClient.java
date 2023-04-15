package it.polimi.ingsw.Controller.observer;

import it.polimi.ingsw.Controller.Subject;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.MessageType;
import it.polimi.ingsw.message.PickCardFromBoardMessage;
import it.polimi.ingsw.modello.*;

import java.util.ArrayList;

public class PickCardFromBoardObserverClient implements ObserverClient{
    //private View view;

    /*
    public PickCardFromBoardObserverClient(View view){
        this.view=view;
    }
     */
    @Override
    public void update(Subject subject, Message message) throws NotUsableException {
        if(message.getCode()== MessageType.PICK_CARD_FROM_BOARD){
            Card[] selectedCardsAllowed;
            PickCardFromBoardMessage pickCardFromBoardMessage = (PickCardFromBoardMessage) message;
            Board board = pickCardFromBoardMessage.getBoard();
            Player player = pickCardFromBoardMessage.getPlayer();
            ArrayList<Card> selectedCardsTemp = pickCardFromBoardMessage.getSelectedCardsTemp();
            selectedCardsAllowed=player.getPlayerManager().selectCard(player , board , selectedCardsTemp);
            //Passare selectedCardsAllowed alla view per poi mettere la carta nella libreria
        }
    }
}
