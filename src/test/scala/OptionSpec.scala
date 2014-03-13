/**
 * Helpful guide to the Option class:
 * http://danielwestheide.com/blog/2012/12/19/the-neophytes-guide-to-scala-part-5-the-option-type.html
 */
class OptionSpec extends UnitSpec {
  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

  "a map" should "store values as options" in {
    assert((capitals get "France") == Some("Paris"))
  }

  it should "return None if the key is not present" in {
    assert((capitals get "Not a country") == None)
  }

  "an optional value" can "be taken apart with case statements" in {
    val value: String = "foo"
    assert(show(Some(value)) == value)
  }

  it should "exist if created from a non-null value using the factory method" in {
    val value: String = "foo"
    assert(Option(value) == Some(value))
  }

  it should "be None if created from null using the factory method" in {
    assert(Option(null) == None)
  }

  it can "be mapped to another Option value" in {
    val firstOption = Some("foo")
    val secondOption = firstOption.map(_.charAt(0))

    assert(secondOption == Some('f'))
  }

  it should "be mapped to None if the original Option is None" in {
    val firstOption: Option[String] = None

    assert(firstOption.map(_.charAt(0)) == None)
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
}
