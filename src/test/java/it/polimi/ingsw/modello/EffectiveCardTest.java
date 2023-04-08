package it.polimi.ingsw.modello;

import it.polimi.ingsw.modello.CommonGoalCard.CommonGoalCard.XGoalCard;
import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.EffectiveCard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EffectiveCardTest {
@Test
    void checkIfWork(){
    CommonGoalCards cgc=new XGoalCard();
    EffectiveCard effectiveCard=new EffectiveCard(cgc);
    ArrayList<Integer> al=new ArrayList<>();
    al.add(1);
    al.add(1);
    al.add(1);
    al.add(1);
    al.add(1);
    effectiveCard.setAllScores(al);
    al=effectiveCard.getAllScores();
    al.add(1);
    assertNotSame(effectiveCard.getAllScores(), al);
  }
}