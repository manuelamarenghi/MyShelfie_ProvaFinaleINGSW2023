package it.polimi.ingsw;

abstract class Matchmanager{
  public Matchmanager(){}
  public abstract void calcPoint(Player p);
  public abstract Boolean checkState(Player p);
  public abstract Player turn(Player p);
  public abstract void createBoard(Match m);
  public abstract void setEffectivecards(Match m);
}
