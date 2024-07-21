package exercises

abstract class MyListFunctionStyle[+T] {
  /**
   * head = first element of the list
   * tail = remaider of the List
   * isEmpty = is this list empty
   * add(int) => new list with this elemnt added
   * toString => a string representation of the list
   */
  def head: T

  def tail: MyListFunctionStyle[T]

  def isEmpty: Boolean

  def add[R >: T](el: R): MyListFunctionStyle[R]

  def printElements: String

  def filter(predicate: T => Boolean): MyListFunctionStyle[T]

  def map[S](transformer: T => S): MyListFunctionStyle[S]

  def flatMap[S](transformer: T => MyListFunctionStyle[S]): MyListFunctionStyle[S]

  def ++[R >: T](list: MyListFunctionStyle[R]): MyListFunctionStyle[R]

  def foreach(consumer: T => Unit): Unit

  def sort(comparator: (T, T) => Int): MyListFunctionStyle[T]

  def zipWith[U, V](list: MyListFunctionStyle[U], zip: (T, U) => V): MyListFunctionStyle[V]

  def fold[U](start: U)(func: (U, T) => U): U

  override def toString: String = "[" + printElements + "]"

}

case object EmptyFunctionStyle extends MyListFunctionStyle[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyListFunctionStyle[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[R >: Nothing](el: R): MyListFunctionStyle[R] = new ConsFunctionStyle[R](el, EmptyFunctionStyle)

  override def printElements: String = ""

  override def filter(predicate: Nothing => Boolean): MyListFunctionStyle[Nothing] = EmptyFunctionStyle

  override def map[S](transformer: Nothing => S): MyListFunctionStyle[Nothing] = EmptyFunctionStyle

  override def flatMap[S](transformer: Nothing => MyListFunctionStyle[S]): MyListFunctionStyle[Nothing] = EmptyFunctionStyle

  override def foreach(consumer: Nothing => Unit): Unit = ()

  def ++[R >: Nothing](list: MyListFunctionStyle[R]): MyListFunctionStyle[R] = list

  override def sort(comparator: (Nothing, Nothing) => Int): MyListFunctionStyle[Nothing] = EmptyFunctionStyle

  override def zipWith[U, V](list: MyListFunctionStyle[U], zip: (Nothing, U) => V): MyListFunctionStyle[V] = EmptyFunctionStyle

  override def fold[U](start: U)(func: (U, Nothing) => U): U = start
}

case class ConsFunctionStyle[+T](h: T, t: MyListFunctionStyle[T]) extends MyListFunctionStyle[T] {
  override def head: T = h

  override def tail: MyListFunctionStyle[T] = t

  override def isEmpty: Boolean = false

  override def add[R >: T](el: R): MyListFunctionStyle[R] = new ConsFunctionStyle[R](el, this)

  override def printElements: String = s"$h, ${tail.printElements}"

  override def filter(predicate: T => Boolean): MyListFunctionStyle[T] = if (predicate(head)) ConsFunctionStyle(head, tail.filter(predicate)) else tail.filter(predicate)

  override def map[R](transformer: T => R): MyListFunctionStyle[R] = ConsFunctionStyle(transformer(head), tail.map(transformer))

  override def flatMap[R](transformer: T => MyListFunctionStyle[R]): MyListFunctionStyle[R] = transformer(head) ++ tail.flatMap(transformer)

  def ++[R >: T](list: MyListFunctionStyle[R]): MyListFunctionStyle[R] = ConsFunctionStyle(head, tail ++ list)

  override def foreach(consumer: T => Unit): Unit = {
    consumer(head)
    tail.foreach(consumer)
  }

  override def sort(comparator: (T, T) => Int): MyListFunctionStyle[T] =
    def insert(x: T, sortedList: MyListFunctionStyle[T]): MyListFunctionStyle[T] =
      if(sortedList.isEmpty) ConsFunctionStyle(x, EmptyFunctionStyle)
      else if (comparator(x, sortedList.head) <= 0) ConsFunctionStyle(x, sortedList)
      else ConsFunctionStyle(sortedList.head, insert(x, sortedList.tail))

    insert(head, tail.sort(comparator))

  override def zipWith[U, V](list: MyListFunctionStyle[U], zip: (T, U) => V): MyListFunctionStyle[V] =
    if (list.isEmpty) return EmptyFunctionStyle
    ConsFunctionStyle(zip(head, list.head), tail.zipWith(list.tail, zip))

  override def fold[U](start: U)(func: (U, T) => U): U =
    tail.fold(func(start,head))(func)
}

object TestFunctionStyle extends App {
  val list = ConsFunctionStyle(1, ConsFunctionStyle(2, ConsFunctionStyle(3, EmptyFunctionStyle)))
  println(list.toString)
  println(list.sort((x, y) => y - x))
  println(list.zipWith(ConsFunctionStyle(2, ConsFunctionStyle(3, EmptyFunctionStyle)), _ * _))
  println(list.fold(0)(_ + _))
  for {
    n <- list
  } println(n)
}
