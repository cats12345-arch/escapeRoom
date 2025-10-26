package com.model;

/**
 * Item and stores the name and description of the Item
 * @author daniel
 */

public class Item {
    private String name;
    private String description;
    
    /**
     * The constructor of the Item
     * @param name The name of the Item
     * @param description The description of the Item
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * A method that will return the name of the Item
     * @return A String of the name of the Item
     */
    public String getName() {
        return name;
    }

    /**
     * A method that will return the description of the Item
     * @return A string of the description of the Item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Primar;y used for bug testing
     * @return A string of the info of the Item
     */
    public String toString() {
        return "\nItem: \n" + "Name: " + name + "\nDescription " + description;
    }
}
