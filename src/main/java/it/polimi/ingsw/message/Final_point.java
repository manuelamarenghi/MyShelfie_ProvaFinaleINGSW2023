package it.polimi.ingsw.message;

import it.polimi.ingsw.Controller.MatchController;

/**
 * message from server to client to give his final point
 */
public class Final_point extends Message{
    public int point;
    public Final_point(int x,String name){
        super(name,"final_point");
        this.point=x;
    }

    public int getPoint() {
        return point;
    }
    @Override
    public void visit(MatchController c) {
        // metodo che gestisce messaggio specifico
    }
}
