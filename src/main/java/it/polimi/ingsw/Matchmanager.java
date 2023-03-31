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
  public abstract void calcPoint(Player p);
  /*
   * checkState() returns the state of a player's connection
   */
  public abstract Boolean checkState(Player p);
  /*
   * turn() manage a player's turn
   */
  public abstract void turn(Player p);
  /*
   * createBoard() create a board with different allowed position according to number of players
   */
  public abstract void createBoard(Match m);
  /*
   * setEffectivecards() choose two card per match
   */
  public abstract void setEffectivecards(Match m);
}
