import java.util.Scanner;

public class Adventure2
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    String answer;
    boolean dead = false;
    boolean escaped = false;
    int currentRoom = 1;

    /*

    lijst met kamers
    1. start
    2. kitchen
    3. top level
    4. bedroom
    5. living room
    6. closet

    */

    System.out.println("YOU ARE INSIDE A CREEPY HOUSE, TRY TO ESCAPE!");

    // loop blijft opniew afspelen zolang de speler nog niet dood of nog niet ontsnapt is
    while(!dead && !escaped)
    {
      // start
      if (currentRoom == 1)
      {
        System.out.println("\nWould you like to go \"upstairs\" or into the \"kitchen\"?");
        System.out.print("> ");
        answer = keyboard.next();

        if (answer.equals("kitchen"))
          currentRoom = 2;
        else if (answer.equals("upstairs"))
          currentRoom = 3;

      }

      // kitchen
      if (currentRoom == 2)
      {
        System.out.println("\nYou are in the kitchen.");
        System.out.println("Would you like to go through the strange looking \"door\", eat the food on the \"counter\" or go \"back\"?");
        System.out.print("> ");
        answer = keyboard.next();

        if (answer.equals("door"))
          currentRoom = 5;
        else if (answer.equals("counter"))
          {
            System.out.println("\nThe food is poisoned!");
            dead = true;
          }
        else if (answer.equals("back"))
          currentRoom = 1;
      }

      // top level
      if (currentRoom == 3)
      {
        System.out.println("\nThe stairs collapsed, you can't go back.\n");
        System.out.println("You are on the top level.");
        System.out.println("Would you like to go through the \"door\" or into the \"bedroom\"?");
        System.out.print("> ");
        answer = keyboard.next();

        if (answer.equals("door"))
          currentRoom = 6;
        else if (answer.equals("bedroom"))
          currentRoom = 4;
      }

      // bedroom
      if (currentRoom == 4)
      {
        System.out.println("\nYou are inside the bedroom.");
        System.out.println("Would you like to go to the \"window\" or go \"back\"?");
        System.out.print("> ");
        answer = keyboard.next();

        if (answer.equals("window"))
          {
            System.out.println("\nThe window is closed!");
            System.out.println("\nA monster appears!");
            dead = true;
          }
        else if (answer.equals("back"))
          currentRoom = 3;
      }

      // living room
      if (currentRoom == 5)
      {
        System.out.println("\nYou are inside the living room.");
        System.out.println("Would you like to go to the \"window\" or go \"back\"?");
        System.out.print("> ");
        answer = keyboard.next();

        if (answer.equals("window"))
        {
          System.out.println("\nThe window is open!");
          escaped = true;
        }
        else if (answer.equals("back"))
          currentRoom = 2;
      }

      // closet
      if (currentRoom == 6)
      {
        System.out.println("\nYou are inside the closet.");
        System.out.println("Would you like to go to move the piece of \"wood\" or go \"back\"?");
        System.out.print("> ");
        answer = keyboard.next();

        if (answer.equals("wood"))
          {
            System.out.println("\nA snake has bitten you!");
            dead = true;
          }
        else if (answer.equals("back"))
          currentRoom = 3;
      }

    }

    // als de while loop voorbij is moet of 'dead' true, of 'escaped' is true
    if (dead)
      System.out.println("\nYou're DEAD");
    else
      System.out.println("\nYou ESCAPED!");

  }
}
