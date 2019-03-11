import java.util.Scanner;

public class CountingMachineRevisited
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int input1, input2, input3, i;

    // vraag voor input1
    System.out.print("Count from: ");
    input1 = keyboard.nextInt();

    // vraag voor input2
    System.out.print("Count to  : ");
    input2 = keyboard.nextInt();

    // vraag voor input3
    System.out.print("Count by  : ");
    input3 = keyboard.nextInt();

    // i moet beginnen met input1 dus de startvalue is input1
    // i mag niet groter zijn dan input2 dus moet die kleiner of gelijk zijn aan
    // input3 is hoeveel er na elke loop bij komt dus na elke loop moet i = i + input3 uitgevoerd worden
    for (i = input1; i <= input2; i += input3)
    {
      System.out.print(i + " ");
    }
  }
}
