package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Controller.observer.ObserverClient;
import it.polimi.ingsw.message.Message;
import it.polimi.ingsw.message.TwoPlayersMessage;
import it.polimi.ingsw.modello.Match;
import it.polimi.ingsw.modello.Matchmanager;
import it.polimi.ingsw.modello.NotUsableException;

import java.util.ArrayList;
import java.util.List;

public class ClientController {

    public void handleMessage (Message message){
        message.visit(this);
    }

    public void handleTwoPlayersBoard(TwoPlayersMessage message){
        Match match = message.getMatch();
        Matchmanager matchmanager = message.getMatchmanager();;

    }

}
