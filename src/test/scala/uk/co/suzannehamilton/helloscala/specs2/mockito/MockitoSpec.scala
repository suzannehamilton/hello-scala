package uk.co.suzannehamilton.helloscala.specs2.mockito

import uk.co.suzannehamilton.helloscala.specs2.Specification
import org.specs2.mock.Mockito
import uk.co.suzannehamilton.helloscala.ClassWithMethods

class MockitoSpec extends Specification with Mockito {
  val testObject = mock[ClassWithMethods]

  "A method with a non-Unit return type can be verified" in {
    there was no(testObject).methodWithStringReturnValue
  }

  /**
   * This method of verification appears to be incorrect. It is mentioned in the original
   * Specs docs: http://code.google.com/p/specs/wiki/UsingMockito
   * but seems to be an error in the docs:
   * https://groups.google.com/forum/#!topic/specs2-users/Jm5KD-303L8
   *
   * I cannot find it mentioned in the Specs2 docs at all.
   *
   * Use "there was one" or "there was no" syntax instead.
   */
  //    testObject.methodWithStringReturnValue was notCalled

  "A method which returns Unit can be verified" in  {
    val testObject = mock[ClassWithMethods]

    there was no(testObject).methodWithUnitReturnValue
  }
}
