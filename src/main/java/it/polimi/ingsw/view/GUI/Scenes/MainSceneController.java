package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.GUI.SceneController;
import it.polimi.ingsw.view.ObservableViewClient;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainSceneController extends ObservableViewClient implements GenericSceneController{
    public Button btn_play;
    public Button btn_exit;

    public void onClickPlay(ActionEvent action){
        SceneController.setRootPane(observers,action,"login-scene.fxml");
    }
    public void onClickExit(ActionEvent action){
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }
}
