package com.company;

import com.sun.jndi.toolkit.url.Uri;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

// Am adaugat in signatura metodei "IOException" pentru a putea lucra cu streamurile pe fisiere si pentru exceptiile implementate de a"IOException"

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
            ((ObjectOutputStream) oos).writeObject(catalog);
        }
    }

    // Am introdus in signatura metodei "InvalidCatalogException, IOException, ClassNotFoundException" pentru a putea arunca exceptiile enumerate in cazul in care nu se respecta conditiile si pentru a putea lucra cu streamurile pe fisiere si pentru exceptiile implementate de a"IOException"

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

    // View va deschide pe desktop URI-ul documentului pe care il primeste ca parametru

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
