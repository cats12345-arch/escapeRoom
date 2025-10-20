package com.model;

import java.time.Duration;

public class PuzzleProgress {
    private boolean isComplete;
    private Duration time;
    private int numHintsUsed;
    private Puzzle puzzle;

    public PuzzleProgress(boolean isComplete, Duration time, int numHintsUsed, Puzzle puzzle) {
        this.isComplete = isComplete;
        this.time = time;
        this.numHintsUsed = numHintsUsed;
        this.puzzle = puzzle;
    }

    public PuzzleProgress() {
        this.isComplete = false;
        this.time = null;
        this.numHintsUsed = 0;
    }

    public void setCompletion(Boolean bool) {
        this.isComplete = bool;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public void setNumHintsUsed(int numHints) {
        this.numHintsUsed = numHints;
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

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public int getnumHintsUsed() {
        return numHintsUsed;
    }

    public String toString() {
        return "\nIs Puzzle complete: " + isComplete + "\nTime on puzzle: " + time + "\nNumber of hints Used: " + numHintsUsed + "\nPuzzle associated with puzzle Progress: " + puzzle;
    }
}
