import java.util.Scanner;

class Student
{
  String name;
  int grade;
  float average;
}

public class LilDatabase
{
  public static void main(String[] args)
  {
    // bij deze opdracht mocht geen gebruik worden gemaakt van loops
    Scanner keyboard = new Scanner(System.in);
    Student[] students = new Student[3];
    students[0] = new Student();
    students[1] = new Student();
    students[2] = new Student();

    // student 1
    System.out.print("Enter student 1's name: ");
    students[0].name = keyboard.next();
    System.out.print("Enter student 1's grade: ");
    students[0].grade = keyboard.nextInt();
    System.out.print("Enter student 1's average: ");
    students[0].average = keyboard.nextFloat();

    // student 2
    System.out.print("\nEnter student 2's name: ");
    students[1].name = keyboard.next();
    System.out.print("Enter student 2's grade: ");
    students[1].grade = keyboard.nextInt();
    System.out.print("Enter student 2's average: ");
    students[1].average = keyboard.nextFloat();

    // student 3
    System.out.print("\nEnter student 3's name: ");
    students[2].name = keyboard.next();
    System.out.print("Enter student 3's grade: ");
    students[2].grade = keyboard.nextInt();
    System.out.print("Enter student 3's average: ");
    students[2].average = keyboard.nextFloat();

    // print alle waardes
    System.out.println("\nThe names are: " + students[0].name + ", " + students[1].name + ", " + students[2].name);
    System.out.println("The grades are: " + students[0].grade + ", " + students[1].grade + ", " + students[2].grade);
    System.out.println("The averages are: " + students[0].average + ", " + students[1].average + ", " + students[2].average);

  }
}
