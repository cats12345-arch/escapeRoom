package com.model;

public class Object 
{
    //Instance
    private String description;
    private String contains;
    private String imagePath;

    //Constructor
    public Object(String description, String contains, String imagePath)
    {
        this.description = description;
        this.contains = contains;
        this.imagePath = imagePath;

    }

    //Default
    public Object()
    {
        this.description = "Normal object.";
        this.contains = "Nothing";
        this.imagePath = "";

    }

    //Methods
    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getContains() 
    {
        return contains;
    }

    public void setContains(String contains) 
    {
        this.contains = contains;
    }

    public String getImagePath() 
    {
        return imagePath;
    }

    public void setImagePath(String imagePath) 
    {
        this.imagePath = imagePath;
    }

    public String inspect()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(description);
        if (isContainer()) {
            sb.append(" It looks like it might contain something.");
        }
        return sb.toString();
    }
    //Returns true if its useful
    public boolean isContainer()
    {
        return contains != null && !contains.trim().isEmpty();
    }


    public Item interact(Account player)
    {
        if(isContainer())
        {
            Item item = revealContents();
            if(item != null && player != null)
            {
                player.giveItem(item);
            }
            return item;
        } 
        else
        {
            System.out.println("You found nothing within this object.");
            return null;
        }
    }

    public Item revealContents()
    {
        if(!isContainer())
        {
            return null;
        }
        else 
        {

        Item found = new Item(contains);
        
        empty();

        return found;
        }
    }

    private void empty() 
    {
        this.contains = null;
    }

    @Override
    public String toString() {
        return "Object [description:" + description + ", contains:" + contains + ", imagePath:" + imagePath + "]";
    }

    
}
