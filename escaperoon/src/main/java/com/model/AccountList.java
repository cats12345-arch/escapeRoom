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

    public void newAccount(String username, String password) {
        Account newAccount = new Account(username, password);
        accounts.add(newAccount);
    }

    public ArrayList<Account> getAccount() {
        return accounts;
    }

    public void deleteAccount(String username, String password) {
        for(int i=0; i<accounts.size(); i++) {
            if(accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)){
                accounts.remove(i);
            }
        }
    }

    public void saveAccount() {
        DataWriter.savePlayers();
    }

    
    public String toString() {
        return accounts.toString();
    }

    public static void main(String[] args) {
        AccountList accounts = AccountList.getInstance();
        //Account testAccount = accounts.login("dmoss", "1234abc");
        accounts.newAccount("Weakend Friends", "Weightless");
        Account testAccount2 = accounts.login("Weakend Friends", "Weightless");
        System.out.println(testAccount2);
        //accounts.deleteAccount("dmoss", "1234abc");
        //System.out.println(accounts);
    }
}
