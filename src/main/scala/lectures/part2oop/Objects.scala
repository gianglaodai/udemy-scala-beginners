package lectures.part2oop

object Objects extends App {
  // SCALA does not have class-level functionality ("static")
  object Person { // type + its only instance
    // "static" / "class" - level functionality
    val N_EYES = 2

    //    def from(mother: Person, father: Person): Person = new Person("Bobbie")
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS - same name and same scope
  // Companions can access each other's private member

  // Scala object = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)
  val bobbie = Person(mary, john)
  // Scala Application = Scala object with
  // def main(args: Array[String]): Unit
}
