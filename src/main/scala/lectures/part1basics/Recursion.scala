package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  println(anotherFactorial(5000))
  // WHEN YOU NEED LOOPS, USE TAIL RECURSION
  /**
   * 1. Concatenate a string n times
   * 2. IsPrime function tail recursive
   * 3. Fibonacci function, tail recursive
   */

  @tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailRec(aString, n - 1, aString + accumulator)
  
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    
    isPrimeUntil(n / 2)
  }
  
  def fibonacci(n: Int): Int = {
    @tailrec
    def fibHelper(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibHelper(i + 1, last + nextToLast, last)
    
    if (n <= 2) 1
    else fibHelper(2, 1, 1)
  }
}
