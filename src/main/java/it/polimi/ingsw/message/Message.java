package it.polimi.ingsw.message;
import it.polimi.ingsw.network.Client;

import java.io.Serializable;

/**
 * this class create a generic message serializable
 */

public class Message implements Serializable {
    protected String nickname;
    private MessageContent message;
    public Message(String c,MessageContent m){
        this.nickname =c;
        this.message=m;
    }
    public MessageContent getMessage() {
        return message;
    }
    public String getnickname() {
        return nickname;
    }

    public void setMessage(MessageContent message) {
        this.message = message;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
