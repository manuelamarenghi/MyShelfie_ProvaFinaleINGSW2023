package it.polimi.ingsw.message;

import it.polimi.ingsw.network.MessageHandler;

public class Receiving_Mex extends Message {
    public String dest;
    public String mex;

    public Receiving_Mex(String s, String name, String dest) {
        super(name, "Mex_from");
        this.mex = s;
        this.dest = dest;
    }

    public String getMex() {
        return mex;
    }

    public String getDest() {
        return dest;
    }

    public void visit(MessageHandler controller) {
        controller.handle(this);
    }
}
