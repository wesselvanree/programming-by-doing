public class VariablesAndNames {
  public static void main(String[] args)
  {
    int cars, drivers, passengers, cars_not_driven, cars_driven;
    double space_in_a_car, carpool_capacity, average_passengers_per_car;

    cars = 100;
    // niet nodig, er komt bij carpool_capacity nog steeds 120.0 uit
    // float is een getal met komma
    space_in_a_car = 4.0;
    drivers = 30;
    passengers = 90;

    // int 100 - int 30 = int 70
    cars_not_driven = cars - drivers;

    // var = int 30 --> int 30 = int 30
    cars_driven = drivers;

    // double carpool_capacity  = int 30 * double 4.0 --> double carpool_capacity = 120.0
    carpool_capacity = cars_driven * space_in_a_car;

    // double average_passengers_per_car = int 90 / int 30 --> double average_passengers_per_car = 3.0
    average_passengers_per_car = passengers / cars_driven;

    System.out.println("There are " + cars + " cars available.");
    System.out.println("There are only " + drivers + " drivers available.");
    System.out.println("There will be " + cars_not_driven + " empty cars today.");
    System.out.println("We can transport " + carpool_capacity + " people today.");
    System.out.println("We have " + passengers + " to carpool today.");
    System.out.println("We need to put about " + average_passengers_per_car + " in each car.");
  }
}
