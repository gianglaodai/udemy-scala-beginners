package lectures.part2oop

object AbstractDataTypes extends App {
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  trait Carnivore {
    def eat (animal: Animal): Unit
  }

  trait ColdBlooded (val name: String) {
    def hello = s"Hello I'm $name"
  }

  class Crocodile(name:String) extends Animal with Carnivore with ColdBlooded (name){
    override val creatureType: String = "croc"
    def eat: Unit = "nomnomnom"
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile("giang")
  croc.eat(dog)
  println(croc.hello)
}
