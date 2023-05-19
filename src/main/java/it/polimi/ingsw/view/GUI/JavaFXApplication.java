package it.polimi.ingsw.view.GUI;


import it.polimi.ingsw.view.GUI.Scenes.LivingRoomController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class JavaFXApplication extends Application {
    Button button;

    //
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IllegalArgumentException, IOException {
        LivingRoomController livingRoomController = new LivingRoomController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/living_room.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/background_livingroom.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/css/Highlights_Image.css").toExternalForm());
        SceneController.setActiveScene(scene);
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}