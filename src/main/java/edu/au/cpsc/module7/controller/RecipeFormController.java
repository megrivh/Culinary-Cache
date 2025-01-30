package edu.au.cpsc.module7.controller;

import edu.au.cpsc.module7.data.DbManager;
import edu.au.cpsc.module7.model.Recipe;
import edu.au.cpsc.module7.uiModel.RecipeUIModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.Collections;
import java.util.Optional;

public class RecipeFormController
{
    @FXML
    private TextField recipeNameTextField;
    @FXML
    private TextArea ingredientsTextArea, instructionsTextArea;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private Button clearButton, saveButton, cancelButton;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem saveRecipeMenuItem, closeMenuItem, resetRecipeMenuItem, moreHelpMenuItem;

    private RecipeUIModel model;
    private Recipe currentRecipe;
    private RecipeManagerController recipeManagerController;


    @FXML
    public void initialize()
    {
        model = new RecipeUIModel();
        categoryComboBox.getItems().addAll("Breakfast", "Lunch/Dinner",
                "Side dish", "Appetizer", "Snack", "Dessert", "Drink");

        recipeNameTextField.textProperty().bindBidirectional(model.recipeNameProperty());
        ingredientsTextArea.textProperty().bindBidirectional(model.ingredientsProperty());
        instructionsTextArea.textProperty().bindBidirectional(model.instructionsProperty());
        categoryComboBox.valueProperty().bindBidirectional(model.categoryProperty());

        saveButton.disableProperty().bind(model.isModifiedProperty().not()
                .or(model.isRecipeNameSet().not())
                .or(model.isCategorySet().not())
        );
        resetRecipeMenuItem.disableProperty().bind(model.isClearedProperty());
        saveRecipeMenuItem.disableProperty().bind(model.isModifiedProperty().not()
                .or(model.isRecipeNameSet().not())
                .or(model.isCategorySet().not())
        );
        clearButton.disableProperty().bind(model.isClearedProperty());
    }

    public void setRecipeManagerController(RecipeManagerController controller)
    {
        this.recipeManagerController = controller;
    }

    public void setCurrentRecipe(Recipe recipe)
    {
        this.currentRecipe = recipe;

        if (recipe != null)
        {
            populateFields(recipe);
            model.isNewProperty().set(false);
            model.isModifiedProperty().set(false);
            model.isClearedProperty().set(false);
        }
        else
        {
            clearFields();
            model.isNewProperty().set(true);
        }
    }

    public void setMenuBarVisible(boolean isVisible)
    {
        menuBar.setVisible(isVisible);
        menuBar.setManaged(isVisible);
    }

    private void populateFields(Recipe recipe)
    {
        model.recipeNameProperty().set(recipe.getRecipeName());
        model.categoryProperty().set(recipe.getCategory());
        model.ingredientsProperty().set(String.join("\n", recipe.getIngredients()));
        model.instructionsProperty().set(recipe.getInstructions());
    }

    public void setViewOnlyFields()
    {
        recipeNameTextField.setEditable(false);
        categoryComboBox.setDisable(true);
        ingredientsTextArea.setEditable(false);
        instructionsTextArea.setEditable(false);
    }

    public void hideButtons()
    {
        saveButton.setVisible(false);
        clearButton.setVisible(false);
        cancelButton.setVisible(false);

    }

    private void clearFields()
    {
        model.recipeNameProperty().set("");
        model.ingredientsProperty().set("");
        model.instructionsProperty().set("");
        model.categoryProperty().set("");
        model.isClearedProperty().set(true);
        model.isModifiedProperty().set(false);
    }

    @FXML
    private void saveButtonClicked()
    {
        //Recipe recipe = getRecipe();

        if (currentRecipe != null)
        {
            currentRecipe.setRecipeName(model.recipeNameProperty().get());
            currentRecipe.setCategory(model.categoryProperty().get());
            currentRecipe.setIngredients(Collections.singletonList(model.ingredientsProperty().get()));
            currentRecipe.setInstructions(model.instructionsProperty().get());
        }
        else
        {
            Recipe newRecipe = new Recipe(model.recipeNameProperty().get(),
                    Collections.singletonList(model.ingredientsProperty().get()),
                    model.instructionsProperty().get(),
                    model.categoryProperty().getValue());

            DbManager.getDatabase().addRecipe(newRecipe);
        }

        DbManager.saveDatabase();
        recipeManagerController.displayRecipes();
        closeWindow();
    }

    @FXML
    private void moreHelp()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("More Help");
        alert.setHeaderText("How to..");
        alert.setContentText("1. Save a recipe: Enter required information and click save (or use menu/shortcut options). If the save button is " +
                "disabled, information is missing or there is nothing to save.\n\n" +
                "2. Clear the form: Click the clear button (or use menu/shortcut options). If the clear button is disabled, the form " +
                "is already cleared.\n\n3. Close the window: Click the cancel button (or use menu/shortcut options).");

        alert.showAndWait();
    }

    @FXML
    private void cancelButtonClicked()
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
            // close window if user is sure they want to exit
            closeWindow();
        }


    }

    @FXML
    private void clearButtonClicked()
    {
        clearFields();
    }

    private void closeWindow()
    {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }

}
