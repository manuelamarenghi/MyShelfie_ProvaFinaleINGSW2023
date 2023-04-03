package it.polimi.ingsw;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Matchmanager{
  /*
   * this class manage actions in a match
   * the match class initialized one of his subclasses according to player's number
   */
  public Matchmanager(){}
  /*
   * results() calculates all players' scores and gives you classification
   */
  public void results(Match m){
    int[] scores=new int[m.getPlayers().length];
    int max=0;
    Player[] p=m.getPlayers();
    int j=0;
    for(Integer i: scores){
      i=p[j].getPlayerManager().showProgressScore(p[j]);
    if(p[j].equals(m.getFirstFinish())){
      System.out.println("You have 1 point from your End Game Token");
      i++;}
    if(i>max){
      max=j;
    }
    System.out.println("Final score for player"+p[j].getNickname()+":"+i);
  }
    j=0;
    int[] position= new int[]{0, 1, 2, 3};
    for (int i = 0; i < 4; ++i) {
      int key = scores[i];
      while(j!=4 && key>scores[j]){
        int temp=position[i];
        position[i]=position[j];
        position[j]=temp;
        temp=scores[j];
        scores[j]=scores[i];
        scores[i]=temp;
        j++;
      }
    }
    System.out.println("Classification:");
    for(int i: position){
      System.out.println(4-i+"-"+p[i].getNickname());
    }
    System.out.println("The winner is:"+p[max].getNickname());
  }
  /*
   * checkState() returns the state of a player's connection
   */
  public Boolean checkState(Player p){return null;};
  /*
   * turn() manage a player's turn
   */
  public void turn(Player p,Match m){
    Scanner in=new Scanner(System.in);
    System.out.println(p.getNickname()+"turn:");
     m.getBoard().showBoard();
    System.out.println("Insert 1 to see CommonCards, 0 to go ahead:");
     int a=in.nextInt();
     if(a==1){  this.showCommGoal(m);
        }
    System.out.println("Insert 2 to see PersonalCards, 0 to go ahead:");
    a=in.nextInt();
    if(a==2){  p.getPersonalCard().showPersonalGoalCard();
    }
    System.out.println("Insert -1 to skip your turn:");
    a=in.nextInt();
    if(a!=-1) {
      p.getLibrary().showLibrary();
      p.getPlayerManager().selectCard(p, m.getBoard());
      p.getLibrary().showLibrary();
      int i = 0;
      for (Card c : p.getLibrary()) {
        if (c.getColour() == null) {
          break;
        } else {
          i++;
        }
      }
      if (i == 30) {
        m.setFirstFinish(p);
        System.out.println("Your library is full, the game continues until the player sitting to the right to the player holding the first player seat");
      }
    }
  }
  /*
   * showCommGoal() let you see CommonCards in a given match
   */
  public void showCommGoal(Match match){
    EffectiveCard[]  cards=match.getCommonCards();
    cards[0].getCommonCard().getImage();
    cards[1].getCommonCard().getImage();
  }
  /*
   * createBoard() create a board with different allowed position according to number of players
   */
  public abstract void createBoard(Match m);
  /*
   * setEffectiveCards() choose two card per match
   */
  public abstract void setEffectiveCards(Match m);
}
