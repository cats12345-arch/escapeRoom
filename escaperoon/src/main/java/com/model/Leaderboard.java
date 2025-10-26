package com.model; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Leaderboard {
    private HashMap<Account, Integer> scores;
    private static Leaderboard leaderboard;
    
    /*
     * Contructs a new Leaderboard instance
     */
    public Leaderboard() {
        this.scores = new HashMap<>();
    }

    /*
     * Returns a single instance of leaderboard
     */
    public static Leaderboard getInstance() {
        if(leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }

    /*
     * Adds or updates the score of a account 
     * If the account does not exist, it is added
     * If the account exists and the new score is higher, it is updated
     */
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

    /*
     * Displays the username and scores of the top accounts 
     */
    public void displayTop(ArrayList<Account> accounts)
    {
        SortedMap<String, Integer> sortedMap = new TreeMap<String, Integer>();
        for(int i=0; i < accounts.size(); i++) {
            sortedMap.put(accounts.get(i).getUsername(), accounts.get(i).getScore());
        }
        for(Map.Entry<String, Integer> entry: sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
