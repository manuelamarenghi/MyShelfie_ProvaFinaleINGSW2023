package it.polimi.ingsw;

import java.util.List;

public class Player {
    private String nickname;
    private int commonGoalScore ;
    private List<Observer> observers;
    private Library library;
    private boolean state;
    private PersonalGoalCard personalCard;
    //private PlayerManager plManag;

    public String getNickname(){
        return  nickname;
    }

    public int getCommonGoalScore(){
        return commonGoalScore;
    }
    public List<Observer> getObservers(){
        return observers;
    }
    public Library getLibrary(){
        return  library;
    }
    public boolean getState(){
        return state;
    }
}
