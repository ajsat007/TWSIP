# Online Voting System

This project is an Online Voting System implemented in Java using the Swing framework for the graphical user interface (GUI) and MySQL for the database. The system allows users to vote for their preferred party and check the voting results.

## Features

- **User-Friendly Interface:** A simple and intuitive interface to cast votes.
- **Vote Submission:** Users can enter their name, phone number, and select their preferred party to cast their vote.
- **View Results:** Users can check the current voting results, showing the number of votes each party has received.

## Prerequisites

- **Java Development Kit (JDK)**
- **MySQL Database**
- **JDBC Driver for MySQL**

## Setup Instructions

1. **Clone the Repository:**
   ```sh
   git clone https://github.com/ajsat007/online-voting-system.git
   cd online-voting-system
   ```

2. **Database Setup:**

   - Start your MySQL server.
   - Create a database named `voting_db`.
   - Use the following SQL script to create the necessary table:
     ```sql
     CREATE TABLE votes (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100),
       phone VARCHAR(15),
       party VARCHAR(50)
     );
     ```

3. **Configure Database Connection:**

   - Open the `VotingSystem.java` file.
   - Locate the database connection setup in the constructor:
     ```java
     connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/voting_db", "root", "ROOT");
     ```
   - Ensure the connection URL, username, and password match your MySQL configuration.

4. **Compile and Run the Application:**

   - Open a terminal and navigate to the project directory.
   - Compile the Java files:
     ```sh
     javac VotingSystem.java
     ```
   - Run the application:
     ```sh
     java VotingSystem
     ```

## Usage

1. **Launch the Application:** Run the `VotingSystem` class to start the application.

2. **Cast a Vote:**
   - Enter your name in the "ENTER NAME" field.
   - Enter your phone number in the "ENTER PHONE" field.
   - Select your preferred party (PARTY A, PARTY B, or PARTY C).
   - Click the "SUBMIT YOUR VOTE" button to cast your vote.

3. **Check Results:**
   - Click the "CHECK RESULTS" button to view the current voting results.

## Dependencies

- **Java Swing:** For creating the graphical user interface.
- **JDBC:** For connecting to and interacting with the MySQL database.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or issues, please contact Ajinkya Satkar at ajinkyasatkar007@gmail.com.

