package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.MessageHandler;

import java.util.HashMap;

/**
 * message from server to client to give his final point
 */
public class Final_point extends Message{
    HashMap<String,Integer> point;
    public Final_point(HashMap<String,Integer> x, String name){
        super(name,"final_point");
        this.point=x;
    }

    public HashMap<String,Integer> getPoint() {
        return point;
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }


}
