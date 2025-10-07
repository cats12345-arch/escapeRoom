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

    

    public static void main(String[] args){
		ArrayList<Player> users = DataLoader.getPlayers();

		for(Account user : users){
			System.out.println(user);
		}
	}
}
