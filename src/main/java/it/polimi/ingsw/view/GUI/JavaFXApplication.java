package it.polimi.ingsw.view.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class JavaFXApplication extends Application {
 @Override
    public void start(Stage primaryStage) throws IOException {
        Parent p=FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/main_scene.fxml")));

    }
    public static void main(String[] args) {
        launch(args);
    }
}
