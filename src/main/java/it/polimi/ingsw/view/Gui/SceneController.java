package it.polimi.ingsw.view.Gui;

import it.polimi.ingsw.view.Gui.Scenes.GenericSceneController;
import it.polimi.ingsw.view.ObservableViewClient;
import javafx.scene.Scene;

public class SceneController extends ObservableViewClient {
    private static Scene activeScene;
    private static GenericSceneController activeController;

    public static Scene getActiveScene(){
        return activeScene;
    }
    public static GenericSceneController getActiveController(){
        return activeController;
    }

}
