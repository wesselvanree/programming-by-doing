import java.util.Scanner;

public class LittleQuiz
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    int ans1, ans2, ans3, count;

    count = 0;
    // laat user iets invoeren, maar de quiz gaat sowieso door dus hoeft niet in variabele opgeslagen te worden
    System.out.print("Are you ready for a quiz? ");
    keyboard.next();
    System.out.println("Okay, here it comes!");

    // question 1
    System.out.println("\nQ1) What is the capital of Alaska?");
    System.out.println("	1) Melbourne");
    System.out.println("	2) Anchorage");
    System.out.println("	3) Juneau");

    System.out.print("\nYour answer: ");
    ans1 = keyboard.nextInt();

    if (ans1 == 3)
    {
      System.out.println("\nThat's right!");
      // omdat dit een goed antwoord is komt er 1 bij count bij
      count++;
    }
    else
    {
      System.out.println("\nSorry, the right answer was 'Juneau'");
    }

    // question 2
    System.out.println("\nQ2) Can you store the value 'cat' in a variable of type int?");
    System.out.println("	1) yes");
    System.out.println("	2) no");

    System.out.print("\nYour answer: ");
    ans2 = keyboard.nextInt();

    if (ans2 == 2) {
      System.out.println("\nThat's right!");
      count++;
    } else {
      System.out.println("\nSorry, 'cat' is a string. ints can only store numbers.");
    }

    //question 3
    System.out.println("\nQ3) What is the result of 9+6/3?");
    System.out.println("	1) 5");
    System.out.println("	2) 11");
    System.out.println("	3) 15/3");

    System.out.print("\nYour answer: ");
    ans3 = keyboard.nextInt();

    if (ans3 == 2)
    {
      System.out.println("\nThat's correct!");
      count++;
    }
    else
    {
      System.out.println("\nSorry, that's wrong");
    }

    // print het aantal goede antwoorden in deze line
    System.out.println("\n\nOverall, you got " + count + " out of 3 correct.\nThanks for playing!");

  }
}
