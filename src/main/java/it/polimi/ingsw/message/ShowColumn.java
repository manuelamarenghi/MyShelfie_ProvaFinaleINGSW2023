package it.polimi.ingsw.message;

/**
 * response to a modify on the board and request for column in library selectable
 */
public class ShowColumn extends Message{
    int[] x;
    public ShowColumn(String name,int[] x){
        super(name,"selectable_column");
        this.x=x;
    }
    public int[] getX() {
        return x;
    }
}
