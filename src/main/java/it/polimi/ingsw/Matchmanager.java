package it.polimi.ingsw;

abstract class Matchmanager{
  /*
   * this class manage actions in a match
   * the match class initialized one of his subclasses according to player's number
   */
  public Matchmanager(){}
  /*
   * calcPoint() calculates and shows final point of a player
   */
  public int calcPoint(Player p){
    return 0;
  }
  /*
   * checkState() returns the state of a player's connection
   */
  public Boolean checkState(Player p){return null;};
  /*
   * turn() manage a player's turn
   */
  public void turn(Player p){

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
