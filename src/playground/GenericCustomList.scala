/**
 * We're going to implement a generic custom list
 * the first element we'll be called first.
 * the remainder of the list we'll be called remain
 * (The naming sucks, I know !)
 */
trait GenericCustomList[+A] {
  def first: A
  def remain: GenericCustomList[A]
  def isEmpty: Boolean
  def add[B >: A](member: B): GenericCustomList[B]
  def print: String
  override def toString: String = "[" + print + "]"
}

case object EmptyGenericCustomList extends GenericCustomList[Nothing] {
  def first: Nothing = throw new NoSuchElementException
  def remain: GenericCustomList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](member: B): GenericCustomList[B] = NonEmptyListGeneric(member, EmptyGenericCustomList)
  def print: String = ""
}

case class NonEmptyListGeneric[+A](f: A, rem: GenericCustomList[A]) extends GenericCustomList[A] {
  def first: A = f
  def remain: GenericCustomList[A] = rem
  def isEmpty: Boolean = false
  def add[B >: A](member: B): GenericCustomList[B] = NonEmptyListGeneric(member, this)
  def print: String =
    if (rem.isEmpty) "" + f
    else f + " " + rem.print
}

object GenericCustomListPlayground extends App {
  val x = NonEmptyListGeneric(1, NonEmptyListGeneric(2, NonEmptyListGeneric(3, NonEmptyListGeneric(4, EmptyGenericCustomList))))
  val y = NonEmptyListGeneric("A", NonEmptyListGeneric("B", NonEmptyListGeneric("C", NonEmptyListGeneric("D", EmptyGenericCustomList))))
  println(x.toString())
  println(y.toString())
}
