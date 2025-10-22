package com.model; 
import java.util.HashMap;

public class Leaderboard {
    private HashMap<Account, Integer> scores;
    private static Leaderboard leaderboard;
    
    public Leaderboard() {
        this.scores = new HashMap<>();
    }

    public static Leaderboard getInstance() {
        if(leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }

    public void addScore(Account account)
    {
        if(account == null)
        return;

        int newScore = account.getScore();
        Integer current = scores.get(account);

        if(current == null || newScore > current)
        {
            scores.put(account, newScore);
        }
    }

    public void displayTop()
    {

    }
}
