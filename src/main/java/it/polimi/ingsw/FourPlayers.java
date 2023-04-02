package it.polimi.ingsw;

import it.polimi.ingsw.CommonGoalCard.*;

import java.util.ArrayList;

public class FourPlayers extends Matchmanager{

    @Override
    public void calcPoint(Player p) {

    }
    /*
     * createBoard() create new Board giving number of players to the constructor, that initialize the right places
     */
    @Override
    public void createBoard(Match m) {
        Board b=new Board(4);
        m.setBoard(b);
    }
    /*
     * setEffectiveCards() setting EffectiveCards choosing randomly in CommonCards of the match and their scores based on number of players
     */
    @Override
    public void setEffectiveCards(Match m) {
        ArrayList<Integer> points= new ArrayList<>();
        ArrayList<CommonGoalCards> l=new ArrayList<>();
        EffectiveCard[] chosen=new EffectiveCard[2];
        l.add(new Col2G());
        l.add(new CornersCommG());
        l.add(new Diagonal5CardG());
        l.add(new DoubleCommG());
        l.add(new EightEqualsCards());
        l.add(new Line4G());
        l.add(new Same4GroupsG());
        points.add(8);
        points.add(6);
        points.add(4);
        points.add(2);
        int i,j;
        i=(int)Math.floor(Math.random() * (7) );
        do {
            j=(int)Math.floor(Math.random() * (7) );
        }while(i==j);
        chosen[0]=new EffectiveCard(l.get(i));
        chosen[0].setAllScores(points);
        chosen[1]=new EffectiveCard(l.get(j));
        chosen[1].setAllScores(points);
        m.setCommonCards(chosen);
    }
}
