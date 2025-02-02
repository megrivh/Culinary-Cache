package edu.au.cpsc.module7.data;

import java.io.*;

/**
 * RecipeDatabaseIO provides methods to save and load RecipeDatabase objects to
 * and from input and output streams.
 */
public class RecipeDatabaseIO
{
    /**
     * Saves a RecipeDatabase object to the specified output stream.
     *
     * @param database The RecipeDatabase to save
     * @param strm The output stream to save to
     * @throws IOException If an error occurs during writing
     */
    public static void save(RecipeDatabase database, OutputStream strm) throws IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(strm);
        oos.writeObject(database);
    }

    /**
     * Loads a RecipeDatabase object from the specified input stream.
     *
     * @param strm The input stream to load from
     * @return The loaded RecipeDatabase
     * @throws IOException If an error occurs during reading
     * @throws ClassNotFoundException If the RecipeDatabase class is not found
     */
    public static RecipeDatabase load(InputStream strm) throws IOException, ClassNotFoundException
    {
        ObjectInputStream ois = new ObjectInputStream(strm);
        return (RecipeDatabase) ois.readObject();
    }
}
