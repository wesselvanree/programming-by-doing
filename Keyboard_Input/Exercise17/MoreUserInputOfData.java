import java.util.Scanner;

public class MoreUserInputOfData
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    String FirstName, MiddleName, LastName, Login;
    int Grade, StudentID;
    double GPA;

    System.out.println("Please enter the following information so I can sell it for a profit!\n");

    // next() leest String
    System.out.print("First name: ");
    FirstName = keyboard.next();

    // nextLine() zorgt ervoor dat hij de volgende regel leest, omdat er nu geen println maar print gebruikt wordt
    System.out.print("Middle name: ");
    keyboard.nextLine();
    MiddleName = keyboard.next();

    System.out.print("Last name: ");
    keyboard.nextLine();
    LastName = keyboard.next();

    // nextInt() leest integer
    System.out.print("Grade: ");
    keyboard.nextLine();
    Grade = keyboard.nextInt();

    System.out.print("Student ID: ");
    keyboard.nextLine();
    StudentID = keyboard.nextInt();

    System.out.print("Login: ");
    keyboard.nextLine();
    Login = keyboard.next();

    // print alle informatie
    System.out.println("\nYour information:");
    System.out.println("    Login: " + Login);
    System.out.println("    ID: " + StudentID);
    System.out.println("    Name: " + MiddleName + " " + LastName + ", " + FirstName);
    System.out.println("    Grade: " + Grade);
  }
}
