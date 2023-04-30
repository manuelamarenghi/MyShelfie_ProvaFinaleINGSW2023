package it.polimi.ingsw.view;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.EffectiveCard;
import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.modello.PersonalGoalCard;
import it.polimi.ingsw.network.ClientHandler;

/**
 * this class implements methods to send message to a specific client
 */
public class VirtualView implements View {
    ClientHandler clientHandler;
    public VirtualView(ClientHandler c){
        this.clientHandler=c;
    }
    /**
     * askNickname() for the nickname of a new player
     */
    @Override
    public void askNickname() {

    }
    /**
     * acceptmatch() response whe the match is started from a player
     */
    @Override
    public void acceptmatch() {
           clientHandler.sendMessage(new StartMatch("Server"));
    }
    /**
     * askNumbPlayer() for number of player
     */
    @Override
    public void askNumbPlayer() {
        clientHandler.sendMessage(new AskNumbPlayer("Server"));
    }
    /**
     * updateboard() when cards are taken
     */
    @Override
    public void updateboard(Board b) {
         clientHandler.sendMessage(new UpdateBoard(b));
    }
    /**
     *  updatelibrary() when a player put there cards
     */
    @Override
    public void updatelibrary(Library l,String nickname) {
         clientHandler.sendMessage(new Updatelibrary(l,nickname));
    }
    /**
     *  updateplayerconnect() update the match if a player has disconnected
     */
    @Override
    public void updateplayerconnect(String name) {
        clientHandler.sendMessage(new Disconnection_Answer(name));
    }
    /**
     *  sendCommonCard() when a player enter the match
     */
    @Override
    public void sendCommonCard(EffectiveCard[] card) {
        clientHandler.sendMessage(new Show_Ccard(card));
    }
    /**
     * sendPersonalCard() when a player enter the match
     */
    @Override
    public void sendPersonalCard(PersonalGoalCard card) {
            clientHandler.sendMessage(new Show_Pcard(card));
    }
    /**
     * showPossibleColumn() columns where the player can put items
     */
    public void showPossibleColumn(String s,int[] x){
          clientHandler.sendMessage(new ShowColumn(s,x));
    }
    /**
     * Gamefull() notify the player that there are enough players
     */
    public void Gamefull(){
        clientHandler.sendMessage(new WaitList("Server"));
    }
    /**
     * updateanotherplayerconnect() update others player view when one has disconnected
     */
    public void updateanotherplayerconnect(String name){
        clientHandler.sendMessage(new AnotherPlayerDisconnect(name));
    }
    /**
     * assignedCC() update the client when a common goal score is assigned
     */
    @Override
    public void assignedCC(EffectiveCard e, int x,String name) {
        clientHandler.sendMessage(new Assigned_CC(x,name,e));
    }
    /**
     * assignedChair() assigned chair to a random player
     */
    public void assignedChair(String name){
        clientHandler.sendMessage(new ChairAssigned(name));
    }
}
