package com.model; 

public class Leaderboard {
    private HashMap<Player, Integer> scores;
    
    public Leaderboard() {
        scores = new HashMap<>();
    }

    public void addScore(Player player)
    {
        scores.put(player, scores.getScore());
    }

    public void displayTop()
    {

    }
}
