package it.polimi.ingsw.message;
/**
 * message from client to server when the player write a message in the chat
 */
public class MexInChat extends MessageContent{
    public String mex;
    public MexInChat(String s){
        super("Mex_in_chat",s);
        this.mex=s;
    }

    public String getMex() {
        return mex;
    }
}
