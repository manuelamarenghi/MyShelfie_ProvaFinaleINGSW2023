package it.polimi.ingsw.view.GUI.Scenes.StoredController;

import it.polimi.ingsw.modello.Position;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.Map;

public class StorageLivingRoom {
    private Button libraries;
    private Button Common1;
    private Button Common2;
    private Button Exit, Send;
    private ImageView PersonalCard;
    private StackPane stackPane;
    private StackPane stackPanelibrary;
    private Map<String, Image[]> tiles;
    private AnchorPane ancor;
    private ImageView background;
    private GridPane gameBoard;
    private ImageView backgroundlibrary;
    private GridPane gameBoardlibrary;
    private TextArea messageServer;
    private TextField inputUser;
    private ImageView Chair, TokenCommon1, TokenCommon2, FirstFinished;
    private ImageView Col0, Col1, Col2, Col3, Col4;
    private boolean yourTurn, SendbuttonAble, Token1set;
    private int cardtaken;
    private int index;
    private Position[] positions = new Position[3];
    private int[] columnforthisturn;

}
