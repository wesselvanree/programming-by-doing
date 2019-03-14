import java.util.Scanner;
import java.util.Random;

public class Hangman
{

  private static char[] current;

  public static void main(String[] args)
  {
    Random r = new Random();
    Scanner keyboard = new Scanner(System.in);
    String[] words = new String[] {"awake","bad","bent","bitter","easy","blue","complete","different","public","future"};

    String word = words[r.nextInt(10)];
    int length = word.length();

    String misses = "";
    boolean miss = true;

    int lives = 7;
    char guess;

    char[] wordArr = new char[length];
    wordArr = convertString(word);

    boolean won, lost;
    won = lost = false;

    // welcome message
    System.out.println("\n\n\n##################");
    System.out.println("WELCOME TO HANGMAN");
    System.out.println("##################\n\n\n");

    initCurrent(length);

    // loop
    while(!won && !lost)
    {
      displayCurrent(length);

      // laat de letters zien die fout geraden zijn
      System.out.println("\nMisses: " + word);

      // vraag welke letter de user wil gebruiken
      boolean valid = false;
      while (!valid)
      {
        guess = askGuess();
        for (int i = 0; i < length; i++)
        {
          if (guess == wordArr[i])
          {
            alterCurrent(i, guess);
            System.out.println("true");
            miss = false;
          }
        }
        if (miss)
        {
          misses += String.valueOf(guess);
          System.out.println("wrong");
        }
        break;
      }

      // print aantal levens
      System.out.print("\nLives: ");
      for (int i = 0; i < lives; i++)
      {
        System.out.print("*");
      }
      System.out.println();


      break;
    }
  }


  public static char askGuess()
  {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("\nGuess: ");
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
    String guessStr = String.valueOf(guess);

  }


  public static void displayCurrent(int length)
  {
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
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
