package lectures.part3fp

object WhatsAFunction extends App {
  // DREAM: use functions as first class elements
  // problem: oop
  val doubler = new MyFunction[Int, Int] {
    override def apply(el: Int): Int = el * 2
  }

  println(doubler(2))

  // function types = Function1[A,B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(str: String): Int = str.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS
  /**
   * 1. a function which takes 2 strings and concatenates them
   * 2. transform the MyPredicate and MyTransformer into function types
   * 3. define a function which takes an int and terun another function which takes an int and return an int
   *  - what's the type of this function
   *  - how to do it
   */
  val concat: (String, String) => String = (a:String, b: String) => s"$a$b"
  val hof: Int => Int => Int = a => b => a + b

}

trait MyFunction[A,B] {
  def apply(el: A): B
}
