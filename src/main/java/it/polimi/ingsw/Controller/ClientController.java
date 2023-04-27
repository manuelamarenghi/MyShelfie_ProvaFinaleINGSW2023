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

    /*public void handleMessage (Message message){
        message.visit(this);
    }*/

    /**
     * The method creates board depending on number of players
     * @param numeberOfPlayers
     * @param match
     * @param matchmanager
     */

    public void handle(int numeberOfPlayers , Match match , Matchmanager matchmanager){
        if(numeberOfPlayers==2){
            this.handleTwoPlayers(match , matchmanager);

        }
        else if(numeberOfPlayers==3){
            this.handleThreePlayers(match , matchmanager);
        }
        else if( numeberOfPlayers ==4){
            this.handleFourPlayers(match , matchmanager);
        }
        else{
            System.out.println("Number of players not valid");
        }

    }

    public void handleTwoPlayers(Match match , Matchmanager matchmanager){
        TwoPlayersMessage message = new TwoPlayersMessage(match , matchmanager);
        client.sendMessage(message);
    }

    public void handleThreePlayers(Match match , Matchmanager matchmanager){
        ThreePlayersMessage message = new ThreePlayersMessage(match , matchmanager);
        client.sendMessage(message);
    }

    public void handleFourPlayers(Match match , Matchmanager matchmanager){
        FourPlayersMessage message = new FourPlayersMessage(match , matchmanager);
        client.sendMessage(message);
    }


    /**
     * the sends a message to client in case it decides to pick a card from board
     * @param player
     * @param board
     * @param selectedCardTemp
     */
    public void handle ( Player player  , Board board , ArrayList<Card> selectedCardTemp ){
        PickCardFromBoardMessage message = new PickCardFromBoardMessage(board , player , selectedCardTemp);
        //Ci sarebbe da contollare nella virtualModel se si può sollevare le carte , cioè se sono adicanti
        client.sendMessage(message);
    }

    /**
     * The message sends a message to client to put a card in the library
     * @param player
     * @param selectedCards
     */
    public void handle (Player player , Card[] selectedCards){
        PutCardInLibraryMessage message = new PutCardInLibraryMessage(selectedCards , player);
        //Si deve controllare se la colonna è libera
        client.sendMessage(message);
    }

    /**
     * The method sends a message to client to show the common goal card
     * @param match
     */
    public void handle (Match match){
        ShowCommonGoalMessage message = new ShowCommonGoalMessage(match);
        client.sendMessage(message);
    }

    /**
     * the method sends a meesage to client to show the personal goal card
     * @param player
     */
    public void handle (Player player){
        ShowPersonalGoalMessage message = new ShowPersonalGoalMessage(player);
        client.sendMessage(message);
    }

    /**
     * The method csends a message to client to fill the board
     * @param board
     */
    public void handle (Board board){
        FillBoardMessage message = new FillBoardMessage(board);
        //Si deve controllare che non ci siano carte adiacenti
        client.sendMessage(message);
    }

    /**
     * the method sends a message to board to calculate points for the player
     * @param playerManager
     */
    public void handle(PlayerManager playerManager){
        CalculatePointsMessage message =new CalculatePointsMessage(playerManager);
        client.sendMessage(message);
    }

}
