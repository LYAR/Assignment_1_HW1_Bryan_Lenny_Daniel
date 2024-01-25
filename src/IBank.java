import java.util.List;

public interface IBank {
    void openAccount(IAccount account);
    void closeAccount(int accountNumber);
    List<IAccount> getAllAccounts();
    List<IAccount> getAllAccountsInDebt();
    List<IAccount> getAllAccountsWithBalance(double minBalance);
}

