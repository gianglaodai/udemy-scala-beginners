package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = a + " " + b

  def aFunctionWithBlock(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hellor", 2))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION
  def aFunctionWithSideEffec(aString: String): Unit = println(aString)

  /**
   * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
   * 2. Factorial function 10! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10
   * 3. A Fibonacci function
   * 4. Test if a number is prime
   */

  def greeting(name: String, age: Int): String =
    s"Hi, my name is $name and I am $age years old"

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }


  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }
}
