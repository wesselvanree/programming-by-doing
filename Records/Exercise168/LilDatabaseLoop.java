import java.util.Scanner;

class Student
{
  String name;
  int grade;
  float average;
}

public class LilDatabaseLoop
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Student[] students = new Student[3];
    for (int i=0; i<students.length; i++)
    {
      students[i] = new Student();
    }

    // students
    for (int i=0; i<students.length; i++)
    {
      int j = i + 1;
      System.out.print("\nEnter student " + j + "'s name: ");
      students[i].name = keyboard.next();
      System.out.print("Enter student " + j + "'s grade: ");
      students[i].grade = keyboard.nextInt();
      System.out.print("Enter student " + j + "'s average: ");
      students[i].average = keyboard.nextFloat();
    }

    // print name
    System.out.print("\nThe names are: ");
    for (int i=0; i<students.length; i++)
    {
      System.out.print(students[i].name + " ");
    }
    System.out.println();

    // print grades
    System.out.print("The grades are: ");
    for (int i=0; i<students.length; i++)
    {
      System.out.print(students[i].grade + ", ");
    }
    System.out.println();

    // print average
    System.out.print("The averages are: ");
    for (int i=0; i<students.length; i++)
    {
      System.out.print(students[i].average + ", ");
    }
    System.out.println();


  }
}
