package oop

object ScalaCaseClasses extends App {
  /**
   * Case classes are a special scala classes
   * - Case class constructor parameters are public val fields by default, so accessor methods are generated for each parameter.
   * - An apply method is created in the companion object of the class, so you don’t need to use the new keyword to create a new instance of the class.
   * - An unapply method is generated, which lets you use case classes in more ways in match expressions.
   * - A copy method is generated in the class. You may not use this feature in Scala/OOP code, but it’s used all the time in Scala/FP.
   * - equals and hashCode methods are generated, which let you compare objects and easily use them as keys in maps.
   * - A default toString method is generated, which is helpful for debugging.
   *
   * Case classes are serializable (can be sent as messages between distributed systems: AKKA)
   */

  case class Account(accountType: String, balance: Int)
  var anAccount = Account("Business", 12000)
  var anotherAccount = Account("Business", 12000)
  println(anAccount.accountType)
  println(anAccount.toString())
  println(anAccount.equals(anotherAccount))

}
