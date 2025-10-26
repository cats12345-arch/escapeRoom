package com.model;

import java.util.ArrayList;

public class ItemPuzzle extends Puzzle {
    protected ArrayList<Item> requiredItems;
    protected Room room;

    public ItemPuzzle(ArrayList<Item> requiredItems, String solution, ArrayList<String> hint, int puzzleNum, Room room) {
        super(solution, hint, puzzleNum, "ITEM");
        this.requiredItems = requiredItems != null ? requiredItems : new ArrayList<>();
        this.room = room;
    }

    public ItemPuzzle(ArrayList<Item> requiredItems, String solution, ArrayList<String> hint, int puzzleNum) {
        super(solution, hint, puzzleNum, "ITEM");
        this.requiredItems = requiredItems != null ? requiredItems : new ArrayList<>();
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

    @Override
    public boolean attempt(String input) {
        if (input.equalsIgnoreCase(solution)) {
            System.out.println("You built a " + solution + ". Puzzle solved.");
            return true;
        } else {
            System.out.println("Incorrect. Try again or gather more resources.");
            return false;
        }
    }

    @Override
    public void displayHint() {
        System.out.println("Item Puzzle: You need to gather resources to build something important.");
        super.displayHint();
        if (requiredItems != null && !requiredItems.isEmpty()) {
            System.out.print("Required items: ");
            for (Item item : requiredItems) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return puzzleType + "|" + solution + "|" + puzzleNum +
                "|Required items: " + (requiredItems != null ? requiredItems.stream().map(Item::getName).toList() : "None");
    }
}
