package com.model;

import java.time.Duration;
import java.util.ArrayList;

public class RoomProgress {
    private ArrayList<Item> items;
    private ArrayList<PuzzleProgress> puzzles;
    private boolean isComplete;
    private Duration time;

    public RoomProgress(ArrayList<Item> items, ArrayList<PuzzleProgress> puzzles, boolean isComplete, Duration time) {
        this.items = items;
        this.puzzles = puzzles;
        this.isComplete = isComplete;
        this.time = time;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<PuzzleProgress> getPuzzles() {
        return puzzles;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public Duration getTime() {
        return time;
    }

    public String getTimeString() {
        return time.toString();
    }

    public String toString() {
        return "\nIs it complete: " + isComplete + "\nTime to complete room" + time + "\nPuzzles in the Room and their info: " + puzzles + "\nItems in this room and their info: " + items;
    }
}
