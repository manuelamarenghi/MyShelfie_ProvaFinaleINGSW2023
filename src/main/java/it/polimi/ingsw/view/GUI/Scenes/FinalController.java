package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class FinalController extends ObservableViewClient implements GenericSceneController {
    @FXML
    private ImageView FIrstStar, SecStar, Third, Four;
    @FXML
    private Text FirstPlace, SecondPlace, ThirdPlace, FourPlace;
    @FXML
    private Text ScoreOne, ScoreTwo, ScoreThird, FourScore;
    /**
     * A method to initialize all the attributes
     */
    public void initialize() {
        FirstPlace.toFront();
        SecondPlace.toFront();
        ThirdPlace.toFront();
        FourPlace.toFront();
        ScoreOne.toFront();
        ScoreTwo.toFront();
        ScoreThird.toFront();
        FourScore.toFront();
    }

    /**
     * A method For the final scoreboard of the game
     * @param point
     */
    public void SetClassification(HashMap<String, Integer> point) {
        ArrayList<Integer> List = new ArrayList<>();
        for (int x : point.values()) {
            List.add(x);
        }
        ArrayList<Integer> sortedList = (ArrayList<Integer>) List.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Set<String> key = point.keySet();
        int i = 0;
        for (String s : key) {
            while (i < sortedList.size()) {
                if (point.get(s).equals(sortedList.get(i))) {
                    InputStream is;
                    switch (i) {
                        case 0:
                            is = this.getClass().getResourceAsStream("/images/Publisher_material/stellina.png");
                            Image image = new Image(is);
                            FIrstStar.setImage(image);
                            FirstPlace.setText(s);
                            ScoreOne.setText(sortedList.get(i).toString());
                            i = 5;
                            break;
                        case 1:
                            is = this.getClass().getResourceAsStream("/images/Publisher_material/stellina.png");
                            Image imageo = new Image(is);
                            SecStar.setImage(imageo);
                            SecondPlace.setText(s);
                            ScoreTwo.setText(sortedList.get(i).toString());
                            i = 5;
                            break;
                        case 2:
                            is = this.getClass().getResourceAsStream("/images/Publisher_material/stellina.png");
                            Image imagea = new Image(is);
                            Third.setImage(imagea);
                            ThirdPlace.setText(s);
                            ScoreThird.setText(sortedList.get(i).toString());
                            i = 5;
                            break;
                        case 3:
                            is = this.getClass().getResourceAsStream("/images/Publisher_material/stellina.png");
                            Image imageu = new Image(is);
                            Four.setImage(imageu);
                            FourPlace.setText(s);
                            FourScore.setText(sortedList.get(i).toString());
                            i = 5;
                            break;
                    }
                }
                i++;
            }
            i = 0;
        }
    }


}
