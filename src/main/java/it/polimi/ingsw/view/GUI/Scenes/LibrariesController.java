package it.polimi.ingsw.view.GUI.Scenes;

import it.polimi.ingsw.modello.Card;
import it.polimi.ingsw.modello.Library;
import it.polimi.ingsw.view.ObservableViewClient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LibrariesController extends ObservableViewClient implements GenericSceneController {
    private Map<String, Image[]> tiles = Collections.synchronizedMap(new HashMap<>());
    @FXML
    private StackPane Stackpane;
    @FXML
    private GridPane GridLibrary = new GridPane();
    @FXML
    private ImageView Backgroundlibrary = new ImageView();
    @FXML
    private Button ButtonBack = new Button();
    @FXML
    private TextField TextFieldd = new TextField();
    @FXML
    private Button OKButton = new Button();
    private Image[] imageB, imageY, imageP, imageW, imageG, imageL;
    /**
     * A method to initialize all the attributes
     */
    public void initialize() {
        Stackpane = new StackPane();
        Backgroundlibrary.toBack();
        ButtonBack.addEventHandler(MouseEvent.MOUSE_CLICKED, this::pressedBack);
        OKButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::pressedOK);
        setTiles();
    }

    /**
     * A method to set the tiles with the corresponding images
     */
    public void setTiles() {
        InputStream is;
        is = this.getClass().getResourceAsStream("/images/item_tiles/yellow/yellow1.png");
        imageY = new Image[3];
        imageY[0] = new Image(is);
        imageY[1] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/yellow/yellow2.png")));
        imageY[2] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/yellow/yellow3.png")));
        tiles.put("yellow", imageY);
        imageP = new Image[3];
        imageP[0] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/pink/pink1.png")));
        imageP[1] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/pink/pink2.png")));
        imageP[2] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/pink/pink3.png")));
        tiles.put("pink", imageP);
        imageW = new Image[3];
        imageW[0] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/white/white1.png")));
        imageW[1] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/white/white2.png")));
        imageW[2] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/white/white3.png")));
        tiles.put("white", imageW);
        imageG = new Image[3];
        imageG[0] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/green/green1.png")));
        imageG[1] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/green/green2.png")));
        imageG[2] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/green/green3.png")));
        tiles.put("green", imageG);
        imageL = new Image[3];
        imageL[0] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/light_blue/light_blue1.png")));
        imageL[1] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/light_blue/light_blue2.png")));
        imageL[2] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/light_blue/light_blue3.png")));
        tiles.put("lightBlue", imageL);
        imageB = new Image[3];
        imageB[0] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/blue/blue1.png")));
        imageB[1] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/blue/blue2.png")));
        imageB[2] = new Image((InputStream) Objects.requireNonNull(this.getClass().getResourceAsStream("/images/item_tiles/blue/blue3.png")));
        tiles.put("blue", imageB);
    }

    /**
     * An ok button when the player types another player's name to see their library
     * @param mouseEvent
     */
    public void pressedOK(MouseEvent mouseEvent) {
        String nickname = TextFieldd.getText();
        TextFieldd.clear();
        this.notifyObserver(obs -> obs.SeeSomeoneLibrary(nickname));
    }

    /**
     * A method to create a library
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
                        GridLibrary.add(image, j, i);
                    } else {
                        final int col = i;
                        final int row = j;
                        GridLibrary.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == row && GridPane.getRowIndex(node) == col);
                    }
                }
                c++;
            }
            c = 0;
            r++;
        }
    }

    /**
     * A metod that brings you back to the living room scene
     * @param mouseEvent
     */
    public void pressedBack(MouseEvent mouseEvent) {
        this.notifyObserver(observerViewClient -> observerViewClient.ChangeRoot("living"));
    }

}
