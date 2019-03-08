// worm animatie v2.0
public class ModulusAnimation
{
  public static void main(String[] args) throws Exception
  {
    int repeats = 5;
    int steps_per_second = 6;

    // omdat ik modulo 13 gebruik moet het aantal repeats keer 13
    for (int i = 0; i < repeats * 13; i++)
    {
      if (i % 13 == 0)
        System.out.print(" -\r");
      else if (i % 13 == 1)
        System.out.print("  ^-\r");
      else if (i % 13 == 2)
        System.out.print("  -----\r");
      else if (i % 13 == 3)
        System.out.print("     -^-  \r");
      else if (i % 13 == 4)
        System.out.print("      -----\r");
      else if (i % 13 == 5)
        System.out.print("        -^-  \r");
      else if (i % 13 == 6)
        System.out.print("          -----\r");
      else if (i % 13 == 7)
        System.out.print("            -^-  \r");
      else if (i % 13 == 8)
        System.out.print("               -----\r");
      else if (i % 13 == 9)
        System.out.print("                 -^-  \r");
      else if (i % 13 == 10)
        System.out.print("                   -----\r");
      else if (i % 13 == 11)
        System.out.print("                      -^  \r");
      else if (i % 13 == 12)
        System.out.print("                           \r");

      // na zoveel tijd wordt er weer 1 bij i opgeteld en speelt de for loop opnieuw af met i 1 hoger dan hiervoor, waardoor dus de volgende if statement uitgevoerd wordt
      Thread.sleep(1000 / steps_per_second);
    }

  }
}
