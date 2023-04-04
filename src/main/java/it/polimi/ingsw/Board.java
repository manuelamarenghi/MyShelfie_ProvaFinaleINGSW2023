package it.polimi.ingsw;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Board {
    private int row=9 , col=9 , numOfPlayers;
    private Card[][] board = new Card[row][col];
    private Card ca;
    private Bag bag;
    private int c , r;
    private Card emptyCard = new Card();
    private Card notUsableCard=new Card();

    /**
     * board get initialized based on number of players
     */

    public Board(int numOfPlayers){
        bag = new Bag();
        this.numOfPlayers=numOfPlayers;
        for(c=0 ; c<9 ; c++){//To put Null the first line
            if(c==4 || c==3){
                board[0][c]=emptyCard;
            }
            else{
                board[0][c]=notUsableCard;
            }
        }
        for(c=0 ; c<9 ; c++){//To put Null the second line
            if(c==3 || c==4 || c==5){
                board[1][c]=emptyCard;
            }
            else {
                board[1][c]=notUsableCard;
            }
        }
        for(c=0 ; c<9 ; c++){//To put Null the third line
            if(c==2 || c==3 || c==4 || c==5 || c==6){
                board[2][c]=emptyCard;

            }
            else {
                board[2][c]=notUsableCard;
            }
        }
        for(c=0 ; c<9 ; c++){
            if(c==0){
                board[3][0]=notUsableCard;//To put Null the Fourth line
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

    public Boolean allow(ArrayList<Card> cards ){
        if(cards.size()==2){
            if(cards.get(1).getCoordinates().getX()==cards.get(0).getCoordinates().getX()+1 ||
                cards.get(1).getCoordinates().getX()==cards.get(0).getCoordinates().getX()-1 ||
                cards.get(1).getCoordinates().getY()==cards.get(0).getCoordinates().getY()-1 ||
                cards.get(1).getCoordinates().getY()==cards.get(0).getCoordinates().getY()+1 ){
                //ok crads are adicent
            }
            else{
                return false;
            }
        }
        if(cards.size()==3){
            if(((cards.get(1).getCoordinates().getX()==cards.get(0).getCoordinates().getX()+1)&&(cards.get(2).getCoordinates().getX()==cards.get(1).getCoordinates().getX()+1)) ||
                ((cards.get(2).getCoordinates().getX()==cards.get(0).getCoordinates().getX()+1)&&(cards.get(1).getCoordinates().getX()==cards.get(2).getCoordinates().getX()+1))||
                ((cards.get(0).getCoordinates().getX()==cards.get(1).getCoordinates().getX()+1)&&(cards.get(2).getCoordinates().getX()==cards.get(0).getCoordinates().getX()+1))||
                ((cards.get(2).getCoordinates().getX()==cards.get(1).getCoordinates().getX()+1)&&(cards.get(0).getCoordinates().getX()==cards.get(2).getCoordinates().getX()+1))||
                ((cards.get(0).getCoordinates().getX()==cards.get(2).getCoordinates().getX()+1)&&(cards.get(1).getCoordinates().getX()==cards.get(0).getCoordinates().getX()+1))||
                ((cards.get(1).getCoordinates().getX()==cards.get(2).getCoordinates().getX()+1)&&(cards.get(0).getCoordinates().getX()==cards.get(1).getCoordinates().getX()+1))
            ){
                //ok Cards are adicent
            }
            else{
                return false;
            }
        }

        if(cards.size()>3){//You cant extract more than 3 cards
           return false;
        }

        for(Card ca : cards){
            if(board[ca.getCoordinates().getX()+1][ca.getCoordinates().getY()]==notUsableCard ||
                board[ca.getCoordinates().getX()+1][ca.getCoordinates().getY()]==null ||
                board[ca.getCoordinates().getX()-1][ca.getCoordinates().getY()]==notUsableCard ||
                board[ca.getCoordinates().getX()-1][ca.getCoordinates().getY()]==null ||
                board[ca.getCoordinates().getX()][ca.getCoordinates().getY()+1]==notUsableCard ||
                board[ca.getCoordinates().getX()][ca.getCoordinates().getY()+1]==null ||
                board[ca.getCoordinates().getX()][ca.getCoordinates().getY()-1]==notUsableCard ||
                board[ca.getCoordinates().getX()][ca.getCoordinates().getY()-1]==null){


            }
            else{
                return false;
            }
            return true;
        }

        return null;
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
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if( board[i][j]==notUsableCard){
                    System.out.print(" [ X ] ");
                }
                else{
                if( board[i][j]!=emptyCard){
                    System.out.print(" ["+board[i][j].getColour()+"] ");
                }
                else{
                    System.out.print(" [  ] ");
                }
            }}
            System.out.println();
        }
    }
    public Card getCard(int x , int y){ return board[x][y];}


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
            System.out.println(g.size());
        }
        return  group;
    }
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
