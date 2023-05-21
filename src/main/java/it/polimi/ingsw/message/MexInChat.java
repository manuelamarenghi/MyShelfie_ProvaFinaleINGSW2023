package it.polimi.ingsw.message;


import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * message from client to server when the player write a message in the chat
 */
public class MexInChat extends Message implements Serializable {
    public ArrayList<String> dest;
    public String mex;

    public MexInChat(String s, String name, ArrayList<String> dest) {
        super(name, "Mex_in_chat");
        this.mex = s;
        this.dest = dest;
    }

    public String getMex() {
        return mex;
    }

    public ArrayList<String> getDest() {
        return dest;
    }

    @Override
    public void MextoClientHandler(ClientHandler c, String s) {
        String destinatario;
        if (this.dest.size() > 1) {
            destinatario = "Group Chat";
        } else {
            destinatario = "you";
        }
        if (dest.contains(s)) {
            c.sendMessage(new Receiving_Mex(mex, nickname, destinatario));
        }
    }

    public void visit(MessageHandler controller) {
        controller.handle(this);
    }

}
