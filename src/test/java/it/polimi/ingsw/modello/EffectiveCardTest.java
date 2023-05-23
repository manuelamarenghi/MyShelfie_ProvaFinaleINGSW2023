package it.polimi.ingsw.modello;

import it.polimi.ingsw.modello.CommonGoalCard.Col2G;
import it.polimi.ingsw.modello.CommonGoalCard.XGoalCard;
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
  }//
    @Test
    public void checkShow(){
        CommonGoalCards commonGoalCard = new Col2G();
        EffectiveCard effectiveCard = new EffectiveCard(commonGoalCard);
        effectiveCard.show();
    }
    @Test
    public void checkDescription(){
        CommonGoalCards commonGoalCard = new Col2G();
        EffectiveCard effectiveCard = new EffectiveCard(commonGoalCard);
        String desc;
        desc=effectiveCard.description();
        System.out.println(desc);
    }
}