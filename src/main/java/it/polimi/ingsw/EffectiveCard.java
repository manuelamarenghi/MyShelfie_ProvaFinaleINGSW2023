<<<<<<< HEAD
package it.polimi.ingsw.CommonGoalCard;

import it.polimi.ingsw.CommonGoalCard.CommonGoalCards;
=======
package it.polimi.ingsw;

import it.polimi.ingsw.CommonGoalCards;
>>>>>>> faa7c6a (Start implementation of CGC with EightEqualsCards)

public class EffectiveCard {
    private CommonGoalCards commonCard;
    private int[] allScores;

<<<<<<< HEAD
    public EffectiveCard(CommonGoalCards commoncard ){
        this.commonCard = commoncard;
    }

    public void update(Player player){
        commonCard.check(player.getLibrary());
        commonCard.expired(player);
    }

    public void show(){
        commonCard.getImage();
    }
=======
>>>>>>> faa7c6a (Start implementation of CGC with EightEqualsCards)
}
