import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        bank Bank = new bank();


        System.out.println("Welcome to Bank_in_Java!!!");
        System.out.println("Select the Service that you want from the below: ");
        System.out.println("1. Create Account\n2. Make Deposit\n3. Make Withdrawl\n4. Show Account");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch(option){
            case 1:
                System.out.println("Enter the account holder name.....");
                String accountHolder = sc.next();
                System.out.println("Enter initial balance.....");
                double initialBalance = sc.nextDouble();
                Bank.createAccount(accountHolder, initialBalance);
                break;
            case 2:
                System.out.println("Enter Your Account Number....");
                int accountNumber = sc.nextInt();
                System.out.println("Enter the Deposit Amount...");
                double amount = sc.nextDouble();
                Bank.makeDeposit(accountNumber, amount);
                break;
            case 3:
                System.out.println("Enter Your Account Number....");
                int AccountNumber = sc.nextInt();
                System.out.println("Enter the Deposit Amount...");
                double Amount = sc.nextDouble();
                Bank.makeWithdrawl(AccountNumber, Amount);
                break;
            case 4:
                System.out.println("Enter Your Account Number....");
                int acntNumber = sc.nextInt();
                Bank.displayAccount(acntNumber);
    }
//        Bank.displayAccount(1);
         Bank.printAllAccounts();

//        System.out.println(savings.totalAmount(20));
    }
}
