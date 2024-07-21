package lectures.part2oop

object Generics extends App {
  class MyList[A] {
    // use the type A
  }

  trait MyMap[Key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A] {
    def add [B >: A](element: B): CovariantList[B] = ???
  }
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  val animals = animalList.add(new Dog)
  // INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  // CONTRAVARIANT
  class Contravariant[-A]
  val contravariantList: Contravariant[Cat] = new Contravariant[Animal]
  // bounded types
  class Cage[A <: Animal] (animal: A)
  val cage = new Cage(new Dog)
  class Car
//  val newCage = new Cage (new Car)

}
