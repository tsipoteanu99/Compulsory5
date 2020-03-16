package com.company;

import com.sun.jndi.toolkit.url.Uri;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
            ((ObjectOutputStream) oos).writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException
    {
        Catalog cat = new Catalog("new", path);
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fis);
            cat = (Catalog) in.readObject();
        }
        catch (IOException io){
            System.out.println("Error reading file");
            io.printStackTrace();
        }catch(ClassNotFoundException cn){
            System.out.println("Error loading treets");
            cn.printStackTrace();
        }
        return cat;
    }

    public static void view(Document doc){
        Desktop desktop = Desktop.getDesktop();
            try{
                URI uri= new URI(doc.getLocation());
                desktop.browse(uri);
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
    }
}
