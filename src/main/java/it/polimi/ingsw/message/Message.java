package it.polimi.ingsw.message;
import it.polimi.ingsw.network.Client;

import java.io.Serializable;

/**
 * this class create a generic message serializable
 */

public class Message implements Serializable {
    protected String nickname;
    private MessageType messageType;
    private MessageContent message;
    public Message(String c,MessageContent m , MessageType messageType){
        this.nickname =c;
        this.message=m;
        this.messageType=messageType;
    }
    public MessageContent getMessage() {
        return message;
    }
    public String getnickname() {
        return nickname;
    }

    public MessageType getCode(){
        return messageType;
    }

    public void setMessage(MessageContent message) {
        this.message = message;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
