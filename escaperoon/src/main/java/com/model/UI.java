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

        printMenu();
        while (running) {
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
                case "16": printMenu();
                break;
                case "0": running = false; 
                break;
                default: println("Try again.");
                break;
            }
        }
        println("Exiting the program");
    }

    /**
     * Ends the Game by saving all player data
     */
    private void endGame() {
        facade.saveGame();
        System.out.println("Saved all the progress and all the accounts progress. Exiting game.");
        System.exit(0);
    }

    /**
     * Loads the next puzzle
     */
    private void puzzleNext() {
        System.out.println("Loading the next puzzle");
        facade.nextPuzzle();
    }

    /**
     * Shows the puzzles answer
     */
    private void puzzleAnswer() {
        System.out.println(facade.puzzleAnswer());
    }

    /**
     * Will show the next avaliable hint
     */
    private void getHint() {
        String hint = facade.getNextHint();
        if(hint == null) {
            System.out.println("Sorry there are no more hints");
        } else {
            System.out.println(hint);
        }
    }

    /**
     * Will ask the user if they want to see all items or just a certain item and then will do as the user asks
     */
    private void selectItem() {
        System.out.println("1. To see all items \n2. To see a certain item.");
        int num = scanner.nextInt();
        System.out.print("");
        if(num == 1) {
            facade.getAllItemsDescription();
        } else if (num == 2) {
            facade.getAllItemNames();
            System.out.println("Which Item would you like to see the details for?");
            num = scanner.nextInt();
            String item = facade.getItemInfo(num);
            if(item == null) {
                System.out.println("Sorry that Item does not exist");
            } else {
                System.out.println(item);
            }
        }
        
    }

    private void exploreRoom() {
        facade.exploreRoom();
    }

    private void saveGame() {
        System.out.println("Saving game");
        facade.saveGame();
        System.out.println("Completed");
    }

    private void loadGame () {
        System.out.println("Loading game");
        facade.loadGame();
        System.out.println("Completed");
    }

    private void leaderboard () {
        facade.addToLeaderbaord();
        facade.displayLeaderBoard();
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
        println("16 - Show options");
        println("0  - Exit");
    }

    private void login()
    {
        String username = prompt("Username");
        String password = prompt("Password");

        try
        {
            Account acc = facade.login(username, password);
            if(acc == null) {
                System.out.println("Login Failed due to different username and password");
            } else {
                println("Login successful");
            }
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
            Account acc = facade.newAccount(username, password);
            if(acc == null) {
                System.out.println("An account with this username already exits!");
            } else {
                println("Account created successfully");
            }
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
            Boolean bool = facade.startGame();
            if(bool) {
                println("Game started successfully");
                println("1. Interact with Objects. \n2. Do the puzzles");
                int input = scanner.nextInt();
                System.out.println("");
                Boolean which = facade.selectPuzzleOrObject(input);
                if(which) {
                    System.out.println("Which object would you like to interact with?");
                    input = scanner.nextInt();
                    
                }
            } else {
                println("Game did not start successfully");
            }
            
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

    private void roomMenu() {

    }

    public static void main(String[] args) {
        new UI().run();
    }
}
