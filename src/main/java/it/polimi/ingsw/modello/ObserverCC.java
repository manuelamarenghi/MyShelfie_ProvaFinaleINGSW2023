package it.polimi.ingsw.modello;

import java.io.Serializable;

/**
 * this abstract class is called during a player's turn to check CommonGoalScore
 */

public interface ObserverCC extends Serializable {
   /**
    * update() has an override in EffectiveCard where each CommonCard execute its checks
    */
    boolean update(Player player);
}
