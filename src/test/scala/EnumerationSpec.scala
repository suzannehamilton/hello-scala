import uk.co.suzannehamilton.helloscala.NamedEnumeration

class EnumerationSpec extends UnitSpec {
  "An enumeration with names" can "return the names assigned to each value" in {
    assert(NamedEnumeration.North.toString == "North")
    assert(NamedEnumeration.West.toString == "West")
  }
}
