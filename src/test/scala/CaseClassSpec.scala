import uk.co.suzannehamilton.helloscala.CaseClass

class CaseClassSpec extends UnitSpec {
  "A case class" can "be created without the 'new' keyword" in {
    val instanceOfCaseClass = CaseClass("", 0)
  }

  it should "have fields defined by the constructor parameters" in {
    val firstField = "foo"
    val secondField = 5

    val instanceOfCaseClass = CaseClass(firstField, secondField)
    
    assert(instanceOfCaseClass.firstField == firstField)
    assert(instanceOfCaseClass.secondField == secondField)
  }

  it should "be equal to another instance with the same field values" in {
    val firstField = "foo"
    val secondField = 5

    val instanceOfCaseClass = CaseClass(firstField, secondField)
    val secondInstance = CaseClass(firstField, secondField)

    assert(instanceOfCaseClass == secondInstance)
  }
}
