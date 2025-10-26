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

    public GameEngine()
    {
        this.accounts = new ArrayList<>();
        this.leaderboard = new Leaderboard();
        this.time = new Timer(0);
        this.currentPuzzle = null;
    }

    public static GameEngine getInstance() {
        if(gameengine == null) {
            gameengine = new GameEngine();
        }
        return gameengine;
    }

    public void startGame()
    {
        time.start();
        loadNextPuzzle(0);
    }

    public void endGame(boolean victory)
    {
        time.stop();
    }


    public void loadNextPuzzle(int num)
    {
        Puzzle tempPuzzle = room.getNextPuzzle(num);
        if(tempPuzzle == null) {
            System.out.println("There are no more puzzles to load.");
        }
        currentPuzzle = room.getNextPuzzle(num);
    }

    public void displaySummary()
    {
        displayLeaderboard();
    }

    public void login()
    {
        Account player = new Account(null, null, null, 0, null, null);
        accounts.add(accounts);
    }

    public void displayLeaderboard()
    {
        leaderboard.displayTop();
    }
}
