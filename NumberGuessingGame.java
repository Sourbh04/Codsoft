//A number guessing game programmed in JAVA as the project for my 1st week of internship at CODSOFT. 
//This is my first Java Program which made me understand java concepts in a practical manner!

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playAgainChoice;

        // Outer do-while loop to allow playing multiple games
        do {
            Random random = new Random();
            // Generates a random number between 1 and 100 for each new game
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int guess=-1;
            final int MAX_ATTEMPTS = 10; // Define maximum attempts for clarity

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Try to guess the number between 1 and 100.");

            // Inner loop for a single game session
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                // Input validation for non-integer input
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next(); // Consume the invalid input
                    System.out.print("Enter your guess: ");
                }
                guess = scanner.nextInt();
                attempts++;

                if (guess > numberToGuess) {
                    System.out.println("Number is Less than " + guess + ". Try again!");
                } else if (guess < numberToGuess) {
                    System.out.println("Number is Greater than " + guess + ". Try again!");
                } else {
                    System.out.println("Correct! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                    break; // Exit the inner game loop if guessed correctly
                }
            }

            // Check if max attempts were reached without guessing correctly
            if (attempts == MAX_ATTEMPTS && guess != numberToGuess) {
                System.out.println("You've reached your maximum attempts! The number was: " + numberToGuess);
            }

            // Prompt to play again
            System.out.println("\nIf you want to play again, Press 1. To exit, press any other number.");
            // Input validation for non-integer playAgainChoice
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1 to play again or any other number to exit.");
                scanner.next(); // Consume the invalid input
                System.out.print("Enter your choice: ");
            }
            playAgainChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character after reading the int

        } while (playAgainChoice == 1); // Continue loop if user wants to play again

        scanner.close(); // Close the scanner when the entire program finishes
        System.out.println("Thanks for playing!");
    }
}
