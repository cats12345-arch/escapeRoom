package com.model;

//Temp removing abstract to test
public class Puzzle {
    protected String solution;
    //protected ArrayList <Hint> hint;
    protected int puzzleNum;
    protected boolean solved;

    public Puzzle(String solution, int puzzleNum) {
        this.solution = solution;
        this.puzzleNum = puzzleNum;
    }

    public Puzzle() {
        //just to make the children be quiet
    }

    public void grabItem() {

    }

    public void lookAtItem() {

    }

    public void addItem() {

    }

    public void attempt(String input) {

    }

    public void showHint() {

    }

    public void reset() {

    }

    public boolean isSolved() {
        return solved;
    }

    public void displayHint() {

    }  

    public String toString() {
        return "\nPuzzle: " + "\nSolution: " + solution + "PuzzleNum: " + puzzleNum;
    }
}
