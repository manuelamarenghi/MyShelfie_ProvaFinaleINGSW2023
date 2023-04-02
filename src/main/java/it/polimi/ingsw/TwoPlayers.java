package it.polimi.ingsw;

public class TwoPlayers extends Matchmanager{

    @Override
    public void calcPoint(Player p) {

    }

    @Override
    public Boolean checkState(Player p) {
        return null;
    }

    /*
     * createBoard() create new Board giving number of players to the constructor, that initialize the right places
     */
    @Override
    public void createBoard(Match m) {
        Board b=new Board(2);
        m.setBoard(b);
    }

    @Override
    public void setEffectivecards(Match m) {

    }
}
