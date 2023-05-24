package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.GUI.SceneController;
import it.polimi.ingsw.view.ObservableViewClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainSceneController extends ObservableViewClient implements GenericSceneController {
    private ImageView Background;
    @FXML
    private StackPane Stack;
    public Button btn_play;
    public Button btn_exit;

    public void initialize() {
        Background = new ImageView();
        Background.getStyleClass().add("Background");
        Background.fitWidthProperty();
        Background.fitHeightProperty();
        Stack.getChildren().add(Background);
    }

    /**
     * The method is used to change the scnee to the connect scene when the game starts
     * @param action
     */
    public void onClickPlay(ActionEvent action) {
        SceneController.setRootPane(observers, "connect_scene.fxml");

    }

    /**
     * The method is used to quit the game
     * @param action
     */
    public void onClickExit(ActionEvent action) {
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }
}
