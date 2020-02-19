package com.qa.data;

public class TagsArrayElement {
    private float id;
    private String name;

    public TagsArrayElement(float id, String name) {
        this.id = id;
        this.name = name;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
