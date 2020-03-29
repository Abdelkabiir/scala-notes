package loops

object ScalaLoops extends App {
  /**
   * Scala loops system contains 3 structures
   * For, While, doWhile
   */

  // For loops with ranges
  for( a <- 1 to 10){
    // do something
  }
  // For loops with collections
  // ex: List
  val list = List(1, 2, 3)
  for(i <- list) {
    // do something
  }

  // For loops allows filter
  for( a <- 1 to 10
       if(a%2 == 0)
       // you can add more conditions
       if(a>3)){
    // do something
  }
  // For loops can yield values
  // the values can then be used
  var values = for{a <- 1 to 10} yield a
  for(value <- values) {
    // do something
  }

  /**
   * While loop
   */
  var i = 1
  while(i<10) {
    // do something
    i = i+1
  }

  /**
   * doWhile loop
   */
  var j = 1
  do {
    // do something
    j = j+1
  }
  while(j<10)
}
