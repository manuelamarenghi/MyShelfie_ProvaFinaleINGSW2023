package it.polimi.ingsw.message;
import it.polimi.ingsw.network.Client;

import java.io.Serializable;

/**
 * this class create a generic message serializable
 */

public abstract  class Message implements Serializable {
    protected String nickname;
    private MessageContent message;
    Message(String c,MessageContent m){
        this.nickname =c;
        this.message=m;
    }
    public MessageContent getMessage() {
        return message;
    }
    public String getnickname() {
        return nickname;
    }

}
