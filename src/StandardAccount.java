public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit < 0 ? creditLimit : 0; // Treat positive values as zero
        this.balance = 0;
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
