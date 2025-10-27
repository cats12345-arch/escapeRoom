package com.model;

import java.util.ArrayList;

/**
 * @author daniel
 * A class for the accounts used to store the username, password, room progress, score, and all user achievements
 */
public class Account {
    private String username;
    private String password;
    private ArrayList<RoomProgress> roomProgresses;
    private int score;
    private ArrayList<Achievement> achievements;

    /**
     * A constructor that is called for the dataloader 
     * @param username The username of the account
     * @param password The password of the account
     * @param roomProgresses The roomprogress for the account
     * @param score The score for the account
     * @param achievements The achievements for the account
     */
    public Account(String username, String password, ArrayList<RoomProgress> roomProgresses, int score, ArrayList<Achievement> achievements) {
        this.username = username;
        this.password = password;
        this.roomProgresses = roomProgresses;
        this.score = score;
        this.achievements = achievements;
    }

    /**
     * This constructor  is used for making new accounts and will make empty array list that will added to by the program
     * @param username The username for a new account
     * @param password The password for a new account
     */
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.roomProgresses = new ArrayList<RoomProgress>();
        this.score = 0;
        this.achievements = new ArrayList<Achievement>();
    }

    /**
     * Used to add to an accounts score
     * @param plus additional score
     */
    public void addToScore(int plus) {
        score += plus;
    }

    /**
     * Used to add onto the users RoomProgress
     * @param roomProgress Additional RoomProgress
     */
    public void addToRoomProgress(RoomProgress roomProgress) {
        this.roomProgresses.add(roomProgress);
    }

    public void addToPuzzleProgress(RoomProgress room, PuzzleProgress puzzle) {
        for(int i=0; i<roomProgresses.size(); i++) {
            if(roomProgresses.get(i).equals(room)) {
                roomProgresses.get(i).addPuzzleProgress(puzzle);
            }
        }
           
    }

    /**
     * Returns Room Progress based on the roomname associated room name
     * @param roomName Used to search for Room Progress by room name
     * @return Returns a RoomProgress
     */
    public RoomProgress getRoomProgress(String roomName) {
        for(int i=0; i<roomProgresses.size(); i++) {
            if(roomProgresses.get(i).getRoom().getRoomName().equalsIgnoreCase(roomName)) {
                return roomProgresses.get(i);
            }
        }
        return null;
    }

    /**
     * Used to add an achievement to the arrayList of achievements
     * @param achievement achievement to be added to the achievement list
     */
    public void addToAchievements(Achievement achievement) {
        achievements.add(achievement);
    }

    /**
     * used by the datawriter to make the JSON
     * @return an arraylist of all the RoomProgress
     */
    public ArrayList<RoomProgress> getRoomProgresses() {
        return roomProgresses;
    }
    
    /**
     * This method will return the accounts score
     * @return returns the accounts score
     */
    public int getScore() {
        return score;
    }

    /**
     * This method will return the accounst arraylist of achievements. Used by the data writer primarly
     * @return retruns an array list of achievemnest 
     */
    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    /**
     * Returns the accounts username
     * @return the accounts username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Used by the datawriter to save the accounts password in the json file
     * @return The password to the account
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Allows the program to change the password of the account
     * @param newPassword A string of the new password
     */
    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }

    /**
     * A to string mainly used for bug testing
     * @return Returns a string containg the information about accounts
     */
    public String toString() {
        return "\nUsername: " + username + "\nPassword: " + password + "\nThe Rooms Progress: " + roomProgresses + "\nScore: " + score + "\nList of Player Achievements: " + achievements;
    }
}
