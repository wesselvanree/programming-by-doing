import java.util.Scanner;

public class SpaceBoxing
{
  public static void main(String[] args)
  {
    // maak scanner aan
    Scanner keyboard = new Scanner(System.in);

    double weight;
    int planetType;
    boolean isValid;

    // sla user input op in double
    System.out.print("Please enter your current earth weight (lbs): ");
    weight = keyboard.nextDouble();

    System.out.println("\nI have information about the following planets");
    System.out.println("   1. Venus   2. Mars    3. Jupiter");
    System.out.println("   4. Saturn  5. Uranus  6. Neptune");

    // sla user input op in int
    System.out.print("\nWhich planet are you visiting? ");
    planetType = keyboard.nextInt();

    // als isValid niet aangepast wordt hieronder is die false
    isValid = false;

    // bij elke if statement wordt de weight aangepast naar hoe het op die planeet zou zijn
    if (planetType == 1)
    {
      weight = weight * 0.78;
      isValid = true;
    }
    else if (planetType == 2)
    {
      weight = weight * 0.39;
      isValid = true;
    }
    else if (planetType == 3)
    {
      weight = weight * 2.65;
      isValid = true;
    }
    else if (planetType == 4)
    {
      weight = weight * 1.17;
      isValid = true;
    }
    else if (planetType == 5)
    {
      weight = weight * 1.05;
      isValid = true;
    }
    else if (planetType == 6)
    {
      weight = weight * 1.23;
      isValid = true;
    }
    else {
      System.out.println("\nError: invalid planet");
    }

    // als de waarde van de planeet valid was
    if (isValid)
    {
      System.out.println("\nYour weight would be " + weight + " pounds on that planet.");
    }
  }
}
