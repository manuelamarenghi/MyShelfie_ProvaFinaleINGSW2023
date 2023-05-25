package it.polimi.ingsw.modello;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable {
    private int row = 9, col = 9, numOfPlayers;
    public static final String ANSI_YELLOW = "\u001B[48;5;227m";
    public static final String ANSI_RESET = "\u001B[0m";
    private Card[][] board = new Card[row][col];
    private Card ca;
    private Bag bag;
    public static final String ANSI_WHITE = "\u001B[107m";
    public static final String ANSI_GREEN = "\u001B[48;5;40m";
    public static final String ANSI_BLUE = "\033[0;106m";
    public static final String ANSI_PINK = "\u001B[48;5;205m";
    private Card emptyCard = new Card();
    public static final String ANSI_NAVY = "\u001B[48;5;18m";
    private int c, r;
    private Card notUsableCard = new Card();


    /**
     * board get initialized based on number of players
     */

    public Board(int numOfPlayers) {
        bag = new Bag();
        this.numOfPlayers = numOfPlayers;
        for (c = 0; c < 9; c++) {//To put Null the first line
            if (c == 4 || c == 3) {
                board[0][c] = emptyCard;
            } else {
                board[0][c] = notUsableCard;
            }
        }
        for (c = 0; c < 9; c++) {//To put Null the second line
            if (c == 3 || c == 4 || c == 5) {
                board[1][c] = emptyCard;
            } else {
                board[1][c] = notUsableCard;
            }
        }
        for (c = 0; c < 9; c++) {//To put Null the third line
            if (c == 2 || c == 3 || c == 4 || c == 5 || c == 6) {
                board[2][c] = emptyCard;

            } else {
                board[2][c] = notUsableCard;
            }
        }
        for (c = 0; c < 9; c++) {
            if (c == 0) {
                board[3][0] = notUsableCard;//To put Null the Fourth line
            }
            else{
                board[3][c]=emptyCard;
            }
        }
        for(c=0 ; c<9 ; c++ ){
            board[4][c]=emptyCard;
        }
        for(c=0 ; c<9 ; c++){
            if(c==8){
                board[5][8]=notUsableCard;//To put Null the Fourth line
            }
            else{
                board[5][c]=emptyCard;
            }
        }

        for(c=0 ; c<9 ; c++){//To put Null the seventh line
            if(c==2 || c==3 || c==4 || c==5 || c==6){
                board[6][c]=emptyCard;
            }
            else{
                board[6][c]=notUsableCard;
            }
        }
        for(c=0 ; c<9 ; c++){//To put Null the second line
            if(c==3 || c==4 || c==5){
                board[7][c]=emptyCard;
            }
            else{
                board[7][c]=notUsableCard;
            }
        }
        for(c=0 ; c<9 ; c++){//To put Null the first line
            if(c==5 || c==4){
                board[8][c]=emptyCard;
            }
            else{
                board[8][c]=notUsableCard;
            }
        }
        if(numOfPlayers==2){//Positions that can not be used with 2 players playing
            board[0][3]=notUsableCard;//Positions with 3 points
            board[2][2]=notUsableCard;
            board[5][0]=notUsableCard;
            board[6][2]=notUsableCard;
            board[8][5]=notUsableCard;
            board[6][6]=notUsableCard;
            board[3][8]=notUsableCard;
            board[2][6]=notUsableCard;

            board[0][4]=notUsableCard;//Positions with 4 points
            board[3][1]=notUsableCard;
            board[4][0]=notUsableCard;
            board[7][3]=notUsableCard;
            board[8][4]=notUsableCard;
            board[5][7]=notUsableCard;
            board[4][8]=notUsableCard;
            board[1][5]=notUsableCard;

        }
        else if(numOfPlayers==3){
            board[0][4]=notUsableCard;//Positions with 4 points
            board[3][1]=notUsableCard;
            board[4][0]=notUsableCard;
            board[7][3]=notUsableCard;
            board[8][4]=notUsableCard;
            board[5][7]=notUsableCard;
            board[4][8]=notUsableCard;
            board[1][5]=notUsableCard;
        }

    }

    /**
     * Board gets filled up with cards from bag
     */


    public void fill(int cardsOnTable){
        int indexOfColours=0;
        ArrayList<String> arrayOfColours=new ArrayList<>();
        Card tempCard;
        arrayOfColours=bag.extract(numOfPlayers , cardsOnTable);
        for(c=0 ; c<9 ; c++){
            for(r=0 ; r<9 ; r++){
                if(board[r][c]==notUsableCard || board[r][c]!=emptyCard) {
                }
                else {

                    tempCard = new Card(arrayOfColours.get(indexOfColours), new Position(r, c));
                    board[r][c] = tempCard;
                    indexOfColours++;
                }
                if(indexOfColours==arrayOfColours.size()){
                    break;
                }
            }
            if(indexOfColours==arrayOfColours.size()){
                break;
            }
        }


    }

    /**
     * The method return true/false if the cards can be taken or not
     */

    public Boolean allow(ArrayList<Card> cards) {
        for (Card c : cards) {
            if (c.getCoordinates() == null)
                return false;
        }
        if (cards.size() == 2) {
            if (((cards.get(1).getCoordinates().getX() == cards.get(0).getCoordinates().getX()) && (
                    cards.get(1).getCoordinates().getY() == cards.get(0).getCoordinates().getY() + 1 ||
                            cards.get(1).getCoordinates().getY() == cards.get(0).getCoordinates().getY() - 1
            )) ||
                    ((cards.get(1).getCoordinates().getY() == cards.get(0).getCoordinates().getY()) && (
                            cards.get(1).getCoordinates().getX() == cards.get(0).getCoordinates().getX() + 1 ||
                                    cards.get(1).getCoordinates().getX() == cards.get(0).getCoordinates().getX() - 1)
                    )) {
                //ok crads are adjcent
            } else {
                return false;
            }
        }
        if (cards.size() == 3) {
            if (((cards.get(1).getCoordinates().getX() == cards.get(0).getCoordinates().getX() + 1) && (cards.get(2).getCoordinates().getX() == cards.get(1).getCoordinates().getX() + 1)) ||
                    ((cards.get(2).getCoordinates().getX() == cards.get(0).getCoordinates().getX() + 1) && (cards.get(1).getCoordinates().getX() == cards.get(2).getCoordinates().getX() + 1)) ||
                    ((cards.get(0).getCoordinates().getX() == cards.get(1).getCoordinates().getX() + 1) && (cards.get(2).getCoordinates().getX() == cards.get(0).getCoordinates().getX() + 1)) ||
                    ((cards.get(2).getCoordinates().getX() == cards.get(1).getCoordinates().getX() + 1) && (cards.get(0).getCoordinates().getX() == cards.get(2).getCoordinates().getX() + 1)) ||
                    ((cards.get(0).getCoordinates().getX() == cards.get(2).getCoordinates().getX() + 1) && (cards.get(1).getCoordinates().getX() == cards.get(0).getCoordinates().getX() + 1)) ||
                    ((cards.get(1).getCoordinates().getX() == cards.get(2).getCoordinates().getX() + 1) && (cards.get(0).getCoordinates().getX() == cards.get(1).getCoordinates().getX() + 1))
            ) {
                //ok Cards are adicent
            } else if (((cards.get(1).getCoordinates().getY() == cards.get(0).getCoordinates().getY() + 1) && (cards.get(2).getCoordinates().getY() == cards.get(1).getCoordinates().getY() + 1)) ||
                    ((cards.get(2).getCoordinates().getY() == cards.get(0).getCoordinates().getY() + 1) && (cards.get(1).getCoordinates().getY() == cards.get(2).getCoordinates().getY() + 1)) ||
                    ((cards.get(0).getCoordinates().getY() == cards.get(1).getCoordinates().getY() + 1) && (cards.get(2).getCoordinates().getY() == cards.get(0).getCoordinates().getY() + 1)) ||
                    ((cards.get(2).getCoordinates().getY() == cards.get(1).getCoordinates().getY() + 1) && (cards.get(0).getCoordinates().getY() == cards.get(2).getCoordinates().getY() + 1)) ||
                    ((cards.get(0).getCoordinates().getY() == cards.get(2).getCoordinates().getY() + 1) && (cards.get(1).getCoordinates().getY() == cards.get(0).getCoordinates().getY() + 1)) ||
                    ((cards.get(1).getCoordinates().getY() == cards.get(2).getCoordinates().getY() + 1) && (cards.get(0).getCoordinates().getY() == cards.get(1).getCoordinates().getY() + 1))) {

            } else {
                return false;
            }
        }

        if (cards.size() > 3) {//You cant extract more than 3 cards
            return false;
        }

        for (Card ca : cards) {
            if(ca.getCoordinates().getX()==0 || ca.getCoordinates().getX()==8 || ca.getCoordinates().getY()==0 || ca.getCoordinates().getY()==8){

            }
            else{
                if (board[ca.getCoordinates().getX() + 1][ca.getCoordinates().getY()] == notUsableCard ||
                        board[ca.getCoordinates().getX() - 1][ca.getCoordinates().getY()] == notUsableCard ||
                        board[ca.getCoordinates().getX()][ca.getCoordinates().getY() + 1] == notUsableCard ||
                        board[ca.getCoordinates().getX()][ca.getCoordinates().getY() - 1] == notUsableCard ||
                        board[ca.getCoordinates().getX() + 1][ca.getCoordinates().getY()] == emptyCard ||
                        board[ca.getCoordinates().getX() - 1][ca.getCoordinates().getY()] == emptyCard ||
                        board[ca.getCoordinates().getX()][ca.getCoordinates().getY() + 1] == emptyCard ||
                        board[ca.getCoordinates().getX()][ca.getCoordinates().getY() - 1] == emptyCard
                ) {


                } else {
                    return false;
                }
            }

        }//Fine ciclo for

        return true;
    }

    /**
     * the method returns number of free positions on table
     */

    public int getFreeposition(){
        int l=0 , row,col ;
        for(row=0 ; row<9 ; row++){
            for(col=0 ; col<9 ; col++){
                if(board[row][col]!=notUsableCard){
                    l++;
                }
            }
        }
        return l;
    }

    /**
     * If the card has been taken from the board it is put to null
     */

    public void takeCard (Position position){
        if(board[position.getX()][position.getY()].equals(notUsableCard) || board[position.getX()][position.getY()].equals(emptyCard)){
            return;
        }
        board[position.getX()][position.getY()]=emptyCard;
    }
    public Bag getBag(){
        return bag;
    }
    public Card[][] getBoard(){
        return board;
    }
    public int getNumOfPlayers(){
        return numOfPlayers;
    }
    /**
     * showBoard() let you see the board
     */
    public void showBoard(){
        System.out.println(" *** living room ***");
        System.out.println("   0   1   2   3   4   5   6   7   8");
        for(int i=0;i<9;i++){
            System.out.print(i + " ");
            for(int j=0;j<9;j++){
                if (board[i][j] == notUsableCard) {
                    System.out.print("    ");
                } else {
                    if (board[i][j] != emptyCard) {
                        if (board[i][j].getColour().equals("yellow")) {
                            System.out.print(ANSI_YELLOW + "  " + ANSI_RESET);
                            System.out.print("  ");
                        } else if (board[i][j].getColour().equals("white")) {
                            System.out.print(ANSI_WHITE + "  " + ANSI_RESET);
                            System.out.print("  ");
                        } else if (board[i][j].getColour().equals("green")) {
                            System.out.print(ANSI_GREEN + "  " + ANSI_RESET);
                            System.out.print("  ");
                        } else if (board[i][j].getColour().equals("lightBlue")) {
                            System.out.print(ANSI_BLUE + "  " + ANSI_RESET);
                            System.out.print("  ");
                        } else if (board[i][j].getColour().equals("blue")) {
                            System.out.print(ANSI_NAVY + "  " + ANSI_RESET);
                            System.out.print("  ");
                        } else if (board[i][j].getColour().equals("pink")) {
                            System.out.print(ANSI_PINK + "  " + ANSI_RESET);
                            System.out.print("  ");
                        }

                    } else {
                        System.out.print("    ");
                    }
                }

            }
            System.out.println();
            System.out.println();
        }
    }
    public Card getCard(int x , int y){ return board[x][y];}

    public void setCard(String color, Position position){
        board[position.getX()][position.getY()] = new Card(color,position);

    }

    /**
     * this method you can see the stacks of adjacent cards on the board
     * @return ArrayList integer, the number of the group of adjacent
     */
    public ArrayList<Integer> Group(){
        ArrayList<Integer> group = new ArrayList<Integer>();
        ArrayList<ArrayList<Card>> groups = new ArrayList<>();

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(!visited[i][j] && board[i][j]!= notUsableCard && board[i][j] != emptyCard){
                    ArrayList<Card> groupCard = new ArrayList<>();
                    Adjacent(board,visited,i,j,groupCard);
                    groups.add(groupCard);
                }
            }
        }

        for(ArrayList<Card> g:groups){
            group.add(g.size());
        }
        return  group;
    }

    /**
     *the method checks if the cards are adjacent or not
     * @param board
     * @param visited
     * @param row
     * @param col
     * @param groupCard
     */
    private void Adjacent(Card[][] board,boolean[][] visited, int row, int col,ArrayList<Card> groupCard)
    {
        if(row < 0 || row >=board.length || col<0 || col>=board[0].length || board[row][col] == notUsableCard || board[row][col] == emptyCard )
            return;
        if(visited[row][col])
            return;


        visited[row][col] =true;
        Position position = new Position(row,col);
        groupCard.add(new Card(board[row][col].getColour(),position));

        Adjacent(board,visited,row-1,col,groupCard);
        Adjacent(board,visited,row+1,col,groupCard);
        Adjacent(board,visited,row,col-1,groupCard);
        Adjacent(board,visited,row,col+1,groupCard);
    }
}
