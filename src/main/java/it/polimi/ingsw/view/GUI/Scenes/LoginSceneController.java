package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

public class LoginSceneController extends ObservableViewClient implements GenericSceneController {
    @FXML
    public TextArea Area;
    public Button okButton;
    @FXML
    private StackPane Stack;
    public TextField name_txb;
    public TextField ip_txb;

    public void initialize() {
        Area.setEditable(false);
        Area.setVisible(false);
        ImageView image = new ImageView();
        image.fitWidthProperty();
        image.fitHeightProperty();
        Stack.getChildren().add(image);
    }

    private static boolean validate(final String ip) {
        if (ip.equals("localhost")) return true;
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(PATTERN);
    }

    public void onClick(ActionEvent actionEvent) {
        if (name_txb.getText().trim().equals("")) System.out.println("Inserire un nome");
        else if (!validate(ip_txb.getText().trim())) System.out.println("Inserire un ip valido");
        else this.notifyObserver(observerViewClient -> observerViewClient.handleEnterPlayer(name_txb.getText()));
        // name_txb.getStylesheets().add("text-red");
        name_txb.clear();
        ip_txb.clear();
    }

    public void onEnter(KeyEvent keyEvent) {
        //if(keyEvent.getCode()== KeyCode.ENTER)onClick(null);
    }

    public void onEnterNick(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) onClick(null);

    }

    public void onEnterIp(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) onClick(null);
    }

    public void Connect_before_first() {
        Area.setVisible(true);
        Area.appendText("First player is deciding number of players.Please try again\n");
    }

    public void NumbPlayer() {
        ip_txb.setVisible(false);
        ip_txb.setEditable(false);
        Area.setVisible(true);
        Area.appendText("Insert number of player between 2,3,4:");
        String numb = name_txb.getText();
        while (numb != "2" || numb != "3" || numb != "4") {
            Area.clear();
            Area.appendText("Insert a valid number");
        }
        this.notifyObserver(observers -> observers.handleCreateBoard(Integer.parseInt(numb)));
        this.notifyObserver(observers -> observers.ChangeRoot("wait"));
    }

    public void GameFull() {
        Area.appendText("I'm sorry.The game is already full of players\n");
    }
}
