public class App {
    public static void main(String[] args) throws Exception {
        bank Bank = new bank();

        Bank.createAccount("Uday", 10000);
        Bank.createAccount("Kiran", 1900);
        Bank.createAccount("Gopi", 11800);
        Bank.createAccount("Sowmya", 6000);

        Bank.displayAccount(4);
        // Bank.printAllAccounts();

        System.out.println(savings.totalAmount(20));
    }
}
