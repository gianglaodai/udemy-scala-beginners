package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  //  println(x.length)
  // this will crash with a NPE
  // throwing and catching exceptions
  //  val aWeirdValue = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes
  // how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  try {
    getInt(true)
  } catch {
    case e: RuntimeException => println(e.getMessage)
  } finally {
    println("finally")
  }
}
