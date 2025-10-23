package com.model; 

import java.util.ArrayList;

public class GameEngine {

    private static GameEngine gameengine; 
    private Puzzle currentPuzzle;
    private Timer time;
    private ArrayList<Account> accounts;
    private Leaderboard leaderboard;

    public GameEngine()
    {
        this.accounts = new ArrayList<>();
        this.leaderboard = new Leaderboard();
        this.time = new Timer();
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
        loadNextPuzzle();
    }

    public void endGame(boolean victory)
    {
        time.stop();
    }


    public void loadNextPuzzle()
    {
        currentPuzzle = new Puzzle();
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
