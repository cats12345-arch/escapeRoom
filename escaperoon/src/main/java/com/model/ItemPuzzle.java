package com.model;

import java.util.ArrayList;

public class ItemPuzzle extends Puzzle {
    private ArrayList<Item> requiredItems;
    private Room room;

    public ItemPuzzle(ArrayList<Item> requiredItems, String solution, ArrayList<String> hint, int puzzleNum, Room room ) {
        super(solution, hint, puzzleNum);
        this.requiredItems = requiredItems != null ? requiredItems : new ArrayList<>();
        this.room = room;
    }

    public ItemPuzzle() {
        System.out.println(".()");
        this.requiredItems = new ArrayList<>();
        this.room = null;
    }

    public boolean playerHasItems(ArrayList<Item> playerInventory) {
        if (requiredItems.isEmpty()) return true;

        for (Item needed : requiredItems) {
            boolean found = false;
            for (Item playerItem : playerInventory) {
                if (playerItem.getName().equalsIgnoreCase(needed.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    public void pickUpItem(Player player, String itemName) {
        if (room == null || room.getInventory() == null) {
            System.out.println("There are no items available in this room.");
            return;
        }

        for (Item item : room.getInventory()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                player.addItem(item);
                System.out.println("You picked up: " + item.getName());
                return;
            }
        }

        System.out.println("No item named '" + itemName + "' found in this room.");
    }
    
    public boolean attempt(String input) {
        // Example: solution could be "SETTLEMENT" or "CITY"
        if (input.equalsIgnoreCase(solution)) {
            if (playerHasItems(room.getInventory())) {
                solved = true;
                System.out.println(" You built a " + solution + "! Puzzle solved.");
                return true;
            } else {
                System.out.println(" You don't have all the required items to build a " + solution + ".");
                return false;
            }
        } else {
            System.out.println("Incorrect. Try again or gather more resources.");
            return false;
        }
    }

    @Override
    public void displayHint() {
        System.out.println("Item Puzzle: You need to gather resources to build something important!");
        super.displayHint();
        System.out.print("Required items: ");
        for (Item item : requiredItems) {
            System.out.print(item.getName() + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Item Puzzle (build: " + solution + ") | Requires: " +
                requiredItems.stream().map(Item::getName).toList();
    }

}
