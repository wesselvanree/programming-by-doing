import java.util.Random;

public class Randomness
{
	public static void main ( String[] args )
	{
    // als de seed een bepaald getal is komt er overal hetzelfde uit
    // als je de seed vervolgens naar een ander getal veranderd zijn het andere waardes dan hiervoor, maar overal komt nog steeds hetzelfde uit
		Random r = new Random();

		int x = 1 + r.nextInt(10);

		System.out.println( "My random number is " + x );

    // nu de '1 +' ervoor weggehaald is, varieren de getallen van 0 tot 4 ipv 1 tot 5
    // als er een 3 voor staat varieren de getallen van 3 tot 7
		System.out.println( "Here are some numbers from 1 to 5!" );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.print( 3 + r.nextInt(5) + " " );
		System.out.println();

		System.out.println( "Here are some numbers from 1 to 100!" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.print( 1 + r.nextInt(100) + "\t" );
		System.out.println();

		int num1 = 1 + r.nextInt(10);
		int num2 = 1 + r.nextInt(10);

		if ( num1 == num2 )
		{
			System.out.println( "The random numbers were the same! Weird." );
		}
		if ( num1 != num2 )
		{
			System.out.println( "The random numbers were different! Not too surprising, actually." );
		}
	}
}
