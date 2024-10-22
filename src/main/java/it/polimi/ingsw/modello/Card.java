package it.polimi.ingsw.modello;

import java.io.Serializable;

/**
 * this class creates items for the game
 */
public class Card implements Serializable {

    private String colour;
    private Position coordinates;

    /**
     * this constructor initialize an empty place in library or board
     */
    public Card() {
        this.colour = "";
        this.coordinates = null;
    }

    public Card(String colour) {
        this.colour = colour;
    }

    /**
     * this constructor initialize a card in a determinate position
     */
    public Card(String colour, Position position) {
        this.coordinates = position;
        this.colour = colour;
    }


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
        if (colour == null) return;

    }

    public Position getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Position coordinates) {
        this.coordinates = coordinates;
    }

}
