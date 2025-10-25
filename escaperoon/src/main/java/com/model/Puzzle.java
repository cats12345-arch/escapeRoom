package com.model;

import java.util.ArrayList;

public abstract class Puzzle {
    protected String solution;
    protected int puzzleNum;
    protected ArrayList<String> hint;
    protected String puzzleType;

public Puzzle(String solution, ArrayList<String> hint, int puzzleNum, String puzzleType) {
        this.solution = solution != null ? solution.toUpperCase() : "";
        this.puzzleNum = puzzleNum;
        this.hint = hint != null ? hint : new ArrayList<>();
        this.puzzleType = puzzleType != null ? puzzleType : "GENERIC";
}
public Puzzle() {
        this.solution = "";
        this.puzzleNum = 0;
        this.hint = new ArrayList<>();
        this.puzzleType = "GENERIC";
        
}
public String getPuzzleType() {
        return puzzleType;
    }

    public void setPuzzleType(String puzzleType) {
        this.puzzleType = puzzleType;
    }

    public String getSolution() {
        return solution;
    }

    public int getPuzzleNum() {
        return puzzleNum;
    }

    public ArrayList<String> getHints() {
        return hint;
    }

    public boolean attempt(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("You must enter an answer.");
            return false;
        }

        if (input.equalsIgnoreCase(solution)) {
            System.out.println("Correct! You solved the puzzle.");
            return true;
        } else {
            System.out.println("Incorrect. Try again.");
            return false;
        }
    }

 public void displayHint() {
        if (!hint.isEmpty()) {
            System.out.println("Hint: " + hint.get(0));
        } else {
            System.out.println("No hints available.");
        }
    }

    
    public String toString() {
        return puzzleType + "|" + solution + "|" + puzzleNum + "|" + String.join(",", hint);
      
    }   
}