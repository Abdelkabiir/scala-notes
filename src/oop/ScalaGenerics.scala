package oop

object ScalaGenerics extends App {
  /**
   * Generics are classes that takes types ase params
   */

  class Thing[A]
  class AnotherThing[A, B]
  val something = new Thing[Int]
  val somethingElse = new AnotherThing[Int, String]
  // Generic method
  object Thing {
    def aMethod[A]: Thing[A] = ???
  }
//  val x = Thing.aMethod[Int]

  /**
   * Now comes the variance problem xD
   */

  class AList[A]
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  val animal: Animal = new Cat

  /**
   * If (class Cat extends Animal) does AList[Cat] extends AList[Animal] ?
   */
  /**
   * 1- yes then => Covariance
   */
  class CovList[+A]
  val covAnimalList: CovList[Animal] = new CovList[Cat]
  // animalList.add(new Dog()) ???
  // well, we should implement add method in a way that transforms the list to (returns) a list of animals CovList[Animal]
  // like this : def add[B :> A](element: B) : CovList[B]

  /**
   * 2 - No then => Invariance
   */
  class InvList[A]
  val invAnimalList: InvList[Animal] = new InvList[Animal]
  // val invAnimalLists: InvList[Animal] = new InvList[Cat] : This will throw an error (required Animal but found Cat) xD

  /**
   * 3 - Another No, then => ContraVariance
   */
  class ContraVarList[-A]
  // this may look a little counter intuitive but there are cases where a super class is more appropriate :
  val contraVarList: ContraVarList[Cat] = new ContraVarList[Animal]

  /**
   * Bounded types : use the generic class either for sub class or super class of a certain type
   */
  // a - Accepts subtypes of a type
  class Zoo[A <: Animal] (animal: Animal)
  val zoo1 = new Zoo(new Animal())
  val zoo2 = new Zoo(new Cat())
  val zoo3 = new Zoo(new Dog())
  class Human
  // val thing = new Zoo(new Human()) // This will throw an error (required Animal but found Human) xD
  // b - Accepts superTypes of a type
  class Pet[A >: Animal] (animal: Animal)
  val pet1 = new Pet(new Animal)
  val pet2 = new Pet(new Cat)
}
