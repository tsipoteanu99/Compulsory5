package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Document implements Serializable {
    private String id;
    private String name;
    private String location; //file name or web page
    private Map<String, Object> tags = new HashMap<>();

    // Aici am creat constructorul in plus fata de slideuri, pentru a putea construi obiectele din main

    public Document(String id, String name, String location){
        this.id=id;
        this.location=location;
        this.name=name;
    }



    // incapsularea

    public void addTag(String key, Object obj){
        getTags().put(key,obj);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    // Override la equals pentru a putea cauta documentele dupa id

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(name, document.name) &&
                Objects.equals(location, document.location) &&
                Objects.equals(tags, document.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, tags);
    }
}
