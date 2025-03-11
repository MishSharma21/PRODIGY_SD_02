import java.util.Random;
import java.util.*;
public class Task2 {
    public static void main(String[] args) 
    {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess < randomNumber) 
            {
                System.out.println("Too low! Try again.");
            } 
            else if (guess > randomNumber) 
            {
                System.out.println("Too high! Try again.");
            } 
            else 
            {
                System.out.println("Congratulations! You guessed the number " + randomNumber + " in " + attempts + " attempts.");
            }
        } 
        while (guess != randomNumber);

        sc.close();
    }
}
