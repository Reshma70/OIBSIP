import java.util.ArrayList;
import java.util.List;

public class ATM {
    private User currentUser;
    private List<String> transactionHistory;

    public ATM(User user) {
        this.currentUser = user;
        this.transactionHistory = new ArrayList<>();
    }

    public void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String record : transactionHistory) {
                System.out.println(record);
            }
        }
    }

    public void deposit(double amount) {
        currentUser.deposit(amount);
        transactionHistory.add("Deposited: $" + amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount) {
        if (currentUser.withdraw(amount)) {
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(int receiverId, double amount) {
        User receiver = BankOperations.getUser(receiverId);
        if (receiver != null && currentUser.transfer(receiver, amount)) {
            transactionHistory.add("Transferred $" + amount + " to user " + receiverId);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed (insufficient funds or invalid user).");
        }
    }
}
