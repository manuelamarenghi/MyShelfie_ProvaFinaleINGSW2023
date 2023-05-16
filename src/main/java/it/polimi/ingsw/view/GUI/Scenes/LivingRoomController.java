package it.polimi.ingsw.view.GUI.Scenes;


import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.modello.Position;
import it.polimi.ingsw.view.ObservableViewClient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * this class represent the main interface of the game which handle changes of scenes after user or server requests
 */
public class LivingRoomController extends ObservableViewClient implements Controller {
    @FXML
    private Button libraries;
    @FXML
    private Button Common1;
    @FXML
    private Button Common2;
    @FXML
    private Button Exit;
    @FXML
    private ImageView PersonalCard;
    @FXML
    private StackPane stackPane;
    @FXML
    private StackPane stackPanelibrary;
    private Map<String, Image[]> tiles;
    @FXML
    private AnchorPane ancor;
    @FXML
    private ImageView background;
    @FXML
    private GridPane gameBoard;
    @FXML
    private ImageView backgroundlibrary;
    @FXML
    private GridPane gameBoardlibrary;
    @FXML
    private TextArea messageServer;
    @FXML
    private TextField inputUser;
    @FXML
    private ImageView Chair;
    private boolean yourTurn;
    private int cardtaken;
    private int index;
    private Position[] positions = new Position[3];

    public void setTextArea(String s) {
        messageServer.appendText(s);
    }

    public void setYourTurn(boolean x) {
        yourTurn = x;
    }

    public void setCardtaken(int x) {
        cardtaken = x;
    }

    public void setTiles() {
        InputStream is;
        tiles = Collections.synchronizedMap(new HashMap<>());
        Image[] imageY = new Image[3];
        is = this.getClass().getResourceAsStream("/images/item_tiles/yellow/yellow1.png");
        imageY[0] = new Image(is);
        imageY[1] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/yellow/yellow2.png"));
        imageY[2] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/yellow/yellow3.png"));
        tiles.put("yellow", imageY);
        Image[] imageP = new Image[3];
        imageP[0] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/pink/pink1.png"));
        imageP[1] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/pink/pink2.png"));
        imageP[2] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/pink/pink3.png"));
        tiles.put("pink", imageP);
        Image[] imageW = new Image[3];
        imageW[0] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/white/white1.png"));
        imageW[1] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/white/white2.png"));
        imageW[2] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/white/white3.png"));
        tiles.put("white", imageW);
        Image[] imageG = new Image[3];
        imageG[0] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/green/green1.png"));
        imageG[1] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/green/green2.png"));
        imageG[2] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/green/green3.png"));
        tiles.put("green", imageG);
        Image[] imageL = new Image[3];
        imageL[0] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/light_blue/light_blue1.png"));
        imageL[1] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/light_blue/light_blue2.png"));
        imageL[2] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/light_blue/light_blue3.png"));
        tiles.put("lightBlue", imageL);
        Image[] imageB = new Image[3];
        imageB[0] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/blue/blue1.png"));
        imageB[1] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/blue/blue2.png"));
        imageB[2] = new Image((InputStream) LivingRoomController.class.getResourceAsStream("/images/item_tiles/blue/blue3.png"));
        tiles.put("blue", imageB);
    }
    public void initialize() {
        index = 0;
        cardtaken = 3;
        yourTurn = true;
        ancor = new AnchorPane();
        setTiles();
        stackPanelibrary = new StackPane();
        backgroundlibrary.toBack();
        stackPane = new StackPane();
        background.toBack();
        Library l = new Library();
        l.getCardinPos(4, 4).setColour("green");
        l.getCardinPos(5, 4).setColour("green");
        l.getCardinPos(5, 2).setColour("blue");
        l.getCardinPos(5, 1).setColour("pink");
        Board board = new Board(2);
        board.fill(0);
        setTiles();
        createBoard(board);
        createLibrary(l);
        gameBoard.toFront();
    }

    public void createBoard(Board b) {
        Card[][] cards = b.getBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cards[i][j] != null) {
                    String color = cards[i][j].getColour();
                    if (color != "") {
                        int x = (int) Math.floor(Math.random() * (3));
                        ImageView image = new ImageView(this.tiles.get(color)[x]);
                        image.setFitWidth(32);
                        image.setFitHeight(33);
                        gameBoard.add(image, j, i);
                        image.setOnMouseClicked(event -> {
                            Node clickedNode = (Node) event.getTarget();
                            Integer columnIndex = GridPane.getColumnIndex(clickedNode);
                            Integer rowIndex = GridPane.getRowIndex(clickedNode);
                            if (yourTurn && index < cardtaken) {
                                image.getStyleClass().add("image");
                                positions[index] = new Position(columnIndex, rowIndex);
                                index++;
                            } else {
                                this.notifyObserver(observerViewClient -> observerViewClient.handleTakeCard(positions, "lalal"));
                                removeHighlights();
                                int index = 0;
                            }
                        });
                    }
                }
            }
        }
    }

    public void createLibrary(Library l) {
        Card[][] cards = l.getLibrary();
        int r = 0, c = 0;
        for (int i = 1; i < 12; i += 2) {
            for (int j = 1; j < 10; j += 2) {
                if (cards[r][c] != null) {
                    String color = cards[r][c].getColour();
                    if (color != "") {
                        int x = (int) Math.floor(Math.random() * (3));
                        ImageView image = new ImageView(this.tiles.get(color)[x]);
                        image.setFitWidth(21);
                        image.setFitHeight(22);
                        gameBoardlibrary.add(image, j, i);
                    }
                }
                c++;
            }
            c = 0;
            r++;
        }
    }

    public void TakeCards() {
        Integer n;
        do {
            messageServer.setText("Insert the number of items you want to take");
            String x = inputUser.getText();
            messageServer.clear();
            n = Integer.parseInt(x);
        } while (n < 0 && n > 3);
        setCardtaken(n);
        inputUser.clear();
        messageServer.setText("Select cards from the gameBoard by clicking on them in the order you want to put in your library");
        index = 0;
    }

    public void removeHighlights() {
        ObservableList<Node> children = gameBoard.getChildren();
        for (Node n : children) {
            ImageView v = (ImageView) n;
            v.getStyleClass().remove("image");
        }
    }

    public void setPP(int x) {
        String c = String.valueOf(x);
        String name = "/images/personal_goal_cards/Personal_Goals" + c + ".png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        Image image = new Image(is);
        PersonalCard = new ImageView(image);
    }

    public void pressedCommon1(MouseEvent mouseEvent) {
        //passa a scena con la prima carta
    }

    public void pressedCommon2(MouseEvent mouseEvent) {
        //passa a scena con seconda carta
    }

    public void pressedExit(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.handleDisconection("lalala"));
    }

    public void pressedLibraries(MouseEvent mouseEvent) {
        //passa a scena libreria
    }

    public void pressedChat(MouseEvent mouseEvent) {
        //passa a chat
    }

    public void setTokenCommon(int x) {
        String c = String.valueOf(x);
        String name = "/images/misc/scoring_" + c + ".png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        Image image = new Image(is);
    }

    public void setChair() {
        String name = "/images/misc/firstplayertoken.png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        Image image = new Image(is);
        Chair = new ImageView(image);
    }
}