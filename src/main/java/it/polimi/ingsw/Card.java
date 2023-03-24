package it.polimi.ingsw;

public class Card {

    private String colour;
    private Position coordinates;

    public Card(String colour){
        this.colour=colour;
    }
    public void setCoordinates(Position coordinatesParametre){
        coordinates=coordinatesParametre; //Coordinates to be set at the value passed as parametre in the method
    }

    public String getColour(){
        return colour;
    }
    public Position getCoordinates(){
        return coordinates;
    }
}
