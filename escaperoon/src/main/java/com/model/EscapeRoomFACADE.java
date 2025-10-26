package com.model;


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

    accountList.newAccount(username, password);
    
    for(Account acc : accountList.getAccount())
    {
        if(acc.getUsername().equals(username) && acc.getPassword().equals(password))
        {
            this.account = acc;
            DataWriter.savePlayers();
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
    leaderboard.displayTop();
    }
}


public void saveGame() {
    accountList.saveAccounts();
    roomList.saveRoom();
}

public void loadGame()
{
    DataLoader.getPlayers();
}

public void endGame()
{
    gameEngine.endGame(false);
    timer.stop();
}

public void startGame()
{
    gameEngine.startGame();
    timer.start();
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

public void roomSelect(String roomName)
{
    roomList.getRoom(roomName);
}

public void exploreRoom()
{
    room.exploreRoom();
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
    roomList.newRoom();
}
}
