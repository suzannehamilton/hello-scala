package uk.co.suzannehamilton.helloscala.scoverage

object DefaultArgumentsObject {

  val defaultName = "world"

  def makeGreeting(name: String = defaultName): String = {
    s"Hello, $name"
  }
}
