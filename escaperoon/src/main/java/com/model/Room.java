package com.model;

import java.util.ArrayList;

public class Room {
    protected String roomName;
    protected String type;
    protected boolean solved;
    protected ArrayList<Puzzle> puzzles;
    protected ArrayList<Item> inventory;

    public Room() {
        this.roomName = "Unnamed";
        this.type = "Normal";
        this.solved = false;
        this.puzzles = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    public Room(String name, String type, ArrayList<Puzzle> puzzle, ArrayList<Item> item) {
        this.roomName = name;
        this.type = type;
        this.puzzles = puzzle;
        this.inventory = item;
    }

    public void reset() {
        this.solved = false;
        for(Puzzle p : puzzles) {
            p.reset();
        }
    }

    public boolean isSolved() {
        for(Puzzle p: puzzles){
            if(!p.isSolved()) {
                return false;
            }
        }
        return solved;
    }

    public Item getItem(Player player) {
        if(!inventory.isEmpty()) {
            Item item = inventory.remove(0);
            return item;
        }
        return null;
    }

    public void exploreRoom() {

    }
    
    public void startPuzzle(){

    }

    public String toString() {
        return "\nRoom: " + "\nName: " + roomName + "\nType: " + type + "\nPuzzle: " + puzzles.toString() + "\nItem: " + inventory.toString();
    }
 
}
 
