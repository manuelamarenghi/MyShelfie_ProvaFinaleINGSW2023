package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class WaitingController extends ObservableViewClient implements GenericSceneController {
    @FXML
    public ListView<String> listPlayer=new ListView<>();
    /**
     * A method to initialize all the attributes
     */
    public void initialize(){

    }
    public void setPlayer(String name) {

        listPlayer.getItems().add(name);
    }


}
