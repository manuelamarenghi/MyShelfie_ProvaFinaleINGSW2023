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
                setColumn(cards,a-1);
            }
        }while(!list.contains(a));
    }
    /*
     * getgroup() returns adjacent items in a given library
     */
    public ArrayList<Integer> getgroup(){
        ArrayList<Integer> Adjacent = new ArrayList<Integer>();
        ArrayList<ArrayList<Card>> groups = new ArrayList<>();

        boolean[][] visited = new boolean[library.length][library[0].length];

        for(int i=0;i<library.length;i++){
            for(int j =0;j<library[0].length;j++){
                if(!visited[i][j] && library[i][j].getColour() !=""){
                    ArrayList<Card> groupCard = new ArrayList<>();
                    Adjacent(library,visited,i,j,library[i][j].getColour(),groupCard);
                    groups.add(groupCard);
                }
            }
        }


        for(ArrayList<Card> g:groups){
            if(g.size()>1) {
                Adjacent.add(g.size());
            }
        }
        return Adjacent;
    }
    /*
     * Adjacent() add(if not present) to an arraylist of Position items that are adjacent starting from a card
     */
    private static void Adjacent(Card[][] library,boolean[][] visited, int row, int col,String color,ArrayList<Card> groupCard)
    {
        if(row < 0 || row >=library.length || col<0 || col>=library[0].length || library[row][col].getColour()=="" )
            return;
        if(visited[row][col] || !library[row][col].getColour().equals(color))
            return;


        visited[row][col] =true;
        Position position = new Position(row,col);
        groupCard.add(new Card(color,position));

        Adjacent(library,visited,row-1,col,color,groupCard);
        Adjacent(library,visited,row+1,col,color,groupCard);
        Adjacent(library,visited,row,col-1,color,groupCard);
        Adjacent(library,visited,row,col+1,color,groupCard);
    }
    public int getFilledColumnNumber(int columnNumber){
        int counter=0;
        for(int i=0;i<6;i++){
            if(!this.library[i][columnNumber].getColour().equals("")) counter++;
        }return counter;
    }

    @Override
    public Iterator iterator() {
        return new LibraryIterator(this.library);
    }
    public int getFilledRowNumber(int rowNumber){
        int counter=0;
        for(int i=0;i<5;i++){
            if(!this.library[rowNumber][i].getColour().equals("")) counter++;
        }return counter;
    }
}
