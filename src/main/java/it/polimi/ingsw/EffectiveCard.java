package it.polimi.ingsw;


<<<<<<< HEAD
import it.polimi.ingsw.CommonGoalCard.CommonGoalCards;
=======

>>>>>>> origin/testb

public class EffectiveCard extends Observer{
    private CommonGoalCards commonCard;
    private int[] allScores;

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
}
