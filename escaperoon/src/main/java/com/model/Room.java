package com.model;

import java.util.ArrayList;

public class Room 
{
    protected String roomName;
    protected String type;
    protected boolean solved;
    protected ArrayList<Puzzle> puzzles;
    protected ArrayList<Item> inventory;
    protected ArrayList<Object> objects;

    //RoomInfo
    protected String roomDescription;
    protected String options;

    public Room(String roomName, String type, boolean solved, ArrayList<Puzzle> puzzles, 
    ArrayList<Item> inventory, ArrayList<Object> objects, String roomDescription, String roomOptions) {
        this.roomName = roomName;
        this.type = type;
        this.solved = solved;
        this.puzzles = puzzles;
        this.inventory = inventory;
        this.objects = objects;
        this.roomDescription = roomDescription;
        this.options = roomOptions;
    }

     public Room()
    {
    this.roomName = "Unnamed";
    this.type = "Normal";
    this.solved = false;
    this.puzzles = new ArrayList<>();
    this.inventory = new ArrayList<>();
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomType() {
        return type;
    }

    public Boolean getSolved() {
        return solved;
    }

    public ArrayList<Puzzle> getPuzzles() {
        return puzzles;
    }

    public ArrayList<Item> getItems() {
        return inventory;
    }

    public ArrayList<Object> getObjects() {
        return objects;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public String getRoomOption() {
        return options;
    }

 public void reset()
 {
    this.solved = false;
    for(Puzzle p : puzzles)
    {
        p.reset();
    }
 }

 public boolean isSolved()
 {
    for(Puzzle p: puzzles)
    {
        if(!p.isSolved())
        {
            return false;
        }
    }
    return solved;
 }

 public void resetItem()
 {
    for(int i=0; i<inventory.size();i++) {
        inventory.remove(i);
        i--;
    }
 }

 public void exploreRoom()
 {
   System.out.println("Exploring " + roomName + ". Found "
   + inventory.size() + " items and "
   + puzzles.size() + " puzzles.");
 }
    


 private void displayOptions()
 {
    System.out.println("\nAvailable actions: ");
    System.out.println(options);
 }

public void inputOptions(int num, Account player) {
        switch (num) {
            case 1:
                Item found = chest();
                if (found != null) {
                    System.out.println("You found: " + found.getName());
                    if (player != null);
                } else {
                    System.out.println("The chest is empty.");
                }
                break;
            case 2:
                bookshelf();
                break;
            case 3:
                dice();
                break;
            case 4:
                desk();
                break;
            case 5:
                bed();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public void inputOptions(int num) 
    {
        inputOptions(num, null);
    }

    // Open a chest — returns an Item (UML: +chest(): item)
    public Item chest() {
        System.out.println("You open the chest...");

        if (inventory.isEmpty()) {
            System.out.println("It appears empty.");
            return null;
        }

        // Return first item from inventory
        Item item = inventory.remove(0);
        return item;
    }

    public void bookshelf() 
    {
        System.out.println("You browse the bookshelf. A few titles catch your eye.");

    }

    public void dice() {
        int roll = (int) (Math.random() * 6) + 1;
        System.out.println("You roll the dice... result: " + roll);
    }

    public void desk() 
    {
        System.out.println("You examine the desk and find scattered notes.");
    }

    public void bed() 
    {
        System.out.println("You check under the bed and lift the mattress.");
    }

    public void addItem(Item item) 
    { 
        inventory.add(item); 
    }

    public void addPuzzle(Puzzle puzzle) 
    { 
        puzzles.add(puzzle); 
    }

    public void interactWithObject()
    {
        for(int i = 0; i < objects.size(); ++i)
        {
            int num = i + 1;
            System.out.println(num +"." + objects.get(i).getName());
        }
    }

    public Object GetObject(int option)
    {
        return objects.get(option);
    }

    public void showObjectOption()
    {
        System.out.println("1. Show Description" );
        System.out.println("2. Interact");
    }


 public String toString()
 {
    return roomName + type + solved + puzzles.toString() + inventory.toString() + "\n" + objects + roomDescription + options; 
 }

}
 
