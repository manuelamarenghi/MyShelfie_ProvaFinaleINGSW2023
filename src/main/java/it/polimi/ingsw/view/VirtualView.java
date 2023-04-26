package it.polimi.ingsw.view;

import it.polimi.ingsw.message.ShowColumn;
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
     * askNickname() for a nickname of a new player
     */
    @Override
    public void askNickname() {

    }
    /**
     * acceptmatch() response whe the match is started from a player
     */
    @Override
    public void acceptmatch() {

    }
    /**
     * askNumbPlayer() for number of player
     */
    @Override
    public void askNumbPlayer() {

    }
    /**
     * updateboard() when cards are taken
     */
    @Override
    public void updateboard() {

    }
    /**
     *  updatelibrary() when a player put there cards
     */
    @Override
    public void updatelibrary() {

    }
    /**
     *  updateplayerconnect() update the match if a player has disconnected
     */
    @Override
    public void updateplayerconnect() {

    }
    /**
     *  sendCommonCard() when a player enter the match
     */
    @Override
    public void sendCommonCard() {

    }
    /**
     * sendPersonalCard() when a player enter the match
     */
    @Override
    public void sendPersonalCard() {

    }
    /**
     * showPossibleColumn() columns where the player can put items
     */
    public void showPossibleColumn(String s,int[] x){
          clientHandler.sendMessage(new ShowColumn(s,x));
    }

}
