package it.polimi.ingsw.Controller.observer;

import it.polimi.ingsw.Controller.Subject;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.MessageType;
import it.polimi.ingsw.message.PutCardInLibraryMessage;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.NotUsableException;
import it.polimi.ingsw.modello.Player;

public class PutCardInLibraryObserverClient implements ObserverClient{


    @Override
    public void update(Subject subject, Message message) throws NotUsableException {
        if(message.getCode()== MessageType.PUT_CARDS_IN_LIBRARY){
            Card[] selectedCards;
            Player player;
            PutCardInLibraryMessage putCardInLibraryMessage = (PutCardInLibraryMessage) message;
            selectedCards = putCardInLibraryMessage.getSelectedCards();
            player = putCardInLibraryMessage.getPlayer();
            player.getPlayerManager().putCard(selectedCards , player);
        }
    }
}
