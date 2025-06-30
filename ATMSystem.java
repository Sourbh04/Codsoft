//Here again with a new project, i.e., Task 3 of my internship at CODSOFT in Java Programming. 
//I made an ATM interface for users with the features to withdraw money, deposit money and check balance. 
//The program uses three classes, namely ATM, BankAccount and ATMSystem
import java.util.Scanner;

// Class representing a simple bank account
class BankAccount {
    private double balance;

    // Constructor to initialize account with a starting balance
    public BankAccount(double balance) {
        this.balance = Math.max(balance, 0); // Ensure non-negative balance
    }

    // Deposit money into the account
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // Withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Get the current balance
    public double getBalance() {
        return balance;
    }
}

// Class representing the ATM interface
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Start the ATM menu
    public void start() {
        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    withdrawMoney();
                    break;
                case "2":
                    depositMoney();
                    break;
                case "3":
                    showBalance();
                    break;
                case "4":
                    System.out.println("Thank you! Goodbye.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Handle withdrawal
    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Not enough balance or invalid amount.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // Handle deposit
    private void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Deposit amount must be positive.");
            } else if (account.deposit(amount)) {
                System.out.println("Deposit successful!");
            } else {
                System.out.println("Deposit failed. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // Show balance
    private void showBalance() {
        System.out.printf("Your balance is: %.2f\n", account.getBalance());
    }
}

// Main class to run the program
public class ATMSystem {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(5000); // Start with $5000
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}
