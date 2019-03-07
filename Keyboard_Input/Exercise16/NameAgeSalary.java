import java.util.Scanner;

public class NameAgeSalary {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    String name;
    int age;
    double money;

    System.out.println("Hello, what is your name?");
    name = keyboard.next();

    System.out.println("\nWelcome " + name + ", how old are you?");
    age = keyboard.nextInt();

    System.out.println("\nOkay so you're " + age + " years old.");
    System.out.println("How much do you make, " + name + "?");
    money = keyboard.nextDouble();

    System.out.println("\nWow, " + money + "!");

  }
}
