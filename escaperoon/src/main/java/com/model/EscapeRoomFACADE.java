package com.model;

import java.util.ArrayList;

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

public EscapeRoomFACADE()
{
    this.accountList = AccountList.getInstance();
    this.roomList = RoomList.getInstance();
    this.gameEngine = GameEngine.getInstance();
    this.leaderboard = Leaderboard.getInstance();
    this.puzzleNum = 0;
    this.hintNum = 0;
}

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
public void logout()
{
    this.account = null;
}

public void getLeaderboard()
{
    if(leaderboard != null)
    {
    leaderboard.displayTop(accountList.getAccount());
    }
}


public void saveGame() {
    accountList.saveAccounts();
    roomList.saveRoom();
}

public void loadGame()
{
    DataLoader.getPlayers();
    DataLoader.getRooms();
}

public void endGame()
{
    gameEngine.endGame(false);
    timer.stop();
}

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

public void showDifferentPuzzles() {
    room.getPuzzleDetails();
}

public void getPuzzle(int num) {
    num--;
    this.puzzle = room.getNextPuzzle(num);
    puzzleProgress.setPuzzle(this.puzzle);
}

public void displayDifferentTypes() {
    if(puzzle.getPuzzleType().equalsIgnoreCase("riddle")) {
        System.out.println("1. Would you like a hint? \n2. Would you like to try to solve the puzzle? \n3. Would you like to see the riddle?");
    } else if(puzzle.getPuzzleType().equalsIgnoreCase("cipher")) {
        System.out.println("1. Would you like a hint? \n2. Would you like to try to solve the puzzle? \n3. Would you like to see the Anagram?");
    } else if (puzzle.getPuzzleType().equalsIgnoreCase("item")) {
        System.out.println("1. Would you like a hint? \n2. Would you like to try to solve the puzzle? \n3. Would you like to see the Anagram?");
    }
}

public void seeHint() {
    System.out.println(puzzle.getHint());
    puzzleProgress.addNumHintsUsed();
}

public void displayPuzzle() {
    if(puzzle.getPuzzleType().equalsIgnoreCase("riddle")) {
        RiddlePuzzle temp =  (RiddlePuzzle) puzzle;
        System.out.println(temp.getRiddle());
    } else if(puzzle.getPuzzleType().equalsIgnoreCase("anagram")) {
        CipherPuzzle temp = (CipherPuzzle) puzzle;
        System.out.println(temp.getAnagram());
    } else if (puzzle.getPuzzleType().equalsIgnoreCase("item")) {
        System.out.println("1. Would you like a hint? \n2. Would you like to try to solve the puzzle? \n3. Would you like to see the Anagram?");
    }
}

public void addPuzzleProgressToAccount() {
    this.roomProgress.addPuzzleProgress(puzzleProgress);
    this.puzzleProgress = null;
}

public void createPuzzleProgress() {
    this.puzzleProgress = new PuzzleProgress();
}

public void addItems(Item item) {
    this.roomProgress.addItem(item);
}

public void solve(String input) {
    Boolean solved = puzzle.solve(input);
    if(solved) {
        System.out.println("The puzzle has been solved!");
        account.addToScore(20);
        puzzleProgress.setCompletion(true);
    } else {
        System.out.println("That was incorrect!");
        account.addToScore(-5);
        puzzleProgress.setCompletion(false);
    }
}

public Boolean selectPuzzleOrObject(int num) {
    return room.showWhich(num);
}

public String getObjectNames() {
    return room.getObjectnames();
}

public Boolean getObject(int num) {
    num--;
    Object temp = room.getObject(num);
    if(temp == null) {
        return false;
    }
    this.object = temp;
    return true;
}

public void getObjectDescription() {
    System.out.println(object.getDescription());
}

public void interactWithObject() {
    Item item = object.interact();
    addItems(item);
    room.addToInventory(item);
}

public void nextPuzzle() {
    gameEngine.loadNextPuzzle(puzzleNum);
    puzzleNum++;
}

public String puzzleAnswer() {
    return puzzle.getSolution();
}

public void puzzleSelect(int num)
{
    gameEngine.loadNextPuzzle(num);
}

public String getNextHint() {
    String temp = puzzle.getHint(hintNum);
    if(temp == null) {
        return null;
    }
    hintNum++;
    return temp;
}

public String getAllItemsDescription() {
    return room.getItemsDetails();
}

public String getAllItemNames() {
    return room.getItemsNames();
}

public String getItemInfo(int num) {
    if(num > room.getInventorySize()) {
        return null;
    }
    return room.getItemInfo(num);
}

public void roomSelect(String roomName)
{
    roomList.getRoom(roomName);
}

public String exploreRoom()
{
    return room.getRoomInfo();
}

public void addToLeaderbaord() {
    ArrayList<Account> accounts = accountList.getAccount();
    for (int i=0; i < accounts.size(); i++) {
        leaderboard.addScore(accounts.get(i));
    }
}

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
