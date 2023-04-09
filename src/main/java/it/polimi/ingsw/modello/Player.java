package it.polimi.ingsw.modello;

import java.util.List;

/**
 * this class is used to create instance of players without managing their logic
 */
public class Player {
    private String nickname;
    private int commonGoalScore ;
    private List<Observer> observers;
    private Library library;
    private boolean state;
    private PersonalGoalCard personalCard;
    private PlayerManager plManag;

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

    public PersonalGoalCard getPersonalCard(){return personalCard;}
    public void setPersonalCard(PersonalGoalCard personalCard){
        this.personalCard=new PersonalGoalCard(personalCard.getPersonalObjective());
    }

    public void setNickname(String nickname){
        this.nickname= nickname;
    }

    public void setCommonGoalScore(int score){
        this.commonGoalScore=score;
    }

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void setState(boolean state){
        this.state = state;
    }

    public PlayerManager getPlayerManager(){
        return plManag;
    }
}
