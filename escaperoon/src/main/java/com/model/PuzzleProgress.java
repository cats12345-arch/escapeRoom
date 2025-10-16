package com.model;

import java.time.Duration;

public class PuzzleProgress {
    private boolean isComplete;
    private Duration time;
    private int numHintsUsed;

    public PuzzleProgress(boolean isComplete, Duration time, int numHintsUsed) {
        this.isComplete = isComplete;
        this.time = time;
        this.numHintsUsed = numHintsUsed;
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

    public int getnumHintsUsed() {
        return numHintsUsed;
    }

    public String toString() {
        return "\nIs Puzzle complete: " + isComplete + "\nTime on puzzle: " + time + "\nNumber of hints Used: " + numHintsUsed;
    }
}
