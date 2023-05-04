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

    @Override
    public void askNickname() {

    }

    @Override
    public void askNumbPlayer() {

    }

    @Override
    public void updateboard(Board b) {

    }

    @Override
    public void updatelibrary(Library l, String nickname) {

    }

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
