package edu.au.cpsc.module7.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recipe implements Serializable
{
    private String recipeName;
    private List<String> ingredients;
    private String instructions;
    private String category;
    private int index;

    public Recipe()
    {
        this.recipeName = "";
        this.ingredients = new ArrayList<>();
        this.instructions = "";
        this.category = "";

    }
    public Recipe(String recipeName, List<String> ingredients, String instructions, String category)
    {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
    }

    public String getRecipeName()
    {
        return recipeName;
    }

    public void setRecipeName(String recipeName)
    {
        this.recipeName = recipeName;
    }

    public List<String> getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getInstructions()
    {
        return instructions;
    }

    public void setInstructions(String instructions)
    {
        this.instructions = instructions;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}

