package it.polimi.ingsw;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.SocketClient;
import it.polimi.ingsw.view.Cli;

import java.io.IOException;

public class ClientApp {
    public static void main(String[] args) throws IOException {
      /*  boolean cliParam = false; // default value

        for (String arg : args) {
            if (arg.equals("--cli") || arg.equals("-c")) {
                cliParam = true;
                break;
            }
        }

        if (cliParam) {
            Cli view = new Cli();
            ClientController clientcontroller = new ClientController(null,null);
        } else {
            //Application.launch(JavaFXGui.class);
        }*/
        SocketClient sClient=new SocketClient("localhost",16847);
        System.out.println("Trying to connect to the server");
        Message m=new Message("niki","Ping!");
        sClient.sendMessage(m);
        sClient.readMessage();
    }
}
