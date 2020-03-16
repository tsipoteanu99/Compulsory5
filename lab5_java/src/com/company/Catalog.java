package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    // Constructor pentru a putea creea obiectul in main

    public Catalog ( String name, String path){
        this.name=name;
        this.path=path;
    }

    public void add(Document doc){
        getDocuments().add(doc);
    }

    public Document findById(String id){
        for(Document doc : getDocuments()){
            if(doc.getId().equals(id)){
                return doc;
            }
        }
        return null;
    }

    //incapsularea

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
