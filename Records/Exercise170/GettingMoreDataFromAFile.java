import java.io.*;
import java.util.Scanner;


class Person
{
  String name;
  int age;
}


public class GettingMoreDataFromAFile
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Person p1 = new Person();
    Person p2 = new Person();
    Person p3 = new Person();
    Person p4 = new Person();
    Person p5 = new Person();

    System.out.print("Which file to open: ");
    String filename = keyboard.next();

    // reading the file
    try {
      File in = new File(filename);
      Scanner input = new Scanner(in);
      System.out.println("Reading data from " + filename);

      // blijft doorgaan tot er geen regels meer zijn
      while (input.hasNext()) {
        // person 1
        p1.name = input.next();
        p1.age = input.nextInt();

        input.nextLine();

        // person 2
        p2.name = input.next();
        p2.age = input.nextInt();

        input.nextLine();

        // person 3
        p3.name = input.next();
        p3.age = input.nextInt();

        input.nextLine();

        // person 4
        p4.name = input.next();
        p4.age = input.nextInt();

        input.nextLine();

        // person 5
        p5.name = input.next();
        p5.age = input.nextInt();

        input.nextLine();
      }
    }
    // als de file niet bestaat wordt deze code uitgevoerd, ex is een variabele
    // waarin de error komt te staan
    catch (FileNotFoundException ex) {
      System.out.println("ERROR: " + ex);
    }

    System.out.println("\n" + p1.name + " is " + p1.age + " years old");
    System.out.println(p2.name + " is " + p1.age + " years old");
    System.out.println(p3.name + " is " + p1.age + " years old");
    System.out.println(p4.name + " is " + p1.age + " years old");
    System.out.println(p5.name + " is " + p1.age + " years old");
  }
}
