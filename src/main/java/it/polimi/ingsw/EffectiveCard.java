package it.polimi.ingsw;


import java.util.ArrayList;

public class EffectiveCard extends Observer{
    private CommonGoalCards commonCard;
    private ArrayList<Integer> allScores;

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

    public void setAllScores(ArrayList<Integer> scores)
    {
        for( Integer i : scores){
            allScores.add(i);
        }
    }
    public boolean update(Player player){

        if(commonCard.check(player.getLibrary())){
            player.setCommonGoalScore(allScores.get(0));
            allScores.remove(0);
        }
        return commonCard.expired(player.getLibrary());


    }

    public void show(){
        commonCard.getImage();
    }
}
