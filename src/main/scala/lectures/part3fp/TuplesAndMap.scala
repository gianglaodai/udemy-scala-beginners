package lectures.part3fp

object TuplesAndMap extends App {
  // tuples = finite ordered "lists"
  //  val aTuple = Tuple2(2, "hello") // Tuple2[Int,String] = (Int, String)
  val aTuple = (2, "hello")
  println(aTuple._1)
  println(aTuple.copy(_2 = "goodbye"))
  println(aTuple.swap)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()
  val phonebook = Map(("Jim", 555), "Danial" -> 789).withDefaultValue(-1)
  // a -> b is sugar for (a,b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("Hoa"))

  val newPairing = "Hoa" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))
  println(phonebook.view.filterKeys(_.startsWith("J")).toMap)
  println(phonebook.view.mapValues(_ * 10).toMap)
  println(phonebook.toList)
  println(List(("Giang", 1234)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
}
