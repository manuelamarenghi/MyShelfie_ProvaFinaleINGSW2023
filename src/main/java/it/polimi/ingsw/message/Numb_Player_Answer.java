package it.polimi.ingsw.message;

public class Numb_Player_Answer extends Message{
    int x;
    public Numb_Player_Answer(int x) {
        super("Server", "Numb_Player_Set");
        this.x=x;
    }
    public int getX() {
        return x;
    }
}
