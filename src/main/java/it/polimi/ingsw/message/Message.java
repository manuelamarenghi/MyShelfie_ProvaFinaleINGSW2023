package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * this class create a generic message serializable
 */

public class Message implements Serializable {
    protected String nickname;
    protected String type;

    public Message(String nickname, String type) {
        this.nickname = nickname;
        this.type =type;
    }

    public String getnickname() {
        return nickname;
    }

    public String getType() {
        return type;

    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setType(String type) {
        this.type = type;
    }

    /**
     * visitServer() let controller use the specific method to Handle this message
     *
     * @param c
     */
    public void visitServer(MatchController c) {
        // metodo che gestisce messaggio
    }


    public void MextoClientHandler(ClientHandler c, String o) {
    }

    public void visit(MessageHandler messageHandler) {
        messageHandler.handle(this);
    }

}
