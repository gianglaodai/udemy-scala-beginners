package lectures.part2oop

object CaseClass extends App {
  // class parameters are fields
  case class Person(name: String, age: Int)
  // no need new keyword
  val giang = Person("Giang", 37)
  println(giang.name)
  // no need call toString
  println(giang.toString)
  println(giang)
  // equal and hashCode is implemented
  val giang2 = Person("Giang", 37)
  val jim = Person("jim", 37)
  println(giang == giang2)
  println(giang.equals(jim))
  // case classes have copy method
  val giang3 = giang.copy(age = 50)
  println(giang3)
  // case classe have companien objects
  val thePerson = Person
  // case class are serializable
  // AKKA
  // case classe have extractor pattern = case class can be used in PATTERN MATCHING
  case object UnitedKingdom {
    def name: String = "The UK"
  }


}
