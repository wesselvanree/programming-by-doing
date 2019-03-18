import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Path;
import java.nio.file.Files;

class Person
{
  String firstName;
  String lastName;
  BigInteger phoneNumber;
  String email;
}

public class AddressBook
{

  private static int personAmount = 10;
  private static String dbFile = "database.txt";
  private static ArrayList<String> firstNames = new ArrayList<String>(10);
  private static ArrayList<String> lastNames = new ArrayList<String>(10);
  private static ArrayList<BigInteger> phoneNumbers = new ArrayList<BigInteger>(10);
  private static ArrayList<String> emails = new ArrayList<String>(10);
  private static Person[] persons = new Person[personAmount];
  private static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args)
  {

    for (int i=0; i<persons.length; i++)
    {
      persons[i] = new Person();
    }

    boolean quit = false;

    while (!quit)
    {
      System.out.println("\n\n1. switch database");
      System.out.println("2. load from file");
      System.out.println("3. write to file");
      System.out.println("4. add to file");
      System.out.println("5. add entry");
      System.out.println("6. remove entry");
      System.out.println("7. edit entry");
      System.out.println("8. display current entries");
      System.out.println("9. quit");
      System.out.print("\nWhat would you like to do with " + dbFile + "? ");
      int choice = keyboard.nextInt();

      if (choice == 1)
        askDBFile();
      else if (choice == 2)
        getFromDB();
      else if (choice == 3)
        writeToDB();
      else if (choice == 4)
        addToDB();
      else if (choice == 5)
        addEntry();
      else if (choice == 6)
        removeEntry();
      else if (choice == 7)
        editEntry();
      else if (choice == 8)
        displayCurrent();
      else if (choice == 9)
        quit = true;
    }

    System.out.println("\nOk, bye");

    // System.out.println("\n" + firstNames + " " + lastNames + " " + phoneNumbers + " " + emails);
  }


  // vraag van welk bestand de user wil gebruiken
  public static void askDBFile()
  {
    System.out.print("What file do you want to use? ");
    dbFile = keyboard.next();
  }


  // adds entry
  public static void addEntry()
  {
    // gegevens vragen
    System.out.print("First name: ");
    String a = keyboard.next();
    System.out.print("Last name: ");
    String b = keyboard.next();
    System.out.print("Phone number: ");
    BigInteger c = keyboard.nextBigInteger();
    System.out.print("Email: ");
    String d = keyboard.next();

    // aan aparte arrayLists toevpegen
    firstNames.add(a);
    lastNames.add(b);
    phoneNumbers.add(c);
    emails.add(d);

    // nieuw Person object aanmaken met de ingevoerde waarden
    for (int i=0; i<firstNames.size(); i++)
    {
      persons[i].firstName = firstNames.get(i);
      persons[i].lastName = lastNames.get(i);
      persons[i].phoneNumber = phoneNumbers.get(i);
      persons[i].email = emails.get(i);
    }
  }


  // remove an entry
  public static void removeEntry()
  {
    System.out.print("Enter the number of the person you want to delete from current entries: ");
    int x = keyboard.nextInt();
    int i = x - 1;
    firstNames.remove(i);
    lastNames.remove(i);
    phoneNumbers.remove(i);
    emails.remove(i);
  }


  public static void editEntry()
  {
    System.out.print("Enter personnumber: ");
    int personNumber = keyboard.nextInt();
    int i = personNumber - 1;

    System.out.println("What would you like to edit?");
    System.out.println("  1. First name");
    System.out.println("  2. Last name");
    System.out.println("  3. Phone number");
    System.out.println("  4. Email");
    System.out.print("> ");
    int option = keyboard.nextInt();

    if (option == 1)
    {
      System.out.print("Enter new first name: ");
      String value = keyboard.next();
      firstNames.set(i, value);
      persons[i].firstName = firstNames.get(i);
    }
    else if (option == 2)
    {
      System.out.print("Enter new last name: ");
      String value = keyboard.next();
      lastNames.set(i, value);
      persons[i].lastName = lastNames.get(i);
    }
    else if (option == 3) {
      System.out.print("Enter new phone number: ");
      BigInteger value = keyboard.nextBigInteger();
      phoneNumbers.set(i, value);
      persons[i].phoneNumber = phoneNumbers.get(i);
    }
    else if (option == 4) {
      System.out.print("Enter new email: ");
      String value = keyboard.next();
      emails.set(i, value);
      persons[i].email = emails.get(i);
    }
  }


  // voegt de entries toe aan de database
  public static void addToDB()
  {
    for (int i=0; i<firstNames.size(); i++)
    {
      String a = firstNames.get(i);
      String b = lastNames.get(i);
      BigInteger c = phoneNumbers.get(i);
      String d = emails.get(i);

      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(dbFile, true));
        String text = a + " " + b + " " + 0 + c + " " + d + "\n";
        bw.write(text);
        bw.close();
      } catch (IOException ex) {
        System.out.println("couldn't write inside " + dbFile + ": " + ex);
      }
    }
  }


  public static void writeToDB()
  {
    String text = "";

    for (int i=0; i<firstNames.size(); i++)
    {
      String a = firstNames.get(i);
      String b = lastNames.get(i);
      BigInteger c = phoneNumbers.get(i);
      String d = emails.get(i);

      text = text + a + " " + b + " " + 0 + c + " " + d + "\n";

    }

    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(dbFile, false));
      bw.write(text);
      bw.close();
    } catch (IOException ex) {
      System.out.println("couldn't write inside " + dbFile + ": " + ex);
    }

  }


  // voeg alle data uit database toe aan entries
  public static void getFromDB()
  {

    try {
      File in = new File(dbFile);
      Scanner input = new Scanner(in);

      // blijft doorgaan tot er geen regels meer zijn
      while (input.hasNext()) {
        firstNames.add(input.next());
        lastNames.add(input.next());
        phoneNumbers.add(input.nextBigInteger());
        emails.add(input.next());

        input.nextLine();
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println("ERROR: " + ex);
    }

    for (int i=0; i<firstNames.size(); i++)
    {
      persons[i].firstName = firstNames.get(i);
      persons[i].lastName = lastNames.get(i);
      persons[i].phoneNumber = phoneNumbers.get(i);
      persons[i].email = emails.get(i);
    }

  }

  // laat alle persone zien in deze sessie
  public static void displayCurrent()
  {
    for (int i=0; i<firstNames.size(); i++)
    {
      int j = i + 1;
      System.out.println("\nPERSON " + j + ":");
      System.out.println("  first name: " + persons[i].firstName);
      System.out.println("  last name: " + persons[i].lastName);
      System.out.println("  phone number: 0" + persons[i].phoneNumber);
      System.out.println("  email: " + persons[i].email);
    }
  }


}
