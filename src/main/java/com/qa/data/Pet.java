package com.qa.data;

import java.util.ArrayList;

public class Pet {
    private float id;
    private String name;
    Category CategoryObject;
    ArrayList< Object > photoUrls = new ArrayList < Object > ();
    ArrayList < Object > tags = new ArrayList < Object > ();
    private String status;

    public Pet(float id, String name, Category categoryObject, ArrayList<Object> photoUrls, ArrayList<Object> tags, String status) {
        this.id = id;
        this.name = name;
        CategoryObject = categoryObject;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public ArrayList<Object> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<Object> photoUrls) {
        this.photoUrls = photoUrls;
    }

    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return CategoryObject;
    }

    public String getStatus() {
        return status;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category categoryObject) {
        this.CategoryObject = categoryObject;
    }

    public ArrayList<Object> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Object> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
