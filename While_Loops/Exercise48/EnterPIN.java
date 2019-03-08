import java.util.Scanner;

public class EnterPIN
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		int pin = 12345;

		System.out.println("WELCOME TO THE BANK OF MITCHELL.");
		System.out.print("ENTER YOUR PIN: ");
		int entry = keyboard.nextInt();

    // 1. Ze voeren allebei iets uit wanneer hetgene tussen de haakjes true is

    // 2. een if statement checkt maar 1 keer, als dit een if statement zou zijn en er wordt een verkeerde pin ingevoerd vraagt hij 1x om opnieuw in te voeren en geeft daarna toegang

    // 3. omdat er hierboven al gezegd is dat entry een int is

    // 4. er ontstaat een infinite loop wanneer de pin fout is omdat de pin niet veranderd en dus ( entry != pin ) true blijft en biljft de while statement doorgaan

		while ( entry != pin )
		{
			System.out.println("\nINCORRECT PIN. TRY AGAIN.");
			System.out.print("ENTER YOUR PIN: ");
			entry = keyboard.nextInt();
		}

		System.out.println("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
	}
}
