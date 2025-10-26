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
     * 
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

    /**
     * 
     */
    public RoomProgress() {
        this.items = new ArrayList<Item>();
        this.puzzles = new ArrayList<PuzzleProgress>();
        this.isComplete = false;
        this.time = null;
        this.room = null;
    }

    /**
     * 
     * @param name
     * @param description
     */
    public void addItem(String name, String description) {
        Item newItem = new Item(name, description);
        items.add(newItem);
    }

    /**
     * 
     * @param isComplete
     * @param time
     * @param numHintsUsed
     * @param puzzle
     */
    public void addPuzzle(boolean isComplete, Duration time, int numHintsUsed, Puzzle puzzle) {
        PuzzleProgress newPuzzleProgress = new PuzzleProgress(isComplete, time, numHintsUsed, puzzle);
        puzzles.add(newPuzzleProgress);
    }

    /**
     * 
     * @param bool
     */
    public void setCompletion(boolean bool) {
        this.isComplete = bool;
    }

    /**
     * 
     * @param time
     */
    public void setTime(Duration time) {
        this.time = time;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * 
     * @return
     */
    public ArrayList<PuzzleProgress> getPuzzles() {
        return puzzles;
    }

    /**
     * 
     * @return
     */
    public boolean getIsComplete() {
        return isComplete;
    }

    /**
     * 
     * @return
     */
    public Duration getTime() {
        return time;
    }

    /**
     * 
     * @return
     */
    public Room getRoom() {
        return room;
    }

    /**
     * 
     * @return
     */
    public String getTimeString() {
        return time.toString();
    }

    /**
     * 
     * @return
     */
    public String toString() {
        return "\nIs it complete: " + isComplete + "\nTime to complete room" + time + "\nPuzzles in the Room and their info: " + puzzles + "\nItems in this room and their info: " + items + "\nRoom and the info associated with it" + room;
    }
}
