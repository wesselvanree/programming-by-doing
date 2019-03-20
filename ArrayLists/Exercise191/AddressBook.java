import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

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

  // kleurcodes
  private static String ANSI_RED="\u001B[31m";
  private static String ANSI_YELLOW="\u001B[33m";
  private static String ANSI_GREEN="\u001B[32m";
  private static String ANSI_RESET="\u001B[0m";

  // ArrayLists
  private static ArrayList<String> firstNames = new ArrayList<String>(1);
  private static ArrayList<String> lastNames = new ArrayList<String>(1);
  private static ArrayList<BigInteger> phoneNumbers = new ArrayList<BigInteger>(1);
  private static ArrayList<String> emails = new ArrayList<String>(1);

  // lijst met Person objects
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

      if (firstNames.size() == personAmount)
        System.out.println(ANSI_YELLOW + "\nYou've reached the maximum amount of entries" + ANSI_RESET);
      else
        System.out.println("\nYou currently have " + firstNames.size() + " entries, the max is " + personAmount);

      System.out.println("1. Load from file");
      System.out.println("2. Save to file");
      System.out.println("3. Add entry");
      System.out.println("4. Remove entry");
      System.out.println("5. Edit entry");
      System.out.println("6. Sort entries");
      System.out.println("7. Search specific entries");
      System.out.println("8. Display all current entries");
      System.out.println("9. Quit");
      System.out.print("\nWhat would you like to do? ");

      int choice = 0;
      boolean valid = false;
      while (!valid)
      {
        try {
          choice = keyboard.nextInt();
        } catch (InputMismatchException ex) {
          System.out.print(ANSI_RED + "Please enter a number: " + ANSI_RESET);
          keyboard.next(); // zodat de string die bij de input stond wordt opgevangen
        }

        if (choice > 0 && choice < 10)
        {
          valid = true;
        }
      }

      if (choice == 1)
        getFromDB();
      else if (choice == 2)
        writeToDB();
      else if (choice == 3)
        addEntry();
      else if (choice == 4)
        removeEntry();
      else if (choice == 5)
        editEntry();
      else if (choice == 6)
        sortEntries();
      else if (choice == 7)
        searchEntry();
      else if (choice == 8)
        displayAll();
      else if (choice == 9)
        quit = true;
    }

    System.out.println("Ok, bye");
  }


  // vraag van welk bestand de user wil gebruiken
  public static void askDBFile()
  {
    boolean valid = false;

    // om te checken of Addressbook.class of Addressbook.java wordt ingevoerd
    while (!valid)
    {
      System.out.print("What file do you want to use? ");
      dbFile = keyboard.next();

      if (dbFile != "AddressBook.java" && dbFile != "AddressBook.class");
      {
        valid = true;
      }
    }
  }


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
      System.out.println(ANSI_GREEN + "Added entry" + ANSI_RESET);
    }
    else
    {
      System.out.println(ANSI_RED + "You can't add any more persons" + ANSI_RESET);
    }

  }


  // verwijdert een entry
  public static void removeEntry()
  {
    System.out.print("Enter the number of the person you want to delete from current entries: ");
    int x = keyboard.nextInt();
    int i = x - 1;
    System.out.println(ANSI_GREEN + "Removed " + firstNames.get(i) + " " + lastNames.get(i) + ANSI_RESET);
    firstNames.remove(i);
    lastNames.remove(i);
    phoneNumbers.remove(i);
    emails.remove(i);
  }


  // past personen aan
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

    System.out.println(ANSI_GREEN + "Edited entry" + ANSI_RESET);
  }


  // sorteer entries op achternaam
  public static void sortEntries()
  {
    System.out.println("By what would you like to sort? ");
    System.out.println("1) First name");
    System.out.println("2) Last name");
    System.out.println("3) Phone number");
    System.out.println("4) Emails");
    System.out.print("> ");
    int choice = keyboard.nextInt();

    while (choice < 1 || choice > 4)
    {
      System.out.print("> ");
      choice = keyboard.nextInt();
    }

    boolean valid = false;
    for (int i = 0; i < lastNames.size(); i++)
    {
      for (int j = i + 1; j < lastNames.size(); j++)
      {
        // compareTo() vergelijkt letters op basis van unicode waarde
        if (choice == 1)
          valid = firstNames.get(i).compareTo(firstNames.get(j)) > 0;
        else if (choice == 2)
          valid = lastNames.get(i).compareTo(lastNames.get(j)) > 0;
        else if (choice == 3)
          valid = phoneNumbers.get(i).compareTo(phoneNumbers.get(j)) > 0;
        else if (choice == 4)
          valid = emails.get(i).compareTo(emails.get(j)) > 0;


        if (valid)
        {
          // wissel lastNames om
          String temp = lastNames.get(i);
          lastNames.set(i, lastNames.get(j));
          lastNames.set(j, temp);

          // wissel first names om
          temp = firstNames.get(i);
          firstNames.set(i, firstNames.get(j));
          firstNames.set(j, temp);

          // wissel phone numbers om
          BigInteger temp2 = phoneNumbers.get(i);
          phoneNumbers.set(i, phoneNumbers.get(j));
          phoneNumbers.set(j, temp2);

          // wissel emails om
          temp = emails.get(i);
          emails.set(i, emails.get(j));
          emails.set(j, temp);
        }
      }
    }

    // pas persons aan
    for (int i = 0; i < firstNames.size(); i++) {
      persons[i].firstName = firstNames.get(i);
      persons[i].lastName = lastNames.get(i);
      persons[i].phoneNumber = phoneNumbers.get(i);
      persons[i].email = emails.get(i);
    }

    String message;
    switch (choice) {
      case 1:
        message = "first name";
        break;
      case 2:
        message = "last name";
        break;
      case 3:
        message = "phone number";
        break;
      case 4:
        message = "email";
        break;
      default:
        message = "";
        break;
    }
    System.out.println(ANSI_GREEN + "Sorted entries by " + message + ANSI_RESET);
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
      System.out.println(ANSI_RED + "couldn't write inside " + dbFile + ": " + ex + ANSI_RESET);
    }

    System.out.println(ANSI_GREEN + "Written inside " + dbFile + ANSI_RESET);
  }


  // voeg alle data uit database toe aan entries
  public static void getFromDB()
  {
    boolean error = false;
    int oldSize = firstNames.size();

    if (firstNames.size() == personAmount)
      System.out.println(ANSI_RED + "You can't add any more persons" + ANSI_RESET);
    else
    {
      askDBFile();

      // loopt regel voor regel gegevens langs
      try
      {
        File in = new File(dbFile);
        Scanner input = new Scanner(in);

        // blijft doorgaan tot er geen regels meer zijn
        while (input.hasNext())
        {
          firstNames.add(input.next());
          lastNames.add(input.next());
          phoneNumbers.add(input.nextBigInteger());
          emails.add(input.next());

          input.nextLine();
        }
        input.close();
      } catch (FileNotFoundException ex)
      {
        System.out.println(ANSI_RED + "\nThat file doesn't exist" + ANSI_RESET);
        error = true;
      }

      // als er in het bestand zoveel personen staan dat het over het maximum amount
      // gaat, worden de laatste verwijderd
      if (firstNames.size() > personAmount)
      {
        System.out.println(ANSI_RED + "Reached maximum capacity of entries. Couldn't add all persons" + ANSI_RESET);
        for (int i = firstNames.size() - 1; i >= personAmount; i--)
        {
          firstNames.remove(i);
          lastNames.remove(i);
          phoneNumbers.remove(i);
          emails.remove(i);
        }
      }

      for (int i = 0; i < firstNames.size(); i++)
      {
        persons[i].firstName = firstNames.get(i);
        persons[i].lastName = lastNames.get(i);
        persons[i].phoneNumber = phoneNumbers.get(i);
        persons[i].email = emails.get(i);
      }

      if (!error) {
        System.out.println(ANSI_GREEN + "\nExtracted persons from " + dbFile + ": ");
        for (int i = oldSize; i < firstNames.size(); i++)
        {
          System.out.println("  " + (i + 1) + ") " + firstNames.get(i));
        }
        System.out.print(ANSI_RESET);
      }
    }
  }


  // laat alle personen zien in deze sessie
  public static void searchEntry()
  {
    System.out.println("For what do you want to search?");
    System.out.println("1) First name");
    System.out.println("2) Last name");
    System.out.println("3) Phone number");
    System.out.println("4) Email");
    System.out.print("> ");
    int choice = keyboard.nextInt();

    while (choice < 1 || choice > 4)
    {
      System.out.print("> ");
      choice = keyboard.nextInt();
    }

    System.out.print("What should it contain? ");
    String value = keyboard.next();

    ArrayList<Integer> indexes = new ArrayList<Integer>(1);
    for (int i = 0; i < firstNames.size(); i++)
    {
      if (choice == 1 && firstNames.get(i).contains(value))
        indexes.add(i);
      else if (choice == 2 && firstNames.get(i).contains(value))
        indexes.add(i);
      else if (choice == 3 && phoneNumbers.get(i).toString().contains(value))
        indexes.add(i);
      else if (choice == 4 && emails.get(i).contains(value))
        indexes.add(i);
    }


    if (firstNames.size() == 0)
      System.out.println(ANSI_RED + "\nThere are no current entries" + ANSI_RESET);
    else if (indexes.size() == 0)
      System.out.println(ANSI_RED + "\nCouldn't find anybody with that criteria" + ANSI_RESET);
    else
    {
      for (int i = 0; i < indexes.size(); i++)
      {
        int index = indexes.get(i);
        System.out.println("\nPERSON " + (index + 1) + ":");
        System.out.println("  first name: " + persons[index].firstName);
        System.out.println("  last name: " + persons[index].lastName);
        System.out.println("  phone number: 0" + persons[index].phoneNumber);
        System.out.println("  email: " + persons[index].email);
      }
    }
  }


  // laat alle entries zien
  public static void displayAll()
  {
    if (firstNames.size() == 0)
      System.out.println(ANSI_GREEN + "There are no current entries" + ANSI_RESET);
    else
    {
      for (int i = 0; i < firstNames.size(); i++) {
        int j = i + 1;
        System.out.println("\nPERSON " + j + ":");
        System.out.println("  first name: " + persons[i].firstName);
        System.out.println("  last name: " + persons[i].lastName);
        System.out.println("  phone number: 0" + persons[i].phoneNumber);
        System.out.println("  email: " + persons[i].email);
      }
    }
  }


}
