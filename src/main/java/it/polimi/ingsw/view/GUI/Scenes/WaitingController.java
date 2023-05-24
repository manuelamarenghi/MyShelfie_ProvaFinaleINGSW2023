package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class WaitingController extends ObservableViewClient implements GenericSceneController {
    @FXML
    public ListView<String> listPlayer;

    /**
     * The method is used to set the player's name
     * @param name
     */
    public void setPlayer(String name) {
        //listPlayer=new ListView<>();
        listPlayer.getItems().add(name);
    }


}
