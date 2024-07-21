package exercises


object FP extends App {
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network.view.mapValues(_ - person).filterKeys(_ != person).toMap

  def friend(network: Map[String, Set[String]], person: String, friend: String): Map[String, Set[String]] =
    network + (person -> (network(person) + friend)) + (friend -> (network(friend) + person))

  def unfriend(network: Map[String, Set[String]], person: String, friend: String): Map[String, Set[String]] =
    network + (person -> (network(person) - friend)) + (friend -> (network(friend) - person))

  def countFriend(network: Map[String, Set[String]], person: String): Int =
    network(person).size

  def mostFriend(network: Map[String, Set[String]]): String =
    network.maxBy(_._2.size)._1

  def countNoFriendPeople(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)

  //  def isSocialConnection(network: Map[String, Set[String]], person1: String, person2: String): Boolean =

  val network = Map("giang" -> Set("hoang", "hoa", "abc"), "hoa" -> Set("giang"), "hoang" -> Set("giang"), "abc" -> Set("giang"))
  println(remove(network, "hoa"))
  println(mostFriend(network))
}

