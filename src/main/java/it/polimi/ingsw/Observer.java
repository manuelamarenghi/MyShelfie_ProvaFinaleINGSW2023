package it.polimi.ingsw;
/**
 * this abstract class is called during a player's turn to check CommonGoalScore
 */

public abstract class Observer {
   /**
    * update() has an override in EffectiveCard where each CommonCard execute its checks
    */
   public abstract boolean update(Player player);
}
