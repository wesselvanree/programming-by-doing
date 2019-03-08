import java.util.Random;
import java.util.Scanner;

public class NumberGuess
{
  public static void main(String[] args)
  {
    // maak random en scanner aan
    Random r = new Random();
    Scanner input = new Scanner(System.in);

    // random nummer varieerd van 1 tot 10
    int number = 1 + r.nextInt(10);

    // bericht en vragen naar input
    System.out.println("\nI'm thinking of a number from 1 to 10.");
    System.out.print("Your guess: ");
    int guess = input.nextInt();

    // input vergelijken met random nummer
    if (number == guess)
    {
      System.out.println("\nThat's right!  My secret number was " + number + "!");
    }
    else
    {
      System.out.println("\nSorry, but I was really thinking of " + number + ".");
    }
  }
}
