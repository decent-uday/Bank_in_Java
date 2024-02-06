import java.util.ArrayList;
import java.util.List;

public class Account {
    private final int accountNumber;
    private final String accountHolder;
    private double balance;
    private final List<Transaction> transactionHistory;

    public Account(int accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction depositTransaction = new Transaction("Deposit", amount);
        transactionHistory.add(depositTransaction);
    }

    public int getAccNo() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
            Transaction withdrawalTransaction = new Transaction("Withdrawal", amount);
            transactionHistory.add(withdrawalTransaction);

        } else {
            throw new InsufficientFundsException(
                    "Your Account Balance is Insufficient!! Your current Balance is " + getBalance());
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Balance: " + balance);
        System.out.println("Transaction History: ");
        for (Transaction t : transactionHistory) {
            t.displayTransaction();
        }
    }

    @Override
    public String toString() {
        return String.format("Account Holder: %s, Account Number: %d, AccountBalance: %f", accountHolder,
                accountNumber, balance);
    }

}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
