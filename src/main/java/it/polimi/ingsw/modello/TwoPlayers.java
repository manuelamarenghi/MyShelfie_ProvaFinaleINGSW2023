package it.polimi.ingsw.modello;

import it.polimi.ingsw.modello.CommonGoalCard.*;


import java.util.ArrayList;

public class TwoPlayers extends Matchmanager {
    public TwoPlayers(Match m){
        super(m);
    }
    /**
     * createBoard() create new Board giving number of players to the constructor, that initialize the right places
     */
    @Override
    public void createBoard(Match m) {
        Board b=new Board(2);
        m.setBoard(b);
    }
    /**
     * setEffectiveCards() setting EffectiveCards choosing randomly in CommonCards of the match and their scores based on number of players
     */
    @Override
    public void setEffectiveCards(Match m) {
        ArrayList<Integer> score=new ArrayList<>();
        ArrayList<CommonGoalCards> l=new ArrayList<>();
        EffectiveCard[] chosen=new EffectiveCard[2];
        l.add(new Col2G());
        l.add(new CornersCommG());
        l.add(new Diagonal5CardG());
        l.add(new DoubleCommG());
        l.add(new EightEqualsCards());
        l.add(new Line4G());
        l.add(new Same4GroupsG());
        l.add(new Col3G());
        l.add(new Line2G());
        l.add(new Square2G());
        l.add(new StairsGoalCard());
        l.add(new XGoalCard());
        score.add(8);
        score.add(4);
        int i,j;
        i=(int)Math.floor(Math.random() * (12) );
        do {
            j=(int)Math.floor(Math.random() * (12) );
        }while(i==j);
        chosen[0]=new EffectiveCard(l.get(i));
        chosen[0].setAllScores(score);
        chosen[1]=new EffectiveCard(l.get(j));
        chosen[1].setAllScores(score);
        m.setCommonCards(chosen);
    }
}
