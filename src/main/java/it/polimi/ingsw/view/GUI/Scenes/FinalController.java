package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javax.swing.text.html.ImageView;
import java.util.HashMap;

public class FinalController extends ObservableViewClient implements GenericSceneController {
    @FXML
    private ImageView FIrstStar, SecStar, Third, Four;
    @FXML
    private Text FirstPlace, SecondPlace, ThirdPlace, FourPlace;
    @FXML
    private Text ScoreOne, ScoreTwo, ScoreThird, FourScore;

    public void initialize() {

    }

    public void SetClassification(HashMap<String, Integer> point) {

    }


}
