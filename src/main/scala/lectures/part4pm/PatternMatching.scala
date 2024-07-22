package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else"
  }

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)
  val greeting = bob match
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know who I am"

  println(greeting)

  /**
   * 1. cases are matched in order
   * 2. what if no cases match? => MatchError
   * 3. what is the type of the PM expression? unified type of all the types in all the cases
   * 4. PM works really well with cases classes
   */

  // PM on sealed hierarchies
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match
    case Dog(somebreed) => println(s"Matched a dog of the $somebreed breed")
    case _ => println("No match")

  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }
  // overkill, should not do like above
  val isEvenCond = if (x % 2 == 0) true else false // still not good
  val isEvenNormal = x % 2 == 0 // good

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  val expr = Prod(Sum(Number(1), Number(2)), Number(3))
  def handleExpr(expr: Expr): Int = expr match {
    case Number(n) => n
    case Sum(e1, e2) => handleExpr(e1) + handleExpr(e2)
    case Prod(e1, e2) => handleExpr(e1) * handleExpr(e2)
  }

  println(handleExpr(expr))
}
