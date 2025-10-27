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

    /**
     * @param roomName the name of the room
     * @param type the type of room
     * @param solved whether the puzzle has been solved or not
     * @param puzzles the list of puzzles 
     * @param inventory the list items in the inventory 
     * @param objects the list of objects 
     * @param roomDescription description text for the room
     * @param roomOptions options text to present to the player 
     */
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

    private void println(String s) {
        //Speek.speak(s);
        System.out.println(s);
    }

    /**
     * A method that will return all of the info about the room
     * @return A sting containing info about the room
     */
    public String getRoomInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exploring ").append(roomName).append("\n").append(roomDescription).append("\nThere are ").append(puzzles.size()).append(" puzzles\nThere are ").append(objects.size()).append(" things to interact with");
        return sb.toString();
    }

    /**
     * A method that will return a string with info about an item
     * @param num The item number in the arrayList
     * @return a Strng with info about item
     */
    public String getItemInfo(int num) {
        return inventory.get(num).toString();
    }

    /**
     * A method that will return the names of all of the items
     * @return A string with all the names of the items
     */
    public String getItemsNames() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<inventory.size(); i++) {
            sb.append("\n" + i-- + ".: " + inventory.get(i).getName());
        }
        return sb.toString();
    }

    /**
     * A method that will return all the names of the objects in the room
     * @return A string of all the object names
     */
    public String getObjectnames() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<objects.size(); i++) {
            int num = i;
            num++;
            sb.append("\n" + num + ".: " + objects.get(i).getName());
        }
        return sb.toString();
    }

    /**
     * A method that will return the selected object
     * @param num The number of the object that will be gottoen
     * @return An object
     */
    public Object getObject(int num) {
        if(num > objects.size()) {
            return null;
        }
        return objects.get(num);
    }

    /**
     * A method that will add an item to the inventory arraylist
     * @param item the item that will be added to the item inventory
     */
    public void addToInventory(Item item) {
        inventory.add(item);
    }

    /**
     * A method that will show all the info about the inventory 
     * @return A string with the inventory item details
     */
    public String getItemsDetails() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<inventory.size(); i++) {
            sb.append(inventory.get(i));
        }
        return sb.toString();
    }

    /**
     * A method that will return a puzzle based on the number entered
     * @param num the puzzle that will be gone to
     * @return A puzzle
     */
    public Puzzle getNextPuzzle(int num) {
        if(num > puzzles.size()) {
            return null;
        }
        return puzzles.get(num);
    }

    /**
     * Returns the size of the inventory
     * @return an int
     */
    public int getInventorySize () {
        return inventory.size();
    }

    /**
     * Shows all of the differnt puzzles that can be solved
     */
    public void showDifferentPuzzles() {
        for(int i=0; i< puzzles.size(); i++ ) {
            int num = i;
            num++;
            println(num + ". " + puzzles.get(i).getPuzzleType());
        }
    }

    /**
     * A method that will return a puzzle to be worked on
     * @param num The puzzle num that is desired
     * @return A puzzle
     */
    public Puzzle getPuzzle(int num) {
        if(num > puzzles.size()) {
            println("Number entered is out of bounds");
        }
        return puzzles.get(num);
    }

    /**
     * A method that will show details about the puzzle
     * @return A string with the details about the puzzle
     */
    public String getPuzzleDetails() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<puzzles.size(); i++) {
            int num = i;
            num++;
            sb.append("\n" + num + ".: " + puzzles.get(i).getPuzzleType());
        }
        return sb.toString();
    }

    /**
     * A method that will show all of the differnet object names numbered off
     */
    public void showDifferentObjects() {
        for(int i=0; i< objects.size(); i++ ) {
            int num = i;
            num++;
            println(num + ". " + objects.get(i).getName());
        }
    }

    /**
     * A method that will show the different objects if the user entered 1 and show the differnet puzzles if the user entered 2
     * @param num The num for user options
     * @return A boolean that is true for objects false for puzzles
     */
    public Boolean showWhich(int num) {
        if(num == 1) {
            showDifferentObjects();
            return true;
        } else if(num == 2) {
            showDifferentPuzzles();
            return false;
        } else {
            System.out.println("Invalid input");
            return false;
        }
    }

    /**
     * A method that will return inventory
     * @return an arrayList of items
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /**
     * Returns the room name.
     *
     * @return the room name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Returns the room type.
     *
     * @return the room type
     */
    public String getRoomType() {
        return type;
    }

    /**
     * Returns the list of puzzles in the room.
     *
     * @return the puzzles list (internal reference)
     */
    public ArrayList<Puzzle> getPuzzles() {
        return puzzles;
    }

    /**
     * Returns the list of items in the room inventory.
     *
     * @return the inventory list (internal reference)
     */
    public ArrayList<Item> getItems() {
        return inventory;
    }

    /**
     * Returns the list of objects in the room.
     *
     * @return the objects list (internal reference)
     */
    public ArrayList<Object> getObjects() {
        return objects;
    }

    /**
     * Returns the room description text.
     *
     * @return the room description
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     * Returns the room options text (used to display available choices).
     *
     * @return the options string
     */
    public String getRoomOption() {
        return options;
    }


    /**
     * Removes all items from the room inventory.
     *
     * <p>Implementation currently removes items by index. Consider replacing with {@code inventory.clear()}
     * for clarity and performance.
     */
    public void resetItem()
    {
        if (inventory == null) {
            return;
        }
        for(int i=0; i<inventory.size();i++) {
            inventory.remove(i);
            i--;
        }
    }

    /**
     * Prints a brief exploration summary to standard output (items and puzzles found).
     */
    public void exploreRoom()
    {
       println("Exploring " + roomName + ". Found "
       + (inventory == null ? 0 : inventory.size()) + " items and "
       + (puzzles == null ? 0 : puzzles.size()) + " puzzles.");
    }

    /**
     * Displays the options text to the console.
     * Visibility is private because it's intended as an internal helper.
     */
    private void displayOptions()
    {
        println("\nAvailable actions: ");
        println(options);
    }

    /**
     * Process a numeric input command for this room, operating on the provided player account.
     *
     * <p>Behavior:
     * <ul>
     *   <li>1 — open a chest ({@link #chest()})</li>
     *   <li>2 — browse bookshelf ({@link #bookshelf()})</li>
     *   <li>3 — roll dice ({@link #dice()})</li>
     *   <li>4 — examine desk ({@link #desk()})</li>
     *   <li>5 — check bed ({@link #bed()})</li>
     * </ul>
     *
     * @param num numeric option to execute
     * @param player the player {@link Account} that may receive items (may be {@code null})
     */
    public void inputOptions(int num, Account player) {
        switch (num) {
            case 1:
                Item found = chest();
                if (found != null) {
                    println("You found: " + found.getName());
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
                println("Invalid option.");
        }
    }

    /**
     * Convenience overload for {@link #inputOptions(int, Account)} when no player account is provided.
     *
     * @param num numeric option to execute
     */
    public void inputOptions(int num) 
    {
        inputOptions(num, null);
    }

    /**
     * Opens the chest and returns the first item from the room inventory, removing it from inventory.
     *
     * <p>If the inventory is empty or null, prints a message and returns {@code null}.
     *
     * @return the removed {@link Item} if present, otherwise {@code null}
     */
    public Item chest() {
        println("You open the chest...");

        if (inventory == null || inventory.isEmpty()) {
            println("It appears empty.");
            return null;
        }

        // Return first item from inventory
        Item item = inventory.remove(0);
        return item;
    }

    /**
     * Simulates browsing a bookshelf; currently prints a placeholder message.
     */
    public void bookshelf() 
    {
        println("You browse the bookshelf. A few titles catch your eye.");
    }

    /**
     * Rolls a six-sided die and prints the result.
     */
    public void dice() {
        int roll = (int) (Math.random() * 6) + 1;
        System.out.println("You roll the dice... result: " + roll);
    }

    /**
     * Simulates examining a desk; currently prints a placeholder message.
     */
    public void desk() 
    {
        println("You examine the desk and find scattered notes.");
    }

    /**
     * Simulates checking under a bed; currently prints a placeholder message.
     */
    public void bed() 
    {
        println("You check under the bed and lift the mattress.");
    }

    /**
     * Adds an {@link Item} to the room inventory.
     *
     * @param item the item to add (may be null - consider guarding against null)
     */
    public void addItem(Item item) 
    { 
        if (inventory == null) {
            inventory = new ArrayList<>();
        }
        inventory.add(item); 
    }

    /**
     * Adds a {@link Puzzle} to the room's puzzle list.
     *
     * @param puzzle the puzzle to add (may be null - consider guarding against null)
     */
    public void addPuzzle(Puzzle puzzle) 
    { 
        if (puzzles == null) {
            puzzles = new ArrayList<>();
        }
        puzzles.add(puzzle); 
    }

    /**
     * Prints the interactable objects in the room to the console with numeric indices.
     * If {@link #objects} is null or empty, prints nothing.
     */
    public void interactWithObject()
    {
        if (objects == null) {
            return;
        }
        for(int i = 0; i < objects.size(); ++i)
        {
            int num = i + 1;
            // Note: assumes objects.get(i) has a getName() method; if not, this will fail at runtime.
            println(num +"." + objects.get(i).getName());
        }
    }

    /**
     * Returns the object at the given index (zero-based).
     *
     * @param option zero-based index into the objects list
     * @return the object at the specified index
     * @throws IndexOutOfBoundsException if {@code option} is out of range or objects is null
     */
    public Object GetObject(int option)
    {
        if (objects == null) {
            throw new IndexOutOfBoundsException("No objects in this room.");
        }
        return objects.get(option);
    }

    /**
     * Prints a small menu of object-related options to the console.
     */
    public void showObjectOption()
    {
        println("1. Show Description" );
        println("2. Interact");
    }

    /**
     * Returns a compact string representation of the room including name, type, solved flag,
     * puzzles, inventory, objects, description and options. This uses the lists' {@code toString()}
     * implementations which can be verbose.
     *
     * @return a string representation of the room
     */
    @Override
    public String toString()
    {
        return roomName + type + solved + (puzzles == null ? "[]" : puzzles.toString())
            + (inventory == null ? "[]" : inventory.toString()) + "\n"
            + objects + roomDescription + options; 
    }

}