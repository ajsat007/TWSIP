# ATM Interface

## Project Overview

The ATM Interface is a simple Java console application that simulates basic ATM operations. Users can create accounts, log in, check balances, deposit money, and withdraw money. This project is a good example of handling basic user authentication, account management, and transaction operations.

## Features

- **User Authentication**: Users can log in using their account number and PIN.
- **Account Management**: Users can create new accounts with unique account numbers and PINs.
- **Balance Inquiry**: Users can check their account balance.
- **Deposits**: Users can deposit money into their account.
- **Withdrawals**: Users can withdraw money from their account if sufficient balance is available.

## Prerequisites

- Java Development Kit (JDK) 8 or later
- A Java Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans
- Basic knowledge of Java programming

## How to Run the Project

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/ajsat007/atm-interface.git
   ```
   
2. **Navigate to the Project Directory**:
   ```sh
   cd atm-interface
   ```

3. **Compile the Code**:
   ```sh
   javac ATM_Interface.java
   ```

4. **Run the Application**:
   ```sh
   java ATM_Interface
   ```

## Usage Instructions

1. **Start the Application**: Run the `ATM_Interface` main method. You will be greeted with a welcome message.

2. **Main Menu**:
   - **Log In**: Enter your account number and PIN to access your account.
   - **Create Account**: Set up a new account with a unique account number and PIN.
   - **Exit**: Exit the application.

3. **Account Operations** (after logging in):
   - **Check Balance**: Display the current balance of your account.
   - **Deposit**: Add a specified amount to your account balance.
   - **Withdraw**: Remove a specified amount from your account balance, if sufficient funds are available.
   - **Exit**: Log out and return to the main menu.

## Code Structure

- **Main Class**: `ATM_Interface`
  - **Static Arrays**: `accountNumbers`, `pins`, `balances`
  - **Static Methods**: `main()`, `login()`, `createAccount()`, `operate(int index)`
  - **Constants**: `MAX_ACCOUNTS`, `numAccounts`

## Sample Data

- The application initializes with one sample account:
  - **Account Number**: 19861001981
  - **PIN**: 2525
  - **Balance**: Rs. 5000.0

## Limitations

- The application currently supports a maximum of 10 accounts.
- The application runs in a console and does not save account data between sessions.
- Input validation is basic and assumes correct data format for account numbers and PINs.

## Future Enhancements

- Implement persistent storage to save account data.
- Enhance input validation to handle a wider range of user inputs.
- Add a graphical user interface (GUI) for better user experience.
- Increase the maximum number of supported accounts.

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests with your improvements.

## License

This project is licensed under the MIT License.

