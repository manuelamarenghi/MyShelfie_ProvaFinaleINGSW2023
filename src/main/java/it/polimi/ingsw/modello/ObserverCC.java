package it.polimi.ingsw.modello;

/**
 * this abstract class is called during a player's turn to check CommonGoalScore
 */

public interface ObserverCC {
   /**
    * update() has an override in EffectiveCard where each CommonCard execute its checks
    */
    boolean update(Player player);
}
