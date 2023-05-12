package it.polimi.ingsw.modello;

import java.io.Serializable;

/**
 *  this interface is used to override check(),expired(),getImage() for each CommonGoal card
 */
public interface CommonGoalCards extends Serializable {
    /**
     * check() returns true if the library match the goal,otherwise false
     */
    public boolean check(Library library);
    /**
     * expired() let you know if the player can still reach the goal or not
     */
    public boolean expired(Library library);
    /**
     * showCommonCard() let you see this goal
     */
    public void showCommonCard();

    /**
     * getDesc() can read the common goal card description
     * @return
     */
    public String getDesc();


}