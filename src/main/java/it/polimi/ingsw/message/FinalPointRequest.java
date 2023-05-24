package it.polimi.ingsw.message;

import java.io.Serializable;

/**
 * Class to send a message to ask the final point of the player
 */
public class FinalPointRequest extends Message implements Serializable {

    public FinalPointRequest(String name){
        super(name , "Final_Point_Request");
    }
}
