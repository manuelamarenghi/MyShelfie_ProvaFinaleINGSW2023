package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.InputStream;

public class CGController extends ObservableViewClient implements GenericSceneController {
    public Button theButton;
    @FXML
    public VBox box;
    @FXML
    public Label theLabel;
    @FXML
    public ImageView imageView;

    public void initialize() {
        box.getStyleClass().add("card");
        theLabel.getStyleClass().add("text");
    }

    //
    public void setImageAndText(int numberImage, String descr) {
        String path = "/images/CommonGoalCards/" + numberImage + ".png";
        InputStream is;
        is = this.getClass().getResourceAsStream("/images/CommonGoalCards/1.png");
        Image image = new Image(is);
        imageView.setImage(image);
        theLabel.setText(descr);
    }

    public void pressedButton(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.ChangeRoot("living"));
    }

}
