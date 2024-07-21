package lectures.part3fp

object MapFlatmapFilterFor extends App{
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')
  private val combinations: List[String] = chars.flatMap(c => numbers.map(n => s"$c$n"))
  combinations.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers
    c <- chars
  } yield s"$c$n"

  // syntax overload
  numbers.map {x => x * 2}
  
  
}
