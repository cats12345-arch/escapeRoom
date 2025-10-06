package java;

import java.util.ArrayList;

public class GameEngine {

    private Puzzle currentPuzzle;
    private Timer time;
    private ArrayList<Player> players;
    private Leaderboard leaderboard;

    public GameEngine()
    {
        players = new ArrayList<>();
        leaderboard = new Leaderboard();
        time = new Timer();
    }

    public void startGame()
    {
        time.start();
        loadNextPuzzle();
    }

    public void endGame(boolean victory)
    {
        time.stop();
        displaySummary();
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
        Player player = new Player("Guest");
        players.add(player);
    }

    public void displayLeaderboard()
    {
        leaderboard.display();
    }



    
    
}
