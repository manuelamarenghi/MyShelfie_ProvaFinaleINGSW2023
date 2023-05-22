package it.polimi.ingsw.view.GUI.Scenes;


import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.modello.Position;
import it.polimi.ingsw.view.GUI.SceneController;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * this class represent the main interface of the game which handle changes of scenes after user or server requests
 */
public class LivingRoomController extends ObservableViewClient implements GenericSceneController {
    @FXML
    private Button libraries;
    @FXML
    private Button Common1;
    @FXML
    private Button Common2;
    @FXML
    private Button Exit, Send;
    @FXML
    private ImageView PersonalCard;
    @FXML
    private StackPane stackPane;
    @FXML
    private StackPane stackPanelibrary;
    private Map<String, Image[]> tiles=Collections.synchronizedMap(new HashMap<>());
    @FXML
    private AnchorPane ancor = new AnchorPane();
    @FXML
    private ImageView background=new ImageView();
    @FXML
    private GridPane gameBoard=new GridPane();
    @FXML
    private ImageView backgroundlibrary=new ImageView();
    @FXML
    private GridPane gameBoardlibrary=new GridPane();
    @FXML
    private TextArea messageServer=new TextArea();
    @FXML
    private TextField inputUser = new TextField();
    @FXML
    private ImageView Chair, TokenCommon1, TokenCommon2, FirstFinished;
    @FXML
    private ImageView Col0, Col1, Col2, Col3, Col4;
    private boolean yourTurn, SendbuttonAble, Token1set;
    private int cardtaken;
    private int index;
    private Position[] positions = new Position[3];
    private int[] columnforthisturn;

    private Image[] imageB,imageY,imageP,imageW,imageG,imageL;

    public String getUserInput() {
        inputUser.clear();
        return inputUser.getText();
    }

    public void setTextArea(String s) {
        messageServer.clear();
        messageServer.appendText(s);
    }

    public void setYourTurn(boolean x) {
        yourTurn = x;
    }

    public void setCardtaken(int x) {
        cardtaken = x;
    }

    public void setTiles() {
        //InputStream is;
        //tiles=Collections.synchronizedMap(new HashMap<>())
        imageY = new Image[3];
        //is = this.getClass().getResourceAsStream("/images/item_tiles/yellow/yellow1.png");
        imageY[0] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/yellow/yellow1.png")).toString());
        imageY[1] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/yellow/yellow2.png")).toString());
        imageY[2] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/yellow/yellow3.png")).toString());
        tiles.put("yellow", imageY);
        imageP = new Image[3];
        imageP[0] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/pink/pink1.png")).toString());
        imageP[1] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/pink/pink2.png")).toString());
        imageP[2] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/pink/pink3.png")).toString());
        tiles.put("pink", imageP);
        imageW = new Image[3];
        imageW[0] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/white/white1.png")).toString());
        imageW[1] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/white/white2.png")).toString());
        imageW[2] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/white/white3.png")).toString());
        tiles.put("white", imageW);
        imageG = new Image[3];
        imageG[0] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/green/green1.png")).toString());
        imageG[1] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/green/green2.png")).toString());
        imageG[2] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/green/green3.png")).toString());
        tiles.put("green", imageG);
        imageL = new Image[3];
        imageL[0] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/light_blue/light_blue1.png")).toString());
        imageL[1] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/light_blue/light_blue2.png")).toString());
        imageL[2] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/light_blue/light_blue3.png")).toString());
        tiles.put("lightBlue", imageL);
        imageB = new Image[3];
        imageB[0] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/blue/blue1.png")).toString());
        imageB[1] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/blue/blue2.png")).toString());
        imageB[2] = new Image(Objects.requireNonNull(this.getClass().getResource("/images/item_tiles/blue/blue3.png")).toString());
        tiles.put("blue", imageB);
    }
    public void start() {
        Token1set = false;
        SendbuttonAble = false;
        messageServer.setEditable(false);
        index = 0;
        cardtaken = 3;
        yourTurn = true;
        setTiles();
        stackPanelibrary = new StackPane();
        backgroundlibrary.toBack();
        stackPane = new StackPane();
        background.toBack();
        gameBoard.toFront();
    }

    public void createBoard(Board b) {
        Card[][] cards = b.getBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cards[i][j] != null) {
                    String color = cards[i][j].getColour();
                    System.out.println(color);
                    if (color!=null && !color.equals("")) {
                        int x = (int) Math.floor(Math.random() * (3));
                        ImageView image = new ImageView((this.tiles.get(color))[x]);
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
                                this.notifyObserver(observerViewClient -> observerViewClient.handleTakeCard(positions));
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
            setTextArea("Insert the number of items you want to take");
            String x = inputUser.getText();
            messageServer.clear();
            n = Integer.parseInt(x);
        } while (n < 0 && n > 3);
        setCardtaken(n);
        inputUser.clear();
        setTextArea("Select cards from the gameBoard by clicking on them in the order you want to put in your library");
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
        String name = "/images/personal_goal_cards/Personal_Goals"+c + ".png";
        System.out.println(name);
        System.out.println(c);
        //InputStream is;
        //is = this.getClass().getResourceAsStream(name);
        Image image = new Image(Objects.requireNonNull(this.getClass().getResource(name)).toString());
        PersonalCard = new ImageView(image);
    }

    public void pressedCommon1(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.ChangeRoot("common1"));
    }

    public void pressedCommon2(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.ChangeRoot("common2"));
    }

    public void pressedExit(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.handleDisconection(null));
    }

    public void pressedLibraries(MouseEvent mouseEvent) throws IOException {
        LibrariesController lcontr = new LibrariesController();
        String f = "libraries.fxml";
        SceneController.setRootPane(observers, f);
    }

    public void pressedChat(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.ChangeRoot("chat"));
    }

    public void pressedSend(MouseEvent mouseEvent) {
        int n;
        if (SendbuttonAble) {
            do {
                setTextArea("Insert a valid column you want to choose");
                String s = getUserInput();
                n = Integer.parseInt(s);
            } while (ValidColumn(columnforthisturn, n));
            int finalN = n;
            this.notifyObserver(observerViewClient -> observerViewClient.handlePutInLibrary(finalN));
            SendbuttonAble = false;
            Col0.setImage(null);
            Col1.setImage(null);
            Col2.setImage(null);
            Col3.setImage(null);
            Col4.setImage(null);
        }
    }

    public void setTokenCommon(int x) {
        String name = "/images/scoring_tokens/scoring_" + x + ".png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        Image image = new Image(is);
        if (Token1set == false) {
            TokenCommon1.setImage(image);
            Token1set = true;
        } else {
            TokenCommon2.setImage(image);
        }
    }

    public void setChair() {
        String name = "/images/misc/firstplayertoken.png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        Image image = new Image(is);
        Chair.setImage(image);
    }

    public void setFirstFinished() {
        String name = "/images/scoring_tokens/end_game.png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        Image image = new Image(is);
        FirstFinished.setImage(image);
    }

    public void ShowColumn(int[] x) {
        Integer n;
        ImageView[] ViewScatola = {Col0, Col1, Col2, Col3, Col4};
        InputStream is;
        String name = "/images/Publisher_material/arrow.png";
        is = this.getClass().getResourceAsStream(name);
        Image image = new Image(is);
        for (int i : x) {
            ViewScatola[i].setImage(image);
            ViewScatola[i].setFitWidth(16);
            ViewScatola[i].setFitHeight(16);
        }
        setTextArea("Insert a valid column you want to choose");
        SendbuttonAble = true;
        columnforthisturn = x;
    }

    public boolean ValidColumn(int[] x, int y) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == y) {
                return true;
            }
        }
        return false;
    }
}