package it.polimi.ingsw.view.GUI.Scenes.Storage;

import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.Library;

public class StorageLiving {
    private Board Board;
    private Library library;
    private int personal = -1;
    private boolean chair = false;
    private int Score0;
    private int Score1 = -1;
    private boolean FirstFinish = false;
    private String TextArea = new String();

    public Board getBoard() {
        return Board;
    }

    public void setBoard(Board b) {
        Board = b;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library l) {
        library = l;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public boolean isChair() {
        return chair;
    }

    public void setChair(boolean chair) {
        this.chair = chair;
    }


    public boolean isFirstFinish() {
        return FirstFinish;
    }

    public void setFirstFinish(boolean firstFinish) {
        FirstFinish = firstFinish;
    }

    public int getScore0() {
        return Score0;
    }

    public void setScore0(int score0) {
        Score0 = score0;
    }

    public int getScore1() {
        return Score1;
    }

    public void setScore1(int score1) {
        Score1 = score1;
    }

    public String getTextArea() {
        return TextArea;
    }

    public void setTextArea(String textArea) {
        TextArea = textArea;
    }
}
