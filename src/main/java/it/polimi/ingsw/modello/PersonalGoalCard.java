package it.polimi.ingsw.modello;

import java.io.Serializable;
import java.util.Arrays;
/**
 * this class initialize PersonalGoalCard using json file as source
 */
public class PersonalGoalCard implements Serializable {
    private static final int DIMENSION = 6;
    private Card[] personalObjective = new Card[DIMENSION];
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[48;5;227m";
    public static final String ANSI_GREEN = "\u001B[48;5;40m";
    public static final String ANSI_WHITE = "\u001B[107m";
    public static final String ANSI_BLUE = "\033[0;106m";
    public static final String ANSI_PINK = "\u001B[48;5;205m";
    public static final String ANSI_NAVY = "\u001B[48;5;18m";
    private int numb_png;

    /**
     * the constructor takes an array of cards with their position and colour based on goals in json's file
     */
    public PersonalGoalCard(Card[] personalObjective) {
        for (int i = 0; i < DIMENSION; i++) {
            this.personalObjective[i] = new Card(personalObjective[i].getColour(), personalObjective[i].getCoordinates());
        }
    }

    /**
     * getPersonalObjective() returns an array with personalObjective's cards
     */
    public Card[] getPersonalObjective() {
        return Arrays.copyOf(personalObjective,personalObjective.length);
    }
    /**
     * showPersonalGoalCard() lets see a player's PersonalGoalCard
     */
    public void showPersonalGoalCard() {
        boolean printed;
        System.out.println(" *** personal card ***");
        System.out.println("  | 0 | 1 | 2 | 3 | 4 | ");
        for (int i = 0; i < 6; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 5; j++) {
                printed = false;
                for (Card card : this.personalObjective) {
                    if (card.getCoordinates().getX() == i && card.getCoordinates().getY() == j) {
                        printed = true;
                        if (card.getColour().equals("yellow")) {
                            System.out.print(ANSI_YELLOW + "  " + ANSI_RESET);
                            System.out.print(" |");
                        } else if (card.getColour().equals("white")) {

                            System.out.print(ANSI_WHITE + "  " + ANSI_RESET);
                            System.out.print(" |");
                        } else if (card.getColour().equals("green")) {

                            System.out.print(ANSI_GREEN + "  " + ANSI_RESET);
                            System.out.print(" |");
                        } else if (card.getColour().equals("lightBlue")) {

                            System.out.print(ANSI_BLUE + "  " + ANSI_RESET);
                            System.out.print(" |");
                        } else if (card.getColour().equals("blue")) {

                            System.out.print(ANSI_NAVY + "  " + ANSI_RESET);
                            System.out.print(" |");
                        } else if (card.getColour().equals("pink")) {
                            System.out.print(ANSI_PINK + "  " + ANSI_RESET);
                            System.out.print(" |");
                        }
                    }

                }
                if (!printed) System.out.print("   |");

            }
            System.out.println();
            System.out.println();
        }
    }

    public void setNumb_png(int x) {
        this.numb_png = x;
    }

    public int getNumn_png() {
        return numb_png;
    }
}