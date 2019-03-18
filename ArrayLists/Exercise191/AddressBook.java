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
  // pas deze aan om het maximum te veranderen
  private static int personAmount = 10;

  private static String dbFile;
  private static ArrayList<String> firstNames = new ArrayList<String>(1);
  private static ArrayList<String> lastNames = new ArrayList<String>(1);
  private static ArrayList<BigInteger> phoneNumbers = new ArrayList<BigInteger>(1);
  private static ArrayList<String> emails = new ArrayList<String>(1);
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
      System.out.println("\n");
      System.out.println("1. load from file");
      System.out.println("2. write to file");
      System.out.println("3. add to file");
      System.out.println("4. add entry");
      System.out.println("5. remove entry");
      System.out.println("6. edit entry");
      System.out.println("7. display current entries");
      System.out.println("8. quit");
      System.out.print("\nWhat would you like to do? ");
      int choice = keyboard.nextInt();

      if (choice == 1)
        getFromDB();
      else if (choice == 2)
        writeToDB();
      else if (choice == 3)
        addToDB();
      else if (choice == 4)
        addEntry();
      else if (choice == 5)
        removeEntry();
      else if (choice == 6)
        editEntry();
      else if (choice == 7)
        displayCurrent();
      else if (choice == 8)
        quit = true;
    }

    System.out.println("Ok, bye");
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
    if (firstNames.size() < personAmount)
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
      for (int i = 0; i < firstNames.size(); i++) {
        persons[i].firstName = firstNames.get(i);
        persons[i].lastName = lastNames.get(i);
        persons[i].phoneNumber = phoneNumbers.get(i);
        persons[i].email = emails.get(i);
      }
      System.out.println("Added entry");
    }
    else
    {
      System.out.println("Maximum capacity of entries reached");
    }

  }


  // verwijder een entry
  public static void removeEntry()
  {
    System.out.print("Enter the number of the person you want to delete from current entries: ");
    int x = keyboard.nextInt();
    int i = x - 1;
    System.out.println("Removed " + firstNames.get(i) + " " + lastNames.get(i));
    firstNames.remove(i);
    lastNames.remove(i);
    phoneNumbers.remove(i);
    emails.remove(i);
  }


  // pas personen aan
  public static void editEntry()
  {
    System.out.print("Enter personnumber: ");
    int personNumber = keyboard.nextInt();
    int i = personNumber - 1;

    while (personNumber > firstNames.size())
    {
      System.out.print("Enter personnumber: ");
      personNumber = keyboard.nextInt();
      i = personNumber - 1;
    }

    System.out.println("What would you like to edit?");
    System.out.println("  1. First name");
    System.out.println("  2. Last name");
    System.out.println("  3. Phone number");
    System.out.println("  4. Email");
    int option = 0;
    do
    {
      System.out.print("> ");
      option = keyboard.nextInt();

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
    } while (option < 1 || option > 4);

    System.out.println("Edited entry");
  }


  // voegt de entries toe aan database
  public static void addToDB()
  {
    askDBFile();
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
    System.out.println("Added entries to " + dbFile);
  }


  // schrijft entries in file
  public static void writeToDB()
  {
    askDBFile();
    String text = "";

    for (int i=0; i<firstNames.size(); i++)
    {
      String a = firstNames.get(i);
      String b = lastNames.get(i);
      BigInteger c = phoneNumbers.get(i);
      String d = emails.get(i);

      text = text + a + " " + b + " " + 0 + c + " " + d + "\n";

    }

    // als het bestand niet bestaat maakt het automatisch een nieuw bestand aan
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(dbFile, false));
      bw.write(text);
      bw.close();
    } catch (IOException ex) {
      System.out.println("couldn't write inside " + dbFile + ": " + ex);
    }

    System.out.println("Written inside " + dbFile);
  }


  // voeg alle data uit database toe aan entries
  public static void getFromDB()
  {
    boolean error = false;
    int oldSize = firstNames.size();
    askDBFile();

    // loopt regel voor regel gegevens langs
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
      System.out.println("\nThat file doesn't exist");
      error = true;
    }

    // als er in het bestand zoveel personen staan dat het over het maximum amount gaat, worden de laatste verwijderd
    if (firstNames.size() > personAmount)
    {
      System.out.println("Reached maximum capacity of entries. Couldn't add all persons");
      for (int i = firstNames.size() - 1; i >= personAmount; i--)
      {
        firstNames.remove(i);
        lastNames.remove(i);
        phoneNumbers.remove(i);
        emails.remove(i);
      }
    }

    for (int i=0; i<firstNames.size(); i++)
    {
      persons[i].firstName = firstNames.get(i);
      persons[i].lastName = lastNames.get(i);
      persons[i].phoneNumber = phoneNumbers.get(i);
      persons[i].email = emails.get(i);
    }

    if (!error)
    {
      System.out.println("\nExtracted persons from " + dbFile + ": ");
      for (int i = oldSize; i < firstNames.size(); i++)
      {
        System.out.println("  " + (i + 1) + ") " +firstNames.get(i));
      }
    }
  }


  // laat alle persone zien in deze sessie
  public static void displayCurrent()
  {
    if (firstNames.size() == 0)
    {
      System.out.println("\nThere are no current entries");
    }
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
