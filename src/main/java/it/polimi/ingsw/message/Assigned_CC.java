package it.polimi.ingsw.message;

/**
 * message from server to client when has reach common goal
 */
public class Assigned_CC extends  MessageContent{
    public int point;
    public Assigned_CC(int x){
        super("Has_reach_point");
        this.point=x;
    }
    public int getPoint() {
        return point;
    }
}
