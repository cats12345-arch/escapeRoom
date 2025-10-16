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
        for(int i=0; i<jsonAccounts.size(); i++) {
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
        return accountdetails;
    }
    
    public static void main(String[] args) {
        //still need to do testing
    }
}
