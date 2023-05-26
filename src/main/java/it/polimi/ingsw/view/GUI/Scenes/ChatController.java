package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.*;

public class ChatController extends ObservableViewClient implements GenericSceneController {
    @FXML
    private Button Back = new Button();
    @FXML
    private ListView ChatsAvaiable = new ListView();
    @FXML
    private Button Send = new Button();
    @FXML
    private TextArea Chat = new TextArea();
    @FXML
    private TextField WriteArea = new TextField();
    private Map<String, ArrayList<String>> StoredChat;
    private ArrayList<String> dest;
    private ArrayList<String> all;
    private String nickname;
    private String selectedItem = new String();

    public void initialize() {
        dest = new ArrayList<>();
        Chat.setEditable(false);
        Send.addEventHandler(MouseEvent.MOUSE_CLICKED, this::pressedButton);
        Back.addEventHandler(MouseEvent.MOUSE_CLICKED, this::pressedBack);
        if (all != null) {
            System.out.println(all);
            ReloadChat(all);
        }
    }

    public void setYourNickname(String nick) {
        nickname = nick;
    }

    public void setChats(ArrayList<String> players) {
        all = new ArrayList<>();
        StoredChat = Collections.synchronizedMap(new HashMap<>());
        for (String name : players) {
            //ArrayList<String> chat = new ArrayList<>();
            all.add(name);
            StoredChat.put(name, new ArrayList<String>());
            ChatsAvaiable.getItems().add(name);

        }
        if (all.size() > 1) {
            ChatsAvaiable.getItems().add("Group Chat");
            ArrayList<String> chat = new ArrayList<>();
            StoredChat.put("Group Chat", chat);
        }

        ChatsAvaiable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dest.clear();
                Chat.clear();
                selectedItem = ChatsAvaiable.getSelectionModel().getSelectedItem().toString();
                if (selectedItem.equals("Group Chat")) {
                    for (String x : all) {
                        dest.add(x);
                    }
                } else {
                    dest.add(selectedItem);
                }
                if (!StoredChat.get(selectedItem).isEmpty()) {
                    for (String x : StoredChat.get(selectedItem)) {
                        Chat.appendText(x + "\n");
                    }
                }
            }
        });
    }

    public void ReloadChat(ArrayList<String> players) {
        System.out.println("All: " + Arrays.toString(players.toArray()));
        for (String name : StoredChat.keySet()) {
            ChatsAvaiable.getItems().add(name);
        }
        //ChatsAvaiable.getItems().add("Group Chat");
        ChatsAvaiable.setOnMouseClicked(event -> {
            Chat.clear();
            dest.clear();
            selectedItem = ChatsAvaiable.getSelectionModel().getSelectedItem().toString();
            if (selectedItem.equals("Group Chat")) {
                for (String x : all) {
                    dest.add(x);
                }
            } else {
                dest.add(selectedItem);
            }
            if (!StoredChat.get(selectedItem).isEmpty()) {
                for (String x : StoredChat.get(selectedItem)) {
                    Chat.appendText(x + "\n");
                }
            }
            System.out.println(Arrays.toString(dest.toArray()));
        });
    }

    public void pressedButton(MouseEvent mouseEvent) {
        String mex = WriteArea.getText();
        WriteArea.clear();
        Chat.appendText("You: " + mex + "\n");
        StoredChat.get(selectedItem).add("You: " + mex + "\n");
        String message = nickname + ": " + mex;
        if (dest.size() != 1) {
            StoredChat.get("Group Chat");
        } else {
            StoredChat.get(dest.get(0));
        }
        this.notifyObserver(observerViewClient -> observerViewClient.handleMexChat(dest, message));
    }

    public void removePlayer(String name) {
        ObservableList<String> allname = ChatsAvaiable.getItems();
        StoredChat.remove(name);
        System.out.println("rimuoviamo persona");
        all.remove(name);
        for (String s : allname) {
            if (s.equals(name)) {
                ChatsAvaiable.getItems().remove(s);
            }
        }
    }

    public void addPlayer(String name) {
        StoredChat.put(name, new ArrayList<>());
        all.add(name);
    }

    public void arrivedMex(String getnickname, String mex, String dest) {
        System.out.println(dest);
        if (dest.equals("you") || StoredChat.get("Group Chat") == null) {
            StoredChat.get(getnickname).add(mex + "\n");
        } else {
            StoredChat.get("Group Chat").add(mex + "\n");
        }
        if (selectedItem.equals(dest)) {
            Chat.appendText(mex + "\n");
        }
        if (selectedItem.equals(getnickname)) {
            Chat.appendText(mex + "\n");
        }
    }

    public void pressedBack(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.ChangeRoot("living"));
    }
}
