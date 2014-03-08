import org.scalatest._
import uk.co.suzannehamilton.helloscala.ObjectWithMethods
import uk.co.suzannehamilton.helloscala.ClassWithApplyMethod

class MethodCallSpec extends UnitSpec {
  "A parameterless method with parentheses" can "be called with parentheses" in {
    ObjectWithMethods.methodWithParentheses()
  }

  it can "be called without parentheses" in {
    ObjectWithMethods.methodWithParentheses
  }

  "A parameterless method without parentheses" can "be called without parentheses" in {
    ObjectWithMethods.methodWithoutParentheses
  }


  it must "not be called with parentheses because that will be interpreted as calling apply() on the return value" in {
    assert(ObjectWithMethods.methodWithoutParentheses() == ClassWithApplyMethod.RETURN_VALUE)
  }
}