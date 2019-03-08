public class ElseAndIf
{
  public static void main(String[] args)
  {
    int people = 30;
    int cars = 40;
    int buses = 15;

    // 1. eerst wordt de if gecheckt, als die false is dan de else if en als die oook false is de else die altijd runt als al het andere false is
    // 2. de else statement geldt nu alleen nog voor de ene if statement erboven.
    if (cars > people) {
      System.out.println("We should take the cars.");
    } if (cars < people) {
      System.out.println("We should not take the cars.");
    } else {
      System.out.println("We can't decide.");
    }

    if (buses > cars) {
      System.out.println("That's too many buses.");
    } if (buses < cars) {
      System.out.println("Maybe we could take the buses.");
    } else {
      System.out.println("We still can't decide.");
    }

    if (people > buses) {
      System.out.println("All right, let's just take the buses.");
    } else {
      System.out.println("Fine, let's stay home then.");
    }
  }
}
