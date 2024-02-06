import java.util.ArrayList;
import java.util.List;

public class bank {
    private final List<Account> accounts;

    public bank() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String accountHolder, double initialBalance) {
        int accountNumber = accounts.size() + 1;
        Account newAcnt = new Account(accountNumber, accountHolder, initialBalance);
        accounts.add(newAcnt);
        // System.out.println(accounts.size());
        System.out.println("Account Created with accountNumber: " + accountNumber + ", AccountHolder: " + accountHolder
                + ", Account Balance: " + initialBalance);
    }

    public synchronized void makeDeposit(int accountNumber, double amount) {
        try {
            Account account = findAccount(accountNumber);
            Runnable depositTask = () -> {
                account.deposit(amount);
                System.out.println("Deposit Successful!! to account number: " + accountNumber);
            };
            Thread depositThread = new Thread(depositTask);
            depositThread.start();
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage() + " for Deposit. Please check the account number.");
        }
    }

    public synchronized void makeWithdrawl(int accountNumber, double amount) {
        try {
            Account account = findAccount(accountNumber);
            Runnable withdrawTask = () -> {
                try {
                    account.withdraw(amount);
                } catch (InsufficientFundsException e) {
                    System.out.println(e);
                }
                System.out.println("Withdrawl Successful!! From account number: " + accountNumber);
            };
            Thread withdrawThread = new Thread(withdrawTask);
            withdrawThread.start();
        } catch (AccountNotFoundException e2) {
            System.out.println(e2);
        }
    }

    public void displayAccount(int accountNumber) throws AccountNotFoundException {
        System.out.println("Displaying the details of the account " + accountNumber);
        Account account = findAccount(accountNumber);
        account.display();
    }

    public Account findAccount(int accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccNo() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found with account number: " + accountNumber);
    }

    public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
