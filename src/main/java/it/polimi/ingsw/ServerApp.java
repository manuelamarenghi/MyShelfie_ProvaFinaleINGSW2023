package it.polimi.ingsw;

import it.polimi.ingsw.Controller.MatchController;
import it.polimi.ingsw.network.Server;
import it.polimi.ingsw.network.SocketServer;

public class ServerApp {
    public static void main(String[] args) {
        int serverPort = 16847; // default value
        MatchController matchController = new MatchController();
        Server server = new Server(matchController);

        SocketServer socketServer = new SocketServer(server, serverPort);
        Thread thread = new Thread(socketServer, "socketserver_");
        System.out.println("Server waiting");
        thread.start();
    }
}
