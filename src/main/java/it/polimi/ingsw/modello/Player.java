package it.polimi.ingsw.modello;

import it.polimi.ingsw.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is used to create instance of players without managing their logic
 */
public class Player implements Serializable {
    private String nickname;
    private int commonGoalScore ;
    private List<ObserverCC> observers;
    private Library library;
    private boolean state;
    private PersonalGoalCard personalCard;
    private PlayerManager plManag;
    private View view;

    public Player(String nickname){
        this.nickname = nickname;
        plManag = new PlayerManager();
        library = new Library();
        observers = new ArrayList<>();
    }

    public String getNickname(){
        return  nickname;
    }

    public int getCommonGoalScore(){
        return commonGoalScore;
    }
    public List<ObserverCC> getObservers(){
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
        this.commonGoalScore += score;

    }

    public void addObserver(ObserverCC observer)
    {
        observers.add(observer);
    }
    public void removeObserver(ObserverCC observer){
        observers.remove(observer);
    }

    public void setState(boolean state){
        this.state = state;
    }

    public PlayerManager getPlayerManager(){
        return plManag;
    }

    public View getView() {
        return view;
    }
    public void setView(View view) {
        this.view = view;
    }

    public void setLibrary(Library library) {
        this.library=library;
    }
}
