package com.model;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
;

public class DataLoader extends DataConstants{
    
    public static ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray accountsJSON = (JSONArray)new JSONParser().parse(reader);
            
            for (int i=0; i < accountsJSON.size(); i++) {
                JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
                String username = (String)accountJSON.get(ACCOUNT_USER_NAME);
                String password = (String)accountJSON.get(ACCOUNT_PASSWORD);
                
                JSONArray playersJSON = (JSONArray)accountJSON.get(PLAYER_ARRAY);
                for (int j=0; j < playersJSON.size(); j++) {
                    JSONObject playerJSON = (JSONObject)playersJSON.get(j);
                    int score = ((Long)playerJSON.get(PLAYER_SCORE)).intValue();

                    ArrayList<Achievement> achievements = new ArrayList<Achievement>();

                    JSONArray achievementsJSON = (JSONArray)playerJSON.get(ACHIEVEMENT_AWARDS);
                    for (int m=0; m<achievementsJSON.size(); m++) {
                        JSONObject achievementJSON = (JSONObject)achievementsJSON.get(m);
                        String name = (String)achievementJSON.get(ACHIEVEMENT_NAME);
                        Boolean awarded = (Boolean)achievementJSON.get(ACHIEVEMENT_AWARDED);
                        String description = (String)achievementJSON.get(ACHIEVEMENT_DESCRIPTION);
                        achievements.add(new Achievement(name, awarded, description));
                    }
                    players.add(new Player(username, password, score, achievements));
                }
            }
            return players;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
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
		ArrayList<Player> users = DataLoader.getPlayers();

		for(Account user : users){
			System.out.println(user);
		}

        ArrayList<Room> rooms = DataLoader.getRooms();

        for(Room room : rooms) {
            System.out.println(room);
        }
	}
}
