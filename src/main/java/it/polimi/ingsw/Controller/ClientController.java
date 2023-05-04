package it.polimi.ingsw.Controller;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.network.Client;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientController {

    private Client client;
    private View view;

    public ClientController(Client client , View view){
        this.client = client;
        this.view = view;
    }

    /*public void handleMessage (Message message){
        message.visit(this);
    }*/

    /**
     * The method creates board depending on number of players
     */

    public void handleCreateBoard(int numeberOfPlayers , String name ){
        Numb_Player message = new Numb_Player(numeberOfPlayers , name);
        client.sendMessage(message);
    }
    /*
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
    */

    public void handleCreateMatch(Match match){
        Created_Match message = new Created_Match(match);
        client.sendMessage(message);
    }

    /**
     * the sends a message to socket client in case it decides to pick a card from board
     */
    public void handleTakeCard( Card[] cards , String name ){
        TakeCardBoard message = new TakeCardBoard(cards , name);
        client.sendMessage(message);
    }

    /**
     * The method sends a message to socket client to put a card in the library
     */
    public void handlePutInLibrary (int x , String name , ArrayList<Card> cards){
        PutInLib message = new PutInLib(x , name , cards);
        client.sendMessage(message);
    }

    public void handleColoumnRequest(int numberOfCards , String name){
        ColumnRequest message = new ColumnRequest(numberOfCards , name);
        client.sendMessage(message);
    }

    /**
     * the method sends a message to socket client to calculate points for the player
     */
    public void handleFinalPoint(String name){
        FinalPointRequest message =new FinalPointRequest(name);
        client.sendMessage(message);
    }

    /**
     * The method tells the server to dissconect
     * @param name
     */

    public void handleDisconection(String name){
        Disconnection message = new Disconnection(name);
        client.sendMessage(message);
    }

    public void handleMessageFromSocketClient(Message message){
        message.visit(this);
    }

    public void handle(UpdateBoard message){

    }

    /**
     * The method takes action on view based on the message recieved by the server , it could be implemented
     * by using a switch case or a visitor method pattern
     * @param message
     */
    public void sendMessageToView(Message message){
        //Chiamare i metodi della view direttamente per fare le cose richieste , per esempio per vedere la
        // plancia chiamerò il metodo view.showBoard()
        // Casi da gestire :
        //vedere la plancia
        //vedere la libreria
        //vedere la common goal card , chiamare il virtual model
        //vedere la personal goal card
        //vedere la carta ?
        //vedere il punteggio attuale?
        // Caso delle carte che non si possono prendere
        //UN altro un giocatore si è disconesso
        //messaggio in chat , far vedere nick e messaggio
        //Far vedere il winnner
        //Caso in cui il giocatore non viene accettato
        //Sedia giocatore assegnato


    }

}
