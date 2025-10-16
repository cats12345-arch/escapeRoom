
import java.util.ArrayList;

public class AccountList {
    private static AccountList accountList;
    private ArrayList<Account> accounts;

    //will implement this when the database stuff is done since it primarly concerns that.
    private AccountList() {

    }

    public static AccountList getInstance() {
        if(accountList == null) {
            accountList = new AccountList();
        }
        return accountList;
    }

    public Account getAccount() {
        return null;
    }

    public void saveAccount() {

    }

    public static void main(String[] args) {
        
    }
}
