package it.polimi.ingsw;

import java.util.*;
import java.util.stream.Collectors;

/*
 * this class is about personal library
 */
public class Library implements Iterable<Card> {
    /*
     * library is a matrix of cards that are insert from library's player
     */
    private Card[][] library=new Card[6][5];
    /*
     * the constructor initialize 6x5 matrix
     */
    public Library() {
        for (int i=0;i<6;i++)
        { for(int j=0;j<5;j++){
            library[i][j]=new Card();}
        }
    }
    /*
     * getCardinPos() returns the card in the position you asked for
     */
    public Card getCardinPos(int x, int y){
        if(library[x][y]!=null)
        {return library[x][y];}
        return null;
    }
    /*
     * showColumn() returns where you can put n cards ( chosen from the player)
     */
    public int[] showColumn (int n){
        int[] temp= new int[]{1,2,3,4,5};
        int size=0;
        int i=0;
        int j=0;
        while(i<5){
            if(!library[n-1][i].getColour().isEmpty()){
                temp[i]=-1;
                size++;
            }
            i++;
        }
        int[] results=new int[5-size];
        for(i=0;i<5;i++){
            if(temp[i]!=-1){
                results[j]=temp[i];
                j++;
            }
        }
        return results;}
    /*
     * showLibrary() let you see your library
     */
    public void showLibrary(){
        System.out.println(" *** Your library ***");
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                if( library[i][j]!=null){
                    System.out.print(" ["+library[i][j].getColour()+"] ");
                }
                else {  System.out.print("  ["+"  "+"]  ");
                }
            }
            System.out.println();
        }}
    /*
     * setColumn() puts n cards in a chosen column
     */
    public void setColumn(Card[] cards,int n){
        int i=5;
        int l=0;
        while(i>0 && l!= cards.length){
            if(library[i][n].getColour().isEmpty()){
                library[i][n]=cards[l];
                l++;
            }
            i--;
        }
    }
    /*
     * takeAction() makes the player decide where to put the selected cards
     */
    public void takeAction(Card[] cards){
        Scanner in=new Scanner(System.in);
        int a;
        List<Integer> list=Arrays.stream(showColumn(cards.length)).boxed().collect(Collectors.toList());
        showLibrary();
        System.out.println("You can put your cards in columns:"+ Arrays.toString(showColumn(cards.length)));
        do {
            System.out.println("Select column or -1 to stop:");
            a = in.nextInt();
            if(a==-1){ break;}
            if (list.contains(a)){
                setColumn(cards,a);
            }
        }while(!list.contains(a));
    }
    /*
     * getgroup() returns adjacent items in a given library
     */
    public void getgroup(){
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<String> list2=new ArrayList<String>();
        ArrayList<Position> n=new ArrayList<Position>();
        for(int i=0;i<6;i++){
        for(int j=0;j<5;j++){
            if(!this.getCardinPos(i,j).getVisited()){
            searchrecursive(i,j,this.getCardinPos(i,j).getColour(),n);
            System.out.println("iteration:"+i+j+" "+n);
            if(n.size()>1){
            list1.add(n.size());
            list2.add(this.getCardinPos(i,j).getColour());
            }}
            n.clear();
        }}
       System.out.println(list1);
        System.out.println(list2);
        for(Card l : this){
            l.setVisited(false);
        }
    }
    /*
     * searchrecursive() add(if not present) to an arraylist of Position items that are adjacent starting from a card
     */
    public void searchrecursive(int r,int c,String color,ArrayList<Position> n) {
        /* first conditions check is a valid place and if it wasn't already visited*/
        if (isValid(r,c) && !this.getCardinPos(r,c).getVisited() &&  !this.getCardinPos(r,c).getColour().isEmpty()) {
            /* then the second checks if the position in line i-1 is valid and there's the same item*/
            if(isValid(r-1,c) && this.getCardinPos(r-1,c).getColour().equals(color)) {
                Position p=new Position(r-1,c);
                /* third checks others recursive calls already add this, then we add and change visited status of the card and call the recursive on the object */
                if (!n.contains(p)) {
                    n.add(p);
                    this.getCardinPos(r - 1, c).setVisited(true);
                    searchrecursive(r - 1, c,this.getCardinPos(r-1,c).getColour(), n);
                }
            }
                /* now we check in i+1 direction*/
                if(isValid(r+1,c) && this.getCardinPos(r+1,c).getColour().equals(color)) {
                    Position p=new Position(r+1,c);
                    if (!n.contains(p)) {
                        n.add(p);
                        this.getCardinPos(r + 1, c).setVisited(true);
                        searchrecursive(r+1,c,this.getCardinPos(r+1,c).getColour(),n);
                    }
                }

            /* now we check in j+1 direction, adjacent column*/
            if(isValid(r,c+1) && this.getCardinPos(r,c+1).getColour().equals(color)) {
                Position p=new Position(r,c+1);
                if (!n.contains(p)){
                    n.add(p);
                    this.getCardinPos(r , c+1).setVisited(true);
                    searchrecursive(r,c+1,this.getCardinPos(r,c+1).getColour(),n);
                }
            }
            /* now we check in j-1 direction, adjacent column*/
            if(isValid(r,c-1) && this.getCardinPos(r,c-1).getColour().equals(color)) {
                Position p=new Position(r,c-1);
                if (!n.contains(p)){
                    n.add(p);
                    this.getCardinPos(r , c-1).setVisited(true);
                    searchrecursive(r,c-1,this.getCardinPos(r,c-1).getColour(),n);
                }
            }
        }
    }

    /*
     * isValid() returns if the position is valid
     */
    public boolean isValid(int r, int c) {
        if (r >= 0 && c < 5 && c >= 0 && r < 6) {
            return true;
        }
        return false;
    }
    public int getFilledColumnNumber(int columnNumber){
        int counter=0;
        for(int i=0;i<6;i++){
                if(!this.library[i][columnNumber].getColour().equals("")) counter++;
        }return counter;
    }
    @Override
    public Iterator<Card> iterator() {
        return new LibraryIterator(this.library);
    }
    public int getFilledRowNumber(int rowNumber){
        int counter=0;
        for(int i=0;i<5;i++){
            if(!this.library[rowNumber][i].getColour().equals("")) counter++;
        }return counter;
    }


}
