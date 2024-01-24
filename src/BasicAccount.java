public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit;
    private boolean isClosed = false; // Add the isClosed flag

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = withdrawalLimit;
        this.balance = 0;
    }

    // Add a method to close the account
    public void close() {
        this.isClosed = true;
    }

    @Override
    public void deposit(double amount) {
        if (!isClosed && amount > 0) { // Check if the account is not closed
            balance += amount;
        }
    }

    @Override
    public double withdraw(double amount) {
        if (!isClosed && amount > 0 && amount <= withdrawalLimit && amount <= balance) { // Check if the account is not closed
            balance -= amount;
            return amount;
        } else {
            return 0.0; // Or appropriate handling, considering the account is closed or other conditions are not met
        }
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}
