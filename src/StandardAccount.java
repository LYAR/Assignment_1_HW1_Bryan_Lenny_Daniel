public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;
    private boolean isClosed = false; // Added attribute to track if the account is closed

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit < 0 ? creditLimit : 0; // Treat positive values as zero
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
        if (amount > 0 && balance - amount >= creditLimit) {
            balance -= amount;
            return amount;
        } else {
            double actualWithdrawn = balance - creditLimit;
            balance = creditLimit;
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