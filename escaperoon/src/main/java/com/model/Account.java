package com.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private String username;
    private String password;
    private ArrayList<RoomProgress> roomProgresses;
    private int score;
    private ArrayList<Achievement> achievements;
    private HashMap<Room, RoomProgress> progress;

    public Account(String username, String password, ArrayList<RoomProgress> roomProgresses, int score, ArrayList<Achievement> achievements, HashMap<Room, RoomProgress> progress) {
        this.username = username;
        this.password = password;
        this.roomProgresses = roomProgresses;
        this.score = score;
        this.achievements = achievements;
        this.progress = progress;
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

    public HashMap<Room, RoomProgress> getProgress() {
        return progress;
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
        return "\nUsername: " + username + "\nPassword: " + password + "\nThe Rooms Progress: " + roomProgresses + "\nScore: " + score + "\nList of Player Achievements: " + achievements + "\nProgress:" + progress;
    }
}
