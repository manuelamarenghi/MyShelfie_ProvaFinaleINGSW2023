package it.polimi.ingsw.view.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;



import java.io.IOException;
import java.util.Objects;

public class JavaFXApplication extends Application {

 @Override
    public void start(Stage primaryStage) throws IOException {

     //GUI gui=new GUI();
     Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/CC1.fxml")));
     Scene scene=new Scene(root);
     primaryStage.setScene(scene);
     primaryStage.show();
     primaryStage.setMaximized(true);
    }
    public static void main(String[] args) {
        launch(args);
    }

}
