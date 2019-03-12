import java.io.*;
import java.util.Scanner;

public class VowelCapitalization
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    // vraag naar file
    System.out.print("Open which file: ");
    String filename = keyboard.next();
    System.out.println();

    // probeert de code uit te voeren en als dat niet lukt komt er een error
    try
    {
      File in = new File(filename);
      Scanner input = new Scanner(in);

      // blijft doorgaan tot er geen regels meer zijn
      while ( input.hasNext() )
      {
        // leest de hele regel en slaat het op in line
        String line = input.nextLine();

        // gaat letter voor letter de regel langs
        for ( int i = 0; i < line.length(); i++ )
        {
          // slaat de letter van dit moment op in c
          char c = line.charAt(i);

          // checkt of c een vowel is
          if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
          {
            System.out.print( Character.toUpperCase(c) );
          }
          else
            System.out.print( c );
        }
        System.out.println();
      }
    }
    // als de file niet bestaat wordt deze code uitgevoerd, ex is een variabele waarin de error komt te staan
    catch (FileNotFoundException ex)
    {
      System.out.println("ERROR: " + ex);
    }
  }
}
