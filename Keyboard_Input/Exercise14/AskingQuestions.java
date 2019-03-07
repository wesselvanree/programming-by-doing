import java.util.Scanner;

public class AskingQuestions {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    int age, metres, centimetres;
    double weight;

    System.out.print("How old are you? ");
    age = keyboard.nextInt();

    System.out.print("How many metres tall are you? ");
    metres = keyboard.nextInt();

    System.out.print("And how many centimetres? ");
    centimetres = keyboard.nextInt();

    System.out.print("How much do you weigh? ");
    weight = keyboard.nextDouble();

    System.out.println("So you're " + age + " years old, " + metres + "," + centimetres + "m tall and " + weight + " heavy.");
  }
}
