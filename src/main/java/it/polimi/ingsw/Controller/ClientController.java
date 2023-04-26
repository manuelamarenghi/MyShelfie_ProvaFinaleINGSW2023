package it.polimi.ingsw.Controller;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.network.Client;

import java.util.ArrayList;

public class ClientController {

    private Client client;

    public ClientController(Client client){
        this.client = client;
    }

    public void handleMessage (Message message){
        message.visit(this);
    }

    public void handle(TwoPlayersMessage message){
        client.sendMessage(message);

    }

    public void handle (ThreePlayersMessage message){
        Match match = message.getMatch();
        Matchmanager matchmanager = message.getMatchmanager();
        client.sendMessage(message);
    }

    public void handle (FourPlayersMessage message){
        Match match = message.getMatch();
        Matchmanager matchmanager = message.getMatchmanager();
        client.sendMessage(message);
    }

    public void handle (PickCardFromBoardMessage message){
        Player player = message.getPlayer();
        Board board = message.getBoard();
        ArrayList<Card> selectedCardsTemp = message.getSelectedCardsTemp();
        client.sendMessage(message);
    }
    public void handle (PutCardInLibraryMessage message){
        Player player = message.getPlayer();
        Card[] selectedCards = message.getSelectedCards();
        client.sendMessage(message);
    }

    public void handle (ShowCommonGoalMessage message){
        Match match = message.getMatch();
        client.sendMessage(message);
    }

    public void handle (ShowPersonalGoalMessage message){
        Player player = message.getPlayer();
        client.sendMessage(message);
    }

    public void handle (FillBoardMessage message){
        Match match = message.getMatch();
        client.sendMessage(message);
    }

    public void handle(CalculatePointsMessage message){
        Match match = message.getMatch();
        client.sendMessage(message);
    }

}
