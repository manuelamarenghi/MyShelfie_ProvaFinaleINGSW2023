package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.view.ObservableViewClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class LoginSceneController extends ObservableViewClient implements GenericSceneController {
    public Text name_txt;
    private boolean askNumb=false;
    @FXML
    public TextArea Area;
    public Button okButton;
    @FXML
    private StackPane Stack;
    public TextField name_txb;

    public void initialize() {
        Area.setEditable(false);
        Area.setVisible(false);
        ImageView image = new ImageView();
        image.fitWidthProperty();
        image.fitHeightProperty();
        Stack.getChildren().add(image);
    }



    public void onClick(ActionEvent actionEvent) {
        if(!askNumb) {
            if (name_txb.getText().trim().equals("")) System.out.println("Inserire un nome");
            else this.notifyObserver(observerViewClient -> observerViewClient.handleEnterPlayer(name_txb.getText()));
        }else{
            String numb = name_txb.getText();
            if(Integer.parseInt(numb) != 2 && Integer.parseInt(numb)  != 3 && Integer.parseInt(numb)  != 4) {
                name_txt.setText("Insert a valid number");
            }
            this.notifyObserver(observers -> observers.ChangeRoot("wait"));
            this.notifyObserver(observers -> observers.handleCreateBoard(Integer.parseInt(numb)));
        }

        // name_txb.getStylesheets().add("text-red");
        name_txb.clear();
    }

    public void onEnter(KeyEvent keyEvent) {
        //if(keyEvent.getCode()== KeyCode.ENTER)onClick(null);
    }

    public void onEnterNick(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) onClick(null);

    }


    public void Connect_before_first() {
        Area.setVisible(true);
        Area.appendText("First player is deciding number of players.Please try again\n");
    }

    public void NumbPlayer() {
        askNumb =true;
        name_txt.setText("Insert number of player between 2,3,4:");
        //ip_txb.setVisible(false);
        //ip_txb.setEditable(false);
        //Area.setVisible(true);
        //Area.appendText("Insert number of player between 2,3,4:");
        /*String numb = name_txb.getText();
        while (Integer.parseInt(numb) != 2 && Integer.parseInt(numb)  != 3 && Integer.parseInt(numb)  != 4) {
            Area.clear();
            Area.appendText("Insert a valid number");

        }
        new Thread(()->notifyObserver(observers -> observers.ChangeRoot("wait")));
        this.notifyObserver(observers -> observers.handleCreateBoard(Integer.parseInt(numb)));
*/
    }

    public void GameFull() {
        Area.appendText("I'm sorry.The game is already full of players\n");
    }
}
