package functions

object ScalaFunctions extends App {

  /**
   * A function can be defined in multiple ways
   */

  def func1(param1: Int, param2: Int) = param1 + param2
  def func2 = {(param1: Int, param2: Int) =>
    param1 + param2
  }
  def func3 = (param1: Int, param2: Int) => param1 + param2
  val func4 = (param1: Int, param2: Int) => param1 + param2
  val func5 = new Function2[Int, Int, Int] {
    def apply(param1: Int, param2: Int) = param1 + param2
  }
  // Syntactic sugar for func 5
  val func6 = new ((Int, Int) => Int) {
    def apply(param1: Int, param2: Int) = param1 + param2
  }
  /**
   * Higher Order Functions:
   * functions that take functions as arguments and/or return other functions
   */
  def higherOrderFunction(x: Int, y: Int => Int) = y(x)
  def someYFunction(x: Int) = x+1
  val res = higherOrderFunction(3, someYFunction)
  println(res)
  def anotherHigherOrderFunction(x: Int) = (y: Int) => x+y
  // anotherHigherOrderFunction(1) is a function f(x)=1+x
  println(anotherHigherOrderFunction(1)(2))
  // map function is an example of a higher order function that takes another function as a param

  val aList = List(1, 2, 3, 5, 6, 8)
  val aListMapped = aList map(x => x*2)
  println(aList)
  println(aListMapped)
}
