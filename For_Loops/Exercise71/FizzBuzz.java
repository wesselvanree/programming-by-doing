public class FizzBuzz
{
  public static void main(String[] args)
  {
    // i start met 1, gaat tot en met 100 en na elke keer komt er 1 bij
    for (int i = 1; i <= 100; i++)
    {
      // als i deelbaar door 3 is en niet deelbaar door 5
      if ((i % 3 == 0) && (i % 5 != 0))
        System.out.println("Fizz");
      // als i deelbaar door 5 is en niet deelbaar door 3
      else if ((i % 5 == 0) && (i % 3 != 0))
        System.out.println("Buzz");
      // als i deelbaar door 3 en door 5 is
      else if ((i % 5 == 0) && i % 3 == 0)
        System.out.println("FizzBuzz");
      // als de bovenstaande allemaal niet waar zijn gewoon het getal waarbij de loop nu is printen
      else
        System.out.println(i);
    }
  }
}
