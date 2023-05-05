package it.polimi.ingsw.view;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.*;

import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Cli implements View{
    private final PrintStream out;
    private final String nickname;
    private Thread inputThread;
    private ClientController clientController;

    /**
     * Default constructor.
     */
    public Cli(ClientController clientController) {
        this.nickname=askNicknameReturn();
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

        // A null jumpList will be transformed in a empty list.
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

    public String askNicknameReturn() {
        out.println("Type your nickanme.");
        try{
            return readLine();
        }catch(ExecutionException e){
            out.println("WRONG_INPUT");
        }
        return null;
    }

    /**
     *The method asks to the user the nickname it wants to use
     * @return it returns the nickname typed by the user
     */

    @Override
    public void askNickname() {
    }

    /**
     * the method asks to the first user the number of players that are going to play
     */
    @Override
    public void askNumbPlayer() {
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

    public void askCardsToTakeFromBoard(){
        int numberOfCards , i , x , y;
        Card cards [] = {};
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
                //cards[i]=VirtualModel.getBoard().getCardInPos(x,y);

            }catch(ExecutionException e ){
                out.println("WRONG_INPUT");
            }
            clientController.handleTakeCard(cards , nickname);
        }



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

    /**
     * The method asks the player if it wants to get dissconnected or not
     */

    public void checkDissconnection(){
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
        clientController.handleCreateMatch(m);
    }



}
