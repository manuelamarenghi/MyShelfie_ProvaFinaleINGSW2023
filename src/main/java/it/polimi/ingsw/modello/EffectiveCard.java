package it.polimi.ingsw.modello;


import it.polimi.ingsw.message.Assigned_CC;
import it.polimi.ingsw.network.observer.Observable;
import it.polimi.ingsw.network.observer.Observer;

import java.util.ArrayList;
import java.util.Collections;

public class EffectiveCard extends Observable implements ObserverCC{
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
        ArrayList<Integer>tmp=new ArrayList<>();
        Collections.copy(this.allScores,tmp);
        return tmp;
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
            notifyObserver(new Assigned_CC(allScores.get(0), player.getNickname(),this));
            allScores.remove(0);
        }
        return commonCard.expired(player.getLibrary());

    }

    public void show(){
        commonCard.getImage();
    }
}
