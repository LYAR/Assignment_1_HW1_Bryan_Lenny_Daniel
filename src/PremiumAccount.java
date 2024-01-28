public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;
    private boolean isClosed = false; // Added attribute to track if the account is closed

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void close() {
        this.isClosed = true; // Added method to close the account
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    @Override
    public double withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return amount;
        } else {
            double actualWithdrawn = balance;
            balance = 0;
            return actualWithdrawn;
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