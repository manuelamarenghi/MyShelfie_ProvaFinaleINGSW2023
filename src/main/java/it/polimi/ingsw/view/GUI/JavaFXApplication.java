package it.polimi.ingsw.view.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class JavaFXApplication extends Application {
    GUI view = new GUI();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent root = (AnchorPane) FXMLLoader.load(getClass().getResource("./JavaFXApplication.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("My Shelfie");
            Image image = new Image(getClass().getResource("Publisher.png").openStream());
            ImageView imageV = new ImageView();
            imageV.setImage(image);
            primaryStage.setScene(scene);
            primaryStage.show();
           /* Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
                if(first.getChildren().get(0).equals(scenes[0]))//If the first scene is loaded, load the second scene.
                {
                    first.getChildren().set(0, scenes[1]);
                }
                else
                {
                    first.getChildren().set(0, scenes[0]);
                }
            }));*/
            //root.getChildren().add(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AnchorPane secondScene() throws IOException {
        AnchorPane borderPane = new AnchorPane();
        Image image = new Image(getClass().getResource("Display_5.png").openStream());
        ImageView imageV = new ImageView();
        imageV.setImage(image);
        Button enter = new Button("Start");
        return borderPane;
    }
}
