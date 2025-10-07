package com.model;

import java.util.ArrayList;

public class Account {
    protected String username;
    protected String password;
    private ArrayList<Player> players;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.players = new ArrayList<Player>();
    }

    public Player getPlayer(String username, String password) {
        for(int i=0; i<players.size(); i++) {
            if(players.get(i).getUsername().equals(username) && players.get(i).getPassword().equals(password)) {
                return players.get(i);
            }
        }
        return null;
    }

    public String getUsername() {
        return this.username;
    }

    public void loadPlayers(String username, String password, int score) {
        Player player = new Player(username, password, score);
        players.add(player);
    }

    public Player logout() {
        return null;
    }

    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }

    public void accountDeletion(String username, String password) {
        for(int i=0; i<players.size(); i++) {
            if(players.get(i).getUsername().equals(username) && players.get(i).getPassword().equals(password)) {
                players.remove(i);
            }
        }
    }

    public String toString() {
        return username + password;
    }
}
