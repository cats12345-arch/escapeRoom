package com.model;

/**
 * Room Progress class that holds all the data for account associated with a room
 * @author daniel
 */
import java.time.Duration;
import java.util.ArrayList;

public class RoomProgress {
    private ArrayList<Item> items;
    private ArrayList<PuzzleProgress> puzzles;
    private boolean isComplete;
    private Duration time;
    private Room room;

    /**
     * The constructor for the Room Progress class that will be primarly used
     * @param items Items that the account has
     * @param puzzles The puzzles in a room
     * @param isComplete If the room is complete
     * @param time The time taken in a room
     * @param room The room associated with the RoomProgress
     */
    public RoomProgress(ArrayList<Item> items, ArrayList<PuzzleProgress> puzzles, boolean isComplete, Duration time, Room room) {
        this.items = items;
        this.puzzles = puzzles;
        this.isComplete = isComplete;
        this.time = time;
        this.room = room;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * A default constructor used for room progress used when making a new account
     */
    public RoomProgress() {
        this.items = new ArrayList<Item>();
        this.puzzles = new ArrayList<PuzzleProgress>();
        this.isComplete = false;
        this.time = null;
        this.room = null;
        this.time = Duration.ZERO;
    }

    public void setRoomProgress(Room room) {
        this.room = room;
    }

    /**
     * A method that makes a new item and adds it to the arrayList of items
     * @param name The name of the new Item
     * @param description The description of the new Item
     */
    public void addItem(String name, String description) {
        Item newItem = new Item(name, description);
        items.add(newItem);
    }

    /**
     * A method that will make a new Puzzle Progress and add it to the arraylist of puzzle progresses
     * @param isComplete Is the puzzle completed
     * @param time How long has been spent on the puzzle
     * @param numHintsUsed The number of hints used on the puzzle
     * @param puzzle the puzzle linked to the puzzle progress 
     */
    public void addPuzzle(boolean isComplete, Duration time, int numHintsUsed, Puzzle puzzle) {
        PuzzleProgress newPuzzleProgress = new PuzzleProgress(isComplete, time, numHintsUsed, puzzle);
        puzzles.add(newPuzzleProgress);
    }

    public void addPuzzleProgress(PuzzleProgress puzzle) {
        this.puzzles.add(puzzle);
    }

    /**
     * Will set the Room to complete
     * @param bool true if the room is completed
     */
    public void setCompletion(boolean bool) {
        this.isComplete = bool;
    }

    /**
     * Sets the time spent in the room
     * @param time The time spent in the room
     */
    public void setTime(Duration time) {
        this.time = time;
    }

    /**
     * A method primarly used by the datawriter to make the JSON files 
     * @return retuns an ArrayList of Items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * A method primarly used by the dataWriter to make the JSON files
     * @return returns an array list of puzzle progresses
     */
    public ArrayList<PuzzleProgress> getPuzzles() {
        return puzzles;
    }

    /**
     * A method that returns a boolean that will be true if the room has been completed
     * @return a boolean of if the room is completed
     */
    public boolean getIsComplete() {
        return isComplete;
    }

    /**
     * A method that returns a duration of the Time spend in the room
     * @return Reeturns the duration of time spent in the room
     */
    public Duration getTime() {
        return time;
    }

    /**
     * Returns the room that is associated with Room Progress 
     * @return A room that is asscoiated with room progress
     */
    public Room getRoom() {
        return room;
    }

    /**
     * A method that will return a String of the Duration of time. Needs to be converted into a readable format
     * @return will return a String of the time spent in the room
     */
    public String getTimeString() {
        return time.toString();
    }

    /**
     * A toString metjod primarly used for testing
     * @return A string with information about the RoomProgress
     */
    public String toString() {
        return "\nIs it complete: " + isComplete + "\nTime to complete room" + time + "\nPuzzles in the Room and their info: " + puzzles + "\nItems in this room and their info: " + items + "\nRoom and the info associated with it" + room;
    }
}
