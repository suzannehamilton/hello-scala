class OptionSpec extends UnitSpec {
  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

  "a map" should "store values as options" in {
    assert((capitals get "France") == Some("Paris"))
  }

  it should "return None if the key is not present" in {
    assert((capitals get "Not a country") == None)
  }

  "an optional value" can "be taken apart with case statements" in {
    assert(show(capitals get "France") == "Paris")
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
}
