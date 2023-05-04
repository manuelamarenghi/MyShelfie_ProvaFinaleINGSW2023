package it.polimi.ingsw.message;

import it.polimi.ingsw.modello.Library;

public class Updatelibrary extends Message{
    Library l;
    public Updatelibrary(Library l,String name){
        super(name,"library_changed");
        this.l=l;
    }
    public Library getL() {
        return l;
    }
}
