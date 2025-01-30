package edu.au.cpsc.module7.data;

import edu.au.cpsc.module7.model.Recipe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecipeDatabase implements Serializable
{
    private final List<Recipe> recipes;

    public RecipeDatabase()
    {
        recipes = new ArrayList<>();
    }

    public List<Recipe> getRecipes()
    {
        return recipes;
    }

    public void addRecipe(Recipe recipe)
    {
        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe)
    {
        recipes.remove(recipe);
    }

}
