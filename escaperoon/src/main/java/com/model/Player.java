package com.model;

import java.util.ArrayList;

public class Player extends Account{
    private String username;
    private String password;
    private int score;
    private ArrayList<Achievement> awards;

    public Player(String username, String password, int score, ArrayList<Achievement> achievements) {
        this.username = username;
        this.password = password;
        this.score = score;
        this.awards = achievements;
    }

    public Player(String username, String password, int score) {
        this.username= username;
        this.password = password;
        this.score = score;
        this.awards = new ArrayList<Achievement>();
    }

    public int getScore() {
        return this.score;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void newAchievement(String name, boolean awarded, String description) {
        Achievement achievement = new Achievement(name, awarded, description);
        awards.add(achievement);
    }

    public void updateScore(int points) {
        score += points;
    }

    public String toString() {
        return "Username: " + username + "\nPassword: " + password + "\nScore: " + score + "\n" + awards.toString();
    }
}
