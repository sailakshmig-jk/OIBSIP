import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;
        int maxAttempts = 7;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low! 📉 Try again.");
            } else {
                System.out.println("Too high! 📈 Try again.");
            }

            if (attempts == maxAttempts) {
                System.out.println("❌ You've used all your attempts. The number was: " + numberToGuess);
            }
        }

        scanner.close();
    }
}
