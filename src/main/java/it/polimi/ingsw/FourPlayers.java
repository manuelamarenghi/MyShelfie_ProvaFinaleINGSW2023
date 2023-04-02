package it.polimi.ingsw;

public class FourPlayers extends Matchmanager{

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
        Board b=new Board(4);
        m.setBoard(b);
    }

    @Override
    public void setEffectivecards(Match m) {

    }
}
