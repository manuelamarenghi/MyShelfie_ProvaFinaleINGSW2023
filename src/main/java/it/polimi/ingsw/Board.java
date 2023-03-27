package it.polimi.ingsw;

import java.util.ArrayList;

public class Board {
    private int row=9 , col=9;
    private Card[][] board = new Card[row][col];
    private Card ca;
    private Bag bag;
    private int c , r;
    private Card notUsableCard=new Card();

    public void setNotPossibleCardsToNull (){
        for(c=0 ; c<9 ; c++){//To put Null the first line
            if(c!=4 && c!=5){
                board[0][c]=notUsableCard;
            }
        }
        for(c=0 ; c<9 ; c++){//To put Null the second line
            if(c!=4 && c!=5 && c!=6){
                board[1][c]=notUsableCard;
            }
        }
        for(c=0 ; c<9 ; c++){//To put Null the third line
            if(c!=3 && c!=4 && c!=5 && c!=6){
                board[2][c]=notUsableCard;
            }
        }
        board[3][0]=notUsableCard;//To put Null the Fourth line
        board[5][8]=notUsableCard;//To put null the sixth line

        for(c=0 ; c<9 ; c++){//To put Null the seventh line
            if(c!=3 && c!=4 && c!=5 && c!=6){
                board[6][c]=notUsableCard;
            }
        }
        for(c=0 ; c<9 ; c++){//To put Null the second line
            if(c!=4 && c!=5 && c!=6){
                board[7][c]=notUsableCard;
            }
        }
        for(c=0 ; c<9 ; c++){//To put Null the first line
            if(c!=4 && c!=5){
                board[8][c]=notUsableCard;
            }
        }

    }

    public void fill(){
        for(c=0 ; c<9 ; c++){
            for(r=0 ; r<9 ; r++){
                if(board[r][c]!=notUsableCard){
                    //board[r][c]=bag.extract();//Extract ancora da implemnetare
                }
            }
        }

    }

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
    public void getBag(){
        return bag;
    }
    public void getBoard(){
        return board;
    }
}
