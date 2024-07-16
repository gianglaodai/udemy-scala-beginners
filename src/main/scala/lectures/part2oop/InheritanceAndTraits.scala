package lectures.part2oop

object InheritanceAndTraits extends App {
  // Single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
    private def privateMethod= println("privateMethod")
    protected def protectedMethod= println("protectedMethod")
  }

  class Cat extends Animal {
    // Cat is subclass of Animal and Animal is super class of Cat
    def crunch = {
      protectedMethod
      println ("crunch crunch")
    }

  }


  val cat = new Cat
  cat.crunch

  // constructor
  class Person(name: String, age: Int) {
    def this(name: String) = this(name,0)
  }
//  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  class Adult(name: String, age: Int, idCard: String) extends Person(name)
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat: Unit = println("crunch, crunch")
  }

  class Fish(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("bubble")
    }
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)
  val fish = new Fish("fish")
  println(fish.creatureType)

  //super
  // prevent override
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other file

}

