import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        int attempts = 0;
        int guess;
        
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");
        
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            
            if (guess < randomNumber) {
                System.out.println("Higher!");
            } else if (guess > randomNumber) {
                System.out.println("Lower!");
            } else {
                System.out.println("Congratulations! You've guessed the number " + randomNumber + " in " + attempts + " attempts!");
            }
        } while (guess != randomNumber);
        
        scanner.close();
    }
}
