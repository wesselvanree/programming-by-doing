public class NumbersAndMath
{
  public static void main(String[] args)
  {
    System.out.println("I will now count my chickens:");

    // 30 / 6 --> 5 + 25
    System.out.println("Hens " + (25 + 30 / 6));

    // 25 * 3 --> 75 % 4 --> 100 - 3
    System.out.println("Roosters " + (100 - 25 * 3 % 4));

    System.out.println("Now I will count the eggs:");

    //  1 / 4 --> 4 % 2 --> 3 + 2 + 1 - 5 + 0 - 0 + 6
    // 1 / 4 = 0,25 --> int 0,25 = 0
    System.out.println(3 + 2 + 1 - 5 + 4 % 2 - 1 / 4 + 6);

    System.out.println("Is it true that 3 + 2 < 5 - 7?");

    // 5 < -2 --> false
    System.out.println(3 + 2 < 5 - 7);

    // 3 + 5 = 5
    System.out.println("What is 3 + 2? " + (3 + 2));

    // 5 - 7 = -2
    System.out.println("What is 5 - 7? " + (5 - 7));

    System.out.println("Oh, that's why it's false.");

    System.out.println("How about some more.");

    // 5 > -2 --> true
    System.out.println("Is it greater? " + (5 > -2));
    // 5 >= -2 --> true
    System.out.println("Is it greater or equal? " + (5 >= -2));
    // 5 <= -2 --> false
    System.out.println("Is it less or equal? " + (5 <= -2));
  }
}
