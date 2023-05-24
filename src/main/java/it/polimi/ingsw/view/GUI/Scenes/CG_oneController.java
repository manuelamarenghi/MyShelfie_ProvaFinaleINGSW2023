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
import java.util.Objects;

public class CG_oneController extends ObservableViewClient implements GenericSceneController {
    public Button theButton = new Button();
    @FXML
    public VBox box = new VBox();
    @FXML
    public Label theLabel = new Label();
    @FXML
    public ImageView imageView=new ImageView();

    public void initialize() {
        box.getStyleClass().add("card");
        theLabel.getStyleClass().add("text");
    }


    public void setImageAndText(int numberImage, String descr) {
        String c = String.valueOf(numberImage);
        String path = "/images/CommonGoalCards/CommonGoal" + c+".png";
        System.out.println(path);
        Image image = new Image(Objects.requireNonNull(this.getClass().getResource(path)).toString());
        imageView.setImage(image);
        theLabel.setText(descr);
    }

    public void pressedButton(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.ChangeRoot("living"));
    }

}
