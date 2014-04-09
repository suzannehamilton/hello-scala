package uk.co.suzannehamilton.helloscala.specs2.mockito

import uk.co.suzannehamilton.helloscala.specs2.Specification
import org.specs2.mock.Mockito
import uk.co.suzannehamilton.helloscala.ClassWithMethods

class MockitoSpec extends Specification with Mockito {
  val testObject = mock[ClassWithMethods]

  "A method with a non-Unit return type can be verified" in {
    there was no(testObject).methodWithStringReturnValue
//    testObject.methodWithStringReturnValue was notCalled
  }

//  "A method which returns Unit" {
//    "can be verified" in {
//      val testObject = mock[ClassWithMethods]
//
//      testObject.methodWithUnitReturnValue was notCalled
//    }
//  }
}
