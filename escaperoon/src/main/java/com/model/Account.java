package com.model;

import java.util.ArrayList;

public class Account {
    private String username;
    private String password;
    private ArrayList<RoomProgress> roomProgresses;
    private int score;
    private ArrayList<Achievement> achievements;

    public Account(String username, String password, ArrayList<RoomProgress> roomProgresses, int score, ArrayList<Achievement> achievements) {
        this.username = username;
        this.password = password;
        this.roomProgresses = roomProgresses;
        this.score = score;
        this.achievements = achievements;
    }

    //defaultish constructor to create an account
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.roomProgresses = new ArrayList<RoomProgress>();
        this.score = 0;
        this.achievements = new ArrayList<Achievement>();
    }

    public ArrayList<RoomProgress> getRoomProgresses() {
        return roomProgresses;
    }
    
    public int getScore() {
        return score;
    }

    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }

    public String toString() {
        return "\nUsername: " + username + "\nPassword: " + password + "\nThe Rooms Progress: " + roomProgresses + "\nScore: " + score + "\nList of Player Achievements: " + achievements;
    }
}
