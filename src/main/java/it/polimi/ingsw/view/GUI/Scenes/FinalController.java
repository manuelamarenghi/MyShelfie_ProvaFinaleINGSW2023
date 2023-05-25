package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class FinalController extends ObservableViewClient implements GenericSceneController {
    @FXML
    private ImageView FIrstStar, SecStar, Third, Four;
    @FXML
    private Text FirstPlace, SecondPlace, ThirdPlace, FourPlace;
    @FXML
    private Text ScoreOne, ScoreTwo, ScoreThird, FourScore;

    public void initialize() {
        FirstPlace.toFront();
        SecondPlace.toFront();
        ThirdPlace.toFront();
        FourPlace.toFront();
        ScoreOne.toFront();
        ScoreTwo.toFront();
        ScoreThird.toFront();
        FourScore.toFront();
        HashMap<String, Integer> con = new HashMap<>();
        con.put("chiara", 3);
        con.put("maria", 10);
        con.put("carlo", 6);
        SetClassification(con);
    }
    public void SetClassification(HashMap<String, Integer> point) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int x : point.values()) {
            sortedList.add(x);
        }
        sortedList.stream().sorted();
        System.out.println(sortedList);
        Set<String> key = point.keySet();
        System.out.println(key);
        int i = 0;
        for (String s : key) {
            while (i < sortedList.size()) {
                System.out.println(s);
                System.out.println(sortedList.get(i));
                if (point.get(s).equals(sortedList.get(i))) {
                    InputStream is;
                    switch (i) {
                        case 0:
                            is = this.getClass().getResourceAsStream("/images/Publisher_material/stellina.png");
                            Image image = new Image(is);
                            FIrstStar.setImage(image);
                            FirstPlace.setText(s);
                            ScoreOne = new Text();
                            ScoreOne.setText(sortedList.get(i).toString());
                            break;
                        case 1:
                            is = this.getClass().getResourceAsStream("/images/Publisher_material/stellina.png");
                            Image imageo = new Image(is);
                            SecStar.setImage(imageo);
                            SecondPlace = new Text();
                            SecondPlace.setText(s);
                            ScoreTwo = new Text();
                            ScoreTwo.setText(sortedList.get(i).toString());
                            break;
                        case 2:
                            is = this.getClass().getResourceAsStream("/images/Publisher_material/stellina.png");
                            Image imagea = new Image(is);
                            Third.setImage(imagea);
                            ThirdPlace = new Text();
                            ThirdPlace.setText(s);
                            ScoreThird = new Text();
                            ScoreThird.setText(sortedList.get(i).toString());
                            break;
                        case 3:
                            is = this.getClass().getResourceAsStream("/images/Publisher_material/stellina.png");
                            Image imageu = new Image(is);
                            Four.setImage(imageu);
                            FourPlace = new Text();
                            FourPlace.setText(s);
                            FourScore = new Text();
                            FourScore.setText(sortedList.get(i).toString());
                            break;
                    }
                    i++;
                }
            }
        }
    }


}
