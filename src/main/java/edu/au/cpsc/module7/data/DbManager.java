package edu.au.cpsc.module7.data;

import java.io.*;

public class DbManager
{
    public static final File DEFAULT_FILE = new File("recipes.dat");

    private static RecipeDatabase recipeDatabase;

    public static RecipeDatabase getDatabase()
    {
        if (recipeDatabase == null)
        {
            recipeDatabase = loadDatabase();
        }

        return recipeDatabase;
    }

    private static RecipeDatabase loadDatabase()
    {
        try (InputStream is = new FileInputStream(DEFAULT_FILE))
        {
            return RecipeDatabaseIO.load(is);
        }
        catch (IOException | ClassNotFoundException exception)
        {
            System.out.println("Database file not found or couldn't be loaded.\nCreating new database...");
            return new RecipeDatabase();
        }
    }

    public static void saveDatabase()
    {
        try (OutputStream os = new FileOutputStream(DEFAULT_FILE))
        {
            RecipeDatabaseIO.save(getDatabase(), os);
        }
        catch (IOException exception)
        {
            System.err.println("Error saving database: " + DEFAULT_FILE);
            exception.printStackTrace();
            System.exit(-1);
        }
    }
}
