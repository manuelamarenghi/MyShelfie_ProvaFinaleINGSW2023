package it.polimi.ingsw;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.network.SocketClient;
import it.polimi.ingsw.view.Cli;

import java.io.IOException;

public class ClientApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Match match = new Match();
        SocketClient socketClient = new SocketClient("localhost", 16847);
        socketClient.readMessage();


        Cli cli = new Cli();

        ClientController clientController = new ClientController(cli, socketClient);
        cli.addObserver(clientController);
        cli.start();
        //Application.launch(JavaFXApplication.class);
    }
}

