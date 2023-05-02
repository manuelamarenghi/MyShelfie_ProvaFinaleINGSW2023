package it.polimi.ingsw.message;

public class AnotherPlayerDisconnect extends Message{
    public AnotherPlayerDisconnect(String name){
        super(name,"player_disconnected");
    }
}
