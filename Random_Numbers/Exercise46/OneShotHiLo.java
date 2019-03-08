import java.util.Random;
import java.util.Scanner;

public class OneShotHiLo
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    Random r = new Random();

    int number = 1 + r.nextInt(100);

    System.out.println("I'm thinking of a number between 1-100.  Try to guess it.");
    System.out.print("> ");
    int guess = input.nextInt();

    if ( number == guess )
      System.out.println("You guessed it!  What are the odds?!?");
    else if ( guess > number )
      System.out.println("Sorry, you are too high.  I was thinking of " + number);
    else
      System.out.println("Sorry, you are too low.  I was thinking of " + number);
  }
}
