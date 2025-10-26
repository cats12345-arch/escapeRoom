package com.model; 

import java.util.ArrayList;

public class GameEngine {

    private static GameEngine gameengine; 
    private Puzzle currentPuzzle;
    private Timer time;
    private ArrayList<Account> accounts;
    private Leaderboard leaderboard;
    private Room room;
    private Puzzle puzzle;
    private int currentPuzzleNum;

    /*
     * Contructs a new GameEngine instance
     * Initializes all attributes
     */
    public GameEngine()
    {
        this.accounts = new ArrayList<>();
        this.leaderboard = new Leaderboard();
        this.currentPuzzle = null;
        this.time = new Timer(0);
    }

    public static GameEngine getInstance() {
        if(gameengine == null) {
            gameengine = new GameEngine();
        }
        return gameengine;
    }

    /*
     * Starts the game by initializing the timer and loading the first puzzle
     */
    public void startGame()
    {
        time.start();
        loadNextPuzzle(0);
    }

    /*
     * Ends the game and stops the timer 
     */
    public void endGame(boolean victory)
    {
        time.stop();
    }

    /*
     * Loads the next puzzle from the room 
     */
    public void loadNextPuzzle(int num)
    {
        Puzzle tempPuzzle = room.getNextPuzzle(num);
        if(tempPuzzle == null) {
            System.out.println("There are no more puzzles to load.");
        }
        currentPuzzle = room.getNextPuzzle(num);
    }

    /*
     * Displays the game summary 
     */
    public void displaySummary()
    {
        displayLeaderboard();
    }

    /*
     * Authenticates a user based on their username and password
     */
    public Account login(String username, String password) {
    for (Account acc : accounts) {
        if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
            return acc; 
        }
    }
    return null; 
}

    /*
     * Displays the leaderboard
     */
    public void displayLeaderboard()
    {
        leaderboard.displayTop(accounts);
    }
}
