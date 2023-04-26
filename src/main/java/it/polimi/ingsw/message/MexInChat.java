package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.ClientHandler;

/**
 * message from client to server when the player write a message in the chat
 */
public class MexInChat extends Message{
    public String mex;
    public MexInChat(String s,String name){
        super(name,"Mex_in_chat");
        this.mex=s;
    }
    public String getMex() {
        return mex;
    }
    @Override
    public void MextoClientHandler(ClientHandler c) {
         
    }
}
