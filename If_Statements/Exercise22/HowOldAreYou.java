import java.util.Scanner;

public class HowOldAreYou
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    String name;
    int age;

    System.out.print("Hello, what is your name? ");
    name = keyboard.next();

    // hierna moeten we een int hebben dus nextLine()
    keyboard.nextLine();

    System.out.print("Welcome " + name + ", what is your age? ");
    age = keyboard.nextInt();

    // als age kleiner is dan 16
    if (age < 16)
    {
      System.out.println("You can't drive.");
    }
    // als age kleiner is dan 18
    if (age < 18)
    {
      System.out.println("You can't vote.");
    }
    // als age kleiner is dan 25
    if (age < 25)
    {
      System.out.println("You can't rent a car.");
    }
    // als age groter is dan 25
    if (age > 25)
    {
      System.out.println("You can do anything that's legal.");
    }
  }
}
