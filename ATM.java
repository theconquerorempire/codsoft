import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Current balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Current balance: $" + userAccount.getBalance());
        }
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Current balance: $" + userAccount.getBalance());
    }

    public double checkBalance() {
        return userAccount.getBalance();
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        do {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: $" + atm.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: $");
                    amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: $");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true; // Successful withdrawal
        } else {
            return false; // Insufficient balance
        }
    }
}
