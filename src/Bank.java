import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void openAccount(IAccount account) {
        accounts.add(account);
    }

    public void closeAccount(int accountNumber) {
        IAccount account = accounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);

        if (account != null) {
            if (account.getCurrentBalance() >= 0) {
                // Close the account based on its type
                if (account instanceof BasicAccount) {
                    ((BasicAccount) account).close(); // Close the BasicAccount
                }
                // Add similar checks and closing logic for other account types if needed
                // e.g. if (account instanceof StandardAccount) { ((StandardAccount) account).close(); }

                accounts.remove(account); // Remove the account from the bank's list
                System.out.println("Account " + accountNumber + " closed successfully.");
            } else {
                System.out.println("Account " + accountNumber + " cannot be closed because it has debt.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public List<IAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    public List<IAccount> getAllAccountsInDebt() {
        return accounts.stream()
                .filter(a -> a.getCurrentBalance() < 0)
                .collect(Collectors.toList());
    }

    public List<IAccount> getAllAccountsWithBalance(double minBalance) {
        return accounts.stream()
                .filter(a -> a.getCurrentBalance() > minBalance)
                .collect(Collectors.toList());
    }
}
