package it.polimi.ingsw.modello;

import it.polimi.ingsw.modello.CommonGoalCard.CornersCommG;
import it.polimi.ingsw.modello.CommonGoalCard.XGoalCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchManagerTest {

    @Test
    public void resultsTest(){

        Match match = new Match();
        match.setMatch(2);


        match.setPlayers(new Player("pippo"));
        match.setPlayers(new Player("pluto"));

        Library library1 = new Library();
        Library library2 = new Library();

        XGoalCard xGoalCard = new XGoalCard();
        CornersCommG cornersCommG = new CornersCommG();
        EffectiveCard c1 = new EffectiveCard(xGoalCard);
        EffectiveCard c2 = new EffectiveCard(cornersCommG);

        ArrayList<Integer> score = new ArrayList<>();
        score.add(8);
        score.add(4);
        c1.setAllScores(score);
        c2.setAllScores(score);

        EffectiveCard[] e = new EffectiveCard[2];
        e[0] = c1;
        e[1] = c2;
        match.setCommonCards(e);


        Card[] cards = new Card[6];
        Card card1= new Card("V",new Position(5,0));
        Card card2= new Card("G",new Position(4,0));
        Card card3= new Card("F",new Position(5,1));
        Card card4= new Card("F",new Position(3,2));
        Card card5= new Card("F",new Position(4,3));
        Card card6= new Card("F",new Position(5,4));


        cards[0] = card1;
        cards[1] = card2;
        cards[2] = card3;
        cards[3] = card4;
        cards[4] = card5;
        cards[5] = card6;

        PersonalGoalCard personalGoalCard = new PersonalGoalCard(cards);
        match.getPlayerByNickname("pippo").setPersonalCard(personalGoalCard);
        match.getPlayerByNickname("pluto").setPersonalCard(personalGoalCard);

        library1.getCardinPos(0,0).setColour("V");
        library1.getCardinPos(5,0).setColour("V");
        library1.getCardinPos(0,4).setColour("V");
        library1.getCardinPos(5,4).setColour("V");

        match.getPlayerByNickname("pippo").setLibrary(library1);
        match.getPlayerByNickname("pippo").getPlayerManager().notifyAllObservers(match.getPlayerByNickname("pippo"));

        HashMap<String,Integer> expected = new HashMap<>();
        expected.put("pippo",9);
        expected.put("pluto",0);

        Assertions.assertEquals(expected,match.getMatchmanager().results(match));

    }

    /**
     * only read personal card
     * check the correct assignment of personal Card
     */
    @Test
    public void setPersonalCardTest(){
        Match match = new Match();
        match.setMatch(3);
        match.setPlayers(new Player("pippo"));
        match.setPlayers(new Player("pluto"));
        match.setPlayers(new Player("paperino"));

        match.getMatchmanager().setPersonalGoal(match.getPlayers());
        for(Player p: match.getPlayers())
        {
            p.getPersonalCard().showPersonalGoalCard();
        }
    }

    @Test
    public void emptyBoardTest(){
        Match match = new Match();
        match.setMatch(2);
        match.setBoard(new Board(2));

        match.getMatchmanager().IsEmptyBoard(match);
        match.getBoard().showBoard();
    }

}
