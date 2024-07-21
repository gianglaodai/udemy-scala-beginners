package exercises

abstract class Maybe[+T] {
  def map[U](f: T => U): Maybe[U]
  def flatMap[U](f: T => Maybe[U]): Maybe[U]
  def filter(p: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {
  override def map[U](f: Nothing => U): Maybe[U] = MaybeNot

  override def flatMap[U](f: Nothing => Maybe[U]): Maybe[U] = MaybeNot

  override def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {
  override def map[U](f: T => U): Maybe[U] = Just(f(value))

  override def flatMap[U](f: T => Maybe[U]): Maybe[U] = f(value)

  override def filter(p: T => Boolean): Maybe[T] = if(p(value)) this else MaybeNot
}
