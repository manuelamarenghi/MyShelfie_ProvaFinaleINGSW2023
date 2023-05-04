package it.polimi.ingsw.view;

import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.EffectiveCard;
import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.modello.Match;

import java.io.PrintStream;

public class Cli implements View{
    private final PrintStream out;

    /**
     * Default constructor.
     */
    public Cli() {
        out = System.out;
    }
    /**
     * init_game() entering interface CLI version
     */
    public void init_game(){

    }
    /**
     * askNickname() called by init_game() this method ask the user for a nickname that will be checked by server
     */
    @Override
    public void askNickname() {

    }
    /**
     * askNumbPlayer() used when is entered the first player to set numb_of_player
     */
    @Override
    public void askNumbPlayer() {

    }
    /**
     * updateboard() is used during a player turn when has to take card from board
     * @param b
     */
    @Override
    public void updateboard(Board b) {

    }
    /**
     * updatelibrary() when the player has
     * @param l
     * @param nickname
     */
    @Override
    public void updatelibrary(Library l, String nickname) {

    }
    /**
     * let the player see when has reached a common goal
     * @param e
     * @param x
     * @param name
     */
    @Override
    public void assignedCC(EffectiveCard e, int x, String name) {

    }

    @Override
    public void assignedChair(String name) {

    }

    @Override
    public void CreateMatch(Match m) {

    }


}
