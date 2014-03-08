import org.scalatest._
import uk.co.suzannehamilton.helloscala.ObjectWithMethods

class MethodCallSpec extends UnitSpec {
  "A parameterless method with parentheses" can "be called with parentheses" in {
    assert(ObjectWithMethods.methodWithParentheses() == "Return value")
  }

  it can "be called without parentheses" in {
    assert(ObjectWithMethods.methodWithParentheses == "Return value")
  }
}