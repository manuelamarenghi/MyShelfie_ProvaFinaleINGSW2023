package it.polimi.ingsw;

import it.polimi.ingsw.Position;

public class Card {

    private String colour;
    private Position coordinates;
    private int visited;
    public Card(){
        this.colour="";
        this.coordinates=null;}
    public Card(String colour,Position position){
        this.coordinates=position;
        this.colour=colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setCoordinates(Position coordinates) {
        this.coordinates = coordinates;
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

    public void setVisited(int visited) {
        this.visited = visited;
    }
}
