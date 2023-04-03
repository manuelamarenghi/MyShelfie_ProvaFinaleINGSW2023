package it.polimi.ingsw;
/**
 *  this interface is used to override check(),expired(),getImage() for each CommonGoal card
 */
public interface CommonGoalCards {
    /**
     * check() returns true if the library match the goal,otherwise false
     */
    public boolean check(Library library);
    /**
     * expired() let you know if the player can still reach the goal or not
     */
    public boolean expired(Library library);
    /**
     * getImage() let you see this goal
     */
    public void getImage();

}