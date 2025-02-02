package edu.au.cpsc.module7.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * The Recipe class represents a recipe with its name, ingredients, instructions,
 * and category. It also supports serialization for saving and loading recipes from
 * a file.
 */
public class Recipe implements Serializable
{
    private String recipeName;
    private List<String> ingredients;
    private String instructions;
    private String category;
    private int index;

    /**
     * Default constructor initializing an empty recipe.
     */
    public Recipe()
    {
        this.recipeName = "";
        this.ingredients = new ArrayList<>();
        this.instructions = "";
        this.category = "";

    }

    /**
     * Constructs a Recipe with the specified name, ingredients, instructions, and category.
     *
     * @param recipeName the name of the recipe
     * @param ingredients the list of ingredients required for the recipe
     * @param instructions the cooking instructions for the recipe
     * @param category the category of the recipe (e.g, Dessert, Side)
     */
    public Recipe(String recipeName, List<String> ingredients, String instructions, String category)
    {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
    }

    /**
     * Returns the recipe name.
     *
     * @return the name of the recipe
     */
    public String getRecipeName()
    {
        return recipeName;
    }

    /**
     * Sets the recipe name.
     *
     * @param recipeName the new name of the recipe
     */
    public void setRecipeName(String recipeName)
    {
        this.recipeName = recipeName;
    }

    /**
     * Returns the list of ingredients required for the recipe.
     *
     * @return the list of ingredients
     */
    public List<String> getIngredients()
    {
        return ingredients;
    }

    /**
     * Sets the list of ingredients for the recipe.
     *
     * @param ingredients the new list of ingredients
     */
    public void setIngredients(List<String> ingredients)
    {
        this.ingredients = ingredients;
    }

    /**
     * Returns the cooking instructions for the recipe.
     *
     * @return the cooking instructions
     */
    public String getInstructions()
    {
        return instructions;
    }

    /**
     * Sets the cooking instructions for the recipe.
     *
     * @param instructions the new instructions for the recipe
     */
    public void setInstructions(String instructions)
    {
        this.instructions = instructions;
    }

    /**
     * Returns the category of the recipe.
     *
     * @return the category of the recipe
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * Sets the category for the recipe.
     *
     * @param category the new category for the recipe
     */
    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * Returns the index of the recipe.
     *
     * @return the index of the recipe
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * Sets the index of the recipe.
     *
     * @param index the new index for the recipe
     */
    public void setIndex(int index)
    {
        this.index = index;
    }
}

