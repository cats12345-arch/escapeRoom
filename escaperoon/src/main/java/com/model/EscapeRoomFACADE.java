package com.model;

import java.util.ArrayList;

import com.speech.Speek;

public class EscapeRoomFACADE {

private Account account; 
private Room room; 

private final AccountList accountList;
private final RoomList roomList;
private final GameEngine gameEngine;
private final Leaderboard leaderboard;
private final Timer timer = new Timer(1800);
private int puzzleNum;
private Puzzle puzzle;
private int hintNum;
private int roomNum;
private Object object;
private PuzzleProgress puzzleProgress;
private RoomProgress roomProgress;

/**
 * Constructs a new EscapeRoomFACADE instance
 * Initalizes all singleton references
 */
public EscapeRoomFACADE()
{
    this.accountList = AccountList.getInstance();
    this.roomList = RoomList.getInstance();
    this.gameEngine = GameEngine.getInstance();
    this.leaderboard = Leaderboard.getInstance();
    this.puzzleNum = 0;
    this.hintNum = 0;
}

/*
 * Logs the user in with the given username and password
 * Returns the Account if successful, null otherwise
 */
public Account login(String username, String password)
{
    if(accountList == null || password == null)
    {
        return null;
    }

    Account acc = accountList.login(username, password);

    if(acc != null)
    {
        this.account = acc;
    }
    return acc;
}

/*
 * Creates a new account with the given username and password 
 * Saves all accounts 
 */
public Account newAccount(String username, String password)
{
    if(accountList == null || password == null)
    {
        return null;
    }

    Boolean works = accountList.newAccount(username, password);
    if (!works) {
        return null;
    }
    
    for(Account acc : accountList.getAccount())
    {
        if(acc.getUsername().equals(username) && acc.getPassword().equals(password))
        {
            this.account = acc;
            accountList.saveAccounts();
            return acc;
        }
    }
    return null;
}

/*
 * Logs out the user
 */
public void logout()
{
    this.account = null;
}

/*
 * Displays the leaderboard 
 */
public void getLeaderboard()
{
    if(leaderboard != null)
    {
    leaderboard.displayTop(accountList.getAccount());
    }
}

/*
 * Saves the game data
 * Saves the accounts and rooms 
 */
public void saveGame() {
    accountList.saveAccounts();
    roomList.saveRoom();
}

/*
 * Loads the game data 
 */
public void loadGame()
{
    DataLoader.getPlayers();
    DataLoader.getRooms();
}

/*
 * Ends the current game 
 */
public void endGame()
{
    gameEngine.endGame(false);
    timer.stop();
}

/*
 * Starts a new game session 
 */
public Boolean startGame()
{
    this.room = roomList.getRoom(roomNum);
    if(room == null) {
        return false;
    }
    roomProgress = new RoomProgress();
    roomProgress.setRoomProgress(room);
    roomNum++;
    timer.start();
    return true;
}

/*
 * Displays all the puzzles in the current room 
 */
public void showDifferentPuzzles() {
    room.getPuzzleDetails();
}

/*
 * Loads the puzzle 
 */
public void getPuzzle(int num) {
    num--;
    this.puzzle = room.getNextPuzzle(num);
    puzzleProgress.setPuzzle(this.puzzle);
}
    private void println(String s) {
        Speek.speak(s);
        System.out.println(s);
    }

/*
 * Displays the different puzzle types 
 */
public void displayDifferentTypes() {
    if(puzzle.getPuzzleType().equalsIgnoreCase("riddle")) {
        println("1. Would you like a hint? \n2. Would you like to try to solve the puzzle? \n3. Would you like to see the riddle?");
    } else if(puzzle.getPuzzleType().equalsIgnoreCase("cipher")) {
        println("1. Would you like a hint? \n2. Would you like to try to solve the puzzle? \n3. Would you like to see the Anagram?");
    } else if (puzzle.getPuzzleType().equalsIgnoreCase("item")) {
        println("1. Would you like a hint? \n2. Would you like to try to solve the puzzle? \n3. Would you like to see the Anagram?");
    }
}

/*
 * Displays the hint for the puzzle 
 */
public void seeHint() {
    println(puzzle.getHint());
    puzzleProgress.addNumHintsUsed();
}

/*
 * Displays the puzzle 
 */
public void displayPuzzle() {
    if(puzzle.getPuzzleType().equalsIgnoreCase("riddle")) {
        RiddlePuzzle temp =  (RiddlePuzzle) puzzle;
        println(temp.getRiddle());
    } else if(puzzle.getPuzzleType().equalsIgnoreCase("anagram")) {
        CipherPuzzle temp = (CipherPuzzle) puzzle;
        println(temp.getAnagram());
    } else if (puzzle.getPuzzleType().equalsIgnoreCase("item")) {
        println("1. Would you like a hint? \n2. Would you like to try to solve the puzzle? \n3. Would you like to see the Anagram?");
    }
}

/**
 * Adds puzzleProgress to the roomprogress in puzzle progress
 */
public void addPuzzleProgressToAccount() {
    this.roomProgress.addPuzzleProgress(puzzleProgress);
    this.puzzleProgress = null;
}

/**
 * Makes a new puzzleProgress
 */
public void createPuzzleProgress() {
    this.puzzleProgress = new PuzzleProgress();
}

/**
 * Adds an item to the roomprogress
 * @param item an item
 */
public void addItems(Item item) {
    this.roomProgress.addItem(item);
}

/*
 * Attempts to solve the puzzle with the given input 
 */
public void solve(String input) {
    Boolean solved = puzzle.solve(input);
    if(solved) {
        println("The puzzle has been solved!");
        account.addToScore(20);
        puzzleProgress.setCompletion(true);
    } else {
        println("That was incorrect!");
        account.addToScore(-5);
        puzzleProgress.setCompletion(false);
    }
}

/*
 * Selects a puzzle or an object in the room 
 */
public Boolean selectPuzzleOrObject(int num) {
    return room.showWhich(num);
}

/*
 * Returns the names of all objects in the room 
 */
public String getObjectNames() {
    return room.getObjectnames();
}

/*
 * Retrieves an object and sets it as the current object
 */
public Boolean getObject(int num) {
    num--;
    Object temp = room.getObject(num);
    if(temp == null) {
        return false;
    }
    this.object = temp;
    return true;
}

/*
 * Displays the description of the current object
 */
public void getObjectDescription() {
    println(object.getDescription());
}

/*
 * Interacts with the selected object 
 */
public void interactWithObject() {
    Item item = object.interact();
    addItems(item);
    room.addToInventory(item);
}

/*
 * Loads the next puzzle 
 */
public void nextPuzzle() {
    gameEngine.loadNextPuzzle(puzzleNum);
    puzzleNum++;
}

/*
 * Returns the solution to the puzzle 
 */
public String puzzleAnswer() {
    return puzzle.getSolution();
}

/*
 * Selects a puzzle by its number and loads it 
 */
public void puzzleSelect(int num)
{
    gameEngine.loadNextPuzzle(num);
}

/*
 * Returns the next hint for the current puzzle 
 */
public String getNextHint() {
    String temp = puzzle.getHint(hintNum);
    if(temp == null) {
        return null;
    }
    hintNum++;
    return temp;
}

/*
 * Returns the descriptions of all the iterms in the room 
 */
public String getAllItemsDescription() {
    return room.getItemsDetails();
}

/*
 * Returns the names of all items in the room 
 */
public String getAllItemNames() {
    return room.getItemsNames();
}

/*
 * Retrieves information for a specific item in the room's inventory 
 */
public String getItemInfo(int num) {
    if(num > room.getInventorySize()) {
        return null;
    }
    return room.getItemInfo(num);
}

/*
 * Selects a room 
 */
public void roomSelect(String roomName)
{
    roomList.getRoom(roomName);
}

/*
 * Returns information about the room 
 */
public String exploreRoom()
{
    return room.getRoomInfo();
}

/*
 * Adds accounts to the leadeboard 
 */
public void addToLeaderbaord() {
    ArrayList<Account> accounts = accountList.getAccount();
    for (int i=0; i < accounts.size(); i++) {
        leaderboard.addScore(accounts.get(i));
    }
}

/*
 * Displays the leaderboard using the account list 
 */
public void displayLeaderBoard() {
    leaderboard.displayTop(accountList.getAccount());
}


public void puzzleAnswer(String answer)
{
    
}

public void getHint()
{
    
}

public void selectItem(String itemName)
{
    
}

public void createRoom()
{
    roomList.getRoom(null);
}
}
