package lectures.part3fp

object HOFsCurries extends App {
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // Function2[Int, Function2[String, Function1[Int,Boolean], Int], Function1[Int, Int]]
  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  val nTimes: (Int => Int, Int, Int) => Int = (f, n, x) =>
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // ntb(f,n) = x => f(f(f...(x)))
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = x =>
    if (n <= 0) x
    else nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = (x, y) => f(x)(y)

  def compose[T, U, V](f: U => V, g: T => U): T => V = x => f(g(x))

  def andThen[T, U, V](f: T => U, g: U => V): T => V = x => g(f(x))

}
