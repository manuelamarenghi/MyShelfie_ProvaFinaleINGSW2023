package it.polimi.ingsw.network;

import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.MessageContent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketClient extends Client{
    private final int TIMEOUT=10000;
    private final Socket socket;
    private final ObjectOutputStream outputStream;
    private final ObjectInputStream inputStream;
    private String nickname;

    private final ExecutorService messageReader;

    public SocketClient(String address,int port) throws IOException {
        this.socket = new Socket();
        this.socket.connect(new InetSocketAddress(address,port),TIMEOUT);
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
        this.inputStream = new ObjectInputStream(socket.getInputStream());
        this.messageReader = Executors.newSingleThreadExecutor();
    }

    @Override
    public void sendMessage(Message message) {
        try {
            outputStream.writeObject(message);
            outputStream.reset();

        }catch(IOException exception){
            disconnect();
            notifyObservers(new Message(nickname,new MessageContent("Couldn't send message",null)));
        }
    }

    @Override
    public void readMessage() {
        messageReader.execute(()->{
            while(!messageReader.isShutdown()){
                Message message;
                try{
                    message=(Message)inputStream.readObject();
                }catch(IOException|ClassNotFoundException exception){
                    message=new Message(nickname,new MessageContent("Connection lost with server.",null));
                }
                notifyObservers(message);
            }
        });
    }

    @Override
    public void disconnect() {
        try{
            if(!socket.isClosed()){
                messageReader.shutdown();
                socket.close();
            }
        }catch(IOException exception){
            notifyObservers(new Message(nickname,new MessageContent("Couldn't disconnect",null)));
        }

    }
}
