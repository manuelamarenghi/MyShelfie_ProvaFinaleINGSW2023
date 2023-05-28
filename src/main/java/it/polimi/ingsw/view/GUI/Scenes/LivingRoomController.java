package it.polimi.ingsw.view.GUI.Scenes;


import it.polimi.ingsw.modello.Board;
import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.modello.Position;
import it.polimi.ingsw.view.GUI.Scenes.Storage.StorageLiving;
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
import java.util.*;

/**
 * this class represent the main interface of the game which handle changes of scenes after user or server requests
 */
public class LivingRoomController extends ObservableViewClient implements GenericSceneController {
    @FXML
    private Button libraries = new Button(), Chat = new Button();
    @FXML
    private Button Common1 = new Button();
    @FXML
    private Button Common2 = new Button();
    @FXML
    private Button Exit = new Button(), Send = new Button();
    @FXML
    private ImageView PersonalCard = new ImageView();
    @FXML
    private StackPane stackPane = new StackPane();
    @FXML
    private StackPane stackPanelibrary = new StackPane();
    private Map<String, Image[]> tiles = Collections.synchronizedMap(new HashMap<>());
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
    private ImageView Chair = new ImageView(), TokenCommon1 = new ImageView(), TokenCommon2 = new ImageView(), FirstFinished = new ImageView();
    @FXML
    private ImageView Col0 = new ImageView(), Col1 = new ImageView(), Col2 = new ImageView(), Col3 = new ImageView(), Col4 = new ImageView();
    private boolean yourTurn, SendbuttonAble, Token1set;
    private int cardtaken;
    private int index;
    private Position[] positions;
    private int[] columnforthisturn;
    private int ableSend;
    private Image[] imageB, imageY, imageP, imageW, imageG, imageL;
    private StorageLiving stored = new StorageLiving();
    @FXML
    private TextArea Notes = new TextArea();

    public StorageLiving getData() {
        return stored;
    }

    public String getUserInput() {
        if (inputUser.getText() != "") {
            return inputUser.getText();
        } else return null;
    }

    public void setTextArea(String s) {
        stored.setTextArea(s);
        messageServer.clear();
        messageServer.appendText(s);
    }

    public void appendText(String s) {
        stored.setNote(s);
        Notes.clear();
        Notes.appendText(s);
    }

    public void setYourTurn(boolean x) {
        yourTurn = x;
    }

    public void setCardtaken(int x) {
        System.out.println(x);
        cardtaken = x;
    }

    /**
     * A method to initialize all the attributes
     */
    public void initialize() {
        if (stored.getBoard() != null) {
            createBoard(stored.getBoard());
        }
        libraries.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                pressedLibraries(mouseEvent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        if (stored.getLibrary() != null) {
            createLibrary(stored.getLibrary());
        }
        if (stored.isChair()) {
            setChair();
        }
        if (stored.isFirstFinish()) {
            setFirstFinished();
        }
        if (stored.getPersonal() != -1) {
            setPP(stored.getPersonal());
        }
        if (Token1set) {
            Token1set = false;
            setTokenCommon(stored.getScore0());
        }
        if (stored.getScore1() != -1) {
            setTokenCommon(stored.getScore1());
        }
        if (stored.getTextArea() != null) {
            setTextArea(stored.getTextArea());
        }
        if (stored.getNote() != null) {
            appendText(stored.getNote());
        }
        Common1.addEventHandler(MouseEvent.MOUSE_CLICKED, this::pressedCommon1);
        Common2.addEventHandler(MouseEvent.MOUSE_CLICKED, this::pressedCommon2);
        Exit.addEventHandler(MouseEvent.MOUSE_CLICKED, this::pressedExit);
        Send.addEventHandler(MouseEvent.MOUSE_CLICKED, this::pressedSend);
        Chat.addEventHandler(MouseEvent.MOUSE_CLICKED, this::pressedChat);
        messageServer.setEditable(false);
        Notes.setEditable(false);
        stackPanelibrary = new StackPane();
        backgroundlibrary.toBack();
        stackPane = new StackPane();
        background.toBack();
        gameBoard.toFront();
        setTiles();
    }

    /**
     * A method to set the tiles to the corresponding images
     */
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

    /**
     * A method to start the game
     */
    public void start() {
        setTiles();
        Token1set = false;
        SendbuttonAble = false;
        index = 0;
    }

    /**
     * A method to create the board
     *
     * @param b
     */
    public void createBoard(Board b) {
        Card[][] cards = b.getBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cards[i][j] != null) {
                    String color = cards[i][j].getColour();
                    if (color != null && !color.equals("")) {
                        int x = (int) Math.floor(Math.random() * (3));
                        ImageView image = new ImageView((this.tiles.get(color))[x]);
                        image.setFitWidth(32);
                        image.setFitHeight(33);
                        gameBoard.add(image, j, i);
                        image.setOnMouseClicked(event -> {
                            Node clickedNode = (Node) event.getTarget();
                            Integer columnIndex = GridPane.getColumnIndex(clickedNode);
                            Integer rowIndex = GridPane.getRowIndex(clickedNode);
                            if (index < cardtaken && yourTurn) {
                                image.getStyleClass().add("image");
                                positions[index] = new Position(rowIndex, columnIndex);
                                index++;
                                if (index == cardtaken) {
                                    ableSend = 4;
                                    index = 0;
                                    cardtaken = 0;
                                }
                            }
                        });
                    } else {
                        final int col = i;
                        final int row = j;
                        gameBoard.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == row && GridPane.getRowIndex(node) == col);
                    }
                }
            }
        }
    }

    /**
     * A metho to create the library
     *
     * @param l
     */
    public void createLibrary(Library l) {
        Card[][] cards = l.getLibrary();
        int r = 0, c = 0;
        for (int i = 1; i < 12; i += 2) {
            for (int j = 1; j < 10; j += 2) {
                if (cards[r][c] != null) {
                    String color = cards[r][c].getColour();
                    if (color != null && !color.equals("")) {
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

    /**
     * A method to take the cards
     */
    public void TakeCards() {
        ableSend = 2;
    }

    /**
     * A method to remove the highlights
     */
    public void removeHighlights() {
        ObservableList<Node> children = gameBoard.getChildren();
        for (Node n : children) {
            ImageView v = (ImageView) n;
            v.getStyleClass().remove("image");
        }
    }

    /**
     * A method to set the personal goal card
     *
     * @param x
     */
    public void setPP(int x) {
        stored.setPersonal(x);
        String c = String.valueOf(x);
        String name = "/images/personal_goal_cards/Personal_Goals" + c + ".png";
        Image image = new Image(Objects.requireNonNull(this.getClass().getResource(name)).toString());
        PersonalCard.setImage(image);
    }

    /**
     * A button to see the common goal card 1
     *
     * @param mouseEvent
     */
    public void pressedCommon1(MouseEvent mouseEvent) {
        this.notifyObserver(observers -> observers.ChangeRoot("common1"));
    }

    /**
     * A button to see the common goal card 2
     *
     * @param mouseEvent
     */
    public void pressedCommon2(MouseEvent mouseEvent) {
        this.notifyObserver(observers -> observers.ChangeRoot("common2"));
    }

    /**
     * A button to exit
     *
     * @param mouseEvent
     */
    public void pressedExit(MouseEvent mouseEvent) {
        this.notifyObserver(observers -> observers.handleDisconection(null));
    }

    /**
     * A button to see the libraries
     *
     * @param mouseEvent
     */
    public void pressedLibraries(MouseEvent mouseEvent) throws IOException {
        this.notifyObserver(observers -> observers.ChangeRoot("library"));
    }

    /**
     * A button to see the chat
     *
     * @param mouseEvent
     */
    public void pressedChat(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.ChangeRoot("chat"));
    }

    /**
     * A button to send the text written
     *
     * @param actionEvent
     */
    public void pressedSend(MouseEvent actionEvent) {
        int n;
        if (SendbuttonAble) {
            String s = getUserInput();
            n = Integer.parseInt(s);
            inputUser.clear();
            if (ValidColumn(columnforthisturn, n - 1)) {
                int finalN = n - 1;
                this.notifyObserver(observerViewClient -> observerViewClient.handlePutInLibrary(finalN));
                SendbuttonAble = false;
                Col0.setImage(null);
                Col1.setImage(null);
                Col2.setImage(null);
                Col3.setImage(null);
                Col4.setImage(null);
            } else {
                setTextArea("Insert a valid column you want to choose\n");
                }
        } else {
            if (ableSend == 2) {
                String s = getUserInput();
                n = Integer.parseInt(s);
                inputUser.clear();
                if (n < 0 || n > 3) {
                    setTextArea("Please insert a valid number less or equal 3\n");
                } else {
                    if (!ValidInputNumb(n)) {
                        setTextArea("There aren't enough adjacent cards for this number\n");
                    } else {
                        if (stored.getLibrary().showColumn(n).length == 0) {
                            setTextArea("Please insert a number of cards you can put in your library\n");
                        } else {
                            positions = new Position[n];
                            ableSend = 1;
                            setCardtaken(n);
                            setTextArea("Select cards in the order you want to put in your library\n");
                            index = 0;
                        }
                    }
                }
            } else if (ableSend == 4) {
                this.notifyObserver(observers -> observers.handleTakeCard(positions));
                ableSend = 1;
                // removeHighlights();
            }
        }
    }

    /**
     * A method to set the token for the common goal card
     *
     * @param x
     */
    public void setTokenCommon(int x) {
        String name = "/images/scoring_tokens/scoring_" + x + ".png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        assert is != null;
        Image image = new Image(is);
        if (!Token1set) {
            TokenCommon1.setImage(image);
            Token1set = true;
        } else {
            TokenCommon2.setImage(image);
        }
    }

    public boolean isToken1set() {
        return Token1set;
    }

    /**
     * A method to set the chair to tha player selected
     */
    public void setChair() {
        String name = "/images/misc/firstplayertoken.png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        assert is != null;
        Image image = new Image(is);
        Chair.setImage(image);
    }

    /**
     * A method to set the player who finished the game first
     */
    public void setFirstFinished() {
        String name = "/images/scoring_tokens/end_game.png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        assert is != null;
        Image image = new Image(is);
        FirstFinished.setImage(image);
    }

    /**
     * A method to show the coloumns where the player can put the cards
     *
     * @param x
     */
    public void ShowColumn(int[] x) {
        ImageView[] ViewScatola = {Col0, Col1, Col2, Col3, Col4};
        String name = "/images/Publisher_material/arrow.png";
        InputStream is;
        is = this.getClass().getResourceAsStream(name);
        assert is != null;
        Image image = new Image(is);
        for (int i : x) {
            ViewScatola[i].setImage(image);
            ViewScatola[i].setFitWidth(16);
            ViewScatola[i].setFitHeight(16);
        }
        setTextArea("Insert a valid column you want to choose\n");
        SendbuttonAble = true;
        columnforthisturn = x;
    }

    /**
     * A metho to check if the coloumns are valid or not
     */
    public boolean ValidColumn(int[] x, int y) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == y) {
                return true;
            }
        }
        return false;
    }

    public boolean ValidInputNumb(int x) {
        ArrayList<Integer> groups = stored.getBoard().Group();
        for (int y : groups) {
            if (y >= x) {
                return true;
            }
        }
        return false;
    }
}