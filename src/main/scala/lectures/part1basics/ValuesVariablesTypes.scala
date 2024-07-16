package lectures.part1basics

/**
 * "extends App" is equivalent to creating a main function, which makes this application runnable.
 * An alternative way is to skp "extends App" and in the body of this object inside {}, type in "main" then hit Tab to
 * generate the function that will be called when running the app.
 */
object ValuesVariablesTypes extends App {
  // VALS ARE IMMUTABLE
  val x: Int = 32
  println(x)
  // COMPILER can infer type
  val y = 40

  val aString: String = "hello"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 123
  val aLong: Long = 123123123123L
  val aFloat: Float = 2.0f
  val aDouble: Double = 2.0

  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effects
}
