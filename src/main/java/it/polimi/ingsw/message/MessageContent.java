package it.polimi.ingsw.message;
/**
 * MessageContent attribute in Message class to personalize the content of message
 */
public class MessageContent {
    private Object obj;
    private String type;
    public MessageContent(String s,Object o){
        this.obj=o;
        this.type=s;
    }
    public Object getObject(){
        return obj;
    }

}
