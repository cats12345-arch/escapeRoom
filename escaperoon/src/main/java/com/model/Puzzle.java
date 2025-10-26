package com.model;

import java.util.ArrayList;

/**
 * puzzle class
 * each puzzle has solutions and hints
 */
public abstract class Puzzle {
    protected String solution;
    protected int puzzleNum;
    protected ArrayList<String> hint;
    protected String puzzleType;
    protected int hintNum;

    /**
     * Constructor for puzzle
     * @param solution, hint, puzzleNum, and puzzleType
     */
    public Puzzle(String solution, ArrayList<String> hint, int puzzleNum, String puzzleType) {
        this.solution = solution != null ? solution.toUpperCase() : "";
        this.puzzleNum = puzzleNum;
        this.hint = hint != null ? hint : new ArrayList<>();
        this.puzzleType = puzzleType != null ? puzzleType : "GENERIC";
    }
/**
 * default constructor to initialize a puzzle
 */
    public Puzzle() {
        this.solution = "";
        this.puzzleNum = 0;
        this.hint = new ArrayList<>();
        this.puzzleType = "GENERIC";
    }

    public boolean solve(String input) {
        if(input.equals(solution)) {
            return true;
        }
        return false;
        
    }

    /**
     * 
     * @return the type of puzzle
     */
public String getPuzzleType() {
        return puzzleType;
    }
/**
 * 
 * @param puzzleType - the puzzles type
 */
    public void setPuzzleType(String puzzleType) {
        this.puzzleType = puzzleType;
    }
/**
 * 
 * @return returns the solution string
 */
    public String getSolution() {
        return solution;
    }
/**
 * 
 * @return puzzle number
 */
    public int getPuzzleNum() {
        return puzzleNum;
    }
/**
 * 
 * @return array list of hints
 */
    public ArrayList<String> getHints() {
        return hint;
    }

    public String getHint() {
        String temp =  hint.get(hintNum);
        hintNum++;
        return temp;
    }
/**
 * 
 * @param num - index of the hint
 * @return hint's string and whether its null or not
 */
    public String getHint(int num) {
        if(num > hint.size()) {
            return null;
        }
        return hint.get(num);
    }
/**
 * 
 * @param input the players answer
 * @return true or false answer
 */
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
/**
 * display hints if its available
 */
    public void displayHint() {
        if (!hint.isEmpty()) {
            System.out.println("Hint: " + hint.get(0));
        } else {
            System.out.println("No hints available.");
        }
    }

    /**
     * @return returns the puzzles string
     */
    public String toString() {
        return puzzleType + "|" + solution + "|" + puzzleNum + "|" + String.join(",", hint);
      
    }   
}