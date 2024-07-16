package lectures.part1basics

object CBNvsCBV extends App{
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // Lazy Evaluation
  def calledByName(x: => Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }
  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)
  printFirst(34, infinite())
}
