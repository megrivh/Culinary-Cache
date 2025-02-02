package edu.au.cpsc.module7.data;

import edu.au.cpsc.module7.model.Recipe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * RecipeDatabase represents a collection of recipes. It provides methods to
 * add, remove, and retrieve recipes.
 */
public class RecipeDatabase implements Serializable
{
    /** List of recipes in the database */
    private final List<Recipe> recipes;

    /**
     * Constructs a new empty RecipeDatabase.
     */
    public RecipeDatabase()
    {
        recipes = new ArrayList<>();
    }

    /**
     * Retrieves the list of recipes in the database.
     *
     * @return A list of recipes
     */
    public List<Recipe> getRecipes()
    {
        return recipes;
    }

    /**
     * Adds a new recipe to the database.
     *
     * @param recipe The recipe to add
     */
    public void addRecipe(Recipe recipe)
    {
        recipes.add(recipe);
    }

    /**
     * Removes a recipe from the database.
     *
     * @param recipe The recipe to remove
     */
    public void removeRecipe(Recipe recipe)
    {
        recipes.remove(recipe);
    }

}
