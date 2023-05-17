package it.polimi.ingsw.view.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class JavaFXApplication extends Application {
 @Override
    public void start(Stage primaryStage) throws IOException {

     GUI gui=new GUI();
     Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/login_scene.fxml")));
     Scene scene=new Scene(root);
     primaryStage.setScene(scene);
     primaryStage.show();
     primaryStage.setMaximized(true);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
