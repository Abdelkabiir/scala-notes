package variables

object ScalaVariables extends App {
  /**
   * In scala we have variables an values
   * Variables are mutable, values aren't (can't assign a new value to it)
   */
  val x: String = "some string"
  var y: String = "another string"
  // x = "some string 2" =>  Error : Reassignment to val
  y = "another string 2" // This works

  /**
   * Scala has type inference
   * Meaning, you don't have to specify a type for your variable
   * Scala will determine the type
   */
  var aNumber = 12
  var aString = "a string"
  // aNumber = "some string" => Error: Type mismatch

  /**
   * Instructions vs expressions
   * an instruction has a side effect
   * an expressions is evaluated
   */

  var exp = if(true) 12 else 13 // is statements are expressions

}
