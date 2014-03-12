import uk.co.suzannehamilton.helloscala.CaseClass

class CaseClassSpec extends UnitSpec {
  "A case class" can "be created without the 'new' keyword" in {
    val instanceOfCaseClass = CaseClass("")
  }
}
