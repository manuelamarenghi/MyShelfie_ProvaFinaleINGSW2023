package it.polimi.ingsw.modello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * this class tests setEffectiveCards and createBoard in FourPlayers' version of the game
 */
class FourPlayersTest {
    /*
     * setEffectiveCards() to see if it does the right assignments

    @Test
    void setEffectiveCards() {
       Match m=new Match(4);
       m.getMatchmanager().setEffectiveCards(m);
       EffectiveCard[] e=m.getCommonCards();
       System.out.println("Le carte di questa manche sono: ");
        e[0].getCommonCard().getImage();
        e[1].getCommonCard().getImage();
        System.out.println("I punteggi sono: "+e[0].getAllScores());
    }

     * createBoard() to check if it's the right dimension of board

    @Test
    void createBoard() {
        Match m=new Match(4);
        m.getMatchmanager().createBoard(m);
        m.getBoard().showBoard();
    }*/
    @Test
    public void checkCreateBoard() {
        Matchmanager matchmanager = new FourPlayers();
        Match m = new Match();
        matchmanager.createBoard(m);
        m.getBoard().fill(0);
        m.getBoard().showBoard();
    }

    @Test
    public void checkSetEffectiveCards() {
        Matchmanager matchmanager = new FourPlayers();
        Match m = new Match();
        matchmanager.setEffectiveCards(m);
        EffectiveCard[] effectiveCards = {};
        effectiveCards = m.getCommonCards();
        assertEquals(2, effectiveCards.length);
    }

}