package it.polimi.ingsw;

import it.polimi.ingsw.Position;

public class Card {

    private String colour;
    private Position coordinates;
    private boolean visited;
    public Card(){
        this.colour="";
        this.coordinates=null;
        this.visited=false;}
    public Card(String colour,Position position){
        this.coordinates=position;
        this.colour=colour;
        this.visited=false;
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
        if(colour == null) return;

    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean getVisited() {
        return visited;
    }
}
