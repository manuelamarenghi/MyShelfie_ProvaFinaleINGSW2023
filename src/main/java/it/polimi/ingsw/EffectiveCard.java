package it.polimi.ingsw;


import java.util.ArrayList;
/**
 *  this class extends observer and represents real CommonGoal cards
 */
public class EffectiveCard extends Observer{
    private CommonGoalCards commonCard;
    private ArrayList<Integer> allScores;
    /**
     *  the constructor takes a CommonGoal card that represents the goal of the effective card
     */
    public EffectiveCard(CommonGoalCards commonCard ){

        this.commonCard = commonCard;
        allScores =new ArrayList<Integer>();
    }
    public CommonGoalCards getCommonCard(){
        return commonCard;
    }

    public ArrayList<Integer> getAllScores(){
        return  allScores;
    }
    /**
     *  setAllScores() based on numbers of players has different size and elements
     */
    public void setAllScores(ArrayList<Integer> scores)
    {
        for( Integer i : scores){
            allScores.add(i);
        }
    }
    /**
     *  update() is called during a turn to check if the goal is reached and if the library can still reach it
     */
    public boolean update(Player player){

        if(commonCard.check(player.getLibrary())){
            player.setCommonGoalScore(allScores.get(0));
            allScores.remove(0);
        }
        return commonCard.expired(player.getLibrary());


    }
    /**
     *  show() let you see an example of library that has reached the goal
     */
    public void show(){
        commonCard.getImage();
    }
}
