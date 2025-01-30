package edu.au.cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RecipeManagerApplication extends Application {
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

    public static void main(String[] args) {
        launch();
    }
}