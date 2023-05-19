package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChatController extends ObservableViewClient implements Controller {
    @FXML
    private ListView ChatsAvaiable;
    @FXML
    private Button Send;
    @FXML
    private TextArea Chat;
    @FXML
    private TextField WriteArea;
    private Map<String, ArrayList<String>> StoredChat;
    private ArrayList<String> dest;
    private ArrayList<String> all;
    private String nickname;
    private String selectedItem;

    public void initialize() {
        selectedItem = new String();
        dest = new ArrayList<>();
        Chat.setEditable(false);
        ArrayList<String> names = new ArrayList<>();
        names.add("carlo");
        names.add("giada");
        names.add("rita");
        setChats(names);
        arrivedMex("carlo", "ciaoo", "you");
    }

    public void setYourNickname(String nick) {
        nickname = nick;
    }

    public void setChats(ArrayList<String> players) {
        all = new ArrayList<>();
        StoredChat = Collections.synchronizedMap(new HashMap<>());
        for (String name : players) {
            ArrayList<String> chat = new ArrayList<>();
            all.add(name);
            StoredChat.put(name, chat);
            ChatsAvaiable.getItems().add(name);
        }
        ChatsAvaiable.getItems().add("Group Chat");
        ArrayList<String> chat = new ArrayList<>();
        StoredChat.put("Group Chat", chat);
        ChatsAvaiable.setOnMouseClicked(event -> {
            Chat.clear();
            selectedItem = (String) ChatsAvaiable.getSelectionModel().getSelectedItem();
            if (selectedItem.equals("Group Chat")) {
                dest = all;
            } else {
                dest.add(selectedItem);
            }
            if (!StoredChat.get(selectedItem).isEmpty()) {
                for (String x : StoredChat.get(selectedItem)) {
                    Chat.appendText(x + "\n");
                }
            }
        });
    }

    public void pressedButton(MouseEvent mouseEvent) {
        String mex = WriteArea.getText();
        WriteArea.clear();
        Chat.appendText("You: " + mex + "\n");
        String message = nickname + ": " + mex;
        if (dest.size() != 1) {
            StoredChat.get("Group Chat");
        } else {
            StoredChat.get(dest.get(0));
        }
        this.notifyObserver(observerViewClient -> observerViewClient.handleMexChat(dest, message));
        dest.clear();
    }

    public void removePlayer(String name) {
        ObservableList<String> allname = ChatsAvaiable.getItems();
        StoredChat.remove(name);
        all.remove(name);
        for (String s : allname) {
            if (s.equals(name)) {
                ChatsAvaiable.getItems().remove(s);
            }
        }
    }

    public void arrivedMex(String getnickname, String mex, String dest) {
        if (dest.equals("you")) {
            StoredChat.get(getnickname).add(getnickname + ": " + mex + "\n");
        } else {
            StoredChat.get("Group Chat").add(getnickname + ": " + mex + "\n");
        }
        if (selectedItem.equals(dest)) {
            Chat.appendText(getnickname + ": " + mex + "\n");
        }
        if (selectedItem.equals(getnickname)) {
            Chat.appendText(getnickname + ": " + mex + "\n");
        }
    }
}
