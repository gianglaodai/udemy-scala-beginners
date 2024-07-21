package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // expression
  println(x)
  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>>

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  println(!(1 == x))
  var aVariable = 2
  aVariable += 3 // also works with -= *= /=
  println(aVariable)
  // Instructions (DO) vs Expressions (VALUE)
  println(if(true) 5 else 3)

  // while loop
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER USE WHILE LOOP IN SCALA
  // EVERYTHING IN SCALA IS AN EXPRESSION

  // code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
}
