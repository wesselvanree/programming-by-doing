import java.util.Scanner;

public class HowOldAreYou2
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    String name;
    int age;

    System.out.print("Hello, what is your name? ");
    name = keyboard.next();

    // hierna moeten we een int hebben dus nextLine()
    keyboard.nextLine();

    // vraag user input en zet het in string age
    System.out.print("Welcome " + name + ", what is your age? ");
    age = keyboard.nextInt();

    // als age kleiner dan 16 is
    if (age < 16) {
      System.out.println("You can't drive.");
    }
    // als age groter of gelijk aan 16 is EN age ook kleiner of gelijk aan 17 is
    else if (age >= 16 && age <= 17) {
      System.out.println("You can drive but not vote.");
    }
    // als age groter of gelijk aan 18 is EN age ook kleiner of gelijk aan 24 is
    else if (age >= 18 && age <= 24) {
      System.out.println("You can vote but not rent a car.");
    }
    // als het bovenstaande allemaal niet waar is moet diegene wel 25 of ouder zijn
    else {
      System.out.println("You can do pretty much anything.");
    }
  }
}
