package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.network.MessageHandler;

import java.io.Serializable;

/**
 * Class to send a message that sends the updated state of the library
 */
public class Updatelibrary extends Message implements Serializable {
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
