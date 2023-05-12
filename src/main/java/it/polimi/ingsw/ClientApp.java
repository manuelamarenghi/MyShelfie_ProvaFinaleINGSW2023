package it.polimi.ingsw;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.network.MessageHandler;
import it.polimi.ingsw.network.SocketClient;
import it.polimi.ingsw.view.Cli;
import it.polimi.ingsw.view.GUI.JavaFXApplication;
import it.polimi.ingsw.view.VirtualModel;
import javafx.application.Application;

import java.io.IOException;

public class ClientApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Match match = new Match();
        SocketClient socketClient = new SocketClient("localhost" , 16847);
        socketClient.readMessage();

        VirtualModel virtualModel = new VirtualModel(match);
        MessageHandler messageHandler = new MessageHandler(virtualModel);
        socketClient.addObserver(messageHandler);
        Cli cli = new Cli();
        virtualModel.addObserver(cli);
        ClientController clientController = new ClientController(cli, virtualModel,socketClient);
        cli.addObserver(clientController);
        cli.start();
        Application.launch(JavaFXApplication.class);
    }
}

