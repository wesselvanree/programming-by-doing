import java.util.Random;
import java.util.Scanner;

public class HiLoLimited
{
  public static void main(String[] args)
  {
    // maak scanner en random
    Scanner input = new Scanner(System.in);
    Random r = new Random();

    // aantal guesses
    int guesses = 0;

    // random getal tussen 1 en 100
    int number = 1 + r.nextInt(100);

    // startmessage en vragen om eerste guess
    System.out.println("I'm thinking of a number between 1-100.  You have 7 guesses.");
    System.out.print("First guess: ");
    int guess = input.nextInt();
    guesses++;

    // dit blijft opnieuw afspelen totdat het aantal guesses 7 is
    while ( (guess != number) && guesses < 7 )
    {
      if ( guess > number )
      {
        guesses++;
        System.out.println("Sorry, that guess is too high.");
        System.out.print("Guess #" + guesses + ": ");
        guess = input.nextInt();
      }
      else
      {
        guesses++;
        System.out.println("Sorry, that guess is too low.");
        System.out.print("Guess #" + guesses + ": ");
        guess = input.nextInt();
      }
    }

    // voorbij de while loop betekent: of heeft al 7 guesses gehad, of het goede antwoord is geraden. Daarom deze if/else statement
    if ( number == guess )
      System.out.println("You guessed it in " + guesses + " guesses!  What are the odds?!?");
    else
      System.out.println("Sorry, you didn't guess it in 7 tries.");
  }
}
