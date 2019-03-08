import java.util.Scanner;

public class DumbCalculator
{
  public static void main(String[] args)
  {
    // maak scanner aan
    Scanner keyboard = new Scanner(System.in);

    Double num1, num2, num3, result;

    // geen nextLine() nodig omdat alles een double is
    System.out.print("Enter first number: ");
    num1 = keyboard.nextDouble();

    System.out.print("Enter second number: ");
    num2 = keyboard.nextDouble();

    System.out.print("Enter third number: ");
    num3 = keyboard.nextDouble();

    result = calculate(num1, num2, num3);

    // print volledige string
    System.out.println("\n(" + num1 + " + " + num2 + " + "  + num3 + ") / 2 is..."  + result);
  }

  // method maakt van de 3 inputs het antwoord
  public static double calculate(double num1, double num2, double num3)
  {
    double ans = num1 + num2 + num3;
    ans = ans / 2;
    return ans;
  }
}
