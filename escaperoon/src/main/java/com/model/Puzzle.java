package com.model;
import java.util.ArrayList;
//Temp removing abstract to test
public abstract class Puzzle {
    protected String solution;
    //protected ArrayList <Hint> hint;
    protected int puzzleNum;
    protected boolean solved;
    protected ArrayList<String> hint;

    public Puzzle(String solution, ArrayList<String> hint, int puzzleNum) {
        this.solution = solution.toUpperCase();
        this.puzzleNum = puzzleNum;
        this.hint = hint;
        this.solved = false;
    }

    public Puzzle() {
        this.solution = "";
        this.puzzleNum = 0;
        this.hint = new ArrayList<>();
        this.solved = false;

    }
        

    public void grabItem() {
        System.out.println("You have grabbed an item");
    }

    public void lookAtItem() {
        System.out.println("You inspect the item carefully");
    }

    public void addItem() {
        System.out.print("You added the item to your inventory");
    }

    public boolean attempt(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("You must enter an answer");
            return false;
        }
        if (input.equalsIgnoreCase(solution)) {
            solved = true;
            System.out.println("✅ Correct! Puzzle solved.");
            return true;
        } else {
            System.out.println("Incorrect. Try again or use a hint.");
            return false;
        }

    }

    public void showHint() {
        if (hint == null || hint.isEmpty()) {
            System.out.println("no  hints available");
        } else {
            System.out.println("Hints:");
            for (int i = 0; i < hint.size(); i++) {
                System.out.println(" " + (i+1) + "." + hint.get(i));
            }
        }
    }

    public void reset() {
        this.solved = false;
        System.out.println("The puzzle was reset");
    }

    public boolean isSolved() {
        return solved;
    }

    public void displayHint() {
        if (hint != null && !hint.isEmpty()) {
            System.out.println("Hint: " + hint.get(0));
        } else {
            System.out.println("No hints is available");
        }
    }  

    public String toString() {
        return "\nPuzzle #" + puzzleNum +
                "\nSolution: " + solution +
                "\nSolved: " + solved +
                "\nHints: " + hint;
    }
}
