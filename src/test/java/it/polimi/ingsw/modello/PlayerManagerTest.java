package it.polimi.ingsw.modello;

import it.polimi.ingsw.modello.CommonGoalCard.CornersCommG;
import it.polimi.ingsw.modello.CommonGoalCard.XGoalCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerManagerTest {
    /*private Player player;
    @Test
    public void checkSelectCardPutsCardsInLibrary(){
        Board board = new Board(2);
        board.fill();
        player.getPlayerManager().selectCard(player,board);
        player.getLibrary().showLibrary();
    }*/

    /**
     * Test one card in correct position
     */
    @Test
    public void calcPersonalPointTest(){
        Card[] cards = new Card[6];
        Card card1= new Card("B",new Position(5,0));
        Card card2= new Card("Y",new Position(4,1));
        Card card3= new Card("G",new Position(5,1));
        Card card4= new Card("F",new Position(3,2));
        Card card5= new Card("R",new Position(4,3));
        Card card6= new Card("R",new Position(5,4));


        cards[0] = card1;
        cards[1] = card2;
        cards[2] = card3;
        cards[3] = card4;
        cards[4] = card5;
        cards[5] = card6;

        Player player = new Player("pippo");
        PersonalGoalCard personalGoalCard = new PersonalGoalCard(cards);
        player.setPersonalCard(personalGoalCard);

        Library library = new Library();
        ArrayList<Card> c = new ArrayList<>();
        c.add(new Card("B",new Position(4,1)));
        library.setColumn(c,0);
        player.setLibrary(library);

        Assertions.assertEquals(1,player.getPlayerManager().showPersonalPoint(player));

    }

    /**
     * Test two card in correct position
     */
    @Test
    public void calcPersonalPointTest2(){
        Card[] cards = new Card[6];
        Card card1= new Card("B",new Position(5,0));
        Card card2= new Card("Y",new Position(4,1));
        Card card3= new Card("G",new Position(5,1));
        Card card4= new Card("F",new Position(3,2));
        Card card5= new Card("R",new Position(4,3));
        Card card6= new Card("R",new Position(5,4));


        cards[0] = card1;
        cards[1] = card2;
        cards[2] = card3;
        cards[3] = card4;
        cards[4] = card5;
        cards[5] = card6;

        Player player = new Player("pippo");
        PersonalGoalCard personalGoalCard = new PersonalGoalCard(cards);
        player.setPersonalCard(personalGoalCard);

        Library library = new Library();
        ArrayList<Card> c = new ArrayList<>();
        c.add(card1);
        ArrayList<Card> c1= new ArrayList<>();
        c1.add(card1);
        c1.add(card2);
        library.setColumn(c,0);
        library.setColumn(c1,1);
        player.setLibrary(library);

        Assertions.assertEquals(2,player.getPlayerManager().showPersonalPoint(player));

    }
    /**
     * Test 3 card in correct position
     *
     */
    @Test
    public void calcPerosonalPointTest3(){
        Card[] cards = new Card[6];
        Card card1= new Card("B",new Position(5,0));
        Card card2= new Card("Y",new Position(4,1));
        Card card3= new Card("G",new Position(5,1));
        Card card4= new Card("F",new Position(3,2));
        Card card5= new Card("R",new Position(4,3));
        Card card6= new Card("R",new Position(5,4));


        cards[0] = card1;
        cards[1] = card2;
        cards[2] = card3;
        cards[3] = card4;
        cards[4] = card5;
        cards[5] = card6;

        Player player = new Player("pippo");
        PersonalGoalCard personalGoalCard = new PersonalGoalCard(cards);
        player.setPersonalCard(personalGoalCard);

        Library library = new Library();
        ArrayList<Card> c = new ArrayList<>();
        c.add(card1);
        ArrayList<Card> c1= new ArrayList<>();
        c1.add(card3);
        c1.add(card2);
        library.setColumn(c,0);
        library.setColumn(c1,1);
        player.setLibrary(library);

        Assertions.assertEquals(4,player.getPlayerManager().showPersonalPoint(player));

    }

    @Test
    public void calcPointTest(){
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

        Player player = new Player("pippo");
        PersonalGoalCard personalGoalCard = new PersonalGoalCard(cards);
        player.setPersonalCard(personalGoalCard);


        Library library = new Library();
        library.getCardinPos(5,0).setColour("V");
        library.getCardinPos(4,0).setColour("G");
        library.getCardinPos(3,0).setColour("G");
        library.getCardinPos(5,1).setColour("V");
        library.getCardinPos(4,1).setColour("B");
        library.getCardinPos(3,1).setColour("V");
        library.getCardinPos(5,2).setColour("V");
        library.getCardinPos(4,2).setColour("V");
        library.getCardinPos(5,3).setColour("V");
        library.getCardinPos(4,3).setColour("V");
        library.getCardinPos(3,3).setColour("V");



        player.setLibrary(library);

        Assertions.assertEquals(10,player.getPlayerManager().showProgressScore(player));

    }
/*
Commentato per il problema della view
    @Test
    public void calcCommonCardTest(){
        Match m = new Match();
        m.setMatch(2);
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
        m.setCommonCards(e);

        Player player = new Player("pippo");
        player.addObserver(c1);
        player.addObserver(c2);
        m.setPlayers(player);

        Library library = new Library();
        library.getCardinPos(0,0).setColour("V");
        library.getCardinPos(5,0).setColour("V");
        library.getCardinPos(0,4).setColour("V");
        library.getCardinPos(5,4).setColour("V");

        player.setLibrary(library);
        player.getPlayerManager().notifyAllObservers(player);

        Assertions.assertEquals(8,player.getCommonGoalScore());


    }
*/
    @Test
    public void checkShowPersonalGoal(){
        Card[] cards=new Card[6];
        cards[0]=new Card("lightBlue",new Position(1,1));
        cards[1]=new Card("white",new Position(2,2));
        cards[2]=new Card("blue",new Position(3,3));
        cards[3]=new Card("green",new Position(4,2));
        cards[4] = new Card("yellow", new Position(4, 4));
        cards[5] = new Card("pink", new Position(3, 4));
        PersonalGoalCard personalGoalCard = new PersonalGoalCard(cards);
        Player player = new Player("Lovish");
        player.setPersonalCard(personalGoalCard);
        player.getPlayerManager().showPersonalGoal(player);
    }
}