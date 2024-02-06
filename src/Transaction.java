import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private final String type;
    private final double amount;
    private final String timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date());
    }

    public void displayTransaction() {
        System.out.println("Type: " + this.type);
        System.out.println("Amount: " + this.amount);
        System.out.print("Timestamp: " + this.timestamp);
        System.out.println("\n_______________________!");
    }

}
