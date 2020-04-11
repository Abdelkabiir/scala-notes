package oop

object ScalaCaseObjects extends App {
  /**
   * Case objects
   * case objects used as the base structure for Enumerations in scala
   * unlike case classes :
   * Apply, Un-apply methods are missing in case objects
   * There are no copy methods since this is a singleton
   * No method for structural equality comparison
   * No constructor as well
   *
   * Case objects are serializable (can be sent as messages between distributed systems: AKKA)
   */

  case object ScalaObject
}
