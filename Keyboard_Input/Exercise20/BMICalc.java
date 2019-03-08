import java.util.Scanner;

public class BMICalc
{
  public static void main(String[] args)
  {
    // maak scanner aan
    Scanner keyboard = new Scanner(System.in);

    int feet, inch;
    double pounds;

    // user input
    System.out.print("Your height (feet only): ");
    feet = keyboard.nextInt();

    System.out.print("Your height (inches): ");
    inch = keyboard.nextInt();

    // volgende waarde is een double dus nextLine()
    keyboard.nextLine();

    System.out.print("Your weight (pounds): ");
    pounds = keyboard.nextDouble();

    // values omzetten
    double metres = toMetres(feet, inch);
    double kg = toKg(pounds);
    System.out.println("\nheight in m: " + metres);
    System.out.println("weight in kg: " + kg);

    // bmi uitrekenen
    double bmi = calcBMI(metres, kg);
    System.out.println("\nBMI: " + bmi);
  }

  public static double toMetres(int feet, int inch)
  {
    double m = feet * 0.3048 + inch * 0.0254;
    return m;
  }

  public static double toKg(double pounds)
  {
    double kg = pounds * 0.45359237;
    return kg;
  }

  public static double calcBMI(double metres, double kg)
  {
    double bmi = kg / (metres * metres);
    return bmi;
  }
}
