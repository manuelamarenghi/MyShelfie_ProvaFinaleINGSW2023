package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.GUI.SceneController;
import it.polimi.ingsw.view.ObservableViewClient;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.Arrays;

public class ConnectSceneController extends ObservableViewClient implements GenericSceneController{

    public Button okButton;
    public TextField ip_txb;
    public Text ip_txt;
    public StackPane Stack;

    public void initialize() {
        ImageView image = new ImageView();
        image.fitWidthProperty();
        image.fitHeightProperty();
        Stack.getChildren().add(image);
    }
    public void onClick(ActionEvent actionEvent) {
        if (!validate(ip_txb.getText().trim())) ip_txt.setText("Inserire un ip valido:");
        else {
            new Thread(() ->this.notifyObserver(obs -> obs.setServerInfo(ip_txb.getText()))).start();

        }
        ip_txb.clear();
    }
    public void onEnterIp(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) onClick(null);
    }

    public void onEnter(KeyEvent keyEvent) {
    }
    private static boolean validate(final String ip) {
        if (ip.equals("localhost")) return true;
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(PATTERN);
    }
}
