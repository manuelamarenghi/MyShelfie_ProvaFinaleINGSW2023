package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class WaitingController extends ObservableViewClient implements GenericSceneController {
    @FXML
    private ListView ListPlayer;

    public void initialize() {

    }

    public void setPlayer(String name) {
        ListPlayer.getItems().add(name);
    }


}
