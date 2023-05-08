package it.polimi.ingsw.view;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.*;
import it.polimi.ingsw.network.observer.VMObserver;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Cli implements ObserverViewClient , VMObserver {
    private final PrintStream out;
    private final String nickname;
    private Thread inputThread;
    private ClientController clientController;

    /**
     * Default constructor.
     */
    public Cli(ClientController clientController ,  VirtualModel virtualModel) {
        this.nickname=askNickname();
        out = System.out;
        this.clientController=clientController;
    }

    /**
     * Reads a line from the standard input.
     *
     * @return the string read from the input.
     * @throws ExecutionException if the input stream thread is interrupted.
     */
    public String readLine() throws ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new InputReadTask());
        inputThread = new Thread(futureTask);
        inputThread.start();

        String input = null;

        try {
            input = futureTask.get();
        } catch (InterruptedException e) {
            futureTask.cancel(true);
            Thread.currentThread().interrupt();
        }
        return input;
    }

    /**
     * Asks the user for a input number. The number must be between minValue and maxValue.
     * A wrong number (outside the range) or a non-number will result in a new request of the input.
     * A forbidden list of numbers inside the range can be set through jumpList parameter.
     * An output question can be set via question parameter.
     *
     * @param minValue the minimum value which can be inserted (included).
     * @param maxValue the maximum value which can be inserted (included).
     * @param jumpList a list of forbidden values inside the range [minValue, maxValue]
     * @param question a question which will be shown to the user.
     * @return the number inserted by the user.
     * @throws ExecutionException if the input stream thread is interrupted.
     */
    private int numberInput(int minValue, int maxValue, List<Integer> jumpList, String question) throws ExecutionException {
        int number = minValue - 1;

        if (jumpList == null) {
            jumpList = List.of();
        }

        do {
            try {
                out.print(question);
                number = Integer.parseInt(readLine());

                if (number < minValue || number > maxValue) {
                    out.println("Invalid number! Please try again.\n");
                } else if (jumpList.contains(number)) {
                    out.println("This number cannot be selected! Please try again.\n");
                }
            } catch (NumberFormatException e) {
                out.println("Invalid input! Please try again.\n");
            }
        } while (number < minValue || number > maxValue || jumpList.contains(number));

        return number;
    }

    /**
     *The method asks to the user the nickname it wants to use
     * @return it returns the nickname typed by the user
     */

    @Override
    public String askNickname() {
        out.println("Type your nickanme.");
        try{
            return readLine();
        }catch(ExecutionException e){
            out.println("WRONG_INPUT");
        }
        return null;
    }
    /**
     * the method asks to the first user the number of players that are going to play
     */
    @Override
    public void askNumberPlayer() {
        String question = "How many player are going to play 2,3 or 4?";

        try{
            int numberOfPlayers = numberInput(2 ,4 , null , question);
            clientController.handleCreateBoard(numberOfPlayers , nickname);
        }catch (ExecutionException e){
            out.println("WRONG_INPUT");
        }

    }

    /**
     * The method is used to select the cards tomtake from the board , and it sends the message to controller
     */
    @Override
    public void askCardsToTakeFromBoard(){
        int numberOfCards , i , x , y;
        Position positions [] = {};
        String question = "How many card do you want to take";
        String questionX = "Type the x value of the card to take";
        String questionY = "Type the y value of the card to take";
        try{
            numberOfCards = numberInput(1,3,null , question);
        }catch(ExecutionException e){
            out.println("WRONG_INPUT");
            return ;
        }
        for(i=0 ; i<numberOfCards ; i++){
            try{
                x = numberInput(0,8 , null , questionX);
                y= numberInput(0,8, null , questionY);
                positions[i]=new Position(x,y);

            }catch(ExecutionException e ){
                out.println("WRONG_INPUT");
            }
            clientController.handleTakeCard(positions , nickname);
        }



    }
    /**
     * The method asks the player if it wants to get dissconnected or not
     */


    @Override
    public void askForDissconection() {
        out.println("Are you sure that you want to dissconnect?");
        try{
            String answer = readLine();
            if(answer.equalsIgnoreCase("yes")){
                clientController.handleDisconection(nickname);
            }
            else if(answer.equalsIgnoreCase("no")){
                return ;
            }
            else{
                out.println("WRONG_INPUT");
            }

        }catch(ExecutionException e){
            out.println("WRONG_INPUT");
        }
    }

    @Override
    public void createMatch(Match match) {
        clientController.handleCreateMatch(match);
    }

    /**
     * The method sends a request to get the coloumns where it can put its cards
     */

    public void requestForColumns(){
        int numberOfCards;
        //Accedere al metodo nella virtual model per vedere se le carte richieste sono valide e avere il loro numero
        //clientController.handleColoumnRequest(numberOfCards , nickname);
    }

    /**
     * The method sends a request to get the final points
     */
    public void requestForFinalPoint(){
        out.println("The Final points for every player are the following");
        clientController.handleFinalPoint(nickname);
        //Fare la richiesta di show final point al virtual model
    }

    @Override
    public void onShowReq(String s) {
        out.println(s);
    }

    @Override
    public void onNicknameReq() {
        //Forse nickname non devo inizializzarlo nel costruttore ma devo mandare un messaggio per quello
    }

    @Override
    public void onNumbPlayerReq() {
        askNumberPlayer();
    }

    @Override
    public void onShowNewBoardReq(Board board) {
        int i , j ;
        for(i=0 ; i<9 ; i++){
            for(j=0 ; j<9 ; j++){
                out.print(board.getCard(i,j).getColour());
            }
            out.println("");
        }

    }

    @Override
    public void onNotifyNewLibraryReq(String nickname, Library library) {
        onShowNewMyLibraryReq(library);
    }

    @Override
    public void onNotifyGameFullReq() {
        out.println("You can not partecipate as the game is already full");
    }

    @Override
    public void onNotifyPlayerDisconnectionReq(Player player) {
        out.println("Player" + player.getNickname() + "has left the game");
    }

    @Override
    public void onNotifyPlayerReconnectionReq(Player player) {
        out.println("Player" + player.getNickname() + "has returned to the game");
    }

    @Override
    public void onNotifyPlayerConnectionReq(Player player) {
        //Risposta di accept player?
    }

    @Override
    public void onNotifyReachedCommonGoalCardReq(EffectiveCard completedEffectiveCard, int score) {
        out.println("You have completed the following goal");
        completedEffectiveCard.show();
        out.println("And your score is " + score);
    }

    @Override
    public void onNotifyChairAssignedReq(String nickname) {
        out.println("The chair has been assigned to " + nickname);
    }

    @Override
    public void onShowPossibleColumnReq(int[] x, Library library) {
        int[] excludedNumbers = {};
        int i , indexExcludedNumbers=0 , selectedColumn;
        ArrayList<Integer> excludedNumbersArrayList = new ArrayList<Integer>();
        for(i=0 ; i<5 ; i++){
            if(x[i]==i){

            }
            else{
                excludedNumbers[indexExcludedNumbers]=i;
                indexExcludedNumbers++;
            }
        }
        String question = "Select the coloumn to put your cards from the shown coloumns.";
        for(i=0 ; i<excludedNumbers.length ; i++){
            excludedNumbersArrayList.add(excludedNumbers[i]);
        }

        try{
            selectedColumn = numberInput(0 , 4 , excludedNumbersArrayList , question);
        }catch(ExecutionException e){
            out.println("WRONG_INPUT");
        }
        //classe messaggio per mettere le carte oin library
    }

    @Override
    public void onNotifyCardsAreNotAdjacentReq() {
        //NOn serve forse perchè il controllo di carte non adiacenti si fa nel modello
    }

    @Override
    public void onNotifyConnectionAcceptedReq() {
        out.println("You have been accepted");
    }

    @Override
    public void onNotifyNumbPlayerReq(int playerNum) {
        out.println("The number of players is" + playerNum);
    }

    @Override
    public void onNotifyPlayerFinishedFirstReq(Player player) {
        out.println("The player that finished first is" + player.getNickname());
    }

    @Override
    public void onNotifyMatchHasStartedReq(ArrayList<Player> players) {
        out.println("The game has started and the names of the players are the following :");
        for(Player p : players){
            out.println(p.getNickname());
        }
    }

    @Override
    public void onShowFinalScoreBoardReq(HashMap<String, Integer> point) {
        //Far vedere la risposta del Fianl_point
    }

    @Override
    public void onShowNewMyLibraryReq(Library l) {
        int i , j;
        for(i=0 ; i<6 ; i++){
            for(j=0 ; j<5 ; j++){
                out.print(l.getCardinPos(j,i).getColour()+"   ");
            }
            out.println("");
        }

    }
}
