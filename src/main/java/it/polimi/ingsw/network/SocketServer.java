package it.polimi.ingsw.network;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer implements Runnable{
    private final Server server;
    private final int port;
    ServerSocket serverSocket;

    public SocketServer(Server server, int port) {
        this.server = server;
        this.port=port;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {

        }
    }
}
