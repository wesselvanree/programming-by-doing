import java.util.Scanner;

public class AgeIn5
{
  public static void main(String[] args)
  {
    // maak scanner
    Scanner input = new Scanner(System.in);

    // alle variabelen definiëren
    String name;
    int age, SubstractedAge, AddedAge;

    System.out.print("Hello, what is your name? ");
    name = input.next();

    System.out.print("\nHi, " + name + "! How old are you? ");
    age = input.nextInt();

    // gebruik de methods om leeftijden aan te passen
    SubstractedAge = substractFive(age);
    AddedAge = addFive(age);

    // output leeftijden
    System.out.println("\nDid you know that in five years you will be " + AddedAge + " years old?");
    System.out.println("And five years ago you were " + SubstractedAge + "! Imagine that!");
  }

  // gebruikt een parameter en haalt er 5 vanaf, deze moet een integer zijn
  public static int substractFive(int age)
  {
    int ageMin = age - 5;
    return ageMin;
  }

  // hetzelfde maar dan + 5
  public static int addFive(int age)
  {
    int agePlus = age + 5;
    return agePlus;
  }
}
