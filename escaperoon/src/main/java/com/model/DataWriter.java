package com.model;

/**
 * Writes all data from the rooms and accounts into a JSON file
 * @author daniel
 */

import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{

    /**
     * Saves all the data from Rooms into a JSONFile
     */
    public static void saveRooms() {
        RoomList rooms = RoomList.getInstance();
        ArrayList<Room> roomList = rooms.getRoomList();

        JSONArray jsonRooms = new JSONArray();
        for(int i=0; i<roomList.size();i++) {
            jsonRooms.add(getRoom(roomList.get(i)));
        }

        try (FileWriter file = new FileWriter(ROOM_TEMP_FILE_NAME)) {
            file.write(jsonRooms.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves all the data from Accounts into a JSON file
     */
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

    /**
     * Takes an account object and turns it into a JSONObject
     * @param account An account with its data
     * @return Returns a JSONObject with all the data of an account
     */
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

    /**
     * Turns an object of Room Progress into a JSONObject
     * @param roomProgress Room Progress and its data
     * @return Returns a JSONObject with all the data of Room Progress
     */
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

        Room roomDetails = roomProgress.getRoom();
        JSONObject jsonRoom = getRoom(roomDetails);
        roomProgressDetails.put(ROOM_ROOM, jsonRoom);
        return roomProgressDetails;
    }

    /**
     * Takes a Room Object and turns it into a JSONObject
     * @param roomDetails Room and its details
     * @return returns a JSONOject with all the info from Room
     */
    public static JSONObject getRoom(Room roomDetails) {
        JSONObject jsonRoom = new JSONObject();
        jsonRoom.put(ROOM_PROGRESS_ROOM_NAME, roomDetails.getRoomName());
        jsonRoom.put(ROOM_PROGRESS_ROOM_TYPE, roomDetails.getRoomType());
        jsonRoom.put(ROOM_PROGRESS_ROOM_SOLVED, roomDetails.getSolved());
        
        ArrayList<Puzzle> puzzleList = roomDetails.getPuzzles();
        JSONArray jsonPuzzleList = new JSONArray();
        for(int i=0; i<puzzleList.size(); i++) {
            jsonPuzzleList.add(getPuzzle(puzzleList.get(i)));
        }
        jsonRoom.put(PUZZLE_ARRAY, jsonPuzzleList);

        ArrayList<Item> roomItemList = roomDetails.getItems();
        JSONArray jsonRoomItemList = new JSONArray();
        for(int i=0; i<roomItemList.size(); i++) {
            jsonRoomItemList.add(getItems(roomItemList.get(i)));
        }
        jsonRoom.put(ITEM_ARRAY, jsonRoomItemList);

        ArrayList<Object> objectList = roomDetails.getObjects();
        JSONArray jsonRoomObjectList = new JSONArray();
        for(int i=0; i<objectList.size(); i++) {
            jsonRoomObjectList.add(getObject(objectList.get(i)));
        }
        jsonRoom.put(ROOM_OBJECTS, jsonRoomObjectList);
        return jsonRoom;
    }

    /**
     * Takes an Object object and turns it into a JSONObject
     * @param object Object and all its details
     * @return A JSON object with all the info from Object
     */
    private static JSONObject getObject(Object object) {
        JSONObject objectDetails = new JSONObject();
        objectDetails.put(OBJECT_DESCRIPTION, object.getDescription());
        objectDetails.put(OBJECT_NAME, object.getName());
        JSONObject objectItem = getItems(object.getContains());
        objectDetails.put(OBJECT_CONTAINS, objectItem);
        return objectDetails;
    }

    /**
     * Takes a Puzzle object and turns it into a JSONObject
     * @param puzzle Puzzle and all its details
     * @return A JSONObject with all the info from Puzzle
     */
    private static JSONObject getPuzzle(Puzzle puzzle) {
        JSONObject puzzleDetails = new JSONObject();
        puzzleDetails.put(PUZZLE_ANSWER, puzzle.getSolution());
        puzzleDetails.put(PUZZLE_PUZZLE_NUM, puzzle.getPuzzleNum());
        JSONArray puzzleHintDetails = new JSONArray();
        ArrayList<String> hints = puzzle.getHints();
        for(int i=0; i<hints.size(); i++) {
            JSONObject hint = new JSONObject();
            hint.put(HINTS, hints.get(i));
            puzzleHintDetails.add(hint);
        }
        puzzleDetails.put(PUZZLE_HINTS, puzzleHintDetails);

        puzzleDetails.put(PUZZLE_TYPE, puzzle.getPuzzleType());
        if(puzzle.getPuzzleType().equalsIgnoreCase("cipher")) {
            puzzleDetails.put(CIPHER_ANAGRAM, ((CipherPuzzle) puzzle).getCeaserCipher());
            puzzleDetails.put(CIPHER_CEASER, ((CipherPuzzle) puzzle).getCeaserCipher());
        } else if(puzzle.getPuzzleType().equalsIgnoreCase("riddle")) {
            puzzleDetails.put(PUZZLE_RIDDLE, ((RiddlePuzzle) puzzle).getRiddle());
        } else if(puzzle.getPuzzleType().equalsIgnoreCase("item")) {

        }
        return puzzleDetails;
    }

    /**
     * Takes a PuzzleProgress object and turns it into a JSONObject
     * @param puzzleProgress PuzzleProgress and all its details
     * @return A JSONObject with all the info from PuzzleProgress
     */
    private static JSONObject getPuzzleProgress(PuzzleProgress puzzleProgress) {
        JSONObject puzzleProgressDetails = new JSONObject();
        puzzleProgressDetails.put(PUZZLE_PROGRESS_COMPLETED, puzzleProgress.getIsComplete());
        JSONObject puzzleTimeDetails = new JSONObject();
        puzzleTimeDetails.put(TIME, puzzleProgress.getTimeString());
        puzzleProgressDetails.put(PUZZLE_PROGRESS_TIME, puzzleTimeDetails);
        puzzleProgressDetails.put(PUZZLE_HINTS_USED, puzzleProgress.getnumHintsUsed());
        
        JSONObject jsonPuzzle = getPuzzle(puzzleProgress.getPuzzle());
        puzzleProgressDetails.put(PUZZLE_PROGRESS_PUZZLE, jsonPuzzle);
        return puzzleProgressDetails;
    }

    /**
     * Takes an Item object and turns it into a JSONObject
     * @param item Item and all its details
     * @return A JSONObject with all the info from Item
     */
    private static JSONObject getItems(Item item) {
        JSONObject itemDetails = new JSONObject();
        itemDetails.put(ITEM_NAME, item.getName());
        itemDetails.put(ITEM_DESCRIPTION, item.getDescription());
        return itemDetails;
    }

    /**
     * Takes an Achievement object and turns it into a JSONObject
     * @param achievement Achivement and all its details 
     * @return A JSONObject with all the details from Achievement
     */
    private static JSONObject getAchievementJSON(Achievement achievement) {
        JSONObject achievementDetails = new JSONObject();
        achievementDetails.put(ACHIEVEMENT_NAME, achievement.getName());
        achievementDetails.put(ACHIEVEMENT_AWARDED, achievement.getAwarded());
        achievementDetails.put(ACHIEVEMENT_DESCRIPTION, achievement.getDescription());

        return achievementDetails;
    }
    
    public static void main(String[] args) {
        DataWriter.savePlayers();
        DataWriter.saveRooms();
    }
}
