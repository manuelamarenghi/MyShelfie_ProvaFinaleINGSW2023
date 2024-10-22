package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.view.GUI.Scenes.GenericSceneController;
import it.polimi.ingsw.view.ObservableViewClient;
import it.polimi.ingsw.view.ObserverViewClient;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;

public class SceneController extends ObservableViewClient {
    private static Scene activeScene;
    private static GenericSceneController activeController;

    public static Scene getActiveScene() {
        return activeScene;
    }

    public static void setActiveScene(Scene scene) {
        activeScene = scene;
    }

    public static GenericSceneController getActiveController() {
        return activeController;
    }

    public static <T> T setRootPane(ArrayList<ObserverViewClient> observerList, Scene scene, String fxml) {
        T controller = null;

        try {
            FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("/fxml/" + fxml));
            Parent root = loader.load();
            controller = loader.getController();
            ((ObservableViewClient) controller).addAllObservers(observerList);

            activeController = (GenericSceneController) controller;
            activeScene = scene;
            activeScene.setRoot(root);
        } catch (IOException e) {
        }
        return controller;
    }

    /**
     * Changes the root panel of the scene argument.
     *
     * @param observerList a list of observers to be set into the scene controller.
     * @param event        the event which is happened into the scene.
     * @param fxml         the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     * @param <T>          this is the type parameter.
     * @return the controller of the new scene loaded by the FXMLLoader.
     */
    public static <T> T setRootPane(ArrayList<ObserverViewClient> observerList, Event event, String fxml) {
        Scene scene = ((Node) event.getSource()).getScene();
        return setRootPane(observerList, scene, fxml);
    }

    /**
     * Changes the root panel of the active scene.
     *
     * @param observerList a list of observers to be set into the scene controller.
     * @param fxml         the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     * @param <T>          this is the type parameter.
     * @return the controller of the new scene loaded by the FXMLLoader.
     */
    public static <T> T setRootPane(ArrayList<ObserverViewClient> observerList, String fxml) {
        return setRootPane(observerList, activeScene, fxml);
    }

    /**
     * Changes the root panel of the scene argument.
     * Offers the possibility to set a custom controller to the FXMLLoader.
     *
     * @param controller the custom controller that will be set into the FXMLLoader.
     * @param fxml       the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     */
    public static void setRootPane(GenericSceneController controller, Scene scene, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneController.class.getResource("/fxml/" + fxml));
            // Setting the controller BEFORE the load() method.
            loader.setController(controller);
            activeController = controller;
            Parent root = loader.load();
            activeScene = scene;
            activeScene.setRoot(root);
            SceneController.getActiveScene().getStylesheets().add(SceneController.class.getResource("/css/background_livingroom.css").toExternalForm());
            SceneController.getActiveScene().getStylesheets().remove(SceneController.class.getResource("/css/InitalBackground.css").toExternalForm());
            if (fxml.equals("FinalScene.fxml")) {
                SceneController.getActiveScene().getStylesheets().remove(SceneController.class.getResource("/css/background_livingroom.css").toExternalForm());
                SceneController.getActiveScene().getStylesheets().add(SceneController.class.getResource("/css/InitalBackground.css").toExternalForm());
            }
        } catch (IOException e) {
        }
    }

    /**
     * Changes the root panel of the scene argument.
     * Offers the possibility to set a custom controller to the FXMLLoader.
     *
     * @param controller the custom controller that will be set into the FXMLLoader.
     * @param event      the event which is happened into the scene.
     * @param fxml       the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     */
    public static void setRootPane(GenericSceneController controller, Event event, String fxml) {
        Scene scene = ((Node) event.getSource()).getScene();
        setRootPane(controller, scene, fxml);
    }

    /**
     * Changes the root panel of the active scene.
     * Offers the possibility to set a custom controller to the FXMLLoader.
     *
     * @param controller the custom controller that will be set into the FXMLLoader.
     * @param fxml       the new scene fxml name. It must include the extension ".fxml" (i.e. next_scene.fxml).
     */
    public static void setRootPane(GenericSceneController controller, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(controller.getClass().getResource("/fxml/" + fxml));
            // Setting the controller BEFORE the load() method.
            loader.setController(controller);
            activeController = controller;
            Parent root = loader.load();
            System.out.println(root.toString());
            activeScene.setRoot(root);
            //activeScene = scene;
            SceneController.getActiveScene().getStylesheets().add(SceneController.class.getResource("/css/background_livingroom.css").toExternalForm());
            SceneController.getActiveScene().getStylesheets().remove(SceneController.class.getResource("/css/InitalBackground.css").toExternalForm());
            if (fxml.equals("FinalScene.fxml")) {
                SceneController.getActiveScene().getStylesheets().remove(SceneController.class.getResource("/css/background_livingroom.css").toExternalForm());
                SceneController.getActiveScene().getStylesheets().add(SceneController.class.getResource("/css/InitalBackground.css").toExternalForm());
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
