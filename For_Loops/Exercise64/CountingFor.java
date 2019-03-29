import java.util.Scanner;

public class CountingFor
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println( "Type in a message, and I'll display it five times." );
        System.out.print( "Message: " );
        String message = keyboard.nextLine();


        // 1. n + 1 (n++ kan ook gebruikt worden) betekent dat na elke keer dat de loop uitgevoerd wordt, er 1 bij opgeteld wordt. Als dit weggehaald wordt wordt het een infinit loop.
        // 2. n = 1 zet de default value, samen met n <= 5 bepaalt dit hoevaak de loop opnieuw afspeeld
        // 3.
        for ( int n = 1 ; n <= 10 ; n = n+1 )
        {
            // voor opdacht 4, anders deze if statement weghalen
            if (n % 2 == 0)
              System.out.println(n + ". " + message);
        }

    }
}
