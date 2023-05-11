package it.polimi.ingsw.modello;

import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.PersonalGoalCard;
import it.polimi.ingsw.modello.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalGoalCardTest {

    @Test
    void getPersonalObjectiveCorrectFromOfReturningTheArrayCoordinates(){
        Card[] cards=new Card[6];
        cards[0]=new Card("lightblue",new Position(1,1));
        cards[1]=new Card("white",new Position(2,2));
        cards[2]=new Card("blue",new Position(3,3));
        cards[3]=new Card("green",new Position(4,5));
        cards[4]=new Card("yellow",new Position(4,6));
        cards[5]=new Card("pink",new Position(3,4));
        PersonalGoalCard personalGoalCard=new PersonalGoalCard(cards);
        assertEquals(cards[0].getCoordinates(),personalGoalCard.getPersonalObjective()[0].getCoordinates());
        assertEquals(cards[1].getCoordinates(),personalGoalCard.getPersonalObjective()[1].getCoordinates());
        assertEquals(cards[2].getCoordinates(),personalGoalCard.getPersonalObjective()[2].getCoordinates());
        assertEquals(cards[3].getCoordinates(),personalGoalCard.getPersonalObjective()[3].getCoordinates());
        assertEquals(cards[4].getCoordinates(),personalGoalCard.getPersonalObjective()[4].getCoordinates());
        assertEquals(cards[5].getCoordinates(),personalGoalCard.getPersonalObjective()[5].getCoordinates());


    }  @Test
    void getPersonalObjectiveCorrectFromOfReturningTheArrayColors(){
        Card[] cards=new Card[6];
        cards[0]=new Card("lightblue",new Position(1,1));
        cards[1]=new Card("white",new Position(2,2));
        cards[2]=new Card("blue",new Position(3,3));
        cards[3]=new Card("green",new Position(4,5));
        cards[4]=new Card("yellow",new Position(4,6));
        cards[5]=new Card("pink",new Position(3,4));
        PersonalGoalCard personalGoalCard=new PersonalGoalCard(cards);
        assertEquals(cards[0].getColour(),personalGoalCard.getPersonalObjective()[0].getColour());
        assertEquals(cards[1].getColour(),personalGoalCard.getPersonalObjective()[1].getColour());
        assertEquals(cards[2].getColour(),personalGoalCard.getPersonalObjective()[2].getColour());
        assertEquals(cards[3].getColour(),personalGoalCard.getPersonalObjective()[3].getColour());
        assertEquals(cards[4].getColour(),personalGoalCard.getPersonalObjective()[4].getColour());
        assertEquals(cards[5].getColour(),personalGoalCard.getPersonalObjective()[5].getColour());
    }
    @Test
    public void showCardTest(){
        Card[] cards=new Card[6];
        cards[0]=new Card("lightBlue",new Position(1,1));
        cards[1]=new Card("white",new Position(2,2));
        cards[2]=new Card("blue",new Position(3,3));
        cards[3]=new Card("green",new Position(4,3));
        cards[4]=new Card("yellow",new Position(5,4));
        cards[5]=new Card("pink",new Position(3,4));
        PersonalGoalCard personalGoalCard=new PersonalGoalCard(cards);
        personalGoalCard.showPersonalGoalCard();
    }

}