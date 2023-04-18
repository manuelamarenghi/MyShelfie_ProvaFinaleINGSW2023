package it.polimi.ingsw.message;

/**
 * message from server to client to give his final point
 */
public class Final_point extends MessageContent{
    public int point;
    public Final_point(int x){
        super("final_point",x);
        this.point=x;
    }

    public int getPoint() {
        return point;
    }
}
