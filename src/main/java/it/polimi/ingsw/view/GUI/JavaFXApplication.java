package it.polimi.ingsw.view.GUI;


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
      /*  LivingRoomController living = new LivingRoomController();
        ChatController chat = new ChatController();
        WaitingController waitingController = new WaitingController();
        GUI gui = new GUI(living, chat, waitingController);
        ClientController clientController = new ClientController(gui);
        //clientController.addViewObserver(gui);
        //clientController.addViewObserver();
        gui.addObserver(clientController);*/
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/FinalScene.fxml"));
      /*  Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.exit(1);
        }
        MainSceneController menu = loader.getController();
        menu.addObserver(clientController);*/
        Parent root = loader.load();
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