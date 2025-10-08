package com.model;

public class Item {
    private String name;
    private String description;
    
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String toString() {
        return "\nItem: \n" + "Name: " + name + "\nDescription " + description;
    }
}
