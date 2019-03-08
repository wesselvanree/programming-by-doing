import java.util.Random;
import java.util.Scanner;

public class KeepGuessing
{
  public static void main(String[] args)
  {
    // maak scanner en random aan
    Scanner input = new Scanner(System.in);
    Random r = new Random();

    // maak random nummer van 1 tot 10
    int number = 1 + r.nextInt(10);

    // startmessage en vragen om guess
    System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
    System.out.print("Your guess: ");
    int guess = input.nextInt();

    // als guess fout is blijft deze while opnieuw uitvoeren totdat het goed is
    while ( guess != number )
    {
        System.out.println("That is incorrect. Guess again.");
        System.out.print("Your guess: ");
        guess = input.nextInt();
    }

    // als het programma voorbij de while loop is moet het antwoord goed zijn en dus komt dan dit bericht
    System.out.println("That's right! You're a good guesser.");
  }
}
