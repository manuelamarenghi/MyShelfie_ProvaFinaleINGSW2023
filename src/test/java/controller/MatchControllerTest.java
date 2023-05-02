package controller;


import it.polimi.ingsw.message.Numb_Player;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.Controller.MatchController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class MatchControllerTest {

    private Match match;
    private MatchController matchController;

    String p1="pippo";
    String p2="pluto";
    String p3="paperino";


    @Test
    public void receveidNumPlayer(){
        matchController = new MatchController();
        Numb_Player numberPlayer = new Numb_Player(3,p1);
        matchController.messageHandler(numberPlayer);
        Assertions.assertEquals(3,matchController.getMatch().getPlayerNumber());
        Assertions.assertEquals(3,matchController.getNumberOfPlayers());


    }
}
