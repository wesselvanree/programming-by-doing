public class WhatIf
{
  public static void main(String[] args)
  {
    int people = 20;
    int cats = 30;
    int dogs = 15;

    // 1. nu dot de if statement nog niks met de code eronder maar als er return in zit stopt de code vanaf de return regel en wordt de rest niet meer uitgevoerd.
    // 2. daarin komt te code die bij de if statement hoort
    if (people > cats) {
      System.out.println("Too many cats!  The world is doomed!");
    }

    if (people > cats) {
      System.out.println("Not many cats!  The world is saved!");
    }

    if (people < dogs) {
      System.out.println("The world is drooled on!");
    }

    if (people > dogs) {
      System.out.println("The world is dry!");
    }

    dogs += 5;

    if (people >= dogs) {
      System.out.println("People are greater than or equal to dogs.");
    }

    if (people <= dogs) {
      System.out.println("People are less than or equal to dogs.");
    }

    if (people == dogs) {
      System.out.println("People are dogs.");
    }
  }
}
