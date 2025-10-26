package com.model;

/**
 * A account list that will call the dataloader to load all player data
 * @author daniel
 */
import java.util.ArrayList;

public class AccountList {
    private static AccountList accountList;
    private ArrayList<Account> accounts;

    /**
     * Loads all of the accounts to the account list using the data loader
     */
    private AccountList() {
        accounts = DataLoader.getPlayers();
    }

    /**
     * Creates an instance of the accountlist if there are none
     * @return returns an instance of the accountList
     */
    public static AccountList getInstance() {
        if(accountList == null) {
            accountList = new AccountList();
        }
        return accountList;
    }

    /**
     * Calls the DataWriter and saves all the different accounts
     */
    public void saveAccounts() {
        DataWriter.savePlayers();
    }

    /**
     * A method that will return a user account if the username and password match, will return null if not
     * @param username The username enter for attempted login
     * @param password The password entered for attempted login
     * @return returns an account or null
     */
    public Account login(String username, String password) {
        for(int i=0; i<accounts.size(); i++) {
            if(accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)){
                return accounts.get(i);
            }
        }
        return null;
    }

    /**
     * Allows the creation of a new account
     * @param username the username of the new account
     * @param password the password of the new account
     */
    public void newAccount(String username, String password) {
        Account newAccount = new Account(username, password);
        accounts.add(newAccount);
    }

    /**
     * Used by the datawriter to make the JSON file
     * @return an ArrayList of accounts
     */
    public ArrayList<Account> getAccount() {
        return accounts;
    }

    /**
     * Removes the account that has the related username and password
     * @param username the username of the account
     * @param password the password of the account
     */
    public void deleteAccount(String username, String password) {
        for(int i=0; i<accounts.size(); i++) {
            if(accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)){
                accounts.remove(i);
            }
        }
    }

    /**
     * Calls the dataWriter to save all the player information
     */
    public void saveAccount() {
        DataWriter.savePlayers();
    }

    /**
     * calls the account to string method
     */
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
