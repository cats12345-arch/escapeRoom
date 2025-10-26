package com.model;

import java.util.Scanner;


public class UI {

    private final EscapeRoomFACADE facade;
    private final Scanner scanner = new Scanner(System.in);

    public UI() {
        this.facade = new EscapeRoomFACADE();
    }

    public void run() {
        println("Escape Room Testing");
        boolean running = true;

        while (running) {
            printMenu();
            String choice = prompt("Choose an option");

            switch (choice) {
                case "1": login(); 
                break;
                case "2": createAccount(); 
                break;
                case "3": logout();
                 break;
                case "4": selectRoom(); 
                break;
                case "5": createRoom();
                 break;
                case "6": startGame();
                 break;
                case "7": endGame(); 
                break;
                case "8": puzzleNext(); 
                break;
                case "9": puzzleAnswer(); 
                break;
                case "10": getHint(); 
                break;
                case "11": selectItem(); 
                break;
                case "12": exploreRoom(); 
                break;
                case "13": saveGame(); 
                break;
                case "14": loadGame(); 
                break;
                case "15": leaderboard(); 
                break;
                case "0": running = false; 
                break;
                default: println("Try again.");
                break;
            }
        }
        println("Exiting the program");
    }

    private void printMenu() {
        println("Menu");
        println("1  - Login");
        println("2  - Create account");
        println("3  - Logout");
        println("4  - Select room (by name)");
        println("5  - Create room");
        println("6  - Start game");
        println("7  - End game");
        println("8  - Next puzzle");
        println("9  - Answer puzzle");
        println("10 - Get hint");
        println("11 - Select item");
        println("12 - Explore room");
        println("13 - Save game");
        println("14 - Load game");
        println("15 - Leaderboard");
        println("0  - Exit");
    }

    private void login()
    {
        String username = prompt("Username");
        String password = prompt("Password");

        try
        {
            facade.login(username, password);
            println("Login successful");
        } catch (Exception e)
        {
            println("Exception during login: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void createAccount()
    {
        String username = prompt("Choose username");
        String password = prompt("Choose password");

        try
        {
            facade.newAccount(username, password);
            println("Account created successfully");
        } catch (Exception e)
        {
            println("Exception during account creation: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void logout()
    {
        try
        {
            facade.logout();
            println("Logged out successfully");
        } catch (Exception e)
        {
            println("Exception during logout: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void selectRoom()
    {
        String room = prompt("Room name");

        try {
            facade.roomSelect(room);
            println("Room selected successfully");
        } catch (Exception e)
        {
            println("Exception selecting room: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void createRoom()
    {
        try {
            facade.createRoom();
            println("Room created successfully");
        } catch (Exception e)
        {
            println("Exception creating room: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private void startGame()
    {
        try {
            facade.startGame();
            println("Game started successfully");
        } catch (Exception e)
        {
            println("Exception starting game: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private String prompt(String label) {
        System.out.print(label + ": ");
        return scanner.nextLine().trim();
    }

    private void println(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new UI().run();
    }
}
