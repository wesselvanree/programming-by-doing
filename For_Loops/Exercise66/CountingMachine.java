import java.util.Scanner;

public class CountingMachine
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int input, i;

    // vraag om nummer
    System.out.print("Count to: ");
    input = keyboard.nextInt();

    // i mag niet groter zijn dan input dus moet die kleiner of gelijk zijn aan
    for (i = 0; i <= input; i++)
    {
      System.out.print(i + " ");
    }
  }
}
