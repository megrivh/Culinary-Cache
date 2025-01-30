package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.data.DbManager;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import edu.au.cpsc.module7.model.Recipe;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

public class RecipeManagerController {
    @FXML
    private TableView<Recipe> recipeTableView;
    @FXML
    private TableColumn<Recipe, String> recipeNameColumn, categoryColumn;
    @FXML
    private Button addRecipeButton, editRecipeButton, deleteRecipeButton, searchButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem newRecipeMenuItem, exitMenuItem, exportRecipiesMenuItem, editRecipeMenuItem,
            deleteRecipeMenuItem, aboutMenuItem;

    private ObservableList<Recipe> recipesList;
    private FilteredList<Recipe> filteredRecipeList;

    @FXML
    public void initialize()
    {

        recipeNameColumn.setCellValueFactory(new PropertyValueFactory<>("recipeName"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        displayRecipes();

        recipeTableView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> tableSelectionChanged()));

        recipeTableView.setOnMouseClicked(event -> tableViewClicked(event));

        editRecipeButton.disableProperty().bind(recipeTableView.getSelectionModel().selectedItemProperty().isNull());
        deleteRecipeButton.disableProperty().bind(recipeTableView.getSelectionModel().selectedItemProperty().isNull());
        editRecipeMenuItem.disableProperty().bind(recipeTableView.getSelectionModel().selectedItemProperty().isNull());
        deleteRecipeMenuItem.disableProperty().bind(recipeTableView.getSelectionModel().selectedItemProperty().isNull());

    }

    @FXML
    private void exitApplication()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit?");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Any unsaved changes will be permanently lost.");

        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == yesButton)
        {
            Platform.exit(); // close application if user is sure they want to exit
        }
    }

    @FXML
    private void exportRecipes()
    {
        // Export data logic goes here
    }

    @FXML
    private void openAboutDialog()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Culinary Cache");
        alert.setHeaderText("Culinary Cache Recipe Manager");
        alert.setContentText("This application allows you to manage your recipes electronically!\n\n" +
                "Version: 1.0.0\n" +
                "Developed by MRH\n\n" +
                "For questions or comments, contact me by email at: mzr0142@auburn.edu");

        alert.showAndWait();
    }

    private void tableViewClicked(MouseEvent event)
    {
        if (event.getClickCount() == 2)
        {
            Recipe selectedRecipe = recipeTableView.getSelectionModel().getSelectedItem();

            if (selectedRecipe != null)
            {
                openViewRecipeForm(selectedRecipe);
            }
        }
    }

    public void displayRecipes()
    {
        ObservableList<Recipe> recipes = FXCollections.observableArrayList(DbManager.getDatabase().getRecipes());
        this.recipesList = recipes;

        filteredRecipeList = new FilteredList<>(recipes, recipe -> true);
        recipeTableView.setItems(filteredRecipeList);

        searchTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredRecipeList.setPredicate(recipe -> {
                if (newValue == null || newValue.isEmpty())
                {
                    return true; // If no input in search text field, display all recipes in tableView
                }
                return recipe.getRecipeName().toLowerCase().contains(newValue.toLowerCase());
            });
        }));
        recipeTableView.refresh();
    }

    public void tableSelectionChanged()
    {
        Recipe selectedRecipe = recipeTableView.getSelectionModel().getSelectedItem();
        RecipeTableEvent event = new RecipeTableEvent(RecipeTableEvent.RECIPE_SELECTED, selectedRecipe);
        recipeTableView.fireEvent(event);
    }

    @FXML
    private void addRecipeButtonClicked()
    {
        openRecipeForm(null);
    }

    @FXML
    private void editRecipeButtonClicked()
    {
        Recipe selectedRecipe = recipeTableView.getSelectionModel().getSelectedItem();
        openRecipeForm(selectedRecipe);
    }

    @FXML
    private void deleteRecipeButtonClicked()
    {
        Recipe selectedRecipe = recipeTableView.getSelectionModel().getSelectedItem();

        if (selectedRecipe != null)
        {
            DbManager.getDatabase().removeRecipe(selectedRecipe);
            DbManager.saveDatabase();
            recipesList.remove(selectedRecipe);
            displayRecipes();
        }

        recipeTableView.refresh();
    }

    private void openRecipeForm(Recipe recipeToEdit)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu.au.cpsc.module7/view/recipe-form-view.fxml"));
            Parent root = fxmlLoader.load();

            RecipeFormController recipeFormController = fxmlLoader.getController();
            recipeFormController.setCurrentRecipe(recipeToEdit);
            recipeFormController.setRecipeManagerController(this);

            recipeFormController.setMenuBarVisible(true);

            Stage stage = new Stage();
            stage.setTitle(recipeToEdit == null ? "Culinary Cache: Add a Recipe" : "Culinary Cache: Edit a Recipe");
            stage.setScene(new Scene(root));

            stage.showAndWait();

            displayRecipes();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            recipeTableView.getSelectionModel().clearSelection();
            searchTextField.textProperty().set("");
        }
    }

    private void openViewRecipeForm(Recipe selectedRecipe)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu.au.cpsc.module7/view/recipe-form-view.fxml"));
            Parent root = fxmlLoader.load();

            RecipeFormController recipeFormController = fxmlLoader.getController();
            recipeFormController.setCurrentRecipe(selectedRecipe);
            recipeFormController.setRecipeManagerController(this);

            recipeFormController.setMenuBarVisible(false);
            recipeFormController.setViewOnlyFields();
            recipeFormController.hideButtons();

            Stage stage = new Stage();
            stage.setTitle("Culinary Cache: View Recipe (" + selectedRecipe.getRecipeName() + ")");
            stage.setScene(new Scene(root));

            stage.showAndWait();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            recipeTableView.getSelectionModel().clearSelection();
            searchTextField.textProperty().set("");
        }
    }

    public static class RecipeTableEvent extends Event
    {
        public static final EventType<RecipeTableEvent> ANY = new EventType<>(Event.ANY, "ANY");
        public static final EventType<RecipeTableEvent> RECIPE_SELECTED = new EventType<>(ANY, "RECIPE_SELECTED");

        private Recipe selectedRecipe;

        public RecipeTableEvent(EventType<? extends Event> eventType, Recipe selectedRecipe)
        {
            super(eventType);
            this.selectedRecipe = selectedRecipe;
        }
    }
}

