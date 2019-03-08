import java.util.Random;

public class DiceDoubles
{
  public static void main(String[] args)
  {
    Random r = new Random();
    int v1 = 1 + r.nextInt(6);
    int v2 = 1 + r.nextInt(6);
    // omdat dit int gelijk is aan andere int, veranderd deze automatisch wanneer die integers aangepast worden in de while loop
    int total = v1 + v2;

    System.out.println("HERE COMES THE DICE!");
    System.out.println("\nRoll #1: " + v1);
    System.out.println("Roll #2: " + v2);
    System.out.println("The total is " + total +"!");

    // blijft uitvoeren totdat v1 gelijk is aan v2
    while ( v1 != v2 )
    {
      // genereer nieuwe random getallen
      v1 = 1 + r.nextInt(6);
      v2 = 1 + r.nextInt(6);
      System.out.println("\nRoll #1: " + v1);
      System.out.println("Roll #2: " + v2);
      System.out.println("The total is " + total + "!");
    }
  }
}
