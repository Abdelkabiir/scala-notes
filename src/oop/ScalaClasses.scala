package oop

object ScalaClasses extends App {
  /**
   * Classes and Objects
   */
  class Person(firstName: String, lastName: String, age: Int, homeAddress: String) {
    def getFullName(): Unit = println("Fullname: " + firstName + " " + lastName)
    def getAddress() = println("Address: " + homeAddress)
    def getAge() = println("Age: " + age)
  }
  var abdel = new Person("Abdelkabir", "Watil", 25, "Tigzmerte, Tata")
  /**
   * Class constructors (Primary and Auxiliary)
   * The primary constructor share same body with the class
   * The auxiliary constructors are defined using keyword "this"
   */
  class Child(name: String, age: Int) {
    def this(name: String) = this(name, 24)
    def this(age: Int) = this("Abdel", age)
  }
  var child1 = new Child("A", 20)
  var child2 = new Child("B")
  var child3 = new Child(22)

  /**
   * Inheritance
   */
  class Child1(firstName: String,
               lastName: String,
               age: Int,
               homeAddress: String) extends Person(firstName, lastName, age ,homeAddress) {

  }
  class Child2(firstName: String,
               lastName: String,
               age: Int, homeAddress: String) extends Person(firstName, lastName, age ,homeAddress) {

  }
}
