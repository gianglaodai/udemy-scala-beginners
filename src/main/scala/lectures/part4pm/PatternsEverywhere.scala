package lectures.part4pm

object PatternsEverywhere extends App {
  // big idea
  try {

  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  // catches are actually MATCHES
  // big idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  // generators are also based on PATTERN MATCHING
  // look like destructoring to me
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // case classes, :: operators, ...
  // big idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b)

  // multiple value definitions based on PATTERN MATCHING
  // ALL THE POWER
  val head :: tail = list
  println(head)
  println(tail)

  // big idea #4 - partial function based on PATTERN MATCHING
  val mappedList = list.map {
    case v if v % 2 == 0 => s"$v is even"
    case 1 => "the one"
    case _ => "something else"
  } // partial function literal
  val mappedList2 = list.map { x =>
    x match {
      case v if v % 2 == 0 => s"$v is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }
}
