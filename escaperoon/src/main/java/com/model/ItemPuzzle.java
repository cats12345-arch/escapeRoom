package com.model;

import java.util.ArrayList;

import com.speech.Speek;

public class ItemPuzzle extends Puzzle {

    protected ArrayList<Item> requiredItems;
    protected Room room;

    /**
     * constructs an ItemPuzzle tied to a specific room.
     * @param requiredItems the items required to solve this puzzle
     * @param hint a list of hints for the player
     * @param puzzleNum the puzzle identifier
     * @param room the room this puzzle is part of
     */
    public ItemPuzzle(String solution, ArrayList<Item> requiredItems, ArrayList<String> hint, int puzzleNum, Room room) {
        super(solution, hint, puzzleNum, "ITEM");
        this.requiredItems = requiredItems != null ? requiredItems : new ArrayList<>();
        this.room = room;
    }

    private void println(String s) {
        Speek.speak(s);
        System.out.println(s);
    }

    /**
     * checks if the player has all the required items that belong to this room. 
     * @param playerInventory the player's current inventory
     * @return true or false if all required room items are found in the player's inventory
     */
    public boolean isSolved(ArrayList<Item> playerInventory) {
        if (room == null) {
            return false;
        }

        ArrayList<Item> roomItems = room.getItems();
        if (roomItems == null || roomItems.isEmpty()) {
            return false;
        }

        if (requiredItems == null || requiredItems.isEmpty()) {
            println("You solved the " + puzzleNum + " puzzle!");
            return true;
        }

        if (playerInventory == null || playerInventory.isEmpty()) {
            return false;
        }

        // verify each required item both exists in the room and is owned by the player
        for (Item needed : requiredItems) {
            boolean inRoom = false;
            boolean withPlayer = false;

            for (Item item : roomItems) {
                if (item.getName().equalsIgnoreCase(needed.getName())) {
                    inRoom = true;
                    break;
                }
            }

            for (Item playerItem : playerInventory) {
                if (playerItem.getName().equalsIgnoreCase(needed.getName())) {
                    withPlayer = true;
                    break;
                }
            }

            // if missing in either location, puzzle is not solved
            if (!inRoom || !withPlayer) {
                return false;
            }
        }

        // all required items are both in the room and owned by the player
        println("You solved the " + puzzleNum + " puzzle!");
        return true;
    }

    @Override
    public boolean attempt(String input) {
        if (input.equalsIgnoreCase(solution)) {
            println("You built a " + solution + ". Puzzle solved.");
            return true;
        } else {
            println("Incorrect. Try again or gather more resources.");
            return false;
        }
    }

    @Override
    public void displayHint() {
        println("Item Puzzle: Find or collect the following items to complete the puzzle.");
        super.displayHint();
        if (!requiredItems.isEmpty()) {
            println("Required items: ");
            for (Item item : requiredItems) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();
        }
    }

    /**
     * returns a summary of the puzzle, including its type, number, and required items.
     *
     * @return a string describing this puzzle
     */
    public String toString() {
        return puzzleType + "|" + solution + "|" + puzzleNum +
                "|Required items: " + (requiredItems != null ? requiredItems.stream().map(Item::getName).toList() : "None");
    }
}
