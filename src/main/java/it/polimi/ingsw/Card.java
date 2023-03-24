package it.polimi.ingsw;

public class Card {

    private String colour;
    private Position coordinates;

    public Card(String colour , Position coordinates){
        this.colour=colour;
        this.coordinates=coordinates;
    }

    public String getColour(){
        return colour;
    }
    public Position getCoordinates(){
        return coordinates;
    }
}
