package lectures.part3fp

object AnonymousFunction extends App {
  def callByName(func: => () => Int) = println(func())

  val justDoSomething: () => Int = () => 3
  callByName(justDoSomething)
  // curly braces with lambdas
  val stringToInt = { (str: String) => str.toInt }
  // MOAR syntactic sugar
  //  val niceIncrementer: Int => Int = x => x + 1
  val niceIncrementer: Int => Int = _ + 1
  //  val niceAdder: (Int, Int) => Int = (a,b)  => a + b
  val niceAdder: (Int, Int) => Int = _ + _

  /**
   * 1. MyList: replace all FunctionX calls with lambda
   * 2. Rewrite the "special" adder as an anonymous function
   */
}
