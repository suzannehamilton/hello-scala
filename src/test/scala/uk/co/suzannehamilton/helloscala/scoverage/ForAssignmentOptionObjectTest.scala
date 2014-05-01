package uk.co.suzannehamilton.helloscala.scoverage

import org.scalatest.FlatSpec

class ForAssignmentOptionObjectTest extends FlatSpec {
  "ForAssigmentObject" should "return a value" in {
    val result = ForAssignmentOptionObject.getOptionValue
    assert(result === Some("foo"))
  }

  "Expanded ForAssigmentObject" should "return a value" in {
    val result = ForAssignmentOptionObject.getOptionValueExpandedVersion
    assert(result === Some("foo"))
  }
}
