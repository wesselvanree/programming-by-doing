import java.io.*;
import java.util.Scanner;


class Dog
{
  String breed;
  int age;
  double weight;
}


public class GettingDataFromAFile
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Dog dog1 = new Dog();
    Dog dog2 = new Dog();

    System.out.print("Which file to open: ");
    String filename = keyboard.next();

    // reading the file
    try {
      File in = new File(filename);
      Scanner input = new Scanner(in);
      System.out.println("Reading data from " + filename);

      // blijft doorgaan tot er geen regels meer zijn
      while (input.hasNext()) {
        // dog1
        dog1.breed = input.next();
        dog1.age = input.nextInt();
        dog1.weight = input.nextDouble();

        input.nextLine();

        // dog2
        dog2.breed = input.next();
        dog2.age = input.nextInt();
        dog2.weight = input.nextDouble();
      }
    }
    // als de file niet bestaat wordt deze code uitgevoerd, ex is een variabele
    // waarin de error komt te staan
    catch (FileNotFoundException ex) {
      System.out.println("ERROR: " + ex);
    }

    System.out.println("\nFirst dog: " + dog1.breed + ", " + dog1.age + ", " + dog1.weight);
    System.out.println("Second dog: " + dog2.breed + ", " + dog2.age + ", " + dog2.weight);
  }
}
