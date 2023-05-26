package it.polimi.ingsw.view;

import it.polimi.ingsw.message.Receiving_Mex;
import it.polimi.ingsw.modello.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Cli extends ObservableViewClient implements ViewClient {

    private final PrintStream out;
    private Thread inputThread;

    private String nickname;


    /**
     * Default constructor.
     */
    public Cli() {
        out = System.out;
        //this.clientController=clientController;
    }

    /**
     * check ip address
     *
     * @param ip ip address server
     * @return true: valide ip address
     */
    private static boolean validate(final String ip) {
        if (ip.equals("localhost")) return true;
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(PATTERN);
    }

    /**
     * The method initial game
     */

    public void init() {
        String address;
        out.println("Welcome to My Shelfie Game!");
        try {
            do {
                out.print("IP ADDRESS : ");
                address = readLine();
            } while (!validate(address));
            String finalAddress = address;
            this.notifyObserver(observerViewClient -> observerViewClient.setServerInfo(finalAddress));

        } catch (ExecutionException e) {
            System.out.println("WRONG_INPUT");
        }
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
     * The method asks to the user the nickname it wants to use
     *
     * @return it returns the nickname typed by the user
     */

    @Override
    public void askNickname() {
        out.println("Type your nickname.");
        try {
            nickname = readLine();
        } catch (ExecutionException e) {
            out.println("WRONG_INPUT");
        }
        this.notifyObserver(observerViewClient -> observerViewClient.handleEnterPlayer(nickname));
    }

    /**
     * the method asks to the first user the number of players that are going to play
     */
    @Override
    public void askNumberPlayer() {
        String question = "How many player are going to play 2,3 or 4?";

        try {
            int numberOfPlayers = numberInput(2, 4, null, question);
            this.notifyObserver(observerViewClient -> observerViewClient.handleCreateBoard(numberOfPlayers));
            //clientController.handleCreateBoard(numberOfPlayers , nickname);
        } catch (ExecutionException e) {
            out.println("WRONG_INPUT");
        }
    }

    /**
     * The method is used to select the cards to take from the board , and it sends the message to controller
     */
    @Override
    public void askCardsToTakeFromBoard() {
        int i, x, y;
        int numberOfCards = -1;

        String action = "";
        System.out.println("Write 'action' if you don't take card\n" +
                "Write other if you take card");
        try {
            action = readLine();
        } catch (ExecutionException e) {
            out.println("WRONG_INPUT");
        }

        while (action.equals("action")) {
            actionByPlayer();
            System.out.println("Write 'action' if you don't tak card\n" +
                    "Write other if you take card");
            try {
                action = readLine();
            } catch (ExecutionException e) {
                out.println("WRONG_INPUT");
            }
        }

        String question = "How many card do you want to take";
        String questionX = "Type the x value of the card to take";
        String questionY = "Type the y value of the card to take";
        try {
            numberOfCards = numberInput(1, 3, null, question);
        } catch (ExecutionException e) {
            out.println(e);
        }
        System.out.println("Choose card in order");
        Position[] positions = new Position[numberOfCards];
        for (i = 0; i < numberOfCards; i++) {
            try {
                x = numberInput(0, 8, null, questionX);
                y = numberInput(0, 8, null, questionY);
                positions[i] = new Position(x, y);

            } catch (ExecutionException e) {
                out.println(e);
            }

        }
        this.notifyObserver(observerViewClient -> observerViewClient.handleTakeCard(positions));

    }

    /**
     * The method returns the columns in which the card can be put
     *
     * @param x       possible columns
     * @param library player library
     */
    @Override
    public void onShowPossibleColumnReq(int[] x, ArrayList<Card> cards, Library library) {
        System.out.println("You can choose these columns");

        ArrayList<Integer> excludedNumbers = new ArrayList<>();
        int i, selectedColumn = 0;
        ArrayList<Integer> excludedNumbersArrayList = new ArrayList<Integer>();

        int j = 0;
        for (i = 0; i < 5; i++) {
            if (j < x.length) {
                if (x[j] == i) {
                    System.out.print(x[j] + ",");
                    j++;
                } else
                    excludedNumbers.add(i);
            }
        }
        out.println();
        String action = "";
        System.out.println("Write 'action' if you don't choose the column\n" +
                "Write other if you take card");
        try {
            action = readLine();
        } catch (ExecutionException e) {
            out.println("WRONG_INPUT");
        }

        while (action.equals("action")) {
            actionByPlayer();
            System.out.println("Write 'action' if you don't tak card\n" +
                    "Write other if you take card");
            try {
                action = readLine();
            } catch (ExecutionException e) {
                out.println("WRONG_INPUT");
            }
        }

        String question = "Select the coloumn to put your cards from the shown coloumns.";
        for (i = 0; i < excludedNumbers.size(); i++) {
            excludedNumbersArrayList.add(excludedNumbers.get(i));
        }
        try {
            selectedColumn = numberInput(0, 4, excludedNumbersArrayList, question);
        } catch (ExecutionException e) {
            out.println("WRONG_INPUT");
        }

        int finalSelectedColumn = selectedColumn;
        this.notifyObserver(observerViewClient -> observerViewClient.handlePutInLibrary(finalSelectedColumn));

    }

    /**
     * The method is used to show the actions that the player can do and lets the player choose
     */
    public void actionByPlayer() {
        System.out.println("You can do these actions: \n" +
                "1-See the board \n" +
                "2-See your personal card \n" +
                "3-See the common goal card\n" +
                "4-See the library of other players\n" +
                "5-Chat");
        String question = "Write the number of action";
        try {
            int actionNumber = numberInput(1, 5, null, question);
            switch (actionNumber) {
                case 1:
                    this.notifyObserver(observerViewClient -> observerViewClient.handleSeeBoard());
                    break;
                case 2:
                    this.notifyObserver(observerViewClient -> observerViewClient.handleSeePersonalCard());
                    break;
                case 3:
                    this.notifyObserver(observerViewClient -> observerViewClient.handleSeeCommonCard());
                    break;
                case 4:
                    seeOtherLibrary();
                    break;
                case 5:
                    this.notifyObserver(observerViewClient -> observerViewClient.ReadMessageChat());
            }
        } catch (ExecutionException e) {
            out.println("WRONG_INPUT");
        }


    }

    /**
     * request to see library of other players
     */
    public void seeOtherLibrary() {
        try {
            System.out.println("Which player's library you want to see?");
            String playerName = readLine();
            this.notifyObserver(observerViewClient -> observerViewClient.SeeSomeoneLibrary(playerName));
        } catch (ExecutionException e) {
            out.println("WRONG_INPUT");
        }

    }

    /**
     * Don't have player with this nickname.
     */
    public void errorNickname(ArrayList<String> players) {
        System.out.println("Not exist the player with this nickname." +
                "Choose other nickname");
        System.out.println("The nickname of the players in the game");
        for (String player : players) {
            System.out.print(player + " , ");
        }

        seeOtherLibrary();
    }


    /**
     * The method can chat with other player
     */

    public void sendMessageChat(ArrayList<String> players) {
        ArrayList<String> dest = new ArrayList<>();
        String message = "";

        try {
            System.out.println("list of player can you send message:\n");

            for (String player : players) {
                if (!player.equals(nickname)) {
                    System.out.println(players.indexOf(player) + " : " + player);
                }
            }
            System.out.println(players.size() + " : " + "Group Chat");
            String question = "Choose player, write the corresponding number";
            int action = numberInput(0, players.size(), null, question);
            if (action < players.size())
                dest.add(players.get(action));
            else
                dest = new ArrayList<>(players);
            System.out.println("Write message");
            message = readLine();
        } catch (ExecutionException e) {
            System.out.println("WRONG_INPUT");
        }

        ArrayList<String> finalDest = dest;
        String finalMessage = message;
        this.notifyObserver(observerViewClient -> observerViewClient.handleMexChat(finalDest, finalMessage));

    }

    @Override
    public void readMessageChat(ArrayList<Receiving_Mex> message, ArrayList<String> players) {
        for (Receiving_Mex m : message) {
            String mex = "";
            if (m.getDest().equals("Group_Chat"))
                mex += "Group Chat - ";
            else
                mex += "Private Chat - ";
            mex += m.getnickname() + " : " + m.getMex();
            System.out.println(mex);

        }
        try {
            String question = "1-Send Message\n" +
                    "2-Exit chat\n";
            int action = numberInput(1, 2, null, question);
            if (action == 1)
                sendMessageChat(players);
            else
                return;
        } catch (ExecutionException e) {
            System.out.println("WRONG_INPUT");
        }
    }

    /**
     * The method asks the player if it wants to get dissconnected or not
     */

    @Override
    public void askForDissconection() {
        out.println("Are you sure that you want to dissconnect?");
        try {
            String answer = readLine();
            if (answer.equalsIgnoreCase("yes")) {
                this.notifyObserver(observerViewClient -> observerViewClient.handleDisconection(nickname));
                //clientController.handleDisconection(nickname);
            } else if (answer.equalsIgnoreCase("no")) {
                return;
            } else {
                out.println("WRONG_INPUT");
            }

        } catch (ExecutionException e) {
            out.println("WRONG_INPUT");
        }
    }

    /**
     * The method prints on the screen the payload of the player
     *
     * @param s
     */
    @Override
    public void onShowReq(String s) {
        out.println(s);
    }

    /**
     * The method calls the method askNumberPlayer() per chiedere all'utente il numero dei giocatori
     */
    @Override
    public void onNumbPlayerReq() {
        askNumberPlayer();
    }

    /**
     * The method prints the updated board
     *
     * @param board
     */
    @Override
    public void onShowNewBoardReq(Board board) {
        board.showBoard();
    }

    /**
     * The method prints the message when the game is over
     */
    @Override
    public void onNotifyGameFullReq() {
        out.println("You can not partecipate as the game is already full");
    }

    /**
     * The method prints the name of tha player which has been disconnected
     *
     * @param player
     */
    @Override
    public void onNotifyPlayerDisconnectionReq(Player player) {
        out.println("Player " + player.getNickname() + "has left the game");
    }

    /**
     * The method notifies when the player has been reconnected
     *
     * @param player
     */
    //@Override
    public void onNotifyPlayerReconnectionReq(Player player) {
        out.println("Player " + player.getNickname() + "has returned to the game");
    }

    @Override
    public void onNotifyPlayerConnectionReq(String nickname, boolean you) {
        if (nickname.equals(this.nickname)) {
            out.println("Connected");
            this.nickname = nickname;
            notifyObserver(obs -> obs.setNickname(nickname));
        } else {
            out.println("The player " + nickname + " has entered in the game");
        }
    }


    /**
     * The method shows the common goal card the has been completed and it's score
     *
     * @param completedEffectiveCard
     * @param score
     */
    @Override
    public void onNotifyReachedCommonGoalCardReq(String nickname, EffectiveCard completedEffectiveCard, int score) {
        if (nickname.equals(this.nickname))
            out.println("You have completed the following goal");
        else
            out.println("The player " + nickname + " completed the following goal");
        completedEffectiveCard.show();
        out.println("And score is " + score);
    }

    /**
     * The method tells the player to who the chair has been assigned
     *
     * @param nickname
     */
    @Override
    public void onNotifyChairAssignedReq(String nickname) {
        out.println("The chair has been assigned to " + nickname);
    }


    /**
     * The method tells the player that the cards selected are not adjacent so it needs to select other cards
     */
    @Override
    public void onNotifyCardsAreNotAdjacentReq() {
        out.println("Selected cards cannot be selected, choose other cards");
        askCardsToTakeFromBoard();

    }

    /**
     * The method prints on the screen the number of players if it is requested by anyone
     *
     * @param playerNum
     */
    @Override
    public void onNotifyNumbPlayerReq(int playerNum) {
        out.println("The number of players is " + playerNum);
    }

    /**
     * The method prints the name of the player that has finished it's library
     *
     * @param player
     */
    @Override
    public void onNotifyPlayerFinishedFirstReq(Player player) {
        out.println("The player " + player.getNickname() + " has finished");
        out.println("LAST ROUND");
    }

    /**
     * The method prints a message to tell everyone that the match has started and it prints name of all the players
     *
     * @param players
     */
    @Override
    public void onNotifyMatchHasStartedReq(ArrayList<Player> players) {
        out.println("The game has started and the names of the players are the following :");
        for (Player p : players) {
            out.println(p.getNickname());
        }
    }

    /**
     * The method prints the final score of all the players
     *
     * @param points
     */
    @Override
    public void onShowFinalScoreBoardReq(HashMap<String, Integer> points) {

        points.forEach((key, value) -> System.out.println("The points are " + key + " : " + value));

        out.println("The game is finished");
        System.exit(0);

    }

    /**
     * The method prints the new updated library
     *
     * @param l
     */
    @Override
    public void onShowNewMyLibraryReq(Library l, String name) {
        l.showLibrary();
    }

    /**
     * the methodnotifies if the dissconnection has been done successfully
     */
    @Override
    public void onNotifyDisconnectionReqAcceptedAns() {
        out.println("The dissconnection has been done successfully");
    }

    /**
     *
     */
    @Override
    public void onNotifyNewNicknameReq() {
        out.println("Choose another nickname.");
        askNickname();
    }

    @Override
    public void onNotifyIsYourTurnReq(Board board, Library library) {
        out.println(nickname + ": it's your turn");
        out.println("Your library :");
        library.showLibrary();
        out.println("The board :");
        board.showBoard();
        askCardsToTakeFromBoard();

    }

    @Override
    public void onNotifyYourTurnIsEndedReq(String current_player) {
        out.println("Your turn is over , now it is " + current_player + "'s turn");
    }

    @Override
    public void onNotifyWhoIsPlayingNowReq(String current_player) {
        out.println(current_player + " is playing right now .");
    }

    @Override
    public void onNotifyPersonalCardReq(PersonalGoalCard personalGoalCard) {
        personalGoalCard.showPersonalGoalCard();
    }

    @Override
    public void NotifyaskNicknameReq() {
        try {
            System.out.println("First Player is connected. Try again later");
            Thread.sleep(5000);
            askNickname();
        } catch (InterruptedException e) {

        }
    }

    /**
     * The method prints the players of the match
     *
     * @param players
     */

    @Override
    public void onNotifyAllPlayerReq(ArrayList<String> players) {
        System.out.println("The players in the match: " + players.toString());
    }

    @Override
    public void onNotifyCommonCards(EffectiveCard[] cards) {
        for (EffectiveCard effectiveCard : cards) {
            effectiveCard.show();

            System.out.println("DESCRIPTION : " + effectiveCard.description());
        }
    }

    @Override
    public void onNotifyMexInChat(String getnickname, String mex, String dest) {

    }

    @Override
    public void onPressedButtonChange(String scene) {

    }

    @Override
    public void setNickname(String nickname) {

    }
}
