package it.polimi.ingsw.view;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.network.ClientHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class implements methods to send message to a specific client
 */
public class VirtualView implements View{
    ClientHandler clientHandler;
    public VirtualView(ClientHandler c){
        this.clientHandler=c;
    }
    /**
     * askNickname() for the nickname of a new player
     */
    @Override
    public void askNickname() {
        clientHandler.sendMessage(new AskNewNickname());
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
    public void updateanotherplayerconnect(String name,Boolean connected,Player p){
        if(connected==false) {
            clientHandler.sendMessage(new AnotherPlayerDisconnect(name));
        }
        else{ clientHandler.sendMessage(new PlayerReturned(p));}
    }
    /**
     * assignedChair() assigned chair to a random player
     */
    public void assignedChair(String name){
        clientHandler.sendMessage(new ChairAssigned(name));
    }

    /**
     * NotallowedCard() when a player choose card not adjacent
     * @param name
     */
    public void NotallowedCard(String name){
        clientHandler.sendMessage(new NotTakeCardBoard(name));
    }
    /**
     * AcceptNewPlayer() when a player join the game
     */
    public void AcceptNewPlayer(String name){
        clientHandler.sendMessage(new AcceptPlayer(name));
    }
    /**
     * YourTurn() to notify when is your turn
     */
    public void YourTurn(String player){
        clientHandler.sendMessage(new Turn(player));
    }
    /**
     * CreateMatch() create the game
     */
    @Override
    public void CreateMatch(Match m) {
        clientHandler.sendMessage(new Created_Match(m));
    }
    /**
     * EndGame() send the classification to all players
     */
    public void EndGame(HashMap<String,Integer> x){
        clientHandler.sendMessage(new Final_point(x,null));
    }
    /**
     * FirstFinished() notify other player that the game is going to end
     */
    public void FirstFinished(String name){
        clientHandler.sendMessage(new First_finish(name));
    }
    /**
     * GenericMessage() send a generic message
     */
    public void GenericMessage(String s, String c) {
        clientHandler.sendMessage(new Message(s, c));
    }

    /**
     * sendNumbPlayer() send to all players the number setted from the first entered
     */
    public void sendNumbPlayer(int x) {
        clientHandler.sendMessage(new Numb_Player_Answer(x));
    }

    /**
     * sendPersonalCard() send to all players their personal goal card
     */
    public void sendPersonalCard(PersonalGoalCard personalGoalCard) {
        clientHandler.sendMessage(new Send_PersonalCard(personalGoalCard));
    }

    @Override
    public void update(Message message) {
        clientHandler.sendMessage(message);
    }

    /**
     * sendCommonCard() send to all players common cards of the game
     */
    public void sendCommonCard(EffectiveCard[] cards) {
        clientHandler.sendMessage(new Send_EffectiveCard(cards));
    }

    /**
     * send list of players in the match
     * @param players
     */
    public void sendAllPlayers(ArrayList<String> players){
        clientHandler.sendMessage(new AllPlayer(players));
    }
}
