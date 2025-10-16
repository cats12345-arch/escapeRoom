package com.model;

import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{

    public static void savePlayers() {
        AccountList accounts = AccountList.getInstance();
        ArrayList<Account> accountList = accounts.getAccount();

        JSONArray jsonAccounts = new JSONArray();

        //making all the json objects
        for(int i=0; i<accountList.size(); i++) {
            jsonAccounts.add(getUserJSON(accountList.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_TEMP_FILE_NAME)){
            file.write(jsonAccounts.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(Account account) {
        JSONObject accountdetails = new JSONObject();
        accountdetails.put(ACCOUNT_USER_NAME, account.getUsername());
        accountdetails.put(ACCOUNT_PASSWORD, account.getPassword());
        accountdetails.put(ACCOUNT_SCORE, account.getScore());

        ArrayList<Achievement> achievementsList = account.getAchievements();
        JSONArray jsonachievement = new JSONArray();

        for(int i=0; i<achievementsList.size(); i++) {
            jsonachievement.add(getAchievementJSON(achievementsList.get(i)));
        }
        accountdetails.put(ACCOUNT_ACHIEVEMENT, jsonachievement);

        ArrayList<RoomProgress> roomProgressList = account.getRoomProgresses();
        JSONArray jsonroomProgress = new JSONArray();
        for(int i=0; i<roomProgressList.size(); i++) {
            jsonroomProgress.add(getRoomProgess(roomProgressList.get(i)));
        }
        accountdetails.put(ACCOUNT_ROOM_PROGRESS, jsonroomProgress);
        return accountdetails;
    }

    private static JSONObject getRoomProgess(RoomProgress roomProgress) {
        JSONObject roomProgressDetails = new JSONObject();
        
        ArrayList<Item> itemList = roomProgress.getItems();
        JSONArray jsonitemList = new JSONArray();
        for(int i=0; i<itemList.size(); i++) {
            jsonitemList.add(getItems(itemList.get(i)));
        }
        roomProgressDetails.put(ROOM_PROGRESS_ITEMS, jsonitemList);

        ArrayList<PuzzleProgress> puzzleProgressList = roomProgress.getPuzzles();
        JSONArray jsonpuzzleProgressList = new JSONArray();
        for(int i=0; i<puzzleProgressList.size(); i++) {
            jsonpuzzleProgressList.add(getPuzzleProgress(puzzleProgressList.get(i)));
        }
        roomProgressDetails.put(ROOM_PUZZLE_PROGRESS, jsonpuzzleProgressList);
        
        roomProgressDetails.put(ROOM_PROGRESS_COMPLETED, roomProgress.getIsComplete());
        JSONObject roomTimeDetails = new JSONObject();
        roomTimeDetails.put(TIME, roomProgress.getTimeString());
        roomProgressDetails.put(ROOM_PROGRESS_TIME, roomTimeDetails);
        return roomProgressDetails;
    }

    private static JSONObject getPuzzleProgress(PuzzleProgress puzzleProgress) {
        JSONObject puzzleProgressDetails = new JSONObject();
        puzzleProgressDetails.put(PUZZLE_PROGRESS_COMPLETED, puzzleProgress.getIsComplete());
        JSONObject puzzleTimeDetails = new JSONObject();
        puzzleTimeDetails.put(TIME, puzzleProgress.getTimeString());
        puzzleProgressDetails.put(PUZZLE_PROGRESS_TIME, puzzleTimeDetails);
        puzzleProgressDetails.put(PUZZLE_HINTS_USED, puzzleProgress.getnumHintsUsed());
        return puzzleProgressDetails;
    }

    private static JSONObject getItems(Item item) {
        JSONObject itemDetails = new JSONObject();
        itemDetails.put(ITEM_NAME, item.getName());
        itemDetails.put(ITEM_DESCRIPTION, item.getDescription());
        return itemDetails;
    }

    private static JSONObject getAchievementJSON(Achievement achievement) {
        JSONObject achievementDetails = new JSONObject();
        achievementDetails.put(ACHIEVEMENT_NAME, achievement.getName());
        achievementDetails.put(ACHIEVEMENT_AWARDED, achievement.getAwarded());
        achievementDetails.put(ACHIEVEMENT_DESCRIPTION, achievement.getDescription());

        return achievementDetails;
    }
    
    public static void main(String[] args) {
        DataWriter.savePlayers();
    }
}
