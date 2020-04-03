package playground

/**
 * We're going to implement a custom list
 * the first element we'll be called first.
 * the remainder of the list we'll be called remain
 * (The naming sucks, I know !)
 */
abstract class CustomList {
  def first: Int
  def remain: CustomList
  def isEmpty: Boolean
  def add(member: Int): CustomList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object EmptyCustomList extends CustomList {
  def first: Int = throw new NoSuchElementException
  def remain: CustomList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(member: Int): CustomList = new NonEmptyList(member, EmptyCustomList)
  def printElements: String = ""
}

class NonEmptyList(f: Int, rem: CustomList) extends CustomList {
  def first: Int = f
  def remain: CustomList = rem
  def isEmpty: Boolean = false
  def add(member: Int): CustomList = new NonEmptyList(member, this)
  def printElements: String =
    if (rem.isEmpty) "" + f
    else f + " " + rem.printElements
}

object CustomListPlayground extends App {
  val x = new NonEmptyList(1, new NonEmptyList(2, new NonEmptyList(3, new NonEmptyList(4, EmptyCustomList))))
  println(x.remain.remain.first)
  println(x.add(4).first)
  println(x.toString())
}
