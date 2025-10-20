package com.model;

import java.io.FileReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
;

public class DataLoader extends DataConstants{
    
    public static ArrayList<Account> getPlayers() {
        ArrayList<Account> accounts = new ArrayList<Account>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray accountsJSON = (JSONArray)new JSONParser().parse(reader);
            
            for (int i=0; i < accountsJSON.size(); i++) {
                JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
                String username = (String)accountJSON.get(ACCOUNT_USER_NAME);
                String password = (String)accountJSON.get(ACCOUNT_PASSWORD);
                int score = ((Long)accountJSON.get(ACCOUNT_SCORE)).intValue();

                //Achievements
                ArrayList<Achievement> achievements = new ArrayList<Achievement>();
                JSONArray achievementsJSON = (JSONArray)accountJSON.get(ACCOUNT_ACHIEVEMENT);
                for (int j=0; j < achievementsJSON.size(); j++) {
                    JSONObject achievementJSON = (JSONObject)achievementsJSON.get(j);
                    String name = (String)achievementJSON.get(ACHIEVEMENT_NAME);
                    Boolean awarded = (Boolean)achievementJSON.get(ACHIEVEMENT_AWARDED);
                    String description = (String)achievementJSON.get(ACHIEVEMENT_DESCRIPTION);
                    achievements.add(new Achievement(name, awarded, description));
                }

                //Room Progress
                ArrayList<RoomProgress> roomProgress = new ArrayList<RoomProgress>();
                JSONArray roomProgressesJSON = (JSONArray)accountJSON.get(ACCOUNT_ROOM_PROGRESS);
                for (int j=0; j < roomProgressesJSON.size(); j++) {
                    JSONObject roomProgressJSON = (JSONObject)roomProgressesJSON.get(j);

                    //Items
                    ArrayList<Item> items = new ArrayList<Item>();
                    JSONArray itemsJSON = (JSONArray)roomProgressJSON.get(ROOM_PROGRESS_ITEMS);
                    for (int m=0; m < itemsJSON.size(); m++) {
                        JSONObject itemJSON = (JSONObject)itemsJSON.get(m);
                        String itemName = (String)itemJSON.get(ITEM_NAME);
                        String itemDescription = (String)itemJSON.get(ITEM_DESCRIPTION);
                        items.add(new Item(itemName, itemDescription));
                    }

                    //Puzzle Progress
                    ArrayList<PuzzleProgress> puzzleProgress = new ArrayList<PuzzleProgress>();
                    JSONArray puzzleProgressesJSON = (JSONArray)roomProgressJSON.get(ROOM_PUZZLE_PROGRESS);
                    for (int m=0; m<puzzleProgressesJSON.size(); m++) {
                        JSONObject puzzleProgressJSON = (JSONObject)puzzleProgressesJSON.get(m);
                        Boolean completed = (Boolean)puzzleProgressJSON.get(PUZZLE_PROGRESS_COMPLETED);

                        //Time or Duration take your pick
                        JSONObject timeJSON = (JSONObject)puzzleProgressJSON.get(PUZZLE_PROGRESS_TIME);
                        String totalTime = (String)timeJSON.get(TIME);
                        Duration time = Duration.parse(totalTime);

                        int numHintsUsed = ((Long)puzzleProgressJSON.get(PUZZLE_HINTS_USED)).intValue();

                        //puzzle
                        JSONObject puzzleJSON = (JSONObject)puzzleProgressJSON.get(PUZZLE_PROGRESS_PUZZLE);
                        String puzzleType = (String)puzzleJSON.get(PUZZLE_TYPE);
                        String puzzleRiddle = (String)puzzleJSON.get(PUZZLE_RIDDLE);
                        String puzzleAnswer = (String)puzzleJSON.get(PUZZLE_ANSWER);
                        
                        //puzzle hints 
                        ArrayList<String> hints = new ArrayList<String>();
                        JSONArray hintsJSON = (JSONArray)puzzleJSON.get(PUZZLE_HINTS);
                        for (int n=0; n<hintsJSON.size(); n++) {
                            JSONObject hintJSON = (JSONObject)hintsJSON.get(n);
                            String hint = (String)hintJSON.get(HINTS);
                            hints.add(hint);
                        }
                        
                        int puzzleNum = ((Long)puzzleJSON.get(PUZZLE_PUZZLE_NUM)).intValue();

                        Puzzle puzzle = null;
                        if(puzzleType.equalsIgnoreCase("riddle")) {
                            puzzle = new RiddlePuzzle(puzzleRiddle, puzzleAnswer, hints, puzzleNum);
                        } else if (puzzleType.equalsIgnoreCase("cipher")) {

                        } else {
                            puzzle = new RiddlePuzzle(puzzleRiddle, puzzleAnswer, hints, puzzleNum);
                        }

        
                        puzzleProgress.add(new PuzzleProgress(completed, time, numHintsUsed, puzzle));
                    }

                    boolean roomCompleted = (boolean)roomProgressJSON.get(ROOM_PROGRESS_COMPLETED);
                    JSONObject timeJSON = (JSONObject)roomProgressJSON.get(ROOM_PROGRESS_TIME);
                    String totalTime = (String)timeJSON.get(TIME);
                    Duration time = Duration.parse(totalTime);


                    //Room For Room Progress
                    JSONObject roomJSON = (JSONObject)roomProgressJSON.get(ROOM_ROOM);
                    String roomName = (String)roomJSON.get(ROOM_PROGRESS_ROOM_NAME);
                    String roomType = (String)roomJSON.get(ROOM_PROGRESS_ROOM_TYPE);
                    Boolean roomSolved = (Boolean)roomJSON.get(ROOM_PROGRESS_ROOM_SOLVED);

                    //puzzle array list I really need to make this into a method dear god
                    ArrayList<Puzzle> puzzles = new ArrayList<Puzzle>();
                    JSONArray puzzlesJSON = (JSONArray)roomJSON.get(ROOM_PROGERSS_ROOM_PUZZLE);
                    for(int n=0; n<puzzlesJSON.size(); n++) {
                        JSONObject puzzleJSON = (JSONObject)puzzlesJSON.get(n);
                        String puzzleType = (String)puzzleJSON.get(PUZZLE_TYPE);
                        String puzzleRiddle = (String)puzzleJSON.get(PUZZLE_RIDDLE);
                        String puzzleAnswer = (String)puzzleJSON.get(PUZZLE_ANSWER);
                        
                        //puzzle hints 
                        ArrayList<String> hints = new ArrayList<String>();
                        JSONArray hintsJSON = (JSONArray)puzzleJSON.get(PUZZLE_HINTS);
                        for (int k=0; k<hintsJSON.size(); k++) {
                            JSONObject hintJSON = (JSONObject)hintsJSON.get(n);
                            String hint = (String)hintJSON.get(HINTS);
                            hints.add(hint);
                        }
                        
                        int puzzleNum = ((Long)puzzleJSON.get(PUZZLE_PUZZLE_NUM)).intValue();

                        Puzzle puzzle = null;
                        if(puzzleType.equalsIgnoreCase("riddle")) {
                            puzzle = new RiddlePuzzle(puzzleRiddle, puzzleAnswer, hints, puzzleNum);
                        } else if (puzzleType.equalsIgnoreCase("cipher")) {

                        } else {
                            puzzle = new RiddlePuzzle(puzzleRiddle, puzzleAnswer, hints, puzzleNum);
                        }

                        puzzles.add(puzzle);
                    }

                    ArrayList<Item> roomItems = new ArrayList<Item>();
                    JSONArray roomItemsJSON = (JSONArray)roomJSON.get(ROOM_PROGRESS_ROOM_ITEMS);
                    for(int n=0; n<roomItemsJSON.size(); n++) {
                        JSONObject roomItemJSON = (JSONObject)roomItemsJSON.get(n);
                        String itemName = (String)roomItemJSON.get(ITEM_NAME);
                        String itemDescription = (String)roomItemJSON.get(ITEM_DESCRIPTION);

                        roomItems.add(new Item(itemName, itemDescription));
                    }

                    String roomDescription = (String)roomJSON.get(ROOM_DESCRIPTION);
                    String roomOptions = (String)roomJSON.get(ROOM_OPTIONS);

                    Room room = new Room(roomName, roomType, roomCompleted, puzzles, roomItems, roomDescription, roomOptions);
                    roomProgress.add(new RoomProgress(items, puzzleProgress, roomCompleted, time, room));
                }
                accounts.add(new Account(username, password, roomProgress, score, achievements));
            }
            return accounts;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static ArrayList<Room> getRooms() {
        ArrayList<Room> Rooms = new ArrayList<Room>();

            try {
                FileReader reader = new FileReader(ROOM_FILE_NAME);
                JSONArray roomsJSON = (JSONArray)new JSONParser().parse(reader);
                for (int i=0; i<roomsJSON.size(); i++) {
                    JSONObject roomJSON = (JSONObject)roomsJSON.get(i);
                    String roomName = (String)roomJSON.get(ROOM_ROOM_NAME);
                    String type = (String)roomJSON.get(ROOM_ROOM_TYPE);

                    ArrayList<Puzzle> puzzles = new ArrayList<Puzzle>();

                    JSONArray puzzlesJSON = (JSONArray)roomJSON.get(PUZZLE_ARRAY);
                    for (int j=0; j<puzzlesJSON.size(); j++) {
                        JSONObject puzzleJSON = (JSONObject)puzzlesJSON.get(j);
                        String solution = (String)puzzleJSON.get(PUZZLE_SOLUTION);
                        int puzzleNum = ((Long)puzzleJSON.get(PUZZLE_NUM)).intValue();
                        puzzles.add(new Puzzle(solution, puzzleNum));
                    }

                    ArrayList<Item> items = new ArrayList<Item>();

                    JSONArray itemsJSON = (JSONArray)roomJSON.get(ITEM_ARRAY);
                    for (int j=0; j<itemsJSON.size(); j++) {
                        JSONObject itemJSON = (JSONObject)itemsJSON.get(j);
                        String name = (String)itemJSON.get(ITEM_NAME);
                        String description  = (String)itemJSON.get(ITEM_DESCRIPTION);
                        items.add(new Item(name, description));
                    }

                    Rooms.add(new Room(roomName, type, puzzles, items));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        return Rooms;
    }

    public static void main(String[] args){
		ArrayList<Account> users = DataLoader.getPlayers();

		for(Account user : users){
			System.out.println(user);
		}

        ArrayList<Room> rooms = DataLoader.getRooms();

        for(Room room : rooms) {
            System.out.println(room);
        }
	}
}
