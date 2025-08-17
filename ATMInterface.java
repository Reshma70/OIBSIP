import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(">> Welcome to Java ATM");
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        User user = BankOperations.authenticate(id, pin);

        if (user == null) {
            System.out.println("Invalid credentials. Exiting.");
            return;
        }

        ATM atm = new ATM(user);

        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. View Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.viewTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = scanner.nextDouble();
                    atm.withdraw(withdrawAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = scanner.nextDouble();
                    atm.deposit(depositAmt);
                    break;
                case 4:
                    System.out.print("Enter receiver user ID: ");
                    int receiverId = scanner.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmt = scanner.nextDouble();
                    atm.transfer(receiverId, transferAmt);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
