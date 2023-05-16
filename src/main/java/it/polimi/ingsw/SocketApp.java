package it.polimi.ingsw;

import it.polimi.ingsw.message.AcceptPlayer;
import it.polimi.ingsw.message.EnterPlayer;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.Numb_Player;
import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.SocketClient;

import java.io.IOException;
import java.util.Scanner;

public class SocketApp {
    static Scanner in=new Scanner(System.in);

    /*public static void main(String[] args) throws IOException {
        Client client = new SocketClient("localhost",16847);
        client.readMessage();

        System.out.println("Inserisci il nickname");
        String nickname = in.nextLine();

        client.sendMessage(new EnterPlayer(nickname));

        client.sendMessage(new Numb_Player(3,nickname));




        

    }*/

}
