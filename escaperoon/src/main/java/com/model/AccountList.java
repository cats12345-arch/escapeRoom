package com.model;

import java.util.ArrayList;

public class AccountList {
    private static AccountList accountList;
    private ArrayList<Account> accounts;

    //will implement this when the database stuff is done since it primarly concerns that.
    private AccountList() {
        accounts = DataLoader.getPlayers();
    }

    public static AccountList getInstance() {
        if(accountList == null) {
            accountList = new AccountList();
        }
        return accountList;
    }

    public Account login(String username, String password) {
        for(int i=0; i<accounts.size(); i++) {
            if(accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)){
                return accounts.get(i);
            }
        }
        return null;
    }

    public ArrayList<Account> getAccount() {
        return accounts;
    }

    public void saveAccount() {

    }

    public static void main(String[] args) {
        
    }
}
