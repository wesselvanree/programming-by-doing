import java.util.Scanner;

public class NumberPuzzles2
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    boolean quit = false;
    int choice;
    do
    {
      System.out.println("1) Find two digit numbers <= 56 with sums of digits > 10");
      System.out.println("2) Find two digit number minus number reversed which equals sum of digits");
      System.out.println("3) Quit\n");

      System.out.print("> ");
      choice = keyboard.nextInt();

      if (choice == 1)
        option1();
      else if (choice == 2)
        option2();
      else if (choice == 3)
        // als quit true is stopt de loop
        quit = true;
      else
        // laat rode ERROR zien
        System.out.println("\n\u001b[31mERROR\u001b[0m\n");

    } while (quit != true);
  }

  public static void option1()
  {
    System.out.println();

    for (int tens = 0; tens <= 5; tens++)
    {
      for (int ones = 0; ones <= 9; ones++)
      {
        if ( (tens + ones) > 10 && ( (tens * 10) + ones) <= 56 )
					System.out.print( tens + "" + ones + ", ");
      }
    }

    System.out.println("\n");
  }


  public static void option2()
  {
    System.out.println();

    for ( int tens = 1; tens < 10; tens++)
		{
			for ( int ones = 0; ones < 10; ones++ )
			{
				if ( ((tens * 10) + ones) - ((ones * 10) + (tens)) == ((tens) + ones) )
					System.out.print( (tens * 10) + ones + " ");
			}
    }

    System.out.println("\n");
  }
}
