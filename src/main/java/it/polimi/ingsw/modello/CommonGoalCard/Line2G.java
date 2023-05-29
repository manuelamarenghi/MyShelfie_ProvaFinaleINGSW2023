package it.polimi.ingsw.modello.CommonGoalCard;

import it.polimi.ingsw.modello.CommonGoalCards;
import it.polimi.ingsw.modello.Library;

import java.io.Serializable;

public class Line2G implements CommonGoalCards, Serializable {
    int numberCard = 6;

    public int getNumberCard() {
        return numberCard;
    }

    /**
     * The method checks if the target has been completed or not
     */

    @Override
    public boolean check(Library library) {
        int r, c, i;
        int[] differentCard = {0, 0, 0, 0, 0, 0};
        int differentLines = 0, total;
        for (r = 0; r < 6; r++) {
            total = 0;
            for (i = 0; i < 6; i++) {
                differentCard[i] = 0;
            }
            for (c = 0; c < 5; c++) {
                if (library.getCardinPos(r, c).getColour().equals("green")) {
                    differentCard[0]++;
                } else if (library.getCardinPos(r, c).getColour().equals("white")) {
                    differentCard[1]++;
                } else if (library.getCardinPos(r, c).getColour().equals("yellow")) {
                    differentCard[2]++;
                } else if (library.getCardinPos(r, c).getColour().equals("blue")) {
                    differentCard[3]++;
                } else if (library.getCardinPos(r, c).getColour().equals("lightBlue")) {
                    differentCard[4]++;
                } else if (library.getCardinPos(r, c).getColour().equals("pink")) {
                    differentCard[5]++;
                }
            }
            for (i = 0; i < 6; i++) {
                if (differentCard[i] == 1) {
                    total++;
                }
            }
            if (total == 5) {
                differentLines++;
            }
        }
        if (differentLines >= 2) {
            return true;
        }
        return false;
    }

    /**
     * The method lets you know if the target is still possible to complete or not , it return true if it is not
     * possible to complete the tatget anymore
     */

    @Override
    public boolean expired(Library library) {
        int r, c, i;
        int[] differentTypes = {0, 0, 0, 0, 0, 0};
        int differentLines = 6, totalTypes, numberOfCards = 0;
        for (r = 0; r < 6; r++) {
            totalTypes = 0;
            numberOfCards = 0;
            for (i = 0; i < 6; i++) {
                differentTypes[i] = 0;
            }
            for (c = 0; c < 5; c++) {
                if (library.getCardinPos(r, c).getColour().equals("green")) {
                    differentTypes[0]++;
                } else if (library.getCardinPos(r, c).getColour().equals("white")) {
                    differentTypes[1]++;
                } else if (library.getCardinPos(r, c).getColour().equals("yellow")) {
                    differentTypes[2]++;
                } else if (library.getCardinPos(r, c).getColour().equals("blue")) {
                    differentTypes[3]++;
                } else if (library.getCardinPos(r, c).getColour().equals("lightBlue")) {
                    differentTypes[4]++;
                } else if (library.getCardinPos(r, c).getColour().equals("pink")) {
                    differentTypes[5]++;
                }
                numberOfCards++;
            }
            for (i = 0; i < 6; i++) {
                if (differentTypes[i] > 1) {
                    differentLines--;
                }
            }
        }
        if (differentLines < 2) {
            return true;
        }
        return false;
    }

    /**
     * the method returns the description of the card
     */

    @Override
    public String getDesc() {
        return "Two lines each formed by 5 different types of tiles.  \n" +
                "One line can show the same or a different combination of the other line.\n";
    }

    /**
     * The method shows you ana example of the target
     */

    @Override
    public void showCommonCard() {
        Library l = new Library();
        l.getCardinPos(5, 0).setColour("green");
        l.getCardinPos(5, 1).setColour("yellow");
        l.getCardinPos(5, 2).setColour("white");
        l.getCardinPos(5, 3).setColour("blue");
        l.getCardinPos(5, 4).setColour("lightBlue");

        l.getCardinPos(4, 0).setColour("green");
        l.getCardinPos(4, 1).setColour("yellow");
        l.getCardinPos(4, 2).setColour("white");
        l.getCardinPos(4, 3).setColour("blue");
        l.getCardinPos(4, 4).setColour("lightBlue");
        System.out.println("This is an example of a library that respects this goal");
        l.showLibrary();
    }
}
