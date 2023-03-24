public class Cards {

    private String colour;
    private Position coordinates;

    public Cards(String colour , Position coordinates){
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
