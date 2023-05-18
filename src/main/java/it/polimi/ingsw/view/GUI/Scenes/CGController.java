package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.modello.CommonGoalCard.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CGController implements Controller{
        public Button theButton;
        public Label theLabel;
        public ImageView imageView;

        private Square2G commonGoalCard1;
        private Col2G commonGoalCard2;
        private Same4GroupsG commonGoalCard3;
        private DoubleCommG commonGoalCard4;
        private Col3G commonGoalCard5;
        private Line2G commonGoalCard6;
        private Line4G commonGoalCard7;
        private CornersCommG commonGoalCard8;
        private EightEqualsCards commonGoalCard9;
        private XGoalCard commonGoalCard10;
        private Diagonal5CardG commonGoalCard11;
        private StairsGoalCard commonGoalCard12;

        private String textToShow;
        //

        public void setImageAndText(int numberImage){
                switch(numberImage){
                        case 1 :
                                Image image1 = new Image("@../images/CommonGoalCards/1.jpg");
                                imageView.setImage(image1);
                                theLabel.setText(commonGoalCard1.getDesc());
                                break;
                        case 2 :
                                Image image2 = new Image("@../images/CommonGoalCards/2.jpg");
                                imageView.setImage(image2);
                                theLabel.setText(commonGoalCard2.getDesc());
                                break;
                        case 3 :
                                Image image3 = new Image("@../images/CommonGoalCards/3.jpg");
                                imageView.setImage(image3);
                                theLabel.setText(commonGoalCard3.getDesc());
                                break;
                        case 4 :
                                Image image4 = new Image("@../images/CommonGoalCards/4.jpg");
                                imageView.setImage(image4);
                                theLabel.setText(commonGoalCard4.getDesc());
                                break;
                        case 5 :
                                Image image5 = new Image("@../images/CommonGoalCards/5.jpg");
                                imageView.setImage(image5);
                                theLabel.setText(commonGoalCard5.getDesc());
                                break;
                        case 6 :
                                Image image6 = new Image("@../images/CommonGoalCards/6.jpg");
                                imageView.setImage(image6);
                                theLabel.setText(commonGoalCard6.getDesc());
                                break;
                        case 7 :
                                Image image7 = new Image("@../images/CommonGoalCards/7.jpg");
                                imageView.setImage(image7);
                                theLabel.setText(commonGoalCard7.getDesc());
                                break;
                        case 8 :
                                Image image8 = new Image("@../images/CommonGoalCards/8.jpg");
                                imageView.setImage(image8);
                                theLabel.setText(commonGoalCard8.getDesc());
                                break;
                        case 9 :
                                Image image9 = new Image("@../images/CommonGoalCards/9.jpg");
                                imageView.setImage(image9);
                                theLabel.setText(commonGoalCard9.getDesc());
                                break;
                        case 10 :
                                Image image10 = new Image("@../images/CommonGoalCards/10.jpg");
                                imageView.setImage(image10);
                                theLabel.setText(commonGoalCard10.getDesc());
                                break;
                        case 11 :
                                Image image11 = new Image("@../images/CommonGoalCards/11.jpg");
                                imageView.setImage(image11);
                                theLabel.setText(commonGoalCard11.getDesc());
                                break;
                        case 12 :
                                Image image12 = new Image("@../images/CommonGoalCards/12.jpg");
                                imageView.setImage(image12);
                                theLabel.setText(commonGoalCard12.getDesc());
                                break;
                }

        }


}
