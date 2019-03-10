import java.util.Random;
import java.util.Scanner;

// 1. verander de standaardvalue naar 'y', dit zorgt ervoor dat de while loop de eerste keer altijd werkt

public class FlipAgain
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		Random rng = new Random();

    // geen startvalue meer nodig omdat de do-while loop eerst 1 keer uitvoert en daarna kijkt of de while statement true is en als dat zo is voert die nog een keer uit
    String again;

    // voert de code tussen de curly braces eerst uit voordat de while statement gecontroleerd wordt
    do
    {
      int flip = rng.nextInt(2);
			String coin;

			if ( flip == 1 )
				coin = "HEADS";
			else
				coin = "TAILS";

			System.out.println( "You flip a coin and it is... " + coin );

			System.out.print( "Would you like to flip again (y/n)? " );
			again = keyboard.next();
    } while ( again.equals("y") );

	}
}
