public class MoreVariablesAndPrinting
{
  public static void main(String[] args)
  {
    String Name, Eyes, Teeth, Hair;
    int Age, Height, Weight, WeightKg, HeightCm;

    Name = "Zed A. Shaw";
    Age = 35; // not a lie
    Height = 74; // inches
    HeightCm = ToCm(Height);
    Weight = 180; // lbs
    WeightKg = ToKg(Weight);
    Eyes = "Blue";
    Teeth = "White";
    Hair = "Brown";

    System.out.println("Let's talk about " + Name + ".");
    System.out.println("He's " + Height + " inches (or " + HeightCm + " cm) tall.");
    System.out.println("He's " + Weight + " pounds (or " + WeightKg + " kg) heavy.");
    System.out.println("Actually, that's not too heavy.");
    System.out.println("He's got " + Eyes + " eyes and " + Hair + " hair.");
    System.out.println("His teeth are usually " + Teeth + " depending on the coffee.");

    // This line is tricky; try to get it exactly right.
    System.out.println(
        "If I add " + Age + ", " + Height + ", and " + Weight + " I get " + (Age + Height + Weight) + ".");
  }

  static int ToKg(int x) {
    double Kg = x * 0.45359237;
    Kg = Math.round(Kg);
    int KgInt = (int) Kg;
    return KgInt;
  }

  static int ToCm(int x) {
    double Cm = x * 2.54;
    Cm = Math.round(Cm);
    int CmInt = (int) Cm;
    return CmInt;
  }
}
