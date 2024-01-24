public class Main {
    public static void main(String[] args) {
        // Create a new instance of Bank
        Bank bank = new Bank();

        // Instantiate Account Objects
        StandardAccount standardAccount = new StandardAccount(1, -500.0);
        BasicAccount basicAccount = new BasicAccount(2, 200.0);
        PremiumAccount premiumAccount = new PremiumAccount(3);

        // Open accounts
        bank.openAccount(standardAccount);
        bank.openAccount(basicAccount);
        bank.openAccount(premiumAccount);

        // Perform initial operations (deposit, withdraw, etc.)
        // ...

        // Edge Case Testing
        // 1. Testing Withdrawal Beyond Balance
        double withdrawnAmount = standardAccount.withdraw(2000.0);
        System.out.println("Attempted to withdraw 2000.0 from StandardAccount, Actual amount withdrawn: " + withdrawnAmount);

        // 2. Testing Deposit of Negative Amount
        standardAccount.deposit(-500.0);
        System.out.println("Attempted to deposit -500.0 into StandardAccount, Balance after deposit: " + standardAccount.getCurrentBalance());

        // 3. Testing Account Closure with Debt
        standardAccount.withdraw(2000.0); // Assuming this sets the account into debt
        bank.closeAccount(standardAccount.getAccountNumber());

        // 4. Testing Withdrawal and Deposit Limits
        basicAccount.withdraw(1000.0); // Assuming the limit is less than 1000
        System.out.println("Attempted to withdraw 1000.0 from BasicAccount, Balance after withdrawal: " + basicAccount.getCurrentBalance());

        premiumAccount.deposit(100000.0);
        premiumAccount.withdraw(50000.0);
        System.out.println("After large transactions, PremiumAccount balance: " + premiumAccount.getCurrentBalance());

        // 5. Testing Close Account Functionality
        bank.closeAccount(basicAccount.getAccountNumber());
        basicAccount.deposit(500.0);
        System.out.println("Attempted to deposit into a closed account, BasicAccount balance: " + basicAccount.getCurrentBalance());

        // Other tests and operations
        // ...
    }
}
