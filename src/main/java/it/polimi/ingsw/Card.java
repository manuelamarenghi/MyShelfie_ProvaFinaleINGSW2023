package it.polimi.ingsw;

import it.polimi.ingsw.Position;

public class Card {

    private String colour;
    private Position coordinates;
    public Card(){
        this.colour="";
        this.coordinates=null;
       }
    public Card(String colour,Position position){
        this.coordinates=position;
        this.colour=colour;
    }


    public String getColour(){
        return colour;}

    public Position getCoordinates(){
        return coordinates;
    }
    public void setCoordinates(Position coordinates) {
        this.coordinates = coordinates;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}
