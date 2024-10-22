package it.polimi.ingsw.network;

import it.polimi.ingsw.message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SocketClient extends Client {
    private final int TIMEOUT = 10000;
    private final Socket socket;
    private final ObjectOutputStream outputStream;
    private final ObjectInputStream inputStream;

    private final ExecutorService messageReader;
    private final ScheduledExecutorService pinger;
    private String nickname;

    /**
     * First constructor for the socket client
     *
     * @param address
     * @param port
     * @throws IOException
     */
    public SocketClient(String address, int port) throws IOException {
        this.socket = new Socket();
        this.socket.connect(new InetSocketAddress(address, port), TIMEOUT);
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
        this.inputStream = new ObjectInputStream(socket.getInputStream());
        this.messageReader = Executors.newSingleThreadExecutor();
        this.pinger = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * Second constructor for the socket client
     *
     * @param address
     * @param port
     * @param nickname
     * @throws IOException
     */
    public SocketClient(String address, int port, String nickname) throws IOException {
        this.socket = new Socket();
        this.socket.connect(new InetSocketAddress(address, port), TIMEOUT);
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
        this.inputStream = new ObjectInputStream(socket.getInputStream());
        this.messageReader = Executors.newSingleThreadExecutor();
        this.pinger = Executors.newSingleThreadScheduledExecutor();
        this.nickname = nickname;
    }

    /**
     * A method to send a message to the sockest server
     *
     * @param message
     */
    @Override
    public synchronized void sendMessage(Message message) {
        try {
            outputStream.writeObject(message);
            outputStream.reset();
        } catch (IOException exception) {
            System.out.println("errore nel mandare mex");
            notifyObserver(new Message(message.getnickname(), "Couldn't send message"));
        }
    }

    /**
     * A method to read a message recieved from the server
     */

    @Override
    public synchronized void readMessage() {
        messageReader.execute(() -> {
            while (!messageReader.isShutdown()) {
                Message message;
                try {
                    message = (Message) inputStream.readObject();
                    //System.out.println(message.getType());
                } catch (IOException | ClassNotFoundException exception) {
                    message = new Message(nickname, "Connection lost with server.");
                    System.exit(0);
                }
                notifyObserver(message);
            }
        });
    }

    /**
     * A method to disconnect
     */
    @Override
    public void disconnect() {
        try {
            if (!socket.isClosed()) {
                messageReader.shutdown();
                socket.close();
            }
        } catch (IOException exception) {
            notifyObserver(new Message(nickname, "Couldn't disconnect"));
        }
    }

    /**
     * A method to enable the pinger
     *
     * @param enabled
     */
    public void enablePinger(boolean enabled) {
        if (enabled) {
            pinger.scheduleAtFixedRate(() -> sendMessage(new Message(nickname, "Ping!")), 0, 1000, TimeUnit.MILLISECONDS);
        } else {
            pinger.shutdownNow();
        }
    }
}
