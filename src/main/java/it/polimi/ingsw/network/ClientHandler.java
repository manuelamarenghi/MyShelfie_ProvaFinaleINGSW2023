package it.polimi.ingsw.network;

import it.polimi.ingsw.message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * this class manage connection from a client to the server and handles message's requests
 */

public class ClientHandler implements Runnable {

    private  Server server;
    private  Socket client;
    private  ServerSocket serversocket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private boolean connected;
    public ClientHandler(Socket client,ServerSocket serversock,Server server){
        this.client=client;
        this.server=server;
        this.serversocket=serversock;
        this.connected=true;
        try {
            this.output = new ObjectOutputStream(client.getOutputStream());
            this.input = new ObjectInputStream(client.getInputStream());
        } catch (IOException e) {

        }
    }
    public ClientHandler(){

    }

    /**
     * ClientHandler checks if the connection isn't dropped and shares the request with the server that has methods to satisfy it
     */
    @Override
    public void run () {
        try {
            System.out.println("Inizio a gestire messaggio");
            handleClientConnection();
        } catch (Exception e) {
            //disconnect();
            System.out.println(e);
        }
    }
    /**
     * disconnect() handles the disconnection of a client
     */
    private void disconnect() {
        System.out.println("client disconnesso");
        if (connected) {
            try {
                if (!client.isClosed()) {
                    client.close();
                }
            } catch (IOException e) {

            }
            connected = false;
            Thread.currentThread().interrupt();
            server.HandleDisconnection();
        }
    }
    /**
     * handleClientConnection() after deserialization of message handle it with server's methods
     */
    private void handleClientConnection() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                    Message message = (Message) input.readObject();
                    if(message.getType().equals("Ping!")){
                        sendMessage(new Message("server","Pong!"));
                    }
                    else if(message.getType().equals("enter_player")){
                        server.addClient(message.getnickname(),this);
                    }
                    else{
                        if(message.getType().equals("Client_has_disconnected")){
                            server.removeClient(message.getnickname());
                        }
                        else {
                                if(message.getType().equals("Mex_in_chat")){
                                    server.broadcastMessage(this,message);
                                }
                                else{
                                    server.onMessageReceived(message);
                                }
                            }
                        }
                    }
        } catch (ClassCastException | ClassNotFoundException | IOException e) {
            //disconnect();
            System.out.println(e);
        }
    }
    /**
     * sendMessage() is used to send message to the client of this specific clientHanlder
     * @param message
     */
    public synchronized void sendMessage(Message message){
        try {
                output.writeObject(message);
                output.reset();

        } catch (IOException e) {
            //disconnect();
            System.out.println(e);
        }
    }
    public boolean isConnected() {
        return connected;
    }
}
