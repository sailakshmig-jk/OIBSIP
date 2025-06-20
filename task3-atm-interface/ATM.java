import java.util.*;

class ATM {
    private double balance;
    private List<String> transactionHistory;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("Successfully withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void transfer(double amount, String toAccount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transferred ₹" + amount + " to " + toAccount);
            System.out.println("Successfully transferred ₹" + amount + " to " + toAccount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (String tx : transactionHistory) {
                System.out.println(tx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(1000); // Starting with ₹1000

        System.out.print("Enter your user ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter your PIN: ");
        String pin = sc.nextLine();

        // Dummy validation
        if (userId.equals("user123") && pin.equals("1234")) {
            int choice;
            do {
                System.out.println("\n=== ATM Interface ===");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        atm.showTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double wAmt = sc.nextDouble();
                        atm.withdraw(wAmt);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double dAmt = sc.nextDouble();
                        atm.deposit(dAmt);
                        break;
                    case 4:
                        System.out.print("Enter receiver's account name: ");
                        String receiver = sc.nextLine();
                        System.out.print("Enter amount to transfer: ");
                        double tAmt = sc.nextDouble();
                        atm.transfer(tAmt, receiver);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Authentication Failed.");
        }

        sc.close();
    }
}

