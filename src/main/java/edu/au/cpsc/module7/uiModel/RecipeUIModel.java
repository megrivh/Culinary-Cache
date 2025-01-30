package edu.au.cpsc.module7.uiModel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;

public class RecipeUIModel
{
    private final StringProperty recipeNameProperty;
    private final StringProperty categoryProperty;
    private final StringProperty ingredientsProperty;
    private final StringProperty instructionsProperty;
    private final BooleanProperty isModifiedProperty;
    private final BooleanProperty isNewProperty;
    private final BooleanProperty isClearedProperty;

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

    private void setupListener(Property<?> property)
    {
        property.addListener(((observable, oldValue, newValue) -> {
            isModifiedProperty.set(true);
            isClearedProperty.set(newValue == null || newValue.toString().trim().isEmpty());
        }));
    }

    public BooleanBinding isRecipeNameSet()
    {
        return recipeNameProperty.isNotEmpty();
    }

    public BooleanBinding isCategorySet()
    {
        return categoryProperty.isNotEmpty();
    }

    public BooleanProperty isModifiedProperty()
    {
        return isModifiedProperty;
    }

    public BooleanProperty isNewProperty()
    {
        return isNewProperty;
    }

    public BooleanProperty isClearedProperty()
    {
        return isClearedProperty;
    }

    public void resetModelState(boolean isNew)
    {
        isNewProperty.set(isNew);
        isModifiedProperty.set(false);
    }

    public StringProperty recipeNameProperty()
    {
        return recipeNameProperty;
    }

    public StringProperty categoryProperty()
    {
        return categoryProperty;
    }

    public StringProperty ingredientsProperty()
    {
        return ingredientsProperty;
    }

    public StringProperty instructionsProperty()
    {
        return instructionsProperty;
    }
}
