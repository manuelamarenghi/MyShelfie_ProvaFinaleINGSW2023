package it.polimi.ingsw.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

/**
 * This class is used to read the input stream and making the input kind of interruptible.
 */
public class InputReadTask implements Callable<String> {
    private final BufferedReader br;

    /**
     * Method to take input from the player
     */
    public InputReadTask() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * A methos that return the input read from the playe r
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public String call() throws IOException, InterruptedException {
        String input;
        // wait until there is data to complete a readLine()
        while (!br.ready()) {
            Thread.sleep(200);
        }
        input = br.readLine();
        return input;
    }
}