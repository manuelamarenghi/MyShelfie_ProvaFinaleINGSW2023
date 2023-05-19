package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.modello.CommonGoalCard.Col2G;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class CC2Controller implements GenericSceneController {
    public Col2G commonGoalCard;
    @FXML
    private Label myLabel;
    @FXML
    private Button myButton;
    private String textToShow;

    public void getDescription(ActionEvent event) {
        textToShow = commonGoalCard.getDesc();
        myLabel.setText(textToShow);

    }

}