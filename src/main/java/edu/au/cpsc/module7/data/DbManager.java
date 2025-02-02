package edu.au.cpsc.module7.data;

import java.io.*;

/**
 * DbManager handles loading and saving of the recipe database. It loads the
 * database from a file and provides access to it, as well as saves the database
 * back to the file system.
 */
public class DbManager
{
    /** The default file where the recipe database is stored */
    public static final File DEFAULT_FILE = new File("recipes.dat");

    private static RecipeDatabase recipeDatabase;

    /**
     * Returns the current recipe database. If the database hasn't been loaded yet,
     * it loads it from the default file.
     *
     * @return The recipe database
     */
    public static RecipeDatabase getDatabase()
    {
        if (recipeDatabase == null)
        {
            recipeDatabase = loadDatabase();
        }

        return recipeDatabase;
    }

    /**
     * Loads the recipe database from the default file. If the file does not exist
     * or an error occurs while loading, a new, empty database is created.
     *
     * @return The loaded recipe database or a new empty one if loading fails
     */
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

    /**
     * Saves the current recipe database to the default file. If an error occurs while
     * saving, it prints an error message and exits the program.
     */
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
