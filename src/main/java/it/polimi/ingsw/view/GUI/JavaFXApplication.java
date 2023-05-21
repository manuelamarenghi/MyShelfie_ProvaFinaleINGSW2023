package it.polimi.ingsw.view.GUI;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class JavaFXApplication extends Application {
    Button button;

    //
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IllegalArgumentException, IOException {
        //  SocketClient socketClient = new SocketClient("localhost", 16847);
        //  LivingRoomController living=new LivingRoomController();
        // ChatController chat=new ChatController();
        //GUI gui=new GUI(living,chat);
        // ClientController clientController = new ClientController(gui, socketClient);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/main_scene.fxml")));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/background_livingroom.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/css/InitalBackground.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/css/Highlights_Image.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true);
        SceneController.setActiveScene(scene);
    }

}