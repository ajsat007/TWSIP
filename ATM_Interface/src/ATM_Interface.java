import java.util.Scanner;

public class ATM_Interface {
    private static final int MAX_ACCOUNTS = 10;
    private static String[] accountNumbers = new String[MAX_ACCOUNTS];
    private static String[] pins = new String[MAX_ACCOUNTS];
    private static double[] balances = new double[MAX_ACCOUNTS];
    private static int numAccounts = 0;

    public static void main(String[] args) {

        accountNumbers[numAccounts] = "19861001981";
        pins[numAccounts] = "2525";
        balances[numAccounts] = 5000.0;
        numAccounts++;

        Scanner scanner = new Scanner(System.in);

        System.out.println(">>>>> Welcome to the ATM <<<<<");

        while (true) {
            System.out.println("1. Log In");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM. Have a good day ahead!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter your pin: ");
        String pin = scanner.nextLine();

        boolean authenticated = false;

        for (int i = 0; i < numAccounts; i++) {
            if (accountNumbers[i].equals(accountNumber) && pins[i].equals(pin)) {
                System.out.println("Authentication successful.");
                operate(i);
                authenticated = true;
                break;
            }
        }

        if (!authenticated) {
            System.out.println("Authentication failed. Please try again.");
        }
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);

        if (numAccounts >= MAX_ACCOUNTS) {
            System.out.println("Maximum number of accounts reached. Cannot create more accounts.");
            return;
        }

        System.out.println("Enter a new account Number: ");
        String newAccountNumber = scanner.nextLine();
        System.out.println("Set a pin for the new account: ");
        String newPin = scanner.nextLine();

        if (newAccountNumber.isEmpty() || newPin.isEmpty()) {
            System.out.println("Invalid input. Account creation failed.");
            return;
        }

        accountNumbers[numAccounts] = newAccountNumber;
        pins[numAccounts] = newPin;
        balances[numAccounts] = 0.0;
        numAccounts++;

        System.out.println("Account created successfully. You can now log in.");
    }

    private static void operate(int index) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is Rs. " + balances[index]);
                    break;
                case 2:
                    System.out.println("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balances[index] += depositAmount;
                        System.out.println("Deposit successful. Your new balance is Rs. " + balances[index]);
                    } else {
                        System.out.println("Invalid amount. Deposit failed.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balances[index]) {
                        balances[index] -= withdrawAmount;
                        System.out.println("Withdrawal successful. Your new balance is Rs. " + balances[index]);
                    } else {
                        System.out.println("Invalid amount or insufficient balance. Withdrawal failed.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
