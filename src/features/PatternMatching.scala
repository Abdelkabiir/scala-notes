package features

object PatternMatching extends App {
  /**
   * Match a value with a set of patterns
   * similar to switch/case
   */

  def errorCodes(x: Int) = x match {
    case 0 => "safely exited"
    case 1 => "runtime error"
    case 2 => "input error"
    case _ => "unspecified error"
  }

  println(errorCodes(0))
  println(errorCodes(1))
  println(errorCodes(2))
  println(errorCodes(3))

  /**
   * Pattern matching is widely use with scala case classes
   */

  class Human
  case class Child(age: Int, name: String, school: String) extends Human
  case class Man(age: Int, name: String, profession: String) extends Human

  // can add guards via if statement
  def showDetailsOfHuman(human: Human) = human match {
    case c: Child if c.age <10 => println(s"I'm just a very little child, I'm ${c.age} years old")
    case c: Child => println(s"I'm just a child, I'm ${c.age} years old")
    case m: Man => println(s"I'm a grown ass man, I'm ${m.age} years old, and works as a ${m.profession}")
  }

  val aChild = Child(12, "Abdel", "EHTP")
  val aChild2 = Child(8, "Abdel", "EHTP")
  val aMan = Man(32, "Abdelkabir", "Software engineer")

  showDetailsOfHuman(aChild)
  showDetailsOfHuman(aChild2)
  showDetailsOfHuman(aMan)

  /**
   * All pattern matching cases
   */
  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case PatternMatching => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }
  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }

  // PMs can be NESTED!

  // 4 - case classes - constructor pattern, see examples above

  // 5 - list patterns (very interesting/useful)
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1,2,3) :+ 42 => // infix pattern
  }

  // 6 - type specifiers, see previous examples
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 - name binding
//  val nameBindingMatch = aStandardList match {
//    case nonEmptyList @ List(_, _) => // name binding => use the name later(here)
//    case List(1, rest @ List(2, _)) => // name binding inside nested patterns
//  }

  /**
   * Exercise: form RJVM course
   */

  sealed trait Expr
  case class Number(number: Int) extends Expr
  case class Sum(expr1: Expr, expr2: Expr) extends Expr
  case class Prod(expr1: Expr, expr2: Expr) extends Expr

  def myFunction(expr: Expr): String = expr match {
    case n: Number => ""+n.number
    case s: Sum => myFunction(s.expr1) + "+" + myFunction(s.expr2)
    case p: Prod => myFunction(p.expr1) + "*" + myFunction(p.expr2)
  }

  val nn = Number(1)
  val ss = Sum(Number(2), Number(4))
  val pp = Prod(Number(5), Sum(Number(2), Number(4)))

  println(myFunction(nn))
  println(myFunction(ss))
  println(myFunction(pp))
}
