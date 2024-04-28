import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randomNum = new Random();
        int randomNumber = randomNum.nextInt(100)+1;
        int maxAttempt = 5;
        int attempt = 0;
        boolean isCorrect = false;
        System.out.println("++++=============================> Welcome to the Guessing Number Game <=============================++++");
        System.out.println("You will be asked to Guess a number to win the Game");
        System.out.println("You have maximum "+(maxAttempt)+" attempts limit.");
        while (attempt < maxAttempt){
            System.out.println("Enter the Guess number between 1 to 100: ");
            try {
                int guess = sc.nextInt();
                attempt++;

                if (guess == randomNumber){
                    System.out.println("OOhhOO!, Your number is Correct. You win the Game!!");
                    isCorrect = true;
                    break;
                } else if (guess > randomNumber) {
                    System.out.println("Your guess number is Greater.");
                }else {
                    System.out.println("Your guess number is Smaller.");
                }

                System.out.println("You have minimum "+(maxAttempt - attempt)+" attempts.") ;
            }catch (Exception e){
                System.out.println("Please enter a valid number. You entered Invalid input");
                sc.next();
            }

        }
        if (!isCorrect){
            System.out.println("Sorry, you ran out of attempts. The correct number was " + randomNumber + ".");
        }
        sc.close();
    }
}