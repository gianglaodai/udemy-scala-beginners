package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER!")
  val potentialFailure = Try(unsafeMethod())

  println(potentialFailure)
  // syntax sugar
  val anotherPotentialFailure = Try {
    // some code that might throw
    unsafeMethod()
  }
  // utilities
  println(potentialFailure.isSuccess)
  // orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))

  // if you design the API
  def betterUnsafeMethod(): Try[String] = Try(unsafeMethod())
  def betterBackupMethod(): Try[String] = Try(backupMethod())
  val betterFallbackTry = betterUnsafeMethod().orElse(betterBackupMethod())

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Try(x * 10)))
  println(aSuccess.filter(_ > 10))

  // for-comprehension
  val host = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)
  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html></html>"
      else throw new RuntimeException("Connection interrupted")
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String) = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }
    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host,port))
  }

  // if you get the html page from the connection ,print it to the console i.e. call renderHTML
  val possibleConnection = HttpService.getSafeConnection(host, port)
  val possibleHTML = possibleConnection.flatMap(connection => Try(connection.get("/home")))
  possibleHTML.foreach(renderHTML)

  // shorthand version
  HttpService.getSafeConnection(host,port).flatMap(connection => Try(connection.get("/home"))).foreach(renderHTML)
  // for-comprehension version
  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- Try(connection.get("/home"))
  } renderHTML(html)

}
