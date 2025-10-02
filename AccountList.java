
import java.util.ArrayList;

public class AccountList {
    private static AccountList accountList;
    private ArrayList<Account> accounts;

    private AccountList() {

    }

    public static AccountList getInstance() {
        return accountList;
    }

    public Account getAccount() {
        return accounts;
    }

    public void saveAccount() {

    }
}
