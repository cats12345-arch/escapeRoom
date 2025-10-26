package com.model; 
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        TreeMap<Account, Integer> sortedMap = new TreeMap<>(scores);
        for(Map.Entry<Account, Integer> entry: sortedMap.entrySet()) {
            System.out.println(entry.getKey().getUsername() + ": " + entry.getValue());
        }
    }
}
