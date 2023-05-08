package it.polimi.ingsw;

import it.polimi.ingsw.Controller.ClientController;
import it.polimi.ingsw.message.*;
import it.polimi.ingsw.network.Client;
import it.polimi.ingsw.network.SocketClient;
import it.polimi.ingsw.view.Cli;

import java.io.IOException;
import java.util.Scanner;

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
        Scanner in=new Scanner(System.in);
        SocketClient sClient=new SocketClient("localhost",16847);
        System.out.println("inserire nickname");
        String s=in.nextLine();
        Message m=new EnterPlayer(s);
        sClient.sendMessage(m);
        sClient.readMessage();
        Message m2;
        int x;
        if(s.equals("giada")){
        x= in.nextInt();
        m2=new Numb_Player(x,s);
        sClient.sendMessage(m2);
        sClient.readMessage();}
        System.out.println("inserire 1 per uscire, 2 mandare mex ");
        x= in.nextInt();
        if(x==1){
            m2=new Disconnection(s);
            sClient.sendMessage(m2);
        }
        else{
            m2=new MexInChat("Hi there",s);
            sClient.sendMessage(m2);
        }
        sClient.readMessage();
    }
}

