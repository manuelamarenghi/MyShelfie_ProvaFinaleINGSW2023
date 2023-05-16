package it.polimi.ingsw.view.Gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class JavaFXGui extends Application {
 @Override
    public void start(Stage primaryStage) throws IOException {

     Gui gui=new Gui();
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
