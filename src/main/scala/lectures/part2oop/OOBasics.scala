package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Giang", 36)
  println(person.age)
  println(person.x)
  person.greet("Hoang")
  private val counter = new Counter(1)
}

// Constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2
  println(1 + 2)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  def greet(): Unit = println(s"Hi, I am $name")

  def this(name: String) = this(name, 0)

  def this() = this("John Doe")


}
// class parameters are NOT FIELDS

/**
 * Novel and a Writer
 * Writer: firstname, surname, year
 * - method fullname
 *
 * Novel : name, year of reales, author
 * - method: authorAge, isWrittenBy(author)
 * - copy (new year of realese) = new instance of Novel
 *
 */
class Writer(val firstName: String, val surName: String, val year: Int) {
  def fullname: String = s"$firstName $surName"
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def authorAge: Int = yearOfRelease - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(yearOfRelease: Int): Novel = new Novel(name, yearOfRelease, author)
}

/**
 * Counter class
 * - receives an int value
 * - method current count
 * - method to increment/decrement => New Counter
 * - overload inc/dec to receive an amount
 */
class Counter(val value: Int) {
  def currentCount(): Int = value

  def increment = new Counter(value + 1)

  def decrement = new Counter(value - 1)

  def increment(amount: Int) = new Counter(value + amount)

  def decrement(amount: Int) = new Counter(value - amount)
}


