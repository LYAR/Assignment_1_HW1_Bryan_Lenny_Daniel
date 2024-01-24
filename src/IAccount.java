public interface IAccount {
    void deposit(double amount);
    double withdraw(double amount);
    double getCurrentBalance();
    int getAccountNumber();
}

