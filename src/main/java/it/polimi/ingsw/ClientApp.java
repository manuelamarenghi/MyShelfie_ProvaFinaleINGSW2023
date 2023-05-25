package it.polimi.ingsw;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.view.Cli;
import it.polimi.ingsw.view.GUI.JavaFXApplication;
import javafx.application.Application;

import java.io.IOException;

public class ClientApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean cliParam = false; // default value

        for (String arg : args) {
            if (arg.equals("--cli") || arg.equals("-c")) {
                cliParam = true;
                break;
            }
        }

        if (cliParam) {

            Cli cli = new Cli();

            ClientController clientController = new ClientController(cli);
            cli.addObserver(clientController);
            cli.init();
        } else {
            Application.launch(JavaFXApplication.class);
        }
    }
}

