package oop

object ScalaTraits extends App {
  /**
   * Traits can be used as Interfaces
   * A class can be extended by one or multiple traits
   */
  trait Human {
    def talks() = println("talking ..") // Actual implementation
    def thinks() // Abstract implementation
    def invents() = println("inventing ..")
  }
  trait Animal {
    def eats()
  }
  class Person extends Human with Animal {
    override def thinks(): Unit = println("thinking ..")
    override def eats(): Unit = println("eating ..")
    override def invents(): Unit = println("tries inventing ...")
  }
  var p = new Person
  p.eats()
  p.thinks()
  p.talks()
  p.invents()
}
