import java.util.Scanner;

public class TheForgetfulMachine {
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    String word1, word2;
    int num1, num2;

    System.out.println("Give me a word!");
    word1 = keyboard.next();

    System.out.println("Give me a second word!");
    word2 = keyboard.next();

    System.out.println("\nGreat, now your favorite number?");
    num1 = keyboard.nextInt();

    System.out.println("And your second-favorite number...");
    num2 = keyboard.nextInt();

    System.out.println("\nThat was fun!");
  }
}
