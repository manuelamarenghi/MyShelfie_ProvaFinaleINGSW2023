package it.polimi.ingsw.modello;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * this class is about personal library
 */
public class Library implements Iterable<Card>, Serializable {
    /**
     * library is a matrix of cards that are insert from library's player
     */
    private Card[][] library = new Card[6][5];
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[48;5;227m";
    public static final String ANSI_GREEN = "\u001B[48;5;40m";
    public static final String ANSI_WHITE = "\u001B[107m";
    public static final String ANSI_BLUE = "\033[0;106m";
    public static final String ANSI_PINK = "\u001B[48;5;205m";
    public static final String ANSI_NAVY = "\u001B[48;5;18m";//

    /**
     * the constructor initialize 6x5 matrix
     */
    public Library() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                library[i][j] = new Card();
            }
        }
    }

    public Card[][] getLibrary() {
        return library;
    }

    /**
     * getCardinPos() returns the card in the position you asked for
     */
    public Card getCardinPos(int x, int y) {
        if (library[x][y] != null) {
            return library[x][y];
        }
        return null;
    }

    /**
     * Adjacent() add(if not present) to an arraylist of Position items that are adjacent starting from a card
     */
    private static void Adjacent(Card[][] library, boolean[][] visited, int row, int col, String color, ArrayList<Card> groupCard) {
        if (row < 0 || row >= library.length || col < 0 || col >= library[0].length || library[row][col].getColour() == "")
            return;
        if (visited[row][col] || !library[row][col].getColour().equals(color))
            return;


        visited[row][col] = true;
        Position position = new Position(row, col);
        groupCard.add(new Card(color, position));

        Adjacent(library, visited, row - 1, col, color, groupCard);
        Adjacent(library, visited, row + 1, col, color, groupCard);
        Adjacent(library, visited, row, col - 1, color, groupCard);
        Adjacent(library, visited, row, col + 1, color, groupCard);
    }

    /**
     * showColumn() returns where you can put n cards ( chosen from the player)
     */
    public int[] showColumn(int n) {
        int[] temp = new int[]{0, 1, 2, 3, 4};
        int size = 0;
        int i = 0;
        int j = 0;
        while (i < 5) {
            if (!library[n - 1][i].getColour().isEmpty()) {
                temp[i] = -1;
                size++;
            }
            i++;
        }
        int[] results = new int[5 - size];
        for (i = 0; i < 5; i++) {
            if (temp[i] != -1) {
                results[j] = temp[i];
                j++;
            }
        }
        return results;
    }

    /**
     * showLibrary() let you see your library
     */
    public void showLibrary() {
        /*System.out.println(" *** Your library ***");
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                if( library[i][j]!=null){
                    System.out.print(" ["+library[i][j].getColour()+"] ");
                }
                else {  System.out.print("  ["+"  "+"]  ");
                }
            }
            System.out.println();
        }*/

        System.out.println(" *** Your Library ***");
        System.out.println("   0   1   2   3   4");
        for (int i = 0; i < 6; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 5; j++) {

                if (library[i][j].getColour().equals("yellow")) {
                    System.out.print(ANSI_YELLOW + "  " + ANSI_RESET);
                    System.out.print("  ");
                } else if (library[i][j].getColour().equals("white")) {
                    System.out.print(ANSI_WHITE + "  " + ANSI_RESET);
                    System.out.print("  ");
                } else if (library[i][j].getColour().equals("green")) {
                    System.out.print(ANSI_GREEN + "  " + ANSI_RESET);
                    System.out.print("  ");
                } else if (library[i][j].getColour().equals("lightBlue")) {
                    System.out.print(ANSI_BLUE + "  " + ANSI_RESET);
                    System.out.print("  ");
                } else if (library[i][j].getColour().equals("blue")) {
                    System.out.print(ANSI_NAVY + "  " + ANSI_RESET);
                    System.out.print("  ");
                } else if (library[i][j].getColour().equals("pink")) {
                    System.out.print(ANSI_PINK + "  " + ANSI_RESET);
                    System.out.print("  ");
                } else {
                    System.out.print("    ");
                }

            }
            System.out.println();
            System.out.println();
        }

    }
    /**
     * takeAction() puts n cards in n-1 column
     */
    /*public void takeAction(Card[] cards,int n) throws NotUsableException {
        List<Integer> list=Arrays.stream(showColumn(cards.length)).boxed().collect(Collectors.toList());
        if(!list.contains(n)){
            throw new NotUsableException();
        }
        else{
            setColumn(cards,n-1);
        }
    }*/

    /**
     * setColumn() puts n cards in a chosen column
     */
    public void setColumn(ArrayList<Card> cards, int n) {
        int i = 5;
        int l = 0;

        while (i >= 0 && l != cards.size()) {
            if (library[i][n].getColour().isEmpty()) {
                library[i][n] = new Card(cards.get(l).getColour(), new Position(i, n));
                l++;
            }
            i--;
        }

    }

    /**
     * getgroup() returns adjacent items in a given library
     */
    public ArrayList<Integer> getgroup() {
        ArrayList<Integer> Adjacent = new ArrayList<Integer>();
        ArrayList<ArrayList<Card>> groups = new ArrayList<>();

        boolean[][] visited = new boolean[library.length][library[0].length];

        for (int i = 0; i < library.length; i++) {
            for (int j = 0; j < library[0].length; j++) {
                if (!visited[i][j] && library[i][j].getColour() != "") {
                    ArrayList<Card> groupCard = new ArrayList<>();
                    Adjacent(library, visited, i, j, library[i][j].getColour(), groupCard);
                    groups.add(groupCard);
                }
            }
        }


        for (ArrayList<Card> g : groups) {
            if (g.size() > 1) {
                Adjacent.add(g.size());
            }
        }
        return Adjacent;
    }

    /**
     * getFilledColumnNumber return the amount of cards that are inserted in the given column
     */
    public int getFilledColumnNumber(int columnNumber) {
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            if (!this.library[i][columnNumber].getColour().equals("")) counter++;
        }
        return counter;
    }

    @Override
    public Iterator iterator() {
        return new LibraryIterator(this.library);
    }

    /**
     * getFilledRowNumber return the amount of cards that are inserted in the given row
     */
    public int getFilledRowNumber(int rowNumber) {
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            if (!this.library[rowNumber][i].getColour().equals("")) counter++;
        }
        return counter;
    }

    /**
     * check the library is full
     *
     * @return true if the library is full , false otherwise
     */
    public boolean isFull() {
        for (int j = 0; j < 5; j++) {
            if (library[0][j].getColour().isEmpty())
                return false;
        }
        return true;
    }
}
