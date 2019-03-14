import java.util.Scanner;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.util.Random;

public class Hangman
{

  private static char[] current;

  public static void main(String[] args)
  {
    Random r = new Random();
    Scanner keyboard = new Scanner(System.in);
    String[] words = new String[] {"awake","bad","bent","bitter","easy","blue","complete","different","public","future"};

    String word = words[r.nextInt(10)]; // genereert random woord
    int length = word.length(); // lengte van het woord

    String guesses = "";
    String misses = "";
    boolean miss;

    int lives = 7; // levens
    char guess; // wat de user voor letter gaat raden

    char[] wordArr = new char[length];
    wordArr = convertString(word); // maakt een char array van het woord

    boolean won, lost;
    won = lost = false; // zet default op false

    // welcome message
    System.out.println("\n\n\n##################");
    System.out.println("WELCOME TO HANGMAN");
    System.out.println("##################\n\n\n");

    initCurrent(length);

    // loop
    while(!won && !lost)
    {
      // laat 'Word: ' zien
      displayCurrent(length);

      // laat de letters zien die fout geraden zijn
      System.out.println("\nMisses: " + misses);

      // print aantal levens
      System.out.print("\nLives: ");
      for (int i = 0; i < lives; i++)
      {
        System.out.print("*");
      }
      System.out.println();


      // vraag welke letter de user wil gebruiken
      miss = true;
      boolean valid = false;
      int guessAmount = 0;
      while (!valid)
      {
        guess = askGuess(guessAmount);
        if (guesses.indexOf(guess) >= 0)
        {
          guessAmount++;
          valid = false;
        }
        else
        {
          guesses += String.valueOf(guess);
          for (int i = 0; i < length; i++) {
            if (guess == wordArr[i]) {
              alterCurrent(i, guess);
              miss = false;
            }
          }
          if (miss) {
            misses += String.valueOf(guess);
            lives -= 1;
          }
          valid = true;
        }
      }

      won = checkWon(word);
      lost = lives == 0;

    }

    if (won) {
      System.out.println("You won!");
    }
    else
    {
      System.out.println("You lose.");
    }

  }


  public static boolean checkWon(String word)
  {
    String currentString = new String(current);

    // currentString == word werkte niet maar dit wel
    if (currentString.equals(word))
      return true;
    else
      return false;
  }


  public static char askGuess(int option)
  {
    Scanner keyboard = new Scanner(System.in);

    if (option == 0)
      System.out.print("Guess: ");
    else
      System.out.print("You already guessed that one: ");

    char guess = keyboard.next().charAt(0);
    keyboard.nextLine();

    return guess;
  }


  public static void initCurrent(int length) {
    current = new char[length];

    for (int i = 0; i < length; i ++)
    {
      current[i] = '_';
    }
  }


  // om current array te veranderen die achter 'Word: ' komt te staan
  public static void alterCurrent(int i, char guess)
  {
    current[i] = guess;
  }


  public static void displayCurrent(int length)
  {
    System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    System.out.print("\nWord: ");
    for (int i = 0; i < length; i++)
    {
      System.out.print(current[i] + " ");
    }
    System.out.println();
  }


  public static char[] convertString(String word) {
    char[] arr = new char[word.length()];

    for (int i = 0; i < word.length(); i++)
    {
      arr[i] = word.charAt(i);
    }

    return arr;
  }


}
