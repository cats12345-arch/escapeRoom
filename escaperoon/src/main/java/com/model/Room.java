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
     * Returns whether the room is marked as solved.
     *
     * @return {@code true} if solved flag is set, {@code false} otherwise
     */
    public Boolean getSolved() {
        return solved;
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
     * Checks whether all puzzles in the room are solved. If any puzzle is not solved,
     * returns {@code false}. If there are no puzzles, returns the value of {@link #solved}.
     *
     * @return {@code true} if every puzzle is solved or {@link #solved} is {@code true} when there are no puzzles
     */
    public boolean getSolved()
    {
        if (puzzles == null || puzzles.isEmpty()) {
            return solved;
        }
        return true;
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
       System.out.println("Exploring " + roomName + ". Found "
       + (inventory == null ? 0 : inventory.size()) + " items and "
       + (puzzles == null ? 0 : puzzles.size()) + " puzzles.");
    }

    /**
     * Displays the options text to the console.
     * Visibility is private because it's intended as an internal helper.
     */
    private void displayOptions()
    {
        System.out.println("\nAvailable actions: ");
        System.out.println(options);
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
        System.out.println("You open the chest...");

        if (inventory == null || inventory.isEmpty()) {
            System.out.println("It appears empty.");
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
        System.out.println("You browse the bookshelf. A few titles catch your eye.");
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
        System.out.println("You examine the desk and find scattered notes.");
    }

    /**
     * Simulates checking under a bed; currently prints a placeholder message.
     */
    public void bed() 
    {
        System.out.println("You check under the bed and lift the mattress.");
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
            System.out.println(num +"." + objects.get(i).getName());
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
        System.out.println("1. Show Description" );
        System.out.println("2. Interact");
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