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
   * calcPoint() calculates and returns final point of a player
   */
  public int calcPoint(Player p,Match m){
    int score=p.getCommonGoalScore();
    System.out.println("Your score starts from your CommonCards' score:"+score);
    // calculate personalgoalcard's achievment and its score
    System.out.println("You achieve from your PersonalGoalCard:");
    // calculate scores about adjacent items
    System.out.println("You achieve from your adjacent items:");
    ArrayList<Integer> groups=p.getLibrary().getgroup();
    for(Integer i: groups){
      if(i==3){
        System.out.println("items"+i+" score: 2");
        score+=2;}
      if(i==4){
        System.out.println("items"+i+" score: 3");
        score+=3;}
      if(i==5){
        System.out.println("items"+i+" score: 5");
        score+=5;}
      if(i>6){
        System.out.println("items"+i+" score: 6");
        score+=8;}
    }
    if(p.equals(m.getFirstFinish())){
      System.out.println("You have 1 point from your End Game Token");
      score++;}
    System.out.println("Final score:"+score);
    return score;
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
     if(a==1){  //mostra commoncard
        }
    System.out.println("Insert 2 to see PersonalCards, 0 to go ahead:");
    a=in.nextInt();
    if(a==2){  //mostra personalcard
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
   * createBoard() create a board with different allowed position according to number of players
   */
  public abstract void createBoard(Match m);
  /*
   * setEffectiveCards() choose two card per match
   */
  public abstract void setEffectiveCards(Match m);
}
