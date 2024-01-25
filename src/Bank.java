import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void openAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void closeAccount(int accountNumber) {
        IAccount account = accounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);

        if (account != null) {
            if (account.getCurrentBalance() >= 0) {
                accounts.remove(account);
                System.out.println("Account " + accountNumber + " closed successfully.");
            } else {
                System.out.println("Account " + accountNumber + " cannot be closed because it has debt.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public List<IAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> getAllAccountsInDebt() {
        return accounts.stream()
                .filter(a -> a.getCurrentBalance() < 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<IAccount> getAllAccountsWithBalance(double minBalance) {
        return accounts.stream()
                .filter(a -> a.getCurrentBalance() > minBalance)
                .collect(Collectors.toList());
    }
}
