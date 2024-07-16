package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, age: Int) {
    def likes(movie: String) = movie == favoriteMovie

    def hangOutWith(person: Person) = s"$name is hangingout with ${person.name}"

    def unary_! = s"$name, what the heck?"

    def + (newName: String) = new Person(s"$name ($newName)", favoriteMovie, age)
    def unary_+ = new Person(name, favoriteMovie, age + 1)
    def learns (subject: String) = s"$name learns $subject"
    def learnsScala = learns("Scala")

    def isAlive = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(times: Int) = s"$name watched $favoriteMovie $times times."
  }

  val mary = new Person("Mary", "Inception", 20)
  print(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)
  // "operators" in Scala

  val tom = new Person("Tom", "Fight Club", 40)
  println(mary hangOutWith tom)
  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !
  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)
  // apply
  println(mary.apply())
  println(mary()) // equivalent mary.apply()

  /**
   * 1. Overload the + operator
   * mary + "the rockestar" => new person "Mary (the rockstar)"
   * 2. Add an age to the Person class
   * Add a unary + operator => new person with age + 1
   * + mary = mary with the age incrementer
   * 3. Add a learns method in the Person class => "Mary learns input"
   * Add a learnsScala method, calls learns method with "Scala".
   * Use it in postfix notation
   * 4. Overload apply method
   * mary.apply(2) => "Mary watched Inception 2 times"
   */
  println(mary learnsScala)
  println(mary(2))
}
