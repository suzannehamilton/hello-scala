import org.scalatest._
import uk.co.suzannehamilton.helloscala.ObjectWithMethods

class MethodCallSpec extends UnitSpec {
  "A parameterless method with parentheses" can "be called with parentheses" in {
    assert(ObjectWithMethods.methodWithParentheses() == ObjectWithMethods.RETURN_VALUE)
  }

  it can "be called without parentheses" in {
    assert(ObjectWithMethods.methodWithParentheses == ObjectWithMethods.RETURN_VALUE)
  }

  "A parameterless method without parentheses" can "be called without parentheses" in {
    assert(ObjectWithMethods.methodWithoutParentheses == ObjectWithMethods.RETURN_VALUE)
  }
}