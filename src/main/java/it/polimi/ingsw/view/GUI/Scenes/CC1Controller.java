package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.modello.CommonGoalCard.Square2G;

import java.awt.*;
import java.awt.event.ActionEvent;

public class CC1Controller implements Controller{
        private Square2G commonGoalCard;
        private Label CC1Label;
        private String textToShow;
        //
        public void getDescription(ActionEvent event) {
                textToShow=commonGoalCard.getDesc();
                CC1Label.setText(textToShow);

        }
}
