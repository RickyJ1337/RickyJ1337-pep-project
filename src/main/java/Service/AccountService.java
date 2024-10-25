package Service;

import DAO.AccountDAO;
import Model.Account;
public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
    // Register a user
    public Account registerAccount(Account account) {
        return accountDAO.registerAccount(account.getUsername(), account.getPassword());
    }
    // Login a user
    public Account loginAccount(Account account) {
        return accountDAO.loginUser(account.getUsername(), account.getPassword());
    }
}
