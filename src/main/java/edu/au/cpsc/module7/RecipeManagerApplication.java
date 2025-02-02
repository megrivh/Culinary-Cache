package edu.au.cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The RecipeManagerApplication class is the main entry point for the Culinary Cache application.
 * It initializes and launches the JavaFX application window.
 */
public class RecipeManagerApplication extends Application {
    /**
     * Starts the JavaFX application window with the Recipe Manager UI.
     *
     * @param stage the primary stage for the JavaFX application.
     * @throws IOException if there is an issue loading the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu.au.cpsc.module7/view/recipe-manager-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setMinWidth(650);
        stage.setMinHeight(450);
        stage.setMaxWidth(650);
        stage.setMaxHeight(450);
        stage.setTitle("Culinary Cache");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method to launch the RecipeManagerApplication.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch();
    }
}