package com.model;

import java.io.FileReader;
import java.util.ArrayList;

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
                //int score = ((Long)accountJSON.get(PLAYER_SCORE)).intValue();
                //String name = (String)accountJSON.get(ACHIEVEMENT_NAME);
                //String description = (String)accountJSON.get(ACHIEVEMENT_DESCRIPTION);
                //boolean awarded = ((boolean)accountJSON.get(ACHIEVEMENT_AWARDED));
                //ArrayList<Achievement> achievements = new ArrayList<Achievement>();
                //achievements.add(new Achievement(name, awarded, description));


                accounts.add(new Account(username, password));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static void main(String[] args){
		ArrayList<Account> users = DataLoader.getPlayers();

		for(Account user : users){
			System.out.println(user);
		}
	}
}
