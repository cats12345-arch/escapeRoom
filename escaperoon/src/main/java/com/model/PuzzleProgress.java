package com.model;

/**
 * Keeps track of all the data in the puzzles for each account
 * @author daniel
 */

import java.time.Duration;

public class PuzzleProgress {
    private boolean isComplete;
    private Duration time;
    private int numHintsUsed;
    private Puzzle puzzle;

    /**
     * A constructor for Puzzle Progress that is used at various points in the program
     * @param isComplete is the puzzle complete 
     * @param time how long did it take to complete the puzzle
     * @param numHintsUsed number of hints used by the Puzzle
     * @param puzzle The linked puzzle to its progress
     */
    public PuzzleProgress(boolean isComplete, Duration time, int numHintsUsed, Puzzle puzzle) {
        this.isComplete = isComplete;
        this.time = time;
        this.numHintsUsed = numHintsUsed;
        this.puzzle = puzzle;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void addNumHintsUsed() {
        this.numHintsUsed++;
    }

    /**
     *  default constructor
     */
    public PuzzleProgress() {
        this.isComplete = false;
        this.time = null;
        this.numHintsUsed = 0;
        this.puzzle = null;
    }

    /**
     * used to set if the puzzle is completed or not
     * @param bool True if puzzle is completed false if not
     */
    public void setCompletion(Boolean bool) {
        this.isComplete = bool;
    }

    /**
     * Used to set how long the puzzle took to complete or how long has been spent on the puzzle
     * @param time Stes the time of the puzzle
     */
    public void setTime(Duration time) {
        this.time = time;
    }

    /**
     * Used to set how many hints have been used on a particular puzzle
     * @param numHints sets the number of hints used on the puzzle
     */
    public void setNumHintsUsed(int numHints) {
        this.numHintsUsed = numHints;
    }

    /**
     * A method to return a boolean of if the puzzle is completed or not
     * @return returns if the puzzle has been completed
     */
    public boolean getIsComplete() {
        return isComplete;
    }

    /**
     * A method to return a Duration fo Time for the Puzzle
     * @return A Duration of time
     */
    public Duration getTime() {
        return time;
    }
    
    /**
     * A method to return a String of the time, used by the dataLoader/Writer
     * @return A string of the time
     */
    public String getTimeString() {
        return time.toString();
    }

    /**
     * A method to return the Puzzle that is associated with this class, used by the dataLoader/Writer primarly
     * @return A puzzle
     */
    public Puzzle getPuzzle() {
        return puzzle;
    }

    /**
     * A method that will return the number of hints used
     * @return an int of number of hints used
     */
    public int getnumHintsUsed() {
        return numHintsUsed;
    }

    /**
     * Used primaryly for testing
     * @return A string with info about Puzzle Progress
     */
    public String toString() {
        return "\nIs Puzzle complete: " + isComplete + "\nTime on puzzle: " + time + "\nNumber of hints Used: " + numHintsUsed + "\nPuzzle associated with puzzle Progress: " + puzzle;
    }
}
