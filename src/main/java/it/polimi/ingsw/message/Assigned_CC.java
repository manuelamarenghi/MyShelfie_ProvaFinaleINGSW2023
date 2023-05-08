package it.polimi.ingsw.message;


import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.modello.EffectiveCard;
import it.polimi.ingsw.network.MessageHandler;

/**
 * message from server to client when has reach common goal
 */
public class Assigned_CC extends  Message{
    private int point;
    private EffectiveCard card;
    public Assigned_CC(int x, String name, EffectiveCard card){
        super(name,"Has_reach_point");
        this.point=x;
        this.card=card;
    }

    public EffectiveCard getCard() {
        return card;
    }

    public int getPoint() {
        return point;
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }


}
