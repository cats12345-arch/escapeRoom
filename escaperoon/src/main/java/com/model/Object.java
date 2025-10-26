package com.model;

public class Object 
{
    //Instance
    private String name;
    private String description;
    private Item contains;


    //Constructor
    public Object(String name, String description, Item contains)
    {
        this.name = name;
        this.description = description;
        this.contains = contains;
    }

    //Methods
    public String getName() {
        return name;
    }
    public String getDescription() 
    {
        return description;
    }

    public Item getContains() 
    {
        return contains;
    }

    public Item interact()
    {
        System.out.println("You interact with " + name + " and you got " + contains.getName());
        return contains;
    }

    @Override
    public String toString() {
        return "Object [description:" + description + ", contains:" + contains + "]";
    }

    
}
