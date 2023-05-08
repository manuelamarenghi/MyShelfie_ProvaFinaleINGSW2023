package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.network.MessageHandler;

public class Updatelibrary extends Message{
    Library l;
    public Updatelibrary(Library l,String name){
        super(name,"library_changed");
        this.l=l;
    }
    public Library getL() {
        return l;
    }
    public void visit(MessageHandler controller){
        controller.handle(this);
    }
}
