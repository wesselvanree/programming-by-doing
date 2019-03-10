import java.util.Scanner;

public class Nim
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    String pile, player, winner;
    int rm;
    boolean hasWinner = false;

    // ik bedacht me hier dat ik dezelfde ANSI escape codes kon gebruiken voor gekleurde output zoals ik in mijn PS1 gedaan heb in mijn .bashrc file
    String ANSI_RESET = "\u001B[0m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_RED = "\u001B[31m";

    int A = 3;
    int B = 4;
    int C = 5;

    // vraag naar naam eerste speler
    System.out.print(ANSI_RESET + "Player 1, enter your name: " + ANSI_CYAN);
    String player1 = keyboard.next();

    // vraag naar naam tweede speler
    System.out.print(ANSI_RESET + "Player 2, enter your name: " + ANSI_CYAN);
    String player2 = keyboard.next();
    System.out.print(ANSI_RESET);

    // zet turnCount op 0
    int turnCount = 0;
    player = ""; // hierdoor wordt door de if statement de eerste keer player1 gekozen
    do
    {
      // System.out.println("\nA: " + A + "\tB: " + B + "\tC: " + C + "\n"); // default
      printScore2(A,B,C);
      // check of het getal even is of niet en selecteert wie er aan de beurt is
      if (player.equals(player1))
        player = player2;
      else
        player = player1;

      // vraag pile
      System.out.print(ANSI_CYAN + player + ANSI_RESET + ", choose a pile: ");
      pile = keyboard.next();

      // checken of de pile wel bestaat
      while ((!pile.equals("A")) && (!pile.equals("B")) && (!pile.equals("C")))
      {
        System.out.print(ANSI_RED + "That pile doesn't exist. Try again: " + ANSI_RESET);
        pile = keyboard.next();
      }

      // BONUS #1.1
      // blijft opnieuw vragen een nieuwe pile te kiezen wanneer er een pile gekozen wordt die leeg is
      while ((pile.equals("A") && A <= 0) || (pile.equals("B") && B <= 0) || (pile.equals("C") && C <= 0))
      {
        System.out.print(ANSI_RED + "Nice try, " + player + ". That pile is empty. Choose again: " + ANSI_RESET);
        pile = keyboard.next();
      }

      // vraag hoeveel er van de pile af moet
      System.out.print("How many to remove from pile? ");
      rm = keyboard.nextInt();

      // BONUS #1.3
      // checkt of het gekozen nummer dat van de pile af moet kleiner dan 0 is
      while (rm <= 0)
      {
        System.out.print(ANSI_RED + "You must choose at least 1. How many? " + ANSI_RESET);
        rm = keyboard.nextInt();
      }

      if (pile.equals("A"))
      {
        // BONUS #1.2
        // checkt of er uit (pile - gekozen getal) een negatief nummer komt
        while (A - rm < 0)
        {
          System.out.print(ANSI_RED + "Pile A doesn't have that many. Try again: " + ANSI_RESET);
          rm = keyboard.nextInt();
        }
        A = A - rm;
      } else if (pile.equals("B"))
      {
        while (B - rm < 0)
        {
          System.out.print(ANSI_RED + "Pile B doesn't have that many. Try again: " + ANSI_RESET);
          rm = keyboard.nextInt();
        }
        B = B - rm;
      } else if (pile.equals("C"))
      {
        while (C - rm < 0)
        {
          System.out.print(ANSI_RED + "Pile C doesn't have that many. Try again: " + ANSI_RESET);
          rm = keyboard.nextInt();
        }
        C = C - rm;
      }

      // BONUS #2
      // checkt of 2 piles 0 zijn en de laatste 1 is
      if ((A == 1 && B == 0 && C == 0) || (A == 0 && B == 1 && C == 0) || (A == 0 && B == 0 && C == 1))
      {
        String loser;
        // de loser is de tegenovergestelde speler die bij deze beurt aan de beurt is
        if (player.equals(player1))
          loser = player2;
        else
          loser = player1;

        // winner is de speler die nu aan de beurt is
        winner = player;
        printScore2(A, B, C);
        System.out.println(ANSI_RED + loser + ANSI_RESET + ", you must take the last remaining counter, so you lose.");
        System.out.println(ANSI_GREEN + winner + ANSI_RESET + " wins!");
        A = B = C = 0;
        // zodat onderaan niet nog een keer komt te staan dat er iemand gewonnen heeft
        hasWinner = true;
      }

    } while (A > 0 || B > 0 || C > 0);

    if (!hasWinner)
    {
      if (player.equals(player1))
        winner = player2;
      else
        winner = player1;
      System.out.println("\n" + winner + ", there are no counters left, so you WIN!");
    }

  }


  // BONUS #3
  public static void printScore1(int A, int B, int C)
  {
    // print lege regel
    System.out.println();

    // print A:
    System.out.print("A: ");

    // elke keer dat deze while loop uitgevoerd wordt wordt er 1 van A afgehaald en omdat hij groter dan nul moet zijn stopt hij na het aantal keer dat de waarde van in dit geval A is
    while (A > 0)
    {
      System.out.print("*");
      A -= 1;
    }

    // hetzelfde bij B
    System.out.print("\nB: ");
    while (B > 0)
    {
      System.out.print("*");
      B -= 1;
    }

    // hetzelfde bij C
    System.out.print("\nC: ");
    while (C > 0)
    {
      System.out.print("*");
      C -= 1;
    }

    // regel afmaken na de C en dan nog \n voor een lege regel eronder
    System.out.println("\n");

  }



  // BONUS #4
  public static void printScore2(int A, int B, int C)
  {
    // voegt lege regel toe aan bovenkant
    System.out.println();

    // zet i als 0
    int i = 0;

    // zoekt het hoogste getal en stelt dat getal gelijk aan i
    if (A > i)
      i = A;
    if (B > i)
      i = B;
    if (C > i)
      i = C;

    // gaat regel voor regel langs waar een sterretje moet komen en waar niet
    while (i > 0) {
      System.out.print("\t");

      // i begint op het hoogste getal dus daarom checken we of i lager is dan de
      // counter
      if (i <= A)
        System.out.print("* ");
      else
        System.out.print("  ");
      if (i <= B)
        System.out.print("* ");
      else
        System.out.print("  ");
      if (i <= C)
        System.out.print("* ");
      else
        System.out.print("  ");
      System.out.println("");
      i -= 1;
    }
    System.out.println("\tA B C");

    // voegt lege regel toe aan onderkant
    System.out.println();
  }


  }
