package edu.au.cpsc.module7.uiModel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;

/**
 * The RecipeUIModel class is a JavaFX view model that binds UI components to the properties
 * of a recipe. It tracks changes to recipe name, category, ingredients, and instructions, and provides
 * logic to determine if a recipe has been modified or if the fields are cleared.
 */
public class RecipeUIModel
{
    private final StringProperty recipeNameProperty;
    private final StringProperty categoryProperty;
    private final StringProperty ingredientsProperty;
    private final StringProperty instructionsProperty;
    private final BooleanProperty isModifiedProperty;
    private final BooleanProperty isNewProperty;
    private final BooleanProperty isClearedProperty;

    /**
     * Initializes the RecipeUIModel with default values for each property.
     */
    public RecipeUIModel()
    {
        recipeNameProperty = new SimpleStringProperty();
        categoryProperty = new SimpleStringProperty();
        ingredientsProperty = new SimpleStringProperty();
        instructionsProperty = new SimpleStringProperty();
        isModifiedProperty = new SimpleBooleanProperty(false);
        isNewProperty = new SimpleBooleanProperty(false);
        isClearedProperty = new SimpleBooleanProperty(true);

        setupListener(recipeNameProperty);
        setupListener(categoryProperty);
        setupListener(ingredientsProperty);
        setupListener(instructionsProperty);
    }

    /**
     * Sets up a listener for properties to track if they are modified or cleared.
     *
     * @param property the property to set the listener for
     */
    private void setupListener(Property<?> property)
    {
        property.addListener(((observable, oldValue, newValue) -> {
            isModifiedProperty.set(true);
            isClearedProperty.set(newValue == null || newValue.toString().trim().isEmpty());
        }));
    }

    /**
     * Returns a BooleanBinding that checks if the recipe name is set (not empty).
     *
     * @return BooleanBinding indicating whether the recipe name is set
     */
    public BooleanBinding isRecipeNameSet()
    {
        return recipeNameProperty.isNotEmpty();
    }

    /**
     * Returns a BooleanBinding that checks if the recipe category is set (not empty).
     *
     * @return BooleanBinding indicating whether the recipe category is set
     */
    public BooleanBinding isCategorySet()
    {
        return categoryProperty.isNotEmpty();
    }

    /**
     * Returns the modified property for the recipe.
     *
     * @return BooleanBinding indicating whether the recipe is modified
     */
    public BooleanProperty isModifiedProperty()
    {
        return isModifiedProperty;
    }

    /**
     * Returns the new property for the recipe.
     *
     * @return BooleanBinding indicating whether the recipe is new
     */
    public BooleanProperty isNewProperty()
    {
        return isNewProperty;
    }

    /**
     * Returns the cleared property for the recipe.
     *
     * @return BooleanBinding indicating whether the recipe fields are cleared
     */
    public BooleanProperty isClearedProperty()
    {
        return isClearedProperty;
    }

    /**
     * Resets the model state based on whether the recipe is new or not.
     *
     * @param isNew a boolean indicating whether the recipe is new
     */
    public void resetModelState(boolean isNew)
    {
        isNewProperty.set(isNew);
        isModifiedProperty.set(false);
    }

    /**
     * Returns the property for the recipe name.
     *
     * @return StringProperty representing the recipe name
     */
    public StringProperty recipeNameProperty()
    {
        return recipeNameProperty;
    }

    /**
     * Returns the property for the category.
     *
     * @return StringProperty representing the category
     */
    public StringProperty categoryProperty()
    {
        return categoryProperty;
    }

    /**
     * Returns the property for the ingredients.
     *
     * @return StringProperty representing the ingredients
     */
    public StringProperty ingredientsProperty()
    {
        return ingredientsProperty;
    }

    /**
     * Returns the property for the instructions.
     *
     * @return StringProperty representing the instructions
     */
    public StringProperty instructionsProperty()
    {
        return instructionsProperty;
    }
}
