package it.polimi.ingsw.message;

import java.io.Serializable;

public class FinalPointRequest extends Message implements Serializable {

    public FinalPointRequest(String name){
        super(name , "Final_Point_Request");
    }
}
