package edu.au.cpsc.module7.data;

import java.io.*;

public class RecipeDatabaseIO
{
    public static void save(RecipeDatabase database, OutputStream strm) throws IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(strm);
        oos.writeObject(database);
    }

    public static RecipeDatabase load(InputStream strm) throws IOException, ClassNotFoundException
    {
        ObjectInputStream ois = new ObjectInputStream(strm);
        return (RecipeDatabase) ois.readObject();
    }
}
