package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;

/**
 * message from server to client when has reach common goal
 */
public class Assigned_CC extends  Message{
    public int point;
    public Assigned_CC(int x,String name){
        super(name,"Has_reach_point");
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
