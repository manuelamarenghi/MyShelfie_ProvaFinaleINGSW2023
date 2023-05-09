package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * message from client to server when the player write a message in the chat
 */
public class MexInChat extends Message implements Serializable {
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
         c.sendMessage(this);
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }

}
