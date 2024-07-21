package exercises

abstract class MyList[+T] {
  /**
   * head = first element of the list
   * tail = remaider of the List
   * isEmpty = is this list empty
   * add(int) => new list with this elemnt added
   * toString => a string representation of the list
   */
  def head: T
  def tail: MyList[T]
  def isEmpty: Boolean
  def add[R >: T](el: R): MyList[R]
  def printElements: String
  def filter(predicate: MyPredicate[T]): MyList[T]
  def map[S](transformer: MyTransformer[T, S]): MyList[S]
  def flatMap[S](transformer: MyTransformer[T, MyList[S]]): MyList[S]
  def ++[R >: T] (list: MyList[R]): MyList[R]
  override def toString: String = "[" + printElements + "]"

}

case object Empty extends MyList[Nothing] {
  /**
   * head = first element of the list
   * tail = remaider of the List
   * isEmpty = is this list empty
   * add(int) => new list with this elemnt added
   * toString => a string representation of the list
   */
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[R >: Nothing](el: R): MyList[R] = new Cons[R](el, Empty)

  override def printElements: String = ""

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def map[S](transformer: MyTransformer[Nothing, S]): MyList[Nothing] = Empty

  override def flatMap[S](transformer: MyTransformer[Nothing, MyList[S]]): MyList[Nothing] = Empty
  def ++[R >: Nothing] (list: MyList[R]): MyList[R] = list
}

case class Cons[+T](h:T, t:MyList[T]) extends MyList[T] {
  override def head: T = h
  override def tail: MyList[T] = t
  override def isEmpty: Boolean = false

  override def add[R >:T](el: R): MyList[R] = new Cons(el, this)

  override def printElements: String = s"$h, ${tail.printElements}"

  override def filter(predicate: MyPredicate[T]): MyList[T] = if (predicate.test(head)) new Cons(head, tail.filter(predicate)) else tail.filter(predicate)

  override def map[R](transformer: MyTransformer[T, R]): MyList[R] = new Cons(transformer.transform(head), tail.map(transformer))

  override def flatMap[R](transformer: MyTransformer[T, MyList[R]]): MyList[R] = transformer.transform(head) ++ tail.flatMap(transformer)
  def ++[R >: T] (list: MyList[R]): MyList[R] = new Cons(head, tail ++ list)
}

object Test extends App{
  val list = Cons(1,Cons(2, Cons(3, Empty)))
  println(list.toString)
}

/**
 * 1. Generic trait MyPredicate[T]j
 * 2. Generic trait MyTransformer[A,B]
 * 3. MyList:
 * - map(transformer) => MyList
 * - filter(predicate) => MyList
 * - flatMap(transformer) => MyList
 */

trait MyPredicate[-T] {
  def test(value: T): Boolean
}
trait MyTransformer[-A,B]{
  def transform(value: A): B
}
