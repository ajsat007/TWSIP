# Guessing Number Game

## Overview

The Guessing Number Game is a simple command-line application written in Java. The objective of the game is to guess a randomly generated number between 1 and 100 within a limited number of attempts. The game provides feedback on whether the guessed number is too high or too low and keeps track of the number of attempts made by the player.

## Features

- Randomly generates a number between 1 and 100.
- Allows the player a maximum of 5 attempts to guess the correct number.
- Provides feedback if the guessed number is too high or too low.
- Displays the remaining number of attempts after each guess.
- Informs the player if the input is invalid (non-integer values).
- Ends the game when the player guesses the correct number or runs out of attempts.

## How to Play

1. Run the application.
2. Enter a guess between 1 and 100 when prompted.
3. The game will inform you if your guess is correct, too high, or too low.
4. You have a maximum of 5 attempts to guess the correct number.
5. The game ends when you guess the correct number or run out of attempts.

## Usage

To run the game, compile and execute the `Main` class.

```bash
javac Main.java
java Main
```

## Example Output

```
++++=============================> Welcome to the Guessing Number Game <=============================++++
You will be asked to Guess a number to win the Game
You have maximum 5 attempts limit.
Enter the Guess number between 1 to 100: 
50
Your guess number is Greater.
You have minimum 4 attempts.
Enter the Guess number between 1 to 100: 
25
Your guess number is Smaller.
You have minimum 3 attempts.
Enter the Guess number between 1 to 100: 
35
Your guess number is Smaller.
You have minimum 2 attempts.
Enter the Guess number between 1 to 100: 
40
Your guess number is Smaller.
You have minimum 1 attempts.
Enter the Guess number between 1 to 100: 
45
OOhhOO!, Your number is Correct. You win the Game!!
```

## Error Handling

- The game handles non-integer inputs gracefully by prompting the user to enter a valid number without counting it as an attempt.

## Code Structure

- `Main`: The main class that contains the game logic.
  - `main`: The main method that initializes the game, handles user input, and contains the game loop.

## Dependencies

- Java Development Kit (JDK) 8 or higher.

## License

This project is licensed under the MIT License.

---

Feel free to modify the game or extend its functionality. Happy coding!
