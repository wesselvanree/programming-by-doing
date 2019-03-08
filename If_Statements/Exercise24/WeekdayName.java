import java.util.GregorianCalendar;

public class WeekdayName {
  public static String weekday_name(int weekday) {
    String result = "";

    // ik had deze eerst met else if gedaan maar dat stond niet in de opdracht dus nu staat het zo, dit kan sneller met switch maar dit was de opdracht
    if (weekday == 1)
    {
      result = "Sunday";
    }
    if (weekday == 2)
    {
      result = "Monday";
    }
    if (weekday == 3)
    {
      result = "Tuesday";
    }
    if (weekday == 4)
    {
      result = "Wednesday";
    }
    if (weekday == 5)
    {
      result = "Thursday";
    }
    if (weekday == 6)
    {
      result = "Friday";
    }
    if (weekday == 7 || weekday == 0)
    {
      result = "Saturday";
    }
    if (weekday < 0 || weekday > 7) {
      result = "Error";
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println("Weekday 1: " + weekday_name(1));
    System.out.println("Weekday 2: " + weekday_name(2));
    System.out.println("Weekday 3: " + weekday_name(3));
    System.out.println("Weekday 4: " + weekday_name(4));
    System.out.println("Weekday 5: " + weekday_name(5));
    System.out.println("Weekday 6: " + weekday_name(6));
    System.out.println("Weekday 7: " + weekday_name(7));
    System.out.println("Weekday 0: " + weekday_name(0));
    System.out.println();
    System.out.println("Weekday 43: " + weekday_name(43));
    System.out.println("Weekday 17: " + weekday_name(17));
    System.out.println("Weekday -1: " + weekday_name(-1));

    GregorianCalendar cal = new GregorianCalendar();
    // maak int voor de dag van vandaag zodat die ingevuld kan worden in de laaste println
    int dow = cal.get(GregorianCalendar.DAY_OF_WEEK);

    System.out.println("\nToday is a " + weekday_name(dow) + "!");
  }

}
