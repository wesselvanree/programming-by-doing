import java.util.Random;

public class FortuneCookie
{
  public static void main(String[] args)
  {
    Random r = new Random();

    int v = 1 + r.nextInt(6);

    // de '\' zorgt ervoor dat het aanhalingsteken daarna bij de string hoort
    if ( v == 1 )
      System.out.println("Fortune cookie says: \"You will find happiness with a new love.\"");
    else if ( v == 2 )
      System.out.println("Fortune cookie says: \"Stick with your wife.\"");
    else if ( v == 3 )
      System.out.println("Fortune cookie says: \"If you refuse to accept anything but the best, you very often get it.\"");
    else if ( v == 4 )
      System.out.println("Fortune cookie says: \"Your high minded principles spell success.\"");
    else if ( v == 5 )
      System.out.println("Fortune cookie says: \"A dream you have will come true.\"");
    else if ( v == 6 )
      System.out.println("Fortune cookie says: \"The greatest risk is not taking one.\"");

    // maak 6 verschillende random waardes
    int l1 = 1 + r.nextInt(54);
    int l2 = 1 + r.nextInt(54);
    int l3 = 1 + r.nextInt(54);
    int l4 = 1 + r.nextInt(54);
    int l5 = 1 + r.nextInt(54);
    int l6 = 1 + r.nextInt(54);

    System.out.println("  " + l1 + " - " + l2 + " - " + l3 + " - " + l4 + " - " + l5 + " - " + l6);


  }
}
