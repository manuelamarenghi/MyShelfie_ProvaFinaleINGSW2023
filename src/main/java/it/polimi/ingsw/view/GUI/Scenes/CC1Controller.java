package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.modello.CommonGoalCard.Square2G;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class CC1Controller implements Controller {
        public Button theButton;
        public Label theLabel;
        private Square2G commonGoalCard;
        private String textToShow;

        //
        public void getDescription(ActionEvent event) {
                textToShow = commonGoalCard.getDesc();
                theLabel.setText(textToShow);

        }
}
