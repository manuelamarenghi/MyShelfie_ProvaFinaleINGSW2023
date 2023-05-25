package it.polimi.ingsw.modello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoPlayersTest {
    @Test
    public void checkCreateBoard() {
        Matchmanager matchmanager = new TwoPlayers();
        Match m = new Match();
        matchmanager.createBoard(m);
        m.getBoard().fill(0);
        m.getBoard().showBoard();
    }

    @Test
    public void checkSetEffectiveCards() {
        Matchmanager matchmanager = new TwoPlayers();
        Match m = new Match();
        matchmanager.setEffectiveCards(m);
        EffectiveCard[] effectiveCards = {};
        effectiveCards = m.getCommonCards();
        assertEquals(2, effectiveCards.length);
    }
}