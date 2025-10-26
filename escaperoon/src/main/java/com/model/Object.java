package com.model;

/**
 * Represents an interactable object in a room.
 */
public class Object 
{
    /** Object name. */
    private String name;

    /** Object description. */
    private String description;

    /** Item contained inside the object. */
    private Item contains;

    /**
     * Creates an object with a name, description, and contained item.
     */
    public Object(String name, String description, Item contains)
    {
        this.name = name;
        this.description = description;
        this.contains = contains;
    }

    /** @return the object's name */
    public String getName() {
        return name;
    }

    /** @return the object's description */
    public String getDescription() 
    {
        return description;
    }

    /** @return the item this object contains */
    public Item getContains() 
    {
        return contains;
    }

    /**
     * Interact with the object and get the contained item.
     */
    public Item interact()
    {
        System.out.println("You interact with " + name + " and you got " + contains.getName());
        return contains;
    }

    /** @return a string with object details */
    @Override
    public String toString() {
        return "Object [description:" + description + ", contains:" + contains + "]";
    }
}
